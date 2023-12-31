package com.example.techshop.profile.interfaces.acl;

import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.domain.model.valueobject.IdentityDocument;
import com.example.techshop.profile.domain.model.valueobject.Location;
import com.example.techshop.profile.infraestructure.persistence.repositories.ProfileRepository;
import com.example.techshop.profile.interfaces.rest.resource.ProfileResource;
import com.example.techshop.profile.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@AllArgsConstructor
@Service
public class ProfileContextFacade {

    private final ProfileRepository profileRepository;

    public Optional<Profile> createProfile(String name, String lastName, IdentityDocument identityDocument, Location location){
        Profile newProfile = new Profile(name, lastName, identityDocument, location);
        profileRepository.save(newProfile);
        return Optional.of(newProfile);
    }

    public static Function<Profile, ProfileResource> toProfileResourceFromEntityProfile(){
        return profile -> ProfileResourceFromEntityAssembler.toResourceFromEntity(profile);
    }

    public Function<Long, Profile> toProfileFromProfileId(){
        return profileId -> profileRepository.findById(profileId).orElseThrow(()->new RuntimeException("Profile id don't exist"));
    }

}
