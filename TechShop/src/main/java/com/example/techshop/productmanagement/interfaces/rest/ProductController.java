package com.example.techshop.productmanagement.interfaces.rest;

import com.example.techshop.productmanagement.domain.model.commands.AddProductCommand;
import com.example.techshop.productmanagement.domain.model.queries.GetProductById;
import com.example.techshop.productmanagement.domain.model.queries.GetProductByProfileId;
import com.example.techshop.productmanagement.domain.services.ProductCommandService;
import com.example.techshop.productmanagement.domain.services.ProductQueryService;
import com.example.techshop.productmanagement.interfaces.rest.resource.ProductResource;
import com.example.techshop.productmanagement.interfaces.rest.resource.commandresource.AddProductResource;
import com.example.techshop.productmanagement.interfaces.rest.transform.AddProductCommandFromResourceAssembler;
import com.example.techshop.productmanagement.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import com.example.techshop.profile.interfaces.rest.resource.ProfileResource;
import com.example.techshop.profile.interfaces.rest.resource.UpdateProfileBasicInformationResource;
import com.example.techshop.profile.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import com.example.techshop.profile.interfaces.rest.transform.UpdateProfileBasicInformationCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "Product Management Endpoints")
public class ProductController {

    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long productId){
        var getProductById = new GetProductById(productId);
        var product = productQueryService.execute(getProductById);
        if(product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<ProductResource>> getProductByProfileId(@PathVariable Long profileId){
        var getProductByProfileId = new GetProductByProfileId(profileId);
        var products = productQueryService.execute(getProductByProfileId);
        if(products.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var productResources = products.stream().map(product -> ProductResourceFromEntityAssembler.toResourceFromEntity(product)).toList();
        return ResponseEntity.ok(productResources);
    }

    @PostMapping("/add-product")
    public ResponseEntity<ProductResource> addProduct (@RequestBody AddProductResource resource){
        var AddProductCommand = AddProductCommandFromResourceAssembler.toCommandFromResource(resource);
        var product = productCommandService.execute(AddProductCommand);
        if(product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }


}
