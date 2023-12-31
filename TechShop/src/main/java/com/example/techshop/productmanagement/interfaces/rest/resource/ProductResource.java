package com.example.techshop.productmanagement.interfaces.rest.resource;

import com.example.techshop.profile.interfaces.rest.resource.ProfileResource;

import java.util.List;

public record ProductResource(Long id, ProfileResource profile, List<String> categories,
                              Long stock, Float unitPrice) {
}
