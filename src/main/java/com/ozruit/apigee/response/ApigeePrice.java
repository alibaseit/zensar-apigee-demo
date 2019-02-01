package com.ozruit.apigee.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApigeePrice {

    private String was;
    private String then1;
    private String then2;
    private JsonNode now;
    private String uom;
    private String currency;

    public ApigeePrice() {
    }

    public double priceNow() {
        if (getNow().getNodeType() == JsonNodeType.STRING)
            return Double.valueOf(getNow().textValue());
        else {
            return Double.valueOf(getNow().get("to").textValue());
        }
    }

    public String getWas() {
        return was;
    }

    public void setWas(String was) {
        this.was = was;
    }

    public String getThen1() {
        return then1;
    }

    public void setThen1(String then1) {
        this.then1 = then1;
    }

    public String getThen2() {
        return then2;
    }

    public void setThen2(String then2) {
        this.then2 = then2;
    }

    public JsonNode getNow() {
        return now;
    }

    public void setNow(JsonNode now) {
        this.now = now;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
