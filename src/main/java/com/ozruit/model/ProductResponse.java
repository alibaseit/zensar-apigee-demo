package com.ozruit.model;

import com.ozruit.model.Product;

import java.util.List;

public class ProductResponse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
