package com.codedifferently;

import org.junit.*;

public class ALUUnitTest {
    @Test
    public void addTest() {
        //given
        double expectedResult = 10.4;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();

        double displayValue = unit.getDisplayValue();
        unit.setDisplayValue(alu.add(10.4, displayValue));
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);

        
       

    }
}