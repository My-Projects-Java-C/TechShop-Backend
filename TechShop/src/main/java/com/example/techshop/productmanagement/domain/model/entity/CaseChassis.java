package com.example.techshop.productmanagement.domain.model.entity;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
public class CaseChassis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer height;

    private Integer width;

    private Integer ventilators;

    public CaseChassis(CaseChassis.Builder builder) {
        this.height = builder.height;
        this.width = builder.width;
        this.ventilators = builder.ventilators;
    }


    public static class Builder{

        private Integer height;

        private Integer width;

        private Integer ventilators;

        public CaseChassis.Builder height(Integer height) {
            this.height = height;
            return this;
        }

        public CaseChassis.Builder width(Integer width) {
            this.width = width;
            return this;
        }

        public CaseChassis.Builder ventilators(Integer ventilators) {
            this.ventilators = ventilators;
            return this;
        }

        public CaseChassis build(){
            return new CaseChassis(this);
        }
    }


}
