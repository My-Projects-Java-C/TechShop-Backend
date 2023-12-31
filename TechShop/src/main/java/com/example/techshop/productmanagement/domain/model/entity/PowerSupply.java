package com.example.techshop.productmanagement.domain.model.entity;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.productmanagement.domain.model.valueobject.enums.Certificate80Plus;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
public class PowerSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private Integer watts;

    @Enumerated(EnumType.STRING)
    private Certificate80Plus certificate80Plus;

    public PowerSupply(PowerSupply.Builder build){
        this.watts = build.watts;
        this.certificate80Plus = build.certificate80Plus;
    }


    public static class Builder{
        private Integer watts;

        private Certificate80Plus certificate80Plus;

        public PowerSupply.Builder setWatts(Integer watts) {
            this.watts = watts;
            return this;
        }

        public PowerSupply.Builder setCertificate80Plus(Certificate80Plus certificate80Plus) {
            this.certificate80Plus = certificate80Plus;
            return this;
        }

        public PowerSupply build (){
            return new PowerSupply(this);
        }


    }


}
