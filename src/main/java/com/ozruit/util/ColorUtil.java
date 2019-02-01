package com.ozruit.util;

import java.util.Hashtable;

public class ColorUtil {

    static final Hashtable<String, String> colors = new Hashtable();

    static {
        colors.put("black", "000000");
        colors.put("white", "FFFFFF");
        colors.put("red", "FF0000");
        colors.put("lime", "00FF00");
        colors.put("blue", "0000FF");
        colors.put("yellow", "FFFF00");
        colors.put("cyan", "00FFFF");
        colors.put("magenta", "FF00FF");
        colors.put("silver", "C0C0C0");
        colors.put("gray", "808080");
        colors.put("grey", "808080");
        colors.put("maroon", "800000");
        colors.put("olive", "808000");
        colors.put("green", "008000");
        colors.put("purple", "800080");
        colors.put("teal", "008080");
        colors.put("navy", "000080");
    }

    private ColorUtil() {

    }

    public static String toRGB(String basicColor) {
        return colors.getOrDefault(basicColor.toLowerCase(), "");
    }
}
