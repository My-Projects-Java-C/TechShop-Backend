package com.example.techshop.iam.interfaces.rest.resources;

import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.interfaces.rest.resource.ProfileResource;

import java.util.List;

public record UserResource(Long id, String email, List<String> roles, ProfileResource profile) {}
