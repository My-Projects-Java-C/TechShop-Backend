package com.example.techshop.productmanagement.interfaces.rest.transform;

import com.example.techshop.productmanagement.domain.model.aggregates.Product;
import com.example.techshop.productmanagement.domain.model.valueobject.Category;
import com.example.techshop.productmanagement.interfaces.rest.resource.ProductResource;
import com.example.techshop.profile.interfaces.acl.ProfileContextFacade;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product product){
        var profileResource = ProfileContextFacade.toProfileResourceFromEntityProfile().apply(product.getProfile());
        var categories = product.getCategories().stream().map(Category::getStringName).toList();
        return new ProductResource(product.getId(),profileResource,
                categories, product.getStock(), product.getUnitPrice());
    }
}
