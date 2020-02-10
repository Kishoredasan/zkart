package com.zkartmod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class PurchaseAction {
    ReadWrite readWrite;
    CheckingAndEncryption checkingAndEncryption;
    InventoryInfoProtos.Product.Builder prod=null;
    Date date=new Date();
    Date date2;
    Date date1;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
    float total=0.0f;
    float discount=0.0f;
    int discountPercentage;


    PurchaseAction() throws Exception {
        readWrite=new ReadWrite();
        checkingAndEncryption=new CheckingAndEncryption();
    }
    public void purchase(UserInfoProtos.UserInfo.Builder user,int id) throws Exception {
        boolean available;
        int choice,j,ch,k=0;
        String number,choice1;
        int[] cart=new int[100];
        int[] position=new int[100];
        int[] orderQuantity=new int[100];
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------------------------PURCHASE-----------------------------------------------------------------------------------");

        while (true) {
            available=false;
            System.out.println("Chose from following categories");
            System.out.println("1.Mobile\n2.Laptop\n3.Tablet\n4.exit");//selecting category
            choice = Integer.parseInt(sc.next());
            if (choice == 4) break;
            else if(choice>0 && choice<4){}
            else{
                System.out.println("invalid option ");
                continue;
            }
            if(!readWrite.inventoryPresent){
                System.out.println("No stock available");
                break;
            }
            j=1;
            InventoryInfoProtos.Products.Builder prods=readWrite.getProds();
            System.out.println("slno  Brand  Model  Price");
            for (InventoryInfoProtos.Product prod:prods.getProductList()
            ) {
                if((choice-1)==prod.getCategoryValue()){
                    if(prod.getStock()>0){
                        System.out.println(j+" "+prod.getBrand()+" "+prod.getModel()+" "+prod.getPrice());//display all product in specified category
                        position[j]=prod.getProdID();
                        j++;
                        available=true;
                    }
                }

            }

            if(!available){
                System.out.println("sorry no chosen category  available right now");//if no stock available
                continue;
            }

            else//selecting the product
                while(true) {
                    System.out.println("Choose your product or give 0 for categories");
                    number = sc.next();
                    if (checkingAndEncryption.checkNumber(number)) {
                        ch = Integer.parseInt(number);
                        if(ch<j){
                            break;
                        }
                        System.out.println("Enter a valid option");
                    }
                    else
                        System.out.println("Enter valid number");
                }


            if (ch!=0 && ch<j) {
                cart[k]=position[ch];
                while (true) {
                    while (true) {
                        System.out.println("Enter the no of product you wish to purchase:");//choosing quantity
                        number = sc.next();
                        if (checkingAndEncryption.checkNumber(number)) {
                            orderQuantity[k]   = Integer.parseInt(number);
                            break;
                        }
                        System.out.println("Enter valid number");
                    }
                    prod=prods.getProductBuilder(position[ch]);
                    if (orderQuantity[k] > prod.getStock()) {
                        System.out.println("Sorry available stock:" + prod.getStock());
                        if (prod.getStock() == 0) {
                            k--;
                            break;
                        }
                    } else {
                        prod.setStock(prod.getStock()-orderQuantity[k]);
                        prods.setProduct(prod.getProdID(),prod.build());
                        break;
                    }
                }
                k++;
                System.out.println("do you wish to purchase more (yes/no):");
                choice1 = sc.next();
                if (choice1.equals("no") || choice1.equals("NO") || choice1.equalsIgnoreCase("No")) {
                    break;
                }
            }
        }
        if(k==0){
            return;
        }
        for(int i=0;i<k;i++){
            readWrite.addToCart(id,cart[i],orderQuantity[i]);
        }
        viewCart(user,id);
    }
    public void viewCart(UserInfoProtos.UserInfo.Builder user,int id) throws Exception{
        char ch;
        Scanner sc= new Scanner(System.in);
        InventoryInfoProtos.Products.Builder prods=readWrite.getProds();
        System.out.println("Brand\tMODEL\tPRICE\tCOUNT");
        for (CartDetailsProtos.Product prod:readWrite.allProducts.getProdList()) {
            System.out.println(prods.getProduct(prod.getProductId()).getBrand()+" "+prods.getProduct(prod.getProductId()).getModel()+" "+prods.getProduct(prod.getProductId()).getPrice()+" "+prod.getCount());
        }
        System.out.println("Do you want to buy y/n");
        ch=sc.next().charAt(0);
        if(ch=='y'||ch=='Y') {
            buyProduct(user, id);
        }
    }
    public void buyProduct(UserInfoProtos.UserInfo.Builder user,int id) throws Exception{
        String specialDiscount = null;
        boolean isSpecialDiscount = false;
        int invoice;
        InventoryInfoProtos.Products.Builder prods=readWrite.getProds();
        Random random = new Random();
        invoice = random.nextInt(899999) + 100000;

        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invoice number " + invoice);
        stringBuilder.append("\n").append("Date: " + DateFormat.getInstance().format(new Date()));
        stringBuilder.append("\n").append("Category  Brand  Model  price  count").append("\n");

        for (i = 0; i < readWrite.allProducts.getProdCount(); i++) {
            InventoryInfoProtos.Product product=prods.getProduct(readWrite.allProducts.getProd(i).getProductId());
            switch (product.getCategoryValue()){
                case 0:
                    stringBuilder.append("Mobile  ");
                    break;
                case 1:
                    stringBuilder.append("LAPTOP  ");
                    break;
                case 2:
                    stringBuilder.append("TABLET  ");
                    break;
            }


            stringBuilder.append(product.getBrand()+ " " + product.getModel() + " " +product.getPrice() + " " + readWrite.allProducts.getProd(i).getCount() + "\n");
            total = total + readWrite.allProducts.getProd(i).getCount() * product.getPrice();
            date2=simpleDateFormat.parse(simpleDateFormat.format(date));
            date1=simpleDateFormat.parse(product.getDate());
            long diff=date2.getTime()-date1.getTime();
            long noOfdays=diff / (1000*60*60*24);
            if (noOfdays>product.getNoOfDays()) {
                specialDiscount = "Brand:" + product.getBrand()+ " model: " + product.getModel();
                discount = discount + ((float) (readWrite.allProducts.getProd(i).getCount() * product.getPrice() / 10));
                isSpecialDiscount=true;
            }
        }
        readWrite.allProducts.clear();
        readWrite.allProducts.setCartEmpty(true);
        FileOutputStream output = new FileOutputStream("userinfo/"+id+"/cart.txt");//adding to cart
        try {
            readWrite.allProducts.build().writeTo(output);
        } finally {
            output.close();
        }

        if(isSpecialDiscount) {
            stringBuilder.append("specialDiscount:10%\n").append("for"+specialDiscount+"\n");
        }

        stringBuilder.append("actual amount :" + total + "\n");
        if (user.getDiscountCode().equals("no")) {
            if (discount > 0) {
                stringBuilder.append("Discount:" + discount + "\n");
            }
            stringBuilder.append("Total:" + (total - discount) + "\n");
            if (user.getNoOfPurchases() == 3 || total > 20000) {
                user.setDiscountCode(checkingAndEncryption.randomAlphaNumeric(6));
                user.setDiscountValidity(3);
                //customerDetails.noOfPurchases[n] = 0;
                user.setNoOfPurchases(user.getNoOfPurchases()+1);
                user.build();
                stringBuilder.append("You have received a discount " + user.getDiscountCode() + " which is valid for next 3 purchases\n\n\n");
                readWrite.update(user,id);//updating the user info
            } else {
                user.setNoOfPurchases(user.getNoOfPurchases()+1);
            }
        }
        else {
            stringBuilder.append("Discount code " + user.getDiscountCode() + " available for you which is added\n");
            discountPercentage = (int) (10 * Math.random() + 20);
            discount = discount + (((total - discount) / 100) * discountPercentage);
            if (user.getDiscountValidity() == 1) {
                user.setDiscountCode("no");
            }
            user.setDiscountValidity(user.getDiscountValidity()-1);
            readWrite.update(user,id);//updating the user info
            stringBuilder.append("Discount% :" + discountPercentage + "\n" + "discount:" + discount + "\n");
            stringBuilder.append("Total:" + (total - discount) + "\n\n\n");
        }
        System.out.println("------ORDER DETAILS---------");
        System.out.println(stringBuilder.toString());
        readWrite.storeOrderDetails(stringBuilder,id);
    }
    public void viewHistory(int id) throws Exception {
        readWrite.viewOrderHistory(id);
    }
}
