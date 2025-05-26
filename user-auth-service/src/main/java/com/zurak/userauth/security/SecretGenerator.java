package com.zurak.userauth.security;
import java.util.Base64;
import java.security.SecureRandom;

public class SecretGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[32]; // 256 bits (recommended minimum)
        random.nextBytes(keyBytes);
        String secretKey = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println("Generated Secret Key: " + secretKey);
    }
}