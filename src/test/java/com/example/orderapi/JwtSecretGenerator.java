package com.example.orderapi;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;

public class JwtSecretGenerator {
    public static void main(String[] args) {
        // Generate a secure key for HS512
        byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);
        
        System.out.println("Generated JWT Secret:");
        System.out.println(base64Key);
        System.out.println("\nAdd this to application.properties:");
        System.out.println("jwt.secret=" + base64Key);
    }
}