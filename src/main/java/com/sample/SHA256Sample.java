package com.sample;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
--input--
HelloWorld

--output--
872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4
*/

/*
--input--
Javarmi123

--output--
f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678
*/

public class SHA256Sample {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String passwordToHash = scanner.next();
        String generatedPassword = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
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
