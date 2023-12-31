package com.example.techshop.profile.domain.model.aggregates;

import com.example.techshop.iam.domain.model.aggregates.User;
import com.example.techshop.profile.domain.model.valueobject.IdentityDocument;
import com.example.techshop.profile.domain.model.valueobject.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String lastName;

    @Basic
    private String photo;

    @Embedded
    private IdentityDocument identityDocument;

    @Embedded
    private Location location;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Profile() {}

    public Profile(String name, String lastName, IdentityDocument identityDocument, Location location) {
        this.name = name;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
        this.location = location;
    }

    public void updateInformation(String name, String lastName, String photo, IdentityDocument identityDocument, Location location){
        this.name = name;
        this.lastName = lastName;
        this.photo = photo;
        this.identityDocument = identityDocument;
        this.location = location;
    }

}
