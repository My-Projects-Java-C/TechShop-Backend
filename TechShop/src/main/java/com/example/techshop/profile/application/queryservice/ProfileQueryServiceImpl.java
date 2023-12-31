package com.example.techshop.profile.application.queryservice;

import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.domain.model.queries.GetProfileByIdQuery;
import com.example.techshop.profile.domain.service.ProfileCommandService;
import com.example.techshop.profile.domain.service.ProfileQueryService;
import com.example.techshop.profile.infraestructure.persistence.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    @Override
    public Optional<Profile> execute(GetProfileByIdQuery query) {
        return Optional.of(profileRepository.findById(query.profileId()).orElseThrow(()-> new RuntimeException("Profile not found")));
    }
}
