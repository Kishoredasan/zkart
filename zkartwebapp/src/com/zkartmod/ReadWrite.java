package com.zkartmod;
import com.zkartmod.LoginInfoProtos.AllLoginInfo;
import com.zkartmod.LoginInfoProtos.Login;
import com.zkartmod.OrderDetailsProtos.Invoice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadWrite {
    AllLoginInfo.Builder all=AllLoginInfo.newBuilder();
    Login.Builder login=null;
    PasswordHistoryProtos.History.Builder history=null;
    Invoice.Builder inv=null;
    UserInfoProtos.UserInfo.Builder user=null;
    InventoryInfoProtos.Products.Builder prods=InventoryInfoProtos.Products.newBuilder();
    InventoryInfoProtos.Product.Builder prod=null;
    boolean present=true,inventoryPresent=true;
    CartDetailsProtos.AllProductsInCart.Builder allProducts;


    ReadWrite()throws Exception{
        allProducts= CartDetailsProtos.AllProductsInCart.newBuilder();
        try{
            FileInputStream inputStream=new FileInputStream("login.txt");
            try{
                all.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }
        }catch (FileNotFoundException e){
            System.out.println("login.txt not found,creating new");
            present=false;
        }

        //to get details from inventory file
        try{
            FileInputStream inputStream=new FileInputStream("userinfo/0/inventory.txt");
            try{
                prods.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }
        }catch (FileNotFoundException e){
            System.out.println("login.txt not found,creating new");
            inventoryPresent=false;
        }

    }

    public InventoryInfoProtos.Products.Builder getProds(){
        return prods;
    }

    public String isMailAlreadyPresent(String mail){
        int Id;
        if(!present){
            return "false";
        }
        for (Login log:all.getLoginList()) {
            if(log.getMail().equals(mail)){
                Id=log.getID();
                return Id+"";
            }
        }
        return "false";
    }
    public int update(String mail,String encryptedPassword)throws Exception{
        login = LoginInfoProtos.Login.newBuilder();
        login.setMail(mail);

        if(!(all.getLoginCount()>0)){
            login.setID(0);
        }else
            login.setID(all.getLoginCount());

        login.setPassword(encryptedPassword);
        all.addLogin(login.build());
        FileOutputStream outputStream=new FileOutputStream("login.txt");

        try {
            all.build().writeTo(outputStream);
        } finally{
            outputStream.close();
        }
        return login.getID();
    }

    public void createAccount(String name,String phoneNumber) throws IOException {
        inv= OrderDetailsProtos.Invoice.newBuilder();
        FileOutputStream fileOutputStream=new FileOutputStream("userinfo/"+login.getID()+"/allorder.txt");
        inv.setMail(login.getMail());

        try{
            inv.build().writeTo(fileOutputStream);
        }finally {
            fileOutputStream.close();
        }

        history= PasswordHistoryProtos.History.newBuilder();
        history.setID(login.getID());
        history.addPassword(login.getPassword());
        FileOutputStream fileOutputStream1=new FileOutputStream("userinfo/"+login.getID()+"/passwordhistory.txt");

        try{
            history.build().writeTo(fileOutputStream1);
        }finally {
            fileOutputStream1.close();
        }

        user= UserInfoProtos.UserInfo.newBuilder();
        user.setName(name);
        user.setNoOfPurchases(0);
        user.setDiscountCode("no");
        user.setDiscountValidity(0);
        user.setMail(login.getMail());
        user.setPhoneNumber(phoneNumber);
        FileOutputStream fileOutputStream2=new FileOutputStream("userinfo/"+login.getID()+"/userinfo.txt");

        try{
            user.build().writeTo(fileOutputStream2);
        }finally {
            fileOutputStream2.close();
        }

        System.out.println("Success,now login");
    }
    public boolean checkPassword(int id , String encryptedPassword){
        login=all.getLoginBuilder(id);
        return encryptedPassword.equals(login.getPassword());
    }
    public void update(UserInfoProtos.UserInfo.Builder user,int id)throws Exception{
        FileOutputStream output = new FileOutputStream("userinfo/"+id+"/userinfo.txt");
        try {
            user.build().writeTo(output);
        } finally {
            output.close();
        }
    }
    public UserInfoProtos.UserInfo.Builder getUserInfo(int id) throws IOException {
        user= UserInfoProtos.UserInfo.newBuilder();
        //read from userinfo.txt
        try{
            FileInputStream inputStream=new FileInputStream("userinfo/"+id+"/userinfo.txt");
            try{
                user.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }

        }catch (FileNotFoundException e){
            System.out.println("userinfo.txt not found");
        }
        return user;
    }
    public Login.Builder getLogin(int id){
       return all.getLoginBuilder(id);
    }
    public PasswordHistoryProtos.History.Builder getHistory(int id) throws IOException {
        try{
            FileInputStream inputStream=new FileInputStream("userinfo/"+id+"/passwordhistory.txt");
            try{
                history.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }

        }catch (FileNotFoundException e){
            System.out.println("password.txt not found");
        }
        return history;
    }

    public void updatePassword(PasswordHistoryProtos.History.Builder history, int id) throws IOException {
        FileOutputStream output = new FileOutputStream("userinfo/"+id+"/passwordhistory.txt");
        try {
            history.build().writeTo(output);
        } finally {
            output.close();
        }
    }

    public void updateLogin(Login.Builder login, int id) throws IOException {
        all.setLogin(id,login);
        FileOutputStream outputs = new FileOutputStream("login.txt");
        try {
            all.build().writeTo(outputs);
        } finally {
            outputs.close();
        }
    }
    public void updateItems(InventoryInfoProtos.Product.Builder product,int index)throws Exception{
        prods.setProduct(index,product.build());


        FileOutputStream output = new FileOutputStream("userinfo/0/inventory.txt");
        try {
            prods.build().writeTo(output);
        } finally {
            output.close();
        }
    }

    public void getCartDetails(int id) throws IOException {
        try{
            FileInputStream inputStream=new FileInputStream("userinfo/"+id+"/cart.txt");
            try{
                allProducts.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }
        }catch (FileNotFoundException e){
            System.out.println("file data not found,sorry");
        }

    }
    public void addToCart(int id, int prodId, int count) throws IOException {
        CartDetailsProtos.Product.Builder cartProduct= CartDetailsProtos.Product.newBuilder();
        getCartDetails(id);
        cartProduct.setProductId(prodId);
        cartProduct.setCount(count);
        allProducts.addProd(cartProduct.build());
        allProducts.setCartEmpty(false);
        FileOutputStream output = new FileOutputStream("userinfo/"+id+"/cart.txt");//adding to cart
        try {
            allProducts.build().writeTo(output);
        } finally {
            output.close();
        }
    }
    public void storeOrderDetails(StringBuilder stringBuilder,int id) throws IOException {
        inv=OrderDetailsProtos.Invoice.newBuilder();

        try{
            FileInputStream fileInputStream=new FileInputStream("userinfo/"+id+"/allorder.txt");
            try{
                inv.mergeFrom(fileInputStream);
            }
            finally {
                try{ fileInputStream.close();} catch (Throwable ignore){}
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found creating new");
        }

        inv.addOrderDetails(stringBuilder.toString());
        FileOutputStream outputStream = new FileOutputStream("userinfo/"+id+"/allorder.txt");//storing the invoice details
        try {
            inv.build().writeTo(outputStream);
        } finally {
            outputStream.close();
        }
    }
    public  void viewOrderHistory(int id) throws Exception{
        inv =Invoice.newBuilder();

        try{
            FileInputStream inputStream=new FileInputStream("userinfo/"+id+"/allorder.txt");
            try{
                inv.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }
        }catch (FileNotFoundException e){
            System.out.println("file data not found,sorry");
            return;
        }

        for (String details:inv.getOrderDetailsList())
        {
            System.out.println(details);
            System.out.println("\n");
        }
    }
}
