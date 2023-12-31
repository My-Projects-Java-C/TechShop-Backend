package com.example.techshop.iam.interfaces.rest;


import com.example.techshop.iam.domain.service.UserCommandService;
import com.example.techshop.iam.interfaces.rest.resources.*;
import com.example.techshop.iam.interfaces.rest.transform.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Management Endpoints")
public class AuthenticationController {

    private final UserCommandService userCommandService;

    @PostMapping("sign-in")
    public ResponseEntity<AuthenticateUserResource> signIn(@RequestBody SignInResource signInResource){
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(signInResource);
        var authenticatedUser = userCommandService.execute(signInCommand);
        if(authenticatedUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler
                .toResourceFromEntity(authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());
        return ResponseEntity.ok(authenticatedUserResource);
    }

    @PostMapping("sign-up")
    public ResponseEntity<UserResource> signUp(@RequestBody SignUpResource signUpResource){
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(signUpResource);
        var user = userCommandService.execute(signUpCommand);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @PostMapping("add-role")
    public ResponseEntity<UserResource> addRole(@RequestBody AddRolesResource addRolesResource){
        var addRoleCommand = AddRolesCommandFromResourceAssembler.toCommandFromResource(addRolesResource);
        var user = userCommandService.execute(addRoleCommand);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }
}
