package com.ozruit.controller;

import com.ozruit.exception.BadRequestException;
import com.ozruit.model.ProductResponse;
import com.ozruit.model.ResponseStatus;
import com.ozruit.service.ProductService;
import com.ozruit.util.LabelFormatType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/categories/{category}/reduced-products")
    ResponseEntity<ProductResponse> discountedProductsByCategory
            (@RequestParam(value = "labelType", defaultValue = "ShowWasNow") String labelType,
             @PathVariable(value = "category") String category)
    {
        validateLabelType(labelType);
        final ProductResponse productResponse = productService.getProducts(category, labelType);
        productResponse.setStatus(new ResponseStatus("OK", ""));
        return ResponseEntity.ok(productResponse);
    }

    private void validateLabelType(String labelType) {
        if (LabelFormatType.fromString(labelType) == null)
            throw new BadRequestException(
                    String.format("Invalid labelType: %s. It must be one of (ShowWasNow, ShowWasThenNow, ShowPercDscount)",
                            labelType));
    }
}
