package com.zkartmod;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminAction {
    ReadWrite readWrite;
    CheckingAndEncryption checkingAndEncryption;
    AdminAction() throws Exception {
        readWrite=new ReadWrite();
        checkingAndEncryption=new CheckingAndEncryption();
    }

public void viewStock(){
        int type;
        String category;
    InventoryInfoProtos.Products.Builder prods=readWrite.getProds();
    System.out.println("---------------------------------------------------------STOCK DETAILS-------------------------------------------------------------------------");
    if(readWrite.inventoryPresent||prods.getProductCount()>0){
        System.out.println("category\tbrand\tmodel\tprice\tstock");
        for (InventoryInfoProtos.Product prod:prods.getProductList())
        {
            type= prod.getCategoryValue();
            if(type==0){
                category="MOBILE";
            }else if(type==1){
                category="LAPTOP";
            }else
                category="TABLET";
            System.out.println(category+"\t"+prod.getBrand()+"\t"+prod.getModel()+"\t"+prod.getPrice()+"\t"+prod.getStock());//display all inventory details
        }
    }
    else
        System.out.println("NO STOCKS");
}
public void addProduct() throws Exception {
    int choice,price,stock,validity;
    String number;
    Scanner sc=new Scanner(System.in);
    String category,brand,model;
    category="";
        System.out.println("Choose category:");
        System.out.println("1.Mobile\n2.Laptop\n3.Tablet\n4.Exit");
        choice = Integer.parseInt(sc.next());
        switch (choice) {
            case 1:
                category = "Mobile";
                break;
            case 2:
                category = "Laptop";
                break;
            case 3:
                category = "Tablet";
                break;
            case 4:
                break;
            default:
                System.out.println("Enter a valid choice");
        }
        if(choice==4)
            return;
        System.out.print("Brand:");
        brand=sc.next();
        System.out.print("Model:");
        model=sc.next();
        while(true) {
            System.out.println("Price:");
            number= sc.next();
            if(checkingAndEncryption.checkNumber(number)){
                price=Integer.parseInt(number);
                break;
            }
            System.out.println("Enter valid number");
        }
        while(true) {
            System.out.print("no of stock u wish to order:");
            number = sc.next();
            if (checkingAndEncryption.checkNumber(number)) {
                stock = Integer.parseInt(number);
                break;
            }
            System.out.println("Enter valid number");
        }
        while(true){
            System.out.println("Enter the no of days remaining to apply deal of moment");
            number = sc.next();
            if (checkingAndEncryption.checkNumber(number)) {
                validity= Integer.parseInt(number);
                break;
            }
            System.out.println("Enter valid number:");
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        String today=simpleDateFormat.format(date);
        addStock(choice,category,brand,model,stock,validity,price,today);//update the data in file
    }
    public void addStock(int ch,String category,String brand,String model,int stock,int validity,int price,String today) throws Exception {
        int added=0,i=0;
        InventoryInfoProtos.Products.Builder prods=readWrite.getProds();
        //output = new BufferedWriter(new FileWriter("z-kart_db.txt"));
        for (InventoryInfoProtos.Product.Builder prod:prods.getProductBuilderList()) {


            if (prod.getCategoryValue() == ch-1) {
                if (prod.getBrand().equalsIgnoreCase(brand)) {
                    if (prod.getModel().equalsIgnoreCase(model)) {
                        prod.setStock( prod.getStock() + stock);
                        prod.setDate( today);
                        prod.setNoOfDays(validity);
                        prod.setPrice(price);
                        readWrite.updateItems(prod,i);
                        added = 1;
                        break;
                    }
                    i++;
                }
            }
        }


        if(added==0){
            InventoryInfoProtos.Product.Builder prod= InventoryInfoProtos.Product.newBuilder();
            prod.setProdID(prods.getProductCount());
            prod.setPrice(price);
            prod.setNoOfDays(validity).setCategory(InventoryInfoProtos.productType.forNumber(ch-1));
            prod.setStock(stock).setDate(today).setBrand(brand).setModel(model);
            prods.addProduct(prod.build());
            FileOutputStream output = new FileOutputStream("userinfo/0/inventory.txt");
            try {
                prods.build().writeTo(output);
            } finally {
                output.close();
            }
        }
    }
}
