package com.codedifferently;

import org.junit.*;

public class ALUUnitTest {
    @Test
    public void addTest() {
        //given
        double expectedResult = 10.4;

        //when
        SciCalculator unit = new SciCalculator();
        unit.add(10.4);
        double actualResult = unit.getDisplay();

        //then
        
    }
}