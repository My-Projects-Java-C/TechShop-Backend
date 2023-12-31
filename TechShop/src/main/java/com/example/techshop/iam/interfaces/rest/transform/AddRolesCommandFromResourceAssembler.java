package com.example.techshop.iam.interfaces.rest.transform;

import com.example.techshop.iam.domain.model.commands.AddRolesCommand;
import com.example.techshop.iam.domain.model.commands.SignInCommand;
import com.example.techshop.iam.interfaces.rest.resources.AddRolesResource;
import com.example.techshop.iam.interfaces.rest.resources.SignInResource;

public class AddRolesCommandFromResourceAssembler {
    public static AddRolesCommand toCommandFromResource(AddRolesResource addRolesResource){
        return new AddRolesCommand(addRolesResource.roleName(), addRolesResource.email());
    }
}
