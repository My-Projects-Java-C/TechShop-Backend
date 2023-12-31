package com.example.techshop.profile.interfaces.rest.resource;

public record UpdateProfileBasicInformationResource(Long profileId, String name, String lastName, String photo, String document, String identity,
                                                    String Country, String address) {
}
