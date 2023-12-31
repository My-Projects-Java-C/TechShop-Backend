package com.example.techshop.productmanagement.domain.model.valueobject;

import com.example.techshop.productmanagement.domain.model.valueobject.enums.Categories;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Categories name;

    public String getStringName(){
        return name.name();
    }

    public Category(Categories name) {
        this.name = name;
    }

    public static Category toRoleFromName(String name){
        return new Category(Categories.valueOf(name));
    }


}
