package com.codedifferently;

import org.junit.Assert;
import org.junit.Test;


public class SciCalculatorTest 
{

    @Test
    public void constructorTest() {
        // Given
        double expectedDisplay = 0.0;

        // When
        SciCalculator calc = new SciCalculator();
        double  actualDisplay = calc.getDisplay();

        // Then
        Assert.assertEquals(expectedDisplay, actualDisplay, 0);
    }
}
