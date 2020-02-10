package com.zkartmod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckingAndEncryption {
    String numberRegex="-?\\d+(\\.\\d+)?";
    String regex = "^(.+)@(.+)$";
    String phoneRegex="((?=.*\\d).{10})";
    Matcher matcher,matcher1,phoneMatcher,numberMatcher;
    Pattern pattern,pattern1,phonePattern,numberPattern;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String PASSWORD_PATTERN ="((?=.*\\d.*\\d)(?=.*[a-z].*[a-z])(?=.*[A-Z].*[A-Z]).{6,20})";


    public boolean isValidMAil(String mail){

        pattern= Pattern.compile(regex);
        matcher=pattern.matcher(mail);
        return matcher.matches();
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


    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }



    public boolean isValidPhoneNumber(String number){

        phonePattern=Pattern.compile(phoneRegex);
        phoneMatcher=phonePattern.matcher(number);
        return phoneMatcher.matches();
    }


    public String encrypt(String pass) {

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

}
