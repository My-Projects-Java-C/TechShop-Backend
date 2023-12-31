package com.example.techshop.productmanagement.domain.model.entity;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private Integer memory;
    @Basic
    private Integer frequency;
    @Column(name = "model")
    private String modelRam;
    @Basic
    private Integer latency;
    @Basic
    @Column(name = "watt_consumption")
    private Integer wattConsumption;

    public Ram(Ram.Builder build){
        this.memory = build.memory;
        this.frequency = build.frequency;
        this.modelRam = build.modelRam;
        this.latency = build.latency;
        this.wattConsumption = 5;
    }

    public static class Builder{
        private Integer memory;
        private Integer frequency;
        private String modelRam;
        private Integer latency;

        public Ram.Builder memory(Integer memory) {
            this.memory = memory;
            return this;
        }

        public Ram.Builder frequency(Integer frequency) {
            this.frequency = frequency;
            return this;
        }

        public Ram.Builder modelRam(String modelRam) {
            this.modelRam = modelRam;
            return this;
        }

        public Ram.Builder latency(Integer latency) {
            this.latency = latency;
            return this;
        }

        public Ram build (){
            return new Ram(this);
        }

    }

}
