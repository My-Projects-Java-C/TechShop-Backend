package com.example.techshop.iam.domain.model.commands;

import com.example.techshop.iam.domain.model.entities.Role;
import com.example.techshop.profile.domain.model.valueobject.IdentityDocument;
import com.example.techshop.profile.domain.model.valueobject.Location;

import java.util.List;

public record SignUpCommand(String email,
                            String password,
                            List<Role> roles,
                            String name,
                            String lastName,
                            IdentityDocument identityDocument,
                            Location location) {
}
