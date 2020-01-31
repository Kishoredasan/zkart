package com.zkartmod;

import java.io.*;
import com.zkartmod.InventoryInfoProtos.Product;
import com.zkartmod.InventoryInfoProtos.Products;
public class additem {

        static Product PromptForAddress(BufferedReader stdin,
                                                            PrintStream stdout) throws IOException {
            Product.Builder product = Product.newBuilder();
            stdout.print("Is this a mobile, laptop, or tablet? ");
            String type = stdin.readLine();
            if (type.equals("mobile")) {
                product.setCategory(InventoryInfoProtos.productType.MOBILE);
            } else if (type.equals("laptop")) {
                product.setCategory(InventoryInfoProtos.productType.LAPTOP);
            } else if (type.equals("tablet")) {
                product.setCategory(InventoryInfoProtos.productType.TABLET);
            } else {
                stdout.println("Unknown phone type.  Using default.");
            }
            stdout.print("Enter product ID: ");
            product.setProdID(Integer.valueOf(stdin.readLine()));

            stdout.print("Enter brand: ");
            product.setBrand(stdin.readLine());

            stdout.print("Enter Model");
            String email = stdin.readLine();
            if (email.length() > 0) {
                product.setModel(email);
            }


            stdout.print("Enter price: ");
            String number = stdin.readLine();
            product.setPrice(Integer.parseInt(number));
            stdout.println("enter no of stock:");
            product.setStock(Integer.parseInt(stdin.readLine()));
            stdout.println("date");
            product.setDate(stdin.readLine());
            product.setNoOfDays(Integer.parseInt(stdin.readLine()));




            return product.build();
        }

        // Main function:  Reads the entire address book from a file,
        //   adds one person based on user input, then writes it back out to the same
        //   file.
        public static void main(String[] args) throws Exception {

            Products.Builder addressBook = Products.newBuilder();

            // Read the existing address book.
            try {
                FileInputStream input = new FileInputStream("userinfo/0/inventory.txt");
                try {
                    addressBook.mergeFrom(input);
                } finally {
                    try { input.close(); } catch (Throwable ignore) {}
                }
            } catch (FileNotFoundException e) {
                System.out.println("inventory.txt: File not found.  Creating a new file.");
            }

            // Add an address.
            addressBook.addProduct(
                    PromptForAddress(new BufferedReader(new InputStreamReader(System.in)),
                            System.out));

            // Write the new address book back to disk.
            FileOutputStream output = new FileOutputStream("userinfo/0/inventory.txt");
            try {
                addressBook.build().writeTo(output);
            } finally {
                output.close();
            }
            Products prod = Products.parseFrom(new FileInputStream("userinfo/0/inventory.txt"));
            for (Product pr:prod.getProductList()
            ) {
                System.out.println(pr);
            }

        }
    }


