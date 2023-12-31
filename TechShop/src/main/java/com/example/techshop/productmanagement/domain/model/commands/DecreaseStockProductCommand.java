package com.example.techshop.productmanagement.domain.model.commands;

public record DecreaseStockProductCommand(Long productId, Long amount) {
}
