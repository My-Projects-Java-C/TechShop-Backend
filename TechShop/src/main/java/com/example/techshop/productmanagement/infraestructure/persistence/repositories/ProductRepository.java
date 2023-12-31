package com.example.techshop.productmanagement.infraestructure.persistence.repositories;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByProfileId(Long profileId);

}
