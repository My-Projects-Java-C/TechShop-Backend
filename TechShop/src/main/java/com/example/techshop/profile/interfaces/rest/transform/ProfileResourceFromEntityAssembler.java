package com.example.techshop.profile.interfaces.rest.transform;

import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.interfaces.rest.resource.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile profile){
        return new ProfileResource(profile.getId(), profile.getName(), profile.getLastName(), profile.getPhoto(), profile.getIdentityDocument().document().name(),
                profile.getIdentityDocument().identity(), profile.getLocation().Country(), profile.getLocation().address());
    }

}
