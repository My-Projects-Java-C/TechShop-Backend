package com.example.techshop.iam.infraestructure.token.jwtd;

import com.example.techshop.iam.application.internal.outboundservices.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {

    String generateToken(Authentication authentication);

    String getBearerTokenFrom(HttpServletRequest token);

}
