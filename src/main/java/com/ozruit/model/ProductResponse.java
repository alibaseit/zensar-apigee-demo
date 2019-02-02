package com.ozruit.model;

import java.util.List;

public class ProductResponse {
    private List<Product> products;

    private ResponseStatus status;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
