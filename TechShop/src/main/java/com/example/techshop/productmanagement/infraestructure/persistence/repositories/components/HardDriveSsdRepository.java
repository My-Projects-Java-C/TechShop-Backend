package com.example.techshop.productmanagement.infraestructure.persistence.repositories.components;

import com.example.techshop.productmanagement.domain.model.entity.HardDriveSsd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveSsdRepository extends JpaRepository<HardDriveSsd, Long> {
}
