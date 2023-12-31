package com.example.techshop.productmanagement.domain.model.entity;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.productmanagement.domain.model.valueobject.enums.Slot;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.query.SelectionQuery;

import java.util.List;
@NoArgsConstructor
@Entity
public class MotherBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "range")
    private String range;
    @Basic
    private Integer chipset;
    @Basic
    private Integer levelChipset;
    @Basic
    private String size;
    private String socket;
    @Column(name = "pci")
    private String pci;
    @Enumerated(EnumType.STRING)
    @Column(name = "slot")
    private Slot slot;
    @Column(name = "model")
    private String modelRam;

    public MotherBoard(MotherBoard.Builder builder) {
        this.range = builder.range;
        this.chipset = builder.chipset;
        this.levelChipset = builder.levelChipset;
        this.size = builder.size;
        this.socket = builder.socket;
        this.pci = builder.pci;
        this.slot = builder.slot;
        this.modelRam = builder.modelRam;
    }
    public static class Builder{
        private String range;
        private Integer chipset;
        private Integer levelChipset;
        private String size;
        private String socket;
        private String pci;
        private Slot slot;
        private String modelRam;




        public MotherBoard.Builder range(String range) {
            this.range = range;
            return this;
        }

        public MotherBoard.Builder chipset(Integer chipset) {
            this.chipset = chipset;
            return this;
        }

        public MotherBoard.Builder levelChipset(Integer levelChipset) {
            this.levelChipset = levelChipset;
            return this;
        }

        public MotherBoard.Builder size(String size) {
            this.size = size;
            return this;
        }

        public MotherBoard.Builder socket(String socket) {
            this.socket = socket;
            return this;
        }

        public MotherBoard.Builder pci(String pci) {
            this.pci = pci;
            return this;
        }

        public MotherBoard.Builder slot(Slot slot) {
            this.slot = slot;
            return this;
        }

        public MotherBoard.Builder modelRam(String modelRam) {
            this.modelRam = modelRam;
            return this;
        }

        public MotherBoard build(){
            return new MotherBoard(this);
        }

    }

}
