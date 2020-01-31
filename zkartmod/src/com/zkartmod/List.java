package com.zkartmod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.zkartmod.LoginInfoProtos.Login;
import com.zkartmod.LoginInfoProtos.AllLoginInfo;
public class List {

        // Iterates though all people in the AddressBook and prints info about them.
        static void Print(AllLoginInfo addressBook) {
            for (Login person: addressBook.getLoginList()) {
                System.out.println("Person ID: " + person.getMail());
                System.out.println("  Name: " + person.getID());

            }
        }

        // Main function:  Reads the entire address book from a file and prints all
        //   the information inside.
        public static void main(String[] args) throws Exception {

            // Read the existing address book.
            AllLoginInfo addressBook =
                    AllLoginInfo.parseFrom(new FileInputStream("login.txt"));

            Print(addressBook);

            System.out.println(addressBook.getLoginCount());
        }
    }



