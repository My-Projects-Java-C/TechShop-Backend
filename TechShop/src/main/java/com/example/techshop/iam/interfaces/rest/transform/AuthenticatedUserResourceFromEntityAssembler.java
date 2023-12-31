package com.example.techshop.iam.interfaces.rest.transform;


import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.iam.domain.model.entities.Role;
import com.example.techshop.iam.interfaces.rest.resources.AuthenticateUserResource;
import com.example.techshop.profile.interfaces.acl.ProfileContextFacade;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticateUserResource toResourceFromEntity(User user, String token){
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new AuthenticateUserResource(user.getId(), user.getEmail(), roles, token,
                ProfileContextFacade.toProfileResourceFromEntityProfile().apply(user.getProfile()));
    }
}
