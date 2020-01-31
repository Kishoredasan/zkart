package com.zkartmod;
import com.zkartmod.LoginInfoProtos.Login;
import com.zkartmod.LoginInfoProtos.AllLoginInfo;
import com.zkartmod.OrderDetailsProtos.Invoice;
import com.zkartmod.PasswordHistoryProtos.History;
import com.zkartmod.UserInfoProtos.UserInfo;
import java.io.*;

public class testadd {
    public static void main(String args[])throws Exception{
        AllLoginInfo.Builder all=AllLoginInfo.newBuilder();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
            FileInputStream inputStream=new FileInputStream("login.txt");
            try{
                all.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }

        }catch (FileNotFoundException e){
            System.out.println("login.txt not found");
        }

        Login.Builder login = Login.newBuilder();
        System.out.println("Enter mail id:");
        login.setMail(br.readLine());
        if(!(all.getLoginCount()>0)){
            login.setID(0);
        }else
            login.setID(all.getLoginCount());
        System.out.println("Enter password:");
        login.setPassword(br.readLine());
        all.addLogin(login.build());
        FileOutputStream outputStream=new FileOutputStream("login.txt");
        try {
            all.build().writeTo(outputStream);
        } finally{
            outputStream.close();
        }
        File file=new File("userinfo/"+login.getID());
        if(file.mkdir()){
            System.out.println("created");
        }
        Invoice.Builder inv=Invoice.newBuilder();
        FileOutputStream fileOutputStream=new FileOutputStream("userinfo/"+login.getID()+"/allorder.txt");
        inv.setMail(login.getMail());
        try{
            inv.build().writeTo(fileOutputStream);
        }finally {
            fileOutputStream.close();
        }
        History.Builder history=History.newBuilder();
        history.setID(login.getID());
        history.addPassword(login.getPassword());
        FileOutputStream fileOutputStream1=new FileOutputStream("userinfo/"+login.getID()+"/passwordhistory.txt");
        try{
            history.build().writeTo(fileOutputStream1);
        }finally {
            fileOutputStream1.close();
        }
        UserInfo.Builder user=UserInfo.newBuilder();
        System.out.println("Enter your name:");
        user.setName(br.readLine());
        user.setNoOfPurchases(0);
        user.setDiscountCode("no");
        user.setDiscountValidity(0);
        user.setMail(login.getMail());
        System.out.println("Enter the phone number:");
        user.setPhoneNumber(br.readLine());
        FileOutputStream fileOutputStream2=new FileOutputStream("userinfo/"+login.getID()+"/userinfo.txt");
        try{
            user.build().writeTo(fileOutputStream2);
        }finally {
            fileOutputStream2.close();
        }
    }
}
