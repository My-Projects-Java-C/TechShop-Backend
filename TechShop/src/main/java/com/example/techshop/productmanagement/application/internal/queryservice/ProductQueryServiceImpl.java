package com.example.techshop.productmanagement.application.internal.queryservice;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.queries.GetProductById;
import com.example.techshop.productmanagement.domain.model.queries.GetProductByProfileId;
import com.example.techshop.productmanagement.domain.services.ProductQueryService;
import com.example.techshop.productmanagement.infraestructure.persistence.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductQueryServiceImpl implements ProductQueryService{

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> execute(GetProductById query) {
        return productRepository.findById(query.productId());
    }

    @Override
    public List<Product> execute(GetProductByProfileId query) {
        return productRepository.findAllByProfileId(query.profileId());
    }
}
