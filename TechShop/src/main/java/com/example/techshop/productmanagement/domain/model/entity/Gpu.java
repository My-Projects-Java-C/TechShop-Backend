package com.example.techshop.productmanagement.domain.model.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String version;
    @Column(name = "generation")
    private Integer generation;
    @Basic
    private Integer tier;
    @Basic
    private Integer vram;
    @Column(name = "pci")
    private String pci;
    @Column(name = "watt_consumption")
    private Integer wattConsumption;


    public Gpu(Builder builder) {
        this.version = builder.version;
        this.generation = builder.generation;
        this.tier = builder.tier;
        this.vram = builder.vram;
        this.pci = builder.pci;
        this.wattConsumption = builder.wattConsumption;
    }

    public static class Builder{
        private String version;
        private Integer generation;
        private Integer tier;
        private Integer vram;
        private String pci;
        private Integer wattConsumption;


        public Gpu.Builder version(String version) {
            this.version = version;
            return this;
        }

        public Gpu.Builder generation(Integer generation) {
            this.generation = generation;
            return this;
        }

        public Gpu.Builder tier(Integer tier) {
            this.tier = tier;
            return this;
        }

        public Gpu.Builder vram(Integer vram) {
            this.vram = vram;
            return this;
        }

        public Gpu.Builder pci(String pci) {
            this.pci = pci;
            return this;
        }

        public Gpu.Builder wattConsumption(Integer wattConsumption) {
            this.wattConsumption = wattConsumption;
            return this;
        }


        public Gpu build(){
            return new Gpu(this);
        }



    }
}
