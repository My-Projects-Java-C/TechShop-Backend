package com.example.techshop.productmanagement.infraestructure.persistence.repositories;

import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.productmanagement.domain.model.valueobject.enums.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(Categories name);

    boolean existsByName(Categories name);

}
