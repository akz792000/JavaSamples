package com.hacker.rank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
--input--
HelloWorld

--output--
68e109f0f40ca72a15e05cc22786f8e6
*/

/*
--input--
Javarmi123

--output--
2da2d1e0ce7b4951a858ed2d547ef485
*/
public class MD5Sample {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String passwordToHash = scanner.next();
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
    }

}
