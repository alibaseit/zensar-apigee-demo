package com.ozruit.apigee.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApigeeProductResponse {

    private List<ApigeeProduct> products;

    public List<ApigeeProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ApigeeProduct> products) {
        this.products = products;
    }
}
