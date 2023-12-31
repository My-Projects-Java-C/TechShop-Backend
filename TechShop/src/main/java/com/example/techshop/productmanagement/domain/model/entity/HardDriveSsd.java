package com.example.techshop.productmanagement.domain.model.entity;

import com.example.techshop.productmanagement.domain.model.valueobject.enums.Slot;
import com.example.techshop.productmanagement.domain.model.valueobject.enums.SsdType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class HardDriveSsd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer capacity;
    private SsdType ssdType;

    @Enumerated(EnumType.STRING)
    @Column(name = "slot")
    private Slot slot;

    public HardDriveSsd(HardDriveSsd.Builder build){
        this.capacity = build.capacity;
        this.ssdType = build.ssdType;
        this.slot = build.slot;
    }

    public static class Builder{

        private Integer capacity;
        private SsdType ssdType;
        private Slot slot;

        public HardDriveSsd.Builder capacity(Integer capacity) {
            this.capacity = capacity;
            return this;
        }

        public HardDriveSsd.Builder  ssdType(SsdType ssdType) {
            this.ssdType = ssdType;
            return this;
        }

        public HardDriveSsd.Builder  slot(Slot slot) {
            this.slot = slot;
            return this;
        }

        public HardDriveSsd build(){
            return new HardDriveSsd(this);
        }

    }


}
