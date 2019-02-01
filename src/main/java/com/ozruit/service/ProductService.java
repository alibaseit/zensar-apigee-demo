package com.ozruit.service;

import com.ozruit.apigee.ApigeeProductClient;
import com.ozruit.apigee.response.ApigeeColorSwatch;
import com.ozruit.apigee.response.ApigeePrice;
import com.ozruit.model.ColorSwatch;
import com.ozruit.model.Product;
import com.ozruit.service.response.ProductResponse;
import com.ozruit.util.ColorUtil;
import com.ozruit.util.LabelFormatType;
import com.ozruit.util.NumberUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ApigeeProductClient apigeeProductClient;

    public ProductService(ApigeeProductClient apigeeProductClient) {
        this.apigeeProductClient = apigeeProductClient;
    }

    public ProductResponse getProducts(String category, String labelType) {

        List<Product> products = apigeeProductClient.getProducts(category)
                .stream()
                .filter(apigeeProduct -> {
                    double was  = NumberUtil.toDouble(apigeeProduct.getPrice().getWas());
                    return apigeeProduct.getPrice().priceNow() < was;
                })
                .map(apigeeProduct -> {
                    Product product = new Product();
                    product.setProductId(apigeeProduct.getProductId());
                    product.setTitle(apigeeProduct.getTitle());
                    product.setColorSwatches(toColorSwatch(apigeeProduct.getColorSwatches()));
                    product.setNowPrice(formatNowPrice(apigeeProduct.getPrice().priceNow(), apigeeProduct.getPrice().getCurrency()));
                    product.setPriceLabel(priceLabel(apigeeProduct.getPrice(), LabelFormatType.fromString(labelType)));
                    return product;
                })
                .collect(Collectors.toList());

        ProductResponse response = new ProductResponse();
        response.setProducts(products);
        return response;
    }

    private String priceLabel(ApigeePrice price, LabelFormatType labelType) {
        final double was = NumberUtil.toDouble(price.getWas());
        final double then = NumberUtil.toDouble(price.getThen1());
        final String currency = price.getCurrency();
        final double priceNow = price.priceNow();

        switch (labelType) {
            case SHOW_PER_DISCOUNT:
                double discount = (was - priceNow) / was;
                return String.format("%.2f%% off - now %s%.2f", discount, currency, priceNow);
            case SHOW_WAS_THEN_NOW:
                return String.format("Was %s%.2f, then %s%.2f, now %s%.3f", currency, was, currency, then, currency, priceNow);
            default:
                return String.format("Was %s%.2f, now %s%.3f", currency, was, currency, priceNow);
        }
    }

    protected String formatNowPrice(double price, String currency) {
        String format = "%s%.2f";

        double decimalPart = price - (int) price;

        if (price > 10 && decimalPart == 0)
            format = "%s%.0f";

        return String.format(format, currency, price);
    }

    private List<ColorSwatch> toColorSwatch(List<ApigeeColorSwatch> apigeeColorSwatches) {
        return apigeeColorSwatches.stream()
                .map(apigeeColorSwatch -> {
                    ColorSwatch colorSwatch = new ColorSwatch();
                    colorSwatch.setColor(apigeeColorSwatch.getColor());
                    colorSwatch.setRgbColor(ColorUtil.toRGB(apigeeColorSwatch.getBasicColor()));
                    colorSwatch.setSkuid(apigeeColorSwatch.getSkuId());
                    return colorSwatch;
                })
                .collect(Collectors.toList());
    }

}
