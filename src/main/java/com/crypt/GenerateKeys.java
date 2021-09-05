package com.crypt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.RSAPrivateCrtKeySpec;

public class GenerateKeys {
    private KeyPairGenerator keyGen;
    private KeyPair pair;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public GenerateKeys(int keylength) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(keylength);
    }

    public void createKeys() {
        this.pair = this.keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public static String getPubliKeyAsXml(PrivateKey privateKey) throws Exception {
        // key pair is in 'kp'
        StringBuilder sb = new StringBuilder();
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec ks = kf.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        sb.append("<RSAKeyValue>");
        sb.append("<Modulus>" + ks.getModulus() + "</Modulus>");
        sb.append("<Exponent>" + ks.getPublicExponent() + "</Exponent>");
        sb.append("<P>" + ks.getPrimeP() + "</P>");
        sb.append("<Q>" + ks.getPrimeQ() + "</Q>");
        sb.append("<DP>" + ks.getPrimeExponentP() + "</DP>");
        sb.append("<DQ>" + ks.getPrimeExponentQ() + "</DQ>");
        sb.append("<InverseQ>" + ks.getCrtCoefficient() + "</InverseQ>");
        sb.append("<D>" + ks.getPrivateExponent() + "</D>");
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }

    public static String getPublicKeyAsXml(PrivateKey privateKey) throws Exception {
        StringBuilder sb = new StringBuilder();
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec ks = kf.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        sb.append("<RSAKeyValue>");
        sb.append("<Modulus>" + ks.getModulus() + "</Modulus>");
        sb.append("<Exponent>" + ks.getPublicExponent() + "</Exponent>");
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }

    public static String getPrivateKeyAsXml(PrivateKey privateKey) throws Exception {
        StringBuilder sb = new StringBuilder();
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec ks = kf.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        sb.append("<RSAKeyValue>");
        sb.append("<Modulus>" + ks.getModulus() + "</Modulus>");
        sb.append("<Exponent>" + ks.getPublicExponent() + "</Exponent>");
        sb.append("<P>" + ks.getPrimeP() + "</P>");
        sb.append("<Q>" + ks.getPrimeQ() + "</Q>");
        sb.append("<DP>" + ks.getPrimeExponentP() + "</DP>");
        sb.append("<DQ>" + ks.getPrimeExponentQ() + "</DQ>");
        sb.append("<InverseQ>" + ks.getCrtCoefficient() + "</InverseQ>");
        sb.append("<D>" + ks.getPrivateExponent() + "</D>");
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }

    public static void main(String[] args) {
        GenerateKeys gk;
        try {
            gk = new GenerateKeys(1024);
            gk.createKeys();
            gk.writeToFile("src/main/resources/KeyPair/publicKey", gk.getPublicKey().getEncoded());
            gk.writeToFile("src/main/resources/KeyPair/privateKey", gk.getPrivateKey().getEncoded());

            // print xml format
            System.out.println(getPrivateKeyAsXml(gk.getPrivateKey()));
            System.out.println(getPubliKeyAsXml(gk.getPrivateKey()));
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
