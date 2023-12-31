package com.example.techshop.iam.interfaces.rest.transform;


import com.example.techshop.iam.domain.model.commands.SignInCommand;
import com.example.techshop.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource){
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
