package com.example.techshop.profile.infraestructure.persistence.repositories;

import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
