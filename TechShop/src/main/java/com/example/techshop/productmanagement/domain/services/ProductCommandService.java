package com.example.techshop.productmanagement.domain.services;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.commands.*;

import java.util.Optional;

public interface ProductCommandService {

    Optional<Product> execute(AddProductCommand command);
    Optional<Product> execute(IncreaseStockProductCommand command);

    Optional<Product> execute(DecreaseStockProductCommand command);
    Optional<Product> execute(UpdateProductInformationCommand command);

    void execute(DeleteProductCommand command);

    void execute(SeedCategoryCommand command);

    void execute(SeedComputerComponentCommand command);
}
