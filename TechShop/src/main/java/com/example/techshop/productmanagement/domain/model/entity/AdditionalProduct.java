package com.example.techshop.productmanagement.domain.model.entity;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
public class AdditionalProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public AdditionalProduct(AdditionalProduct.Builder builder) {
        this.name = builder.name;
    }

    public static class Builder{
        private String name;

        public AdditionalProduct.Builder name(String name) {
            this.name = name;
            return this;
        }

        public AdditionalProduct build(){
            return new AdditionalProduct(this);
        }
    }



}
