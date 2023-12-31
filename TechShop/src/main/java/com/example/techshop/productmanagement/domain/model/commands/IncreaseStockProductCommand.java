package com.example.techshop.productmanagement.domain.model.commands;

public record IncreaseStockProductCommand(Long productId, Long amount) {
}
