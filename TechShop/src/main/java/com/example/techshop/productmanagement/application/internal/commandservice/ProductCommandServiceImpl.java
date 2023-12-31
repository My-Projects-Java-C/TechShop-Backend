package com.example.techshop.productmanagement.application.internal.commandservice;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.commands.*;
import com.example.techshop.productmanagement.domain.model.entity.Cpu;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.productmanagement.domain.model.valueobject.enums.Categories;
import com.example.techshop.productmanagement.domain.services.ProductCommandService;
import com.example.techshop.productmanagement.infraestructure.persistence.repositories.CategoryRepository;
import com.example.techshop.productmanagement.infraestructure.persistence.repositories.ProductRepository;
import com.example.techshop.profile.interfaces.acl.ProfileContextFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;


    private final ProfileContextFacade profileContextFacade;




    @Override
    public Optional<Product> execute(AddProductCommand command) {
        var profile = profileContextFacade.toProfileFromProfileId().apply(command.profileId());
        var categories = command.categories().stream().map(category -> categoryRepository.findByName(Categories.valueOf(category))
                .orElseThrow(()->new RuntimeException("Category Name Not Found"))).toList();

        var product = new Product.Builder()
                .profile(profile)
                .computerComponent(command.computerComponent())
                .categories(categories)
                .stock(command.stock())
                .unitPrice(command.unitPrice())
                .build();

        /*var computerComponent = computerComponentRepository.findByName(ComputerComponents.valueOf(command.computerComponent()))
                .orElseThrow(() -> new RuntimeException("Computer component name not found"));
        var categories = command.categories().stream().map(category -> categoryRepository.findByName(Categories.valueOf(category))
                .orElseThrow(()->new RuntimeException("Category Name Not Found"))).toList();*/
        return Optional.empty();
    }

    @Override
    public Optional<Product> execute(IncreaseStockProductCommand command) {
        var product = productRepository.findById(command.productId()).orElseThrow(()->new RuntimeException("Product not found"));
        product.setStock(product.getStock() + command.amount());
        var optionalProduct = Optional.of(productRepository.save(product));
        return optionalProduct.isPresent() ? optionalProduct : Optional.empty();
    }

    @Override
    public Optional<Product> execute(DecreaseStockProductCommand command) {
        var product = productRepository.findById(command.productId()).orElseThrow(()->new RuntimeException("Product not found"));
        product.setStock(product.getStock() - command.amount());
        var optionalProduct = Optional.of(productRepository.save(product));
        return optionalProduct.isPresent() ? optionalProduct : Optional.empty();
    }

    @Override
    public Optional<Product> execute(UpdateProductInformationCommand command) {
        /*var product = productRepository.findById(command.productId()).orElseThrow(()->new RuntimeException("Product not found"));
        var computerComponent = computerComponentRepository.findByName(ComputerComponents.valueOf(command.computerComponent()))
                .orElseThrow(() -> new RuntimeException("Computer component name not found"));
        var categories = command.categories().stream().map(category -> categoryRepository.findByName(Categories.valueOf(category))
                .orElseThrow(()->new RuntimeException("Category Name Not Found"))).toList();
        product.updateBasicInformation(computerComponent, categories, command.unitPrice());
        var optionalProduct = Optional.of(productRepository.save(product));*/
        return Optional.empty();
    }

    @Override
    public void execute(DeleteProductCommand command) {
        var product = productRepository.findById(command.productId()).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    @Override
    public void execute(SeedCategoryCommand command) {
        Arrays.stream(Categories.values()).forEach(
                category -> {
                    if (!categoryRepository.existsByName(category)) {
                        categoryRepository.save(new Category(Categories.valueOf(category.name())));
                    }
                }
        );
    }

    @Override
    public void execute(SeedComputerComponentCommand command) {
       /* Arrays.stream(ComputerComponents.values()).forEach(
                computerComponent -> {
                    if (!computerComponentRepository.existsByName(computerComponent)) {
                        computerComponentRepository.save(new ComputerComponent(ComputerComponents.valueOf(computerComponent.name())));
                    }
                }
        );*/
    }
}
