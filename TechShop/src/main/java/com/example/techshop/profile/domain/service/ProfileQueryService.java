package com.example.techshop.profile.domain.service;

import com.example.techshop.profile.domain.model.aggregates.Profile;
import com.example.techshop.profile.domain.model.queries.GetProfileByIdQuery;

import java.util.Optional;

public interface ProfileQueryService {

    Optional<Profile> execute (GetProfileByIdQuery query);

}
