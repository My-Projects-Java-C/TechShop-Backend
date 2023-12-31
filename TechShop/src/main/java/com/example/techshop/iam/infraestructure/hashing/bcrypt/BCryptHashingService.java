package com.example.techshop.iam.infraestructure.hashing.bcrypt;

import com.example.techshop.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}
