package com.example.techshop.productmanagement.infraestructure.persistence.repositories.components;

import com.example.techshop.productmanagement.domain.model.entity.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
