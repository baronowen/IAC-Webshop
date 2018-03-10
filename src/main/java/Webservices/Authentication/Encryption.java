package Webservices.Authentication;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    // Encrypt the salt key
    protected static final String salt_key1 = getSHA512SecurePassword("bF05gfuctgCYkQTUcrKM", "tF2QNMkFjfrH6AIirKqG");
    protected static final String salt_key2 = getSHA512SecurePassword("I3hOjsmOpNSSE0LihQk0", "vMMOjTwxDMltIllHG8WI");
    protected static final String salt_key3 = getSHA512SecurePassword("tF2QNMkFjfrH6AIirKqG", "m7q5phI4um8NV6PV4vzL");

    private static String getSHA512SecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static String encrypt (String password) {

        String encrypted = password;

        // encrypt a total of 1000x with 3 different salts
        for (int i=0; i < 10; i++) {
            encrypted = getSHA512SecurePassword(encrypted, salt_key1);
            for (int ii = 0; ii < 10; ii++) {
                encrypted = getSHA512SecurePassword(encrypted, salt_key2);
                for (int iii = 0; iii < 10; iii++) {
                    encrypted = getSHA512SecurePassword(encrypted, salt_key3);
                }
            }
        }

        return encrypted;

    }

    // Just for the lolz, only works with single small letter
    public static void decrypter (String hashed) {


        String s = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //Process char

            if (hashed.equals(  encrypt(String.valueOf(c)) )) {

                System.out.println("The password was: " + c);
                break;

            }


        }


    }

    // 3x salt keys
    public static void main (String[] args) {

        String hash = encrypt("A random password");
        System.out.println(hash);

    }

}
