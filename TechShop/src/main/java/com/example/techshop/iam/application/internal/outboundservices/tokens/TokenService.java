package com.example.techshop.iam.application.internal.outboundservices.tokens;

public interface TokenService {

    String generateToken(String username);

    String getUserEmailFromToken(String token);

    boolean validateToken(String token);
}
