package com.example.techshop.productmanagement.domain.model.aggregates;

import com.example.techshop.productmanagement.domain.model.entity.*;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.productmanagement.domain.model.valueobject.enums.ComputerComponents;
import com.example.techshop.profile.domain.model.aggregates.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Profile profile;

    @Enumerated(EnumType.STRING)
    private ComputerComponents computerComponent;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
    @Setter
    @Basic
    private Long stock;
    @Basic
    private Float unitPrice;


    @OneToOne
    private AdditionalProduct additionalProduct;
    @OneToOne
    private CaseChassis caseChassis;
    @OneToOne
    private Cpu cpu;
    @OneToOne
    private Gpu gpu;
    @OneToOne
    private HardDriveSsd hardDriveSsd;
    @OneToOne
    private MotherBoard motherBoard;
    @OneToOne
    private PowerSupply powerSupply;
    @OneToOne
    private Ram ram;

    public Product (Product.Builder builder) {
        this.profile = builder.profile;
        this.computerComponent = builder.computerComponent;
        this.categories = builder.categories;
        this.stock = builder.stock;
        this.unitPrice = builder.unitPrice;

    }
    public Product(Product.Builder builder, AdditionalProduct additionalProduct){
        this(builder);
        this.additionalProduct = additionalProduct;
    }
    public Product(Product.Builder builder, CaseChassis caseChassis){
        this(builder);
        this.caseChassis = caseChassis;
    }
    public Product(Product.Builder builder, Cpu cpu){
        this(builder);
        this.cpu = cpu;
    }
    public Product(Product.Builder builder, Gpu gpu){
        this(builder);
        this.gpu = gpu;
    }
    public Product(Product.Builder builder, HardDriveSsd hardDriveSsd){
        this(builder);
        this.hardDriveSsd = hardDriveSsd;
    }
    public Product(Product.Builder builder, MotherBoard motherBoard){
        this(builder);
        this.motherBoard = motherBoard;
    }
    public Product(Product.Builder builder, PowerSupply powerSupply){
        this(builder);
        this.powerSupply = powerSupply;
    }
    public Product(Product.Builder builder, Ram ram){
        this(builder);
        this.ram = ram;
    }
    public static class Builder{

        private Profile profile;
        private ComputerComponents computerComponent;
        private Set<Category> categories;
        private Long stock;
        private Float unitPrice;

        public Product.Builder profile(Profile profile) {
            this.profile = profile;
            return this;
        }

        public Product.Builder categories(List<Category> categories) {
            this.categories = new HashSet<>(categories);
            return this;
        }

        public Product.Builder stock(Long stock) {
            this.stock = stock;
            return this;
        }

        public Product.Builder unitPrice(Float unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }


        public Product.Builder computerComponent(String computerComponent) {
            this.computerComponent = ComputerComponents.valueOf(computerComponent);
            return this;
        }

        public Product build(AdditionalProduct additionalProduct){
            return new Product(this, additionalProduct);
        }
        public Product build(CaseChassis caseChassis){
            return new Product(this, caseChassis);
        }
        public Product build(Cpu cpu){
            return new Product(this, cpu);
        }
        public Product build(Gpu gpu){
            return new Product(this, gpu);
        }
        public Product build(HardDriveSsd hardDriveSsd){
            return new Product(this, hardDriveSsd);
        }
        public Product build(MotherBoard motherBoard){
            return new Product(this,motherBoard );
        }
        public Product build(PowerSupply powerSupply){
            return new Product(this,powerSupply);
        }
        public Product build(Ram ram){
            return new Product(this, ram);
        }

    }

    public void updateBasicInformation(String computerComponent, List<Category> categories,
                                       Float unitPrice){
        this.computerComponent = ComputerComponents.valueOf(computerComponent);
        this.categories = new HashSet<>(categories);
        this.unitPrice = unitPrice;
    }




}
