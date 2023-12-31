package com.example.techshop.productmanagement.domain.model.commands;

import java.util.List;

public record UpdateProductInformationCommand(Long productId,String computerComponent, List<String> categories,
                                              Float unitPrice) {
}
