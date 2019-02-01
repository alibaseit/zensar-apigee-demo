package com.ozruit.util;

public class NumberUtil {

    public static double toDouble(String val) {
        try {
            return Double.valueOf(val);
        } catch (Exception e) {
            return 0;
        }
    }
}
