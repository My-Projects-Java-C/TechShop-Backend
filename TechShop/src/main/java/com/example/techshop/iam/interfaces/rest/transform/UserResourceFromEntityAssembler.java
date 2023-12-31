package com.example.techshop.iam.interfaces.rest.transform;

import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.iam.domain.model.entities.Role;
import com.example.techshop.iam.interfaces.rest.resources.UserResource;
import com.example.techshop.profile.interfaces.acl.ProfileContextFacade;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user){
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getEmail(), roles,
                ProfileContextFacade.toProfileResourceFromEntityProfile().apply(user.getProfile()));
    }
}
