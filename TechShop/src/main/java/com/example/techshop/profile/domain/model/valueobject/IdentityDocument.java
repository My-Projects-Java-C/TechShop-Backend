package com.example.techshop.profile.domain.model.valueobject;

import jakarta.persistence.Embeddable;

import javax.print.Doc;

@Embeddable
public record IdentityDocument(Document document, String identity) {

}
