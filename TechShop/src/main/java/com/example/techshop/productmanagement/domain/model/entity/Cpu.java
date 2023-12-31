package com.example.techshop.productmanagement.domain.model.entity;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.productmanagement.domain.model.valueobject.enums.components.Cpus;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructorne
@Entity
public class Cpu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "range")
    private Integer range;
    @Column(name = "generation")
    private Integer generation;
    @Basic
    private Integer sku;
    @Basic
    private String cpuCategory;
    @Column(name = "socket")
    private String socket;
    @Column(name = "model")
    private String modelRam;
    @Column(name = "watt_consumption")
    private Integer wattConsumption;

    public Cpu(Builder build){
        this.brand = build.brand;
        this.range = build.range;
        this.generation = build.generation;
        this.sku = build.sku;
        this.cpuCategory = build.cpuCategory;
        this.socket = build.socket;
        this.modelRam = build.modelRam;
        this.wattConsumption = build.wattConsumption;
    }

    public static class Builder{
        private String brand;
        private Integer range;
        private Integer generation;
        private Integer sku;
        private String cpuCategory;
        private String socket;
        private String modelRam;
        private Integer wattConsumption;

        public Cpu.Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Cpu.Builder range(Integer range) {
            this.range = range;
            return this;
        }

        public Cpu.Builder generation(Integer generation) {
            this.generation = generation;
            return this;
        }

        public Cpu.Builder sku(Integer sku) {
            this.sku = sku;
            return this;
        }

        public Cpu.Builder cpuCategory(String cpuCategory) {
            this.cpuCategory = cpuCategory;
            return this;
        }

        public Cpu.Builder socket(String socket) {
            this.socket = socket;
            return this;
        }

        public Cpu.Builder modelRam(String modelRam) {
            this.modelRam = modelRam;
            return this;
        }

        public Cpu.Builder wattConsumption(Integer wattConsumption) {
            this.wattConsumption = wattConsumption;
            return this;
        }

        public Cpu build (){
            return new Cpu(this);
        }

    }


}
