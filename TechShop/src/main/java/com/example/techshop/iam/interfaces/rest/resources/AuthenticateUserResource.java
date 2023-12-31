package com.example.techshop.iam.interfaces.rest.resources;

import com.example.techshop.profile.interfaces.rest.resource.ProfileResource;

import java.util.List;

public record AuthenticateUserResource(Long id, String email, List<String> roles, String token, ProfileResource profile) {
}
