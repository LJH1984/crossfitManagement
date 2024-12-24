package main.java.com.crossfitmanagement.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    // AES 키 (최소 16바이트)
    private static final String SECRET_KEY

    //비밀번호를 SHA-256으로 암호화
    public static String encryptPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();

        for(byte b : hashedBytes){
            sb.append(String.format("%02x",b));
        }
        return sb.toString();
    }

}

