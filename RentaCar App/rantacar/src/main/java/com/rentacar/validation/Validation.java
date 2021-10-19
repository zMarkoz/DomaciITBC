package com.rentacar.validation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validation {

    //Validnost maila


    public static boolean isEmailValid(String email) {

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    //Validnost passworda

    public static boolean isPasswordValid(String password) {

        if (password.length() < 8) {
            return false;
        }
        boolean hasNumber = false;
        boolean hasLetter = false;
        char[] array = password.toCharArray();
        for (char c : array) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (hasLetter && hasNumber) {
                return true;
            }
        }
        return false;
    }

    //Hush enkripcija

    public static String getSHA256(String password) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] digestedBytes = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digestedBytes){
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
