package com.ozruit.util;

public enum LabelFormatType {
    SHOW_WAS_NOW, SHOW_WAS_THEN_NOW, SHOW_PER_DISCOUNT;

    public static LabelFormatType fromString(String labelFormatType) {
        switch (labelFormatType.toUpperCase()) {
            case "SHOWWASNOW":
                return SHOW_WAS_NOW;
            case "SHOWWASTHENNOW":
                return SHOW_WAS_THEN_NOW;
            case "SHOWPERCDSCOUNT":
                return SHOW_PER_DISCOUNT;
            default:
                return null;
        }
    }
}
