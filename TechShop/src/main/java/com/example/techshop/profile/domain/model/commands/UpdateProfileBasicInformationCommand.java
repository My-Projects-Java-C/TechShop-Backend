package com.example.techshop.profile.domain.model.commands;

import com.example.techshop.profile.domain.model.valueobject.IdentityDocument;
import com.example.techshop.profile.domain.model.valueobject.Location;

public record UpdateProfileBasicInformationCommand(Long profileId, String name, String lastName, String photo,
                                                   IdentityDocument identityDocument, Location location) {
}
