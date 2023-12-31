package com.example.techshop.profile.interfaces.rest.resource;

public record ProfileResource(Long Id, String name, String lastName, String photo, String document, String identity,
                              String Country, String address) {
}
