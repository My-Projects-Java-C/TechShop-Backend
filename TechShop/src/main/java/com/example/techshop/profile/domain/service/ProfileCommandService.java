package com.example.techshop.profile.domain.service;

import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.domain.model.commands.UpdateProfileBasicInformationCommand;

import java.util.Optional;

public interface ProfileCommandService {

    Optional<Profile> execute(UpdateProfileBasicInformationCommand command);

}
