package com.ozruit.apigee;


import com.ozruit.apigee.exception.ApigeeException;
import com.ozruit.apigee.response.ApigeeProductResponse;
import com.ozruit.apigee.response.ApigeeProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApigeeProductClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApigeeProductClient.class);

    private static final String URL_PRODUCT_BY_CATEGORY = "https://jl-nonprod-syst.apigee.net/v1/categories/%s/products?key=%s";

    private final RestTemplate restTemplate;

    public ApigeeProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ApigeeProduct> getProducts(String category) {
        String apiKey = "2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

        String urlGet = String.format(URL_PRODUCT_BY_CATEGORY, category, apiKey);

        ResponseEntity<ApigeeProductResponse> responseEntity =
                restTemplate.getForEntity(urlGet, ApigeeProductResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful())
            return responseEntity.getBody().getProducts();
        else {
            LOGGER.error("Apigee exception {}", responseEntity.getBody());
            throw new ApigeeException("Apigee Exception.", responseEntity.getStatusCodeValue());
        }
    }

}
