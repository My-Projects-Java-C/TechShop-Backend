package com.example.techshop.productmanagement.domain.services;


import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.queries.GetProductById;
import com.example.techshop.productmanagement.domain.model.queries.GetProductByProfileId;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {

    Optional<Product> execute(GetProductById query);

    List<Product> execute(GetProductByProfileId query);

}
