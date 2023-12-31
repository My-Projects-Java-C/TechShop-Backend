package com.example.techshop.iam.domain.model.entities;

import com.example.techshop.iam.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    public String getStringName(){
        return name.name();
    }

    public static Role getDefaultRole(){
        return new Role(Roles.ROLE_CUSTOMER);
    }

    public Role(Roles name) {
        this.name = name;
    }

    public static Role toRoleFromName(String name){
        return new Role(Roles.valueOf(name));
    }

}
