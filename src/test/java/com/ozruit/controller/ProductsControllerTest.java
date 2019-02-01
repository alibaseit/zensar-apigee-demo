package com.ozruit.controller;

import com.ozruit.model.Product;
import com.ozruit.model.ProductResponse;
import com.ozruit.service.ProductService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductsController.class)
public class ProductsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void discountedProductsByCategory() throws Exception {
        ProductResponse productResponse = productResponse();
        when(productService.getProducts(anyString(), anyString())).thenReturn(productResponse);
        this.mockMvc.perform(get("/categories/{category}/reduced-products", "12121"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products[0].title").value(Matchers.is("Test 1")))
                .andExpect(jsonPath("$.products", Matchers.hasSize(productResponse.getProducts().size())));
    }

    private ProductResponse productResponse() {
        ProductResponse productResponse = new ProductResponse();
        List<Product> products = Arrays.asList(product("111", "Test 1"), product("222", "Test 2"));
        productResponse.setProducts(products);
        return productResponse;
    }

    private Product product(String productId, String title) {
        Product product = new Product();
        product.setProductId(productId);
        product.setTitle(title);
        return product;
    }
}