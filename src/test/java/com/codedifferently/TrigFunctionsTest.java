package com.codedifferently;

import org.junit.*;

public class TrigFunctionsTest {
    @Test
    public void sineTest() {
       //given
       double expectedResult = 0.120;

       //when
       SciCalculator calc = new SciCalculator();
       TrigFunctions trigFunctions = new TrigFunctions();

       calc.setDisplayValue(0.12);
       double displayValue = calc.getDisplayValue();
       double newValue = trigFunctions.sine(displayValue);
       calc.setDisplayValue(newValue);
       double actualResult = calc.getDisplayValue();
       
       //then
       Assert.assertEquals(expectedResult, actualResult, 0.01);
       
       
    }

    @Test
    public void cosineTest() {
        //given
        double expectedResult = 0.993;

        //when
        SciCalculator calc = new SciCalculator();
        TrigFunctions trigFunctions = new TrigFunctions();

        calc.setDisplayValue(0.12);
        double displayValue = calc.getDisplayValue();
        double newValue = trigFunctions.cosine(displayValue);
        calc.setDisplayValue(newValue);
        double actualResult = calc.getDisplayValue();
        
        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void tangentTest() {
        //given
        double expectedResult = 0.121;

        //when
        SciCalculator calc = new SciCalculator();
        TrigFunctions trigFunctions = new TrigFunctions();

        calc.setDisplayValue(0.12);
        double displayValue = calc.getDisplayValue();
        double newValue = trigFunctions.tangent(displayValue);
        calc.setDisplayValue(newValue);
        double actualResult = calc.getDisplayValue();
        
        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
        
        
    }

    @Test
    public void inverseSineTest() {
        //given
        double expectedResult = 0.120;

        //when
        SciCalculator unit = new SciCalculator();
        TrigFunctions trigFunctions = new TrigFunctions();

        unit.setDisplayValue(0.12);
        double displayValue = unit.getDisplayValue();
        double newValue = trigFunctions.inverseSine(displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void inverseCosineTest() {
        //given
        double expectedResult = 1.451;

        //when
        SciCalculator unit = new SciCalculator();
        TrigFunctions trigFunctions = new TrigFunctions();

        unit.setDisplayValue(0.12);
        double displayValue = unit.getDisplayValue();
        double newValue = trigFunctions.inverseCosine(displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void inverseTangentTest() {
        //given
        double expectedResult = 0.119;

        //when
        SciCalculator unit = new SciCalculator();
        TrigFunctions trigFunctions = new TrigFunctions();

        unit.setDisplayValue(0.12);
        double displayValue = unit.getDisplayValue();
        double newValue = trigFunctions.inverseTangent(displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void isValNaNTest() {
        //given
        boolean expectedResult = true;

        //when
        SciCalculator calc = new SciCalculator();
        TrigFunctions trigFunctions = new TrigFunctions();
        boolean actualResult = trigFunctions.isValNaN(calc.getTrigFunctions().inverseSine(1235568767958.0));

        //then
        Assert.assertEquals(expectedResult, actualResult);
    }
}