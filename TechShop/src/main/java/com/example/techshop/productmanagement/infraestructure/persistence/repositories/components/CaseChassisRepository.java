package com.example.techshop.productmanagement.infraestructure.persistence.repositories.components;

import com.example.techshop.productmanagement.domain.model.entity.AdditionalProduct;
import com.example.techshop.productmanagement.domain.model.entity.CaseChassis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseChassisRepository extends JpaRepository<CaseChassis, Long> {
}
