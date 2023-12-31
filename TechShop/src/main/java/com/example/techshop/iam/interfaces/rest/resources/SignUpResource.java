package com.example.techshop.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String email,
                             String password,
                             List<String> roles,
                             String name,
                             String lastName,
                             String country,
                             String address,
                             String document,
                             String identity) {
}
