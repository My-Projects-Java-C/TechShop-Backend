package com.example.techshop.profile.interfaces.rest.transform;

import com.example.techshop.profile.domain.model.commands.UpdateProfileBasicInformationCommand;
import com.example.techshop.profile.domain.model.valueobject.Document;
import com.example.techshop.profile.domain.model.valueobject.IdentityDocument;
import com.example.techshop.profile.domain.model.valueobject.Location;
import com.example.techshop.profile.interfaces.rest.resource.UpdateProfileBasicInformationResource;

public class UpdateProfileBasicInformationCommandFromResourceAssembler {
    public static UpdateProfileBasicInformationCommand toCommandFromResource(UpdateProfileBasicInformationResource resource){
        return new UpdateProfileBasicInformationCommand(resource.profileId(), resource.name(), resource.lastName(), resource.photo(),
                new IdentityDocument(Document.valueOf(resource.document()), resource.identity()),
                new Location(resource.Country(), resource.address()));
    }
}
