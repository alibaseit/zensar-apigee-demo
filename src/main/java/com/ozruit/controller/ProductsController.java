package com.ozruit.controller;

import com.ozruit.service.ProductService;
import com.ozruit.model.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping()
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/categories/{category}/reduced-products")
    ProductResponse discountedProductsByCategory
            (@RequestParam(value = "labelType", defaultValue = "ShowWasNow") String labelType,
             @PathVariable(value = "category", required = true) String category)
    {

        try {
            return productService.getProducts(category, labelType);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }
}
