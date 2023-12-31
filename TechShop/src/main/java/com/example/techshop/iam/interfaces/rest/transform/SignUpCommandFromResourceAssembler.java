package com.example.techshop.iam.interfaces.rest.transform;

import com.example.techshop.iam.domain.model.commands.SignUpCommand;
import com.example.techshop.iam.domain.model.entities.Role;
import com.example.techshop.iam.interfaces.rest.resources.SignUpResource;
import com.example.techshop.profile.domain.model.valueobject.Document;
import com.example.techshop.profile.domain.model.valueobject.IdentityDocument;
import com.example.techshop.profile.domain.model.valueobject.Location;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource){
        var roles = resource.roles() != null ? resource.roles().stream().map(
                name -> Role.toRoleFromName(name)).toList(): new ArrayList<Role>();
        var identityDocument = new IdentityDocument(Document.valueOf(resource.document()), resource.identity());
        var location = new Location(resource.country(), resource.address());
        return new SignUpCommand(resource.email(), resource.password(),
                roles, resource.name(), resource.lastName(), identityDocument, location);
    }
}
