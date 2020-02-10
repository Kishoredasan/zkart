package com.zkartmod;
import java.util.Scanner;

public class ProfileAction {
    ReadWrite readWrite;
    CheckingAndEncryption checkingAndEncryption;

    ProfileAction() throws Exception {
        readWrite=new ReadWrite();
        checkingAndEncryption=new CheckingAndEncryption();
    }


    public void changePassword(UserInfoProtos.UserInfo.Builder user,int id)throws Exception{

        String password,reTypePassword;
        System.out.println("------------------------------------------------------------------------------CHANGE PASSWORD----------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        LoginInfoProtos.Login.Builder login=readWrite.getLogin(id);
        PasswordHistoryProtos.History.Builder history=readWrite.getHistory(id);


        if(id!=0){
            System.out.println("password:");
            password = sc.next();
            String encryptPass = checkingAndEncryption.encrypt(password);
            if (!encryptPass.equals(login.getPassword())) {
                System.out.println("invalid password");
                return;
            }}

        while (true) {
            System.out.println("new password:");
            password = sc.next();
            if(!checkingAndEncryption.checkPassword(password)){
                System.out.println("Password should contain at least 2 digit ,2 upper case ,2 lower case letters and with minimum of length 6");
                continue;
            }
            System.out.println("Retype password:");
            reTypePassword = sc.next();
            //System.out.println(password + " " + reTypePassword);
            if (!password.equals(reTypePassword)) {
                System.out.println("password does not match");
                continue;
            }
            String encryptedPassword = checkingAndEncryption.encrypt(password);
            boolean result=passwordHistoryCheck(encryptedPassword,id,user,login,history);
            //System.out.println(result);
            if ( result ){
                System.out.println("changed");
            }
            else {
                System.out.println("Your password should not be the same as last three password enter new password");
                continue;
            }

            break;
        }

    }
    public boolean passwordHistoryCheck(String pass,int id, UserInfoProtos.UserInfo.Builder user, LoginInfoProtos.Login.Builder login,
                                        PasswordHistoryProtos.History.Builder history) throws Exception{
        //System.out.println(history.getPasswordCount());
        for(int i=0;i<history.getPasswordCount();i++){
            if(pass.equals(history.getPassword(i))){
                //System.out.println("inside");
                return false;
            }}
        //System.out.println("password true");
        switch (history.getPasswordCount()){
            case 1 :
            case 2 :
                history.addPassword(pass);
                break;
            case 3:
                history.setPassword(0,history.getPassword(1));
                history.setPassword(1,history.getPassword(2));
                history.setPassword(2,pass);
        }
        readWrite.updatePassword(history,id);
        login.setPassword(pass);
        readWrite.updateLogin(login,id);
        readWrite.update(user,id);
        return true;
    }

    public boolean changePhoneNumber(int id,UserInfoProtos.UserInfo.Builder user) throws Exception {
        String password,phoneNumber;
        Scanner sc=new Scanner(System.in);
        System.out.println("password:");
        password = sc.next();
        String encryptPass = checkingAndEncryption.encrypt(password);
        if (readWrite.checkPassword(id,encryptPass)) {
            System.out.println("invalid password");
            return false;
        }
        System.out.println("Enter new phone number");
        while (true) {
            phoneNumber = sc.next();
            if (!checkingAndEncryption.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Enter a valid phone number of 10 digits:");
            } else
                break;
        }
        user.setPhoneNumber(phoneNumber);
        readWrite.update(user,id);
        return true;
    }

    public boolean changeName(int id , UserInfoProtos.UserInfo.Builder user)throws Exception{
        String password,name;
        Scanner sc=new Scanner(System.in);
        System.out.println("password:");
        password = sc.next();
        String encryptPass = checkingAndEncryption.encrypt(password);
        if (readWrite.checkPassword(id,encryptPass)) {
            System.out.println("invalid password");
            return false;
        }
        System.out.print("Enter new name:");
        name=sc.next();
        user.setName(name);
        readWrite.update(user,id);
        return true;
    }
}
