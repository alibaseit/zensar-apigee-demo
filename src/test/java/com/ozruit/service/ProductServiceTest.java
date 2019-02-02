package com.ozruit.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.ozruit.apigee.ApigeeProductClient;
import com.ozruit.apigee.response.ApigeeNow;
import com.ozruit.apigee.response.ApigeePrice;
import com.ozruit.apigee.response.ApigeeProduct;
import com.ozruit.model.ProductResponse;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Test
    public void formatNowPrice() {

        ProductService productService = new ProductService(null );
        String formatNowPrice = productService.formatNowPrice(9.5, "GBP");
        Assertions.assertThat(formatNowPrice).isEqualToIgnoringCase("GBP9.50");

        formatNowPrice = productService.formatNowPrice(34.00, "GBP");
        Assertions.assertThat(formatNowPrice).isEqualToIgnoringCase("GBP34");

        formatNowPrice = productService.formatNowPrice(34, "GBP");
        Assertions.assertThat(formatNowPrice).isEqualToIgnoringCase("GBP34");

        formatNowPrice = productService.formatNowPrice(34.01, "GBP");
        Assertions.assertThat(formatNowPrice).isEqualToIgnoringCase("GBP34.01");

        formatNowPrice = productService.formatNowPrice(10.01, "GBP");
        Assertions.assertThat(formatNowPrice).isEqualToIgnoringCase("GBP10.01");

        formatNowPrice = productService.formatNowPrice(9, "GBP");
        Assertions.assertThat(formatNowPrice).isEqualToIgnoringCase("GBP9.00");

    }

    @Test
    public void testGetProducts() {
        ApigeeProductClient apigeeProductClient = mock(ApigeeProductClient.class);
        when(apigeeProductClient.getProducts(anyString())).thenReturn(apigeeProducts());
        ProductService productService = new ProductService(apigeeProductClient );

        final ProductResponse productResponse = productService.getProducts("category11", "ShowPercDscount");

        Assertions.assertThat(productResponse.getProducts().size()).isEqualTo(1);
    }

    private List<ApigeeProduct> apigeeProducts() {
        ApigeeProduct apigeeProduct1 = new ApigeeProduct();
        apigeeProduct1.setTitle("Product 1");
        apigeeProduct1.setProductId("111");
        apigeeProduct1.setPrice(createPrice("12.34", "19.99"));

        ApigeeProduct apigeeProduct2 = new ApigeeProduct();
        apigeeProduct2.setTitle("Product 1");
        apigeeProduct2.setProductId("111");
        apigeeProduct2.setPrice(createPrice("88.34", "77.99"));
        return Arrays.asList(apigeeProduct1, apigeeProduct2);
    }

    private ApigeePrice createPrice(String now, String was) {

        JsonNode jsonNode = new TextNode(now);
        ApigeePrice apigeePrice = new ApigeePrice();
        apigeePrice.setCurrency("GBP");
        apigeePrice.setNow(jsonNode);
        apigeePrice.setWas(was);
        return apigeePrice;
    }
}