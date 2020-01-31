package com.zkartmod;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.zkartmod.LoginInfoProtos.AllLoginInfo;
import com.zkartmod.LoginInfoProtos.Login;
import com.zkartmod.OrderDetailsProtos.Invoice;
import static java.lang.System.exit;


public class MainClass {
    //all declarations
    String numberRegex="-?\\d+(\\.\\d+)?";
    String regex = "^(.+)@(.+)$";
    String phoneRegex="((?=.*\\d).{10})";
    float total=0.0f;
    float discount=0.0f;
    int discountPercentage;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String PASSWORD_PATTERN ="((?=.*\\d.*\\d)(?=.*[a-z].*[a-z])(?=.*[A-Z].*[A-Z]).{6,20})";
    boolean present=true,inventoryPresent=true;
    Matcher matcher,matcher1,phoneMatcher,numberMatcher;
    Pattern pattern,pattern1,phonePattern,numberPattern;
    AllLoginInfo.Builder all=AllLoginInfo.newBuilder();
    Login.Builder login=null;
    PasswordHistoryProtos.History.Builder history=null;
    Invoice.Builder inv=null;
    UserInfoProtos.UserInfo.Builder user=null;
    InventoryInfoProtos.Products.Builder prods=InventoryInfoProtos.Products.newBuilder();
    InventoryInfoProtos.Product.Builder prod=null;
    Date date=new Date();
    Date date2;
    Date date1;
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");



    MainClass() throws Exception {

        //to get details from login file
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


    // After a login successfull
    public void loggedIn(int id) throws Exception {
        //declarations
        Scanner sc=new Scanner(System.in);
        int choice2;
        String category,c,brand,model,number;
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


        if(id==0){//if the login person is admin
            System.out.println("--------------------------------------------------------------------------------------ADMIN LOGIN------------------------------------------------------------");
            if(user.getNoOfPurchases()==0){
                user.setNoOfPurchases(1);
                changePassword(user,id);
            }
            while(true){
                System.out.println("\n1.Change password\n2.view stocks\n3.Logout:");
                System.out.println("Enter your choice:");
                int i,type,choice,price,stock,validity;

                choice2=Integer.parseInt(sc.next());
                switch(choice2){
                    case 1:
                        changePassword(user,id);
                        break;
                    case 2:
                        category="";
                        System.out.println("---------------------------------------------------------STOCK DETAILS-------------------------------------------------------------------------");
                        if(inventoryPresent||prods.getProductCount()>0){
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
                        System.out.println("Do u wish to reorder or add new product");//if new product need to be added
                        c=sc.next();
                        if(c.equalsIgnoreCase("yes")) {
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
                                break;
                            System.out.print("Brand:");
                            brand=sc.next();
                            System.out.print("Model:");
                            model=sc.next();
                            while(true) {
                                System.out.println("Price:");
                                number= sc.next();
                                if(checkNumber(number)){
                                    price=Integer.parseInt(number);
                                    break;
                                }
                                System.out.println("Enter valid number");
                            }
                            while(true) {
                                System.out.print("no of stock u wish to order:");
                                number = sc.next();
                                if (checkNumber(number)) {
                                    stock = Integer.parseInt(number);
                                    break;
                                }
                                System.out.println("Enter valid number");
                            }
                            while(true){
                                System.out.println("Enter the no of days remaining to apply deal of moment");
                                number = sc.next();
                                if (checkNumber(number)) {
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
                        break;
                    case 3:
                        return;//logsout
                    default:
                        System.out.println("Enter a valid choice");
                        break;
                }
            }
        }


        else {
            while(true){//if the login is a customer
                System.out.println("--------------------------------------------------------------USER LOGIN-----------------------------------------------------------------------------");
                System.out.println("\n1.Purchase\n2.Change password\n3.view order history\n4.logout");
                System.out.println("Enter your choice:");
                while(true) {
                    number = sc.next();
                    if (checkNumber(number)) {
                        choice2 = Integer.parseInt(number);
                        break;
                    }
                    System.out.println("Enter valid choice");
                }
                switch(choice2) {
                    case 1:
                        purchase(user,id);
                        break;
                    case 2:
                        changePassword(user,id);
                        break;
                    case 3:
                        System.out.println("-------------------------------------------------------------------------ORDER HISTORY-------------------------------------------------------------");
                        viewOrderHistory(id);
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



    //  purchasing option for customer
    public void purchase(UserInfoProtos.UserInfo.Builder user,int id) throws Exception {

        boolean available;
        int choice,j,ch,k=0,invoice;
        String number,choice1;
        String specialDiscount = null;
        boolean isSpecialDiscount = false;
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
            if(!inventoryPresent){
                System.out.println("No stock available");
                break;
            }
            j=1;
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
                    if (checkNumber(number)) {
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
                            if (checkNumber(number)) {
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

        //creating an invoice for the the customer
        Random random = new Random();
        invoice = random.nextInt(899999) + 100000;
        if (k == 0)
            return;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invoice number " + invoice);
        stringBuilder.append("\n").append("Date: " + DateFormat.getInstance().format(new Date()));
        stringBuilder.append("\n").append("Category  Brand  Model  price  count").append("\n");

        for (i = 0; i < k; i++) {
            InventoryInfoProtos.Product product=prods.getProduct(position[i]);
            switch (product.getCategoryValue()){
                case 0:
                    stringBuilder.append("Mobile");
                    break;
                case 1:
                    stringBuilder.append("LAPTOP");
                    break;
                case 2:
                    stringBuilder.append("TABLET");
                    break;
            }


            stringBuilder.append(product.getBrand()+ " " + product.getModel() + " " +product.getPrice() + " " + orderQuantity[i] + "\n");
            total = total + orderQuantity[i] * product.getPrice();
            date2=simpleDateFormat.parse(simpleDateFormat.format(date));
            date1=simpleDateFormat.parse(product.getDate());
            long diff=date2.getTime()-date1.getTime();
            long noOfdays=diff / (1000*60*60*24);
            if (noOfdays>product.getNoOfDays()) {
                specialDiscount = "Brand:" + product.getBrand()+ " model: " + product.getModel();
                discount = discount + ((float) (cart[i] * product.getPrice() / 10));
                isSpecialDiscount=true;
            }
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
                user.setDiscountCode(randomAlphaNumeric(6));
                user.setDiscountValidity(3);
                //customerDetails.noOfPurchases[n] = 0;
                user.setNoOfPurchases(user.getNoOfPurchases()+1);
                user.build();
                stringBuilder.append("You have received a discount " + user.getDiscountCode() + " which is valid for next 3 purchases\n\n\n");
                update(user,id);//updating the user info
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
            update(user,id);//updating the user info
            stringBuilder.append("Discount% :" + discountPercentage + "\n" + "discount:" + discount + "\n");
            stringBuilder.append("Total:" + (total - discount) + "\n\n\n");
        }
        System.out.println("------ORDER DETAILS---------");
        System.out.println(stringBuilder.toString());
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
        FileOutputStream output = new FileOutputStream("userinfo/"+id+"/allorder.txt");//storing the invoice details
        try {
            inv.build().writeTo(output);
        } finally {
            output.close();
        }

    }



    private void viewOrderHistory(int id) throws Exception{
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



    public void addStock(int ch,String category,String brand,String model,int stock,int validity,int price,String today) throws Exception {
        int added=0,i=0;

        //output = new BufferedWriter(new FileWriter("z-kart_db.txt"));
        for (InventoryInfoProtos.Product.Builder prod:prods.getProductBuilderList()) {


            if (prod.getCategoryValue() == ch-1) {
                if (prod.getBrand().equalsIgnoreCase(brand)) {
                    if (prod.getModel().equalsIgnoreCase(model)) {
                        prod.setStock( prod.getStock() + stock);
                        prod.setDate( today);
                        prod.setNoOfDays(validity);
                        prod.setPrice(price);
                        updateItems(prod,i);
                        added = 1;
                        break;
                    }
                    i++;
                }
            }
        }


        if(added==0){
            prod= InventoryInfoProtos.Product.newBuilder();
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



    public void updateItems(InventoryInfoProtos.Product.Builder product,int index)throws Exception{
        prods.setProduct(index,product.build());


        FileOutputStream output = new FileOutputStream("userinfo/0/inventory.txt");
        try {
            prods.build().writeTo(output);
        } finally {
            output.close();
        }
    }



    public void changePassword(UserInfoProtos.UserInfo.Builder user,int id)throws Exception{

        String password,reTypePassword;
        System.out.println("------------------------------------------------------------------------------CHANGE PASSWORD----------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        login=all.getLoginBuilder(id);
        history=PasswordHistoryProtos.History.newBuilder();

        try{
            FileInputStream inputStream=new FileInputStream("userinfo/"+id+"/passwordhistory.txt");
            try{
                user.mergeFrom(inputStream);
            }finally {
                try{ inputStream.close();}catch (Throwable ignore){}
            }

        }catch (FileNotFoundException e){
            System.out.println("password.txt not found");
        }

        if(id!=0){
            System.out.println("password:");
            password = sc.next();
            String encryptPass = encrypt(password);
            if (!encryptPass.equals(login.getPassword())) {
                System.out.println("invalid password");
                return;
            }}

        while (true) {
            System.out.println("new password:");
            password = sc.next();
            if(!checkPassword(password)){
                System.out.println("Password should contain atleast 2 digit ,2 upper case ,2 lower case letters and with minimum of length 6");
                continue;
            }
            System.out.println("Retype password:");
            reTypePassword = sc.next();
            //System.out.println(password + " " + reTypePassword);
            if (!password.equals(reTypePassword)) {
                System.out.println("password doesnot match");
                continue;
            }
            String encryptedPassword = encrypt(password);
            if (passwordHistoryCheck(encryptedPassword,id,user,login,history) ){
                System.out.println("changed");
            } else {
                System.out.println("Your password should not be the same as last three password enter new password");
                continue;
            }

            break;
        }

    }


    public String logIn(){
        Scanner sc=new Scanner(System.in);
        String mail,result,password;
        int Id;
        while(true) {
            System.out.println("Enter your mail:");

            mail = sc.nextLine();
            if (!isValidMAil(mail)) {
                System.out.println("Enter a valid email id:");
            }
            else
                break;
        }
        result=isMailAlreadyPresent(mail);
        if (result.equals("false")||!present) {
            System.out.println("account does not exists please signup");
            return "no";
        }
        Id=Integer.parseInt(result);
        login=all.getLoginBuilder(Id);
        System.out.println("password:");
        password = sc.next();
        String encryptPass = encrypt(password);
        if(encryptPass.equals(login.getPassword()))
        return Id+"";
        else
        {
            System.out.println("Invalid password try again");
            return "no";
        }
    }



    public void signUp()throws Exception{

        String mail,name,phoneNumber,password,reTypePassword;
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------------------SIGN UP PAGE------------------------------------------------------");

        while(true) {
            System.out.print("Enter your mail:");
            mail = sc.next();
            if (isValidMAil(mail)) {
                break;
            }
            System.out.println("Please enter a valid email:");
        }

        if(!(isMailAlreadyPresent(mail).equals("false"))){
            System.out.println("Mail already exists ,please login");
            return;
        }

        System.out.println("Enter your name: ");
        name = sc.next();

        while(true){
            System.out.println("Enter your phone number:");
            phoneNumber = sc.next();
            if (!isValidPhoneNumber(phoneNumber)) {
                System.out.println("Enter a valid phone number of 10 digits:");
            }
            else
                break;
        }

        while (true) {
            // number=0;lowercase=0;uppercase=0;

            System.out.println("password:");
            password = sc.next();

            boolean result=checkPassword(password);

            if(!result){
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

        String encryptedPassword = encrypt(password);
        login = Login.newBuilder();
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

        File file=new File("userinfo/"+login.getID());
        if(file.mkdir()){
            System.out.println("account created");
        }

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


    public boolean passwordHistoryCheck(String pass,int id, UserInfoProtos.UserInfo.Builder user, Login.Builder login,
                                        PasswordHistoryProtos.History.Builder history) throws Exception{

        for(int i=0;i<history.getPasswordCount();i++){
            if(pass.equals(history.getPassword(i))){
                return false;
            }
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

            FileOutputStream output = new FileOutputStream("userinfo/"+id+"/passwordhistory.txt");
            try {
                history.build().writeTo(output);
            } finally {
                output.close();
            }

            login.setPassword(pass);
            all.setLogin(id,login);
            FileOutputStream outputs = new FileOutputStream("login.txt");
            try {
                all.build().writeTo(outputs);
            } finally {
                outputs.close();
            }
        }
        update(user,id);
        return true;
    }


    private String encrypt(String pass) {

        int i;
        StringBuilder encrypt = new StringBuilder();
        for (i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (c == 'z')
                encrypt.append('a');
            else if (c == 'Z')
                encrypt.append('A');
            else if (c == '9')
                encrypt.append('0');
            else {
                if (Character.isDigit(c)) {
                    encrypt.append(c - 47);
                } else {
                    c++;
                    encrypt.append(c);
                }
            }
        }
        return encrypt.toString();
    }



    public boolean isValidMAil(String mail){

        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(mail);
        return matcher.matches();
    }



    public boolean isValidPhoneNumber(String number){

        phonePattern=Pattern.compile(phoneRegex);
        phoneMatcher=phonePattern.matcher(number);
        return phoneMatcher.matches();
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



    public boolean checkNumber(String number){
        numberPattern=Pattern.compile(numberRegex);
        numberMatcher=numberPattern.matcher(number);
        return numberMatcher.matches();
    }


    public boolean checkPassword(String password){
        pattern1=Pattern.compile(PASSWORD_PATTERN);
        matcher1=pattern1.matcher(password);
        return matcher1.matches();
    }



    public void update(UserInfoProtos.UserInfo.Builder user,int id)throws Exception{
        FileOutputStream output = new FileOutputStream("userinfo/"+id+"/userinfo.txt");
        try {
            user.build().writeTo(output);
        } finally {
            output.close();
        }
    }


    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }



    public static void main(String[] args) throws Exception {
        int choice1;
        String result;
        MainClass mc=new MainClass();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("-----------------------------------------------Z-KART_APPLICATION-----------------------------------------------------");
            System.out.println("\n1.Login\n2.Sign up\n3.Exit");
            System.out.println("Enter your choice :");
            choice1=Integer.parseInt(sc.next());
            switch(choice1){
                case 1:
                    System.out.println("-------------------------------------------------LOGIN PAGE------------------------------------------------------------");
                    result = mc.logIn();
                    //System.out.println(result);
                    if(result.equals("no")){
                        break;
                    }
                    else
                        mc.loggedIn(Integer.parseInt(result));
                    break;
                case 2:
                   // System.out.println("------------------------------------------------------SIGN UP PAGE------------------------------------------------------");
                    mc.signUp();
                    break;
                case 3:
                    exit(1);
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }
}
