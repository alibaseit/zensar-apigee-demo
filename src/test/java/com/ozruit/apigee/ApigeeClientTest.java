package com.ozruit.apigee;

import com.ozruit.apigee.response.ApigeeProduct;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApigeeClientTest {

    @Test
    public void getProducts() {
        ApigeeProductClient apigeeClient = new ApigeeProductClient(new RestTemplate());

        List<ApigeeProduct> products = apigeeClient.getProducts("600001506");

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isGreaterThan(0);
    }

    @Test
    public void testApigeeProducts() {
        RestTemplate restTemplate = new RestTemplate();
        String category = "600001506";
        String urlGETProduct = String.format("https://jl-nonprod-syst.apigee.net/v1/categories/%s/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma", category);
        Object forObject = restTemplate.getForObject(urlGETProduct, Object.class);
        Assertions.assertThat(forObject).isNotNull();
    }
}