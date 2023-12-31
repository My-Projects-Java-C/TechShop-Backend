package com.example.techshop.productmanagement.domain.model.commands;

import com.example.techshop.productmanagement.domain.model.entity.AdditionalProduct;
import com.example.techshop.productmanagement.domain.model.entity.CaseChassis;
import com.example.techshop.productmanagement.domain.model.entity.Cpu;

import java.util.List;
import java.util.Optional;

public record AddProductCommand(Long profileId, String computerComponent,
                                List<String> categories, Long stock, Float unitPrice) {
}