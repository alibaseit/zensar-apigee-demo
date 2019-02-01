package com.ozruit.apigee.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApigeeProduct {

    private String productId;
    private String type;
    private String title;
    private BigDecimal code;
    private Long reviews;
    private ApigeePrice price;

    private List<ApigeeColorSwatch> colorSwatches;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getCode() {
        return code;
    }

    public void setCode(BigDecimal code) {
        this.code = code;
    }

    public Long getReviews() {
        return reviews;
    }

    public void setReviews(Long reviews) {
        this.reviews = reviews;
    }

    public ApigeePrice getPrice() {
        return price;
    }

    public void setPrice(ApigeePrice price) {
        this.price = price;
    }

    public List<ApigeeColorSwatch> getColorSwatches() {
        return colorSwatches;
    }

    public void setColorSwatches(List<ApigeeColorSwatch> colorSwatches) {
        this.colorSwatches = colorSwatches;
    }

    @Override
    public String toString() {
        return "ApigeeProduct{" +
                "productId='" + productId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", code=" + code +
                ", reviews=" + reviews +
                ", price=" + price +
                ", colorSwatches=" + colorSwatches +
                '}';
    }
}
