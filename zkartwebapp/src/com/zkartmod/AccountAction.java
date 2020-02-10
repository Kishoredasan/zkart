package com.zkartmod;

import java.io.File;
import java.util.Scanner;

public class AccountAction {
    CheckingAndEncryption checkingAndEncryption;
    ReadWrite readWrite;

    public AccountAction() throws Exception {
        checkingAndEncryption=new CheckingAndEncryption();
        readWrite=new ReadWrite();
    }


    public void signUp()throws Exception {

        String mail, name, phoneNumber, password, reTypePassword;
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------SIGN UP PAGE------------------------------------------------------");

        while (true) {
            System.out.print("Enter your mail:");
            mail = sc.next();
            if (checkingAndEncryption.isValidMAil(mail)) {
                break;
            }
            System.out.println("Please enter a valid email:");
        }

        if (!(readWrite.isMailAlreadyPresent(mail).equals("false"))) {
            System.out.println("Mail already exists ,please login");
            return;
        }

        System.out.println("Enter your name: ");
        name = sc.next();

        while (true) {
            System.out.println("Enter your phone number:");
            phoneNumber = sc.next();
            if (!checkingAndEncryption.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Enter a valid phone number of 10 digits:");
            } else
                break;
        }

        while (true) {
            // number=0;lowercase=0;uppercase=0;

            System.out.println("password:");
            password = sc.next();

            boolean result = checkingAndEncryption.checkPassword(password);

            if (!result) {
                System.out.println("Password should contain atleast 2 digit ,2 upper case ,2 lower case letters and with minimum of length 6");
                continue;
            }

            System.out.println("Retype password:");
            reTypePassword = sc.next();
            //System.out.println(password + " " + reTypePassword);

            if (!password.equals(reTypePassword)) {
                System.out.println("password doesn't match");
                continue;
            }
            break;
        }

        String encryptedPassword = checkingAndEncryption.encrypt(password);

        int id = readWrite.update(mail, encryptedPassword);
        File file = new File("userinfo/" + id);
        if (file.mkdir()) {
            System.out.println("account created");
        }
        readWrite.createAccount(name,phoneNumber);
    }
    public String logIn(){
        Scanner sc=new Scanner(System.in);
        String mail,result,password;
        int Id;
        while(true) {
            System.out.println("Enter your mail:");

            mail = sc.nextLine();
            if (!checkingAndEncryption.isValidMAil(mail)) {
                System.out.println("Enter a valid email id:");
            }
            else
                break;
        }
        result=readWrite.isMailAlreadyPresent(mail);
        if (result.equals("false")||!readWrite.present) {
            System.out.println("account does not exists please signup");
            return "no";
        }
        Id=Integer.parseInt(result);
        System.out.println("password:");
        password = sc.next();
        String encryptPass = checkingAndEncryption.encrypt(password);
        if(readWrite.checkPassword(Id,encryptPass))
            return Id+"";
        else
        {
            System.out.println("Invalid password try again");
            return "no";
        }
    }
}
