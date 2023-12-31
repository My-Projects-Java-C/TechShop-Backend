package com.example.techshop.iam.infraestructure.persistence.jpa.repositories;

import com.example.techshop.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String userName);

    boolean existsByEmail(String email);
}
