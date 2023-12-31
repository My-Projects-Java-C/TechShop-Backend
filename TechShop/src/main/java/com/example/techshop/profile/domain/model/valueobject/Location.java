package com.example.techshop.profile.domain.model.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public record Location(String Country, String address) {
}
