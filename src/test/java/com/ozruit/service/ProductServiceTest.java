package com.ozruit.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;

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
}