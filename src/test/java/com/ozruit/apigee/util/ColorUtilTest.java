package com.ozruit.apigee.util;

import com.ozruit.util.ColorUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ColorUtilTest {

    @Test
    public void testBasicColorToRGB() {
        String rgbRed = ColorUtil.toRGB("Red");
        Assertions.assertThat(rgbRed).isEqualToIgnoringCase("FF0000");


        String rgbNoColor = ColorUtil.toRGB("fakeColor");
        Assertions.assertThat(rgbNoColor).isEmpty();
    }

}
