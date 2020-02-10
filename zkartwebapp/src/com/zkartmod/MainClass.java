package com.zkartmod;

import java.io.File;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainClass {
    AdminAction adminAction;
    PurchaseAction purchase;
    MainClass() throws Exception {
        adminAction=new AdminAction();
        purchase=new PurchaseAction();
    }

    public static void main(String[] args) throws Exception {
        int choice1;
        String result;
        MainClass mc=new MainClass();

        AccountAction accountAction=new AccountAction();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("-----------------------------------------------Z-KART_APPLICATION-----------------------------------------------------");
            System.out.println("\n1.Login\n2.Sign up\n3.Exit");
            System.out.println("Enter your choice :");
            choice1=Integer.parseInt(sc.next());
            switch(choice1){
                case 1:
                    System.out.println("-------------------------------------------------LOGIN PAGE------------------------------------------------------------");
                    result = accountAction.logIn();
                    //System.out.println(result);
                    if(result.equals("no")){
                        break;
                    }
                    else
                        mc.loggedIn(Integer.parseInt(result));
                    break;
                case 2:
                    // System.out.println("------------------------------------------------------SIGN UP PAGE------------------------------------------------------");
                    accountAction.signUp();
                    break;
                case 3:
                    exit(1);
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }
    public void loggedIn(int id) throws Exception {
        //declarations
        ReadWrite readWrite=new ReadWrite();
        ProfileAction profileAction=new ProfileAction();
        CheckingAndEncryption checkingAndEncryption=new CheckingAndEncryption();
        Scanner sc=new Scanner(System.in);
        int choice2;
        String c,number;
        UserInfoProtos.UserInfo.Builder user=readWrite.getUserInfo(id);
        //read from userinfo.txt
        if(id==0){//if the login person is admin
            System.out.println("--------------------------------------------------------------------------------------ADMIN LOGIN------------------------------------------------------------");
            if(user.getNoOfPurchases()==0){
                user.setNoOfPurchases(1);
                profileAction.changePassword(user,id);
            }
            while(true){
                System.out.println("\n1.Change password\n2.view stocks\n3.Logout:");
                System.out.println("Enter your choice:");

                choice2=Integer.parseInt(sc.next());
                switch(choice2){
                    case 1:
                        profileAction.changePassword(user,id);
                        break;
                    case 2:
                        adminAction.viewStock();
                        System.out.println("Do u wish to reorder or add new product");//if new product need to be added
                        c=sc.next();
                        if(c.equalsIgnoreCase("yes")) {
                            adminAction.addProduct();
                        }
                        break;
                    case 3:
                        return;//logs out
                    default:
                        System.out.println("Enter a valid choice");
                        break;
                }
            }
        }


        else {
            while(true){//if the login is a customer
               readWrite.getCartDetails(id);
                int choice;
                System.out.println("--------------------------------------------------------------USER LOGIN-----------------------------------------------------------------------------");
                System.out.println("\n1.Purchase\n2.Change password\n3.view order history\n4.logout");
                System.out.println("Enter your choice:");
                while(true) {
                    number = sc.next();
                    if (checkingAndEncryption.checkNumber(number)) {
                        choice2 = Integer.parseInt(number);
                        break;
                    }
                    System.out.println("Enter valid choice");
                }
                switch(choice2) {
                    case 1:
                        File file=new File("userinfo/"+id+"/cart.txt");
                        if(readWrite.allProducts.getCartEmpty()||!file.exists()){
                            purchase.purchase(user,id);
                        }
                        else {
                            System.out.println("1.View cart\n2.Purchase more\n3.back");
                            while(true) {
                                number = sc.next();
                                if (checkingAndEncryption.checkNumber(number)) {
                                    choice = Integer.parseInt(number);
                                    break;
                                }
                                System.out.println("Enter valid choice");
                            }
                            switch (choice){
                                case 1:
                                    purchase.viewCart(user,id);
                                    break;
                                case 2:
                                    purchase.purchase(user,id);
                                    break;
                                case 3:
                                default:
                                    break;
                            }
                        }
                        break;
                    case 2:
                        profileAction.changePassword(user,id);
                        break;
                    case 3:
                        System.out.println("-------------------------------------------------------------------------ORDER HISTORY-------------------------------------------------------------");
                        purchase.viewHistory(id);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
    }


}
