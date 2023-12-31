package com.example.techshop.profile.interfaces.rest;

import com.example.techshop.profile.domain.model.queries.GetProfileByIdQuery;
import com.example.techshop.profile.domain.service.ProfileCommandService;
import com.example.techshop.profile.domain.service.ProfileQueryService;
import com.example.techshop.profile.interfaces.rest.resource.ProfileResource;
import com.example.techshop.profile.interfaces.rest.resource.UpdateProfileBasicInformationResource;
import com.example.techshop.profile.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import com.example.techshop.profile.interfaces.rest.transform.UpdateProfileBasicInformationCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/profile", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class ProfileController {

    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId){
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.execute(getProfileByIdQuery);
        if (profile.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @PutMapping("/update/{profileId}")
    public ResponseEntity<ProfileResource> updateProfileInformationById(@RequestBody UpdateProfileBasicInformationResource resource){
        var updateProfileBasicInformationCommand = UpdateProfileBasicInformationCommandFromResourceAssembler.toCommandFromResource(resource);
        var profile = profileCommandService.execute(updateProfileBasicInformationCommand);
        if(profile.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

}
