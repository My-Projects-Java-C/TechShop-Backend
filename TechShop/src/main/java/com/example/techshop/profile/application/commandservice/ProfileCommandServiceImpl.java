package com.example.techshop.profile.application.commandservice;

import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.domain.model.commands.UpdateProfileBasicInformationCommand;
import com.example.techshop.profile.domain.service.ProfileCommandService;
import com.example.techshop.profile.infraestructure.persistence.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    @Override
    public Optional<Profile> execute(UpdateProfileBasicInformationCommand command) {
        var profile = profileRepository.findById(command.profileId()).orElseThrow(()-> new RuntimeException("profile not found"));
        if (profile != null){
            profile.updateInformation(command.name(), command.lastName(), command.photo(), command.identityDocument(), command.location());
            profileRepository.save(profile);
            return Optional.of(profile);
        }
        return Optional.empty();
    }
}
