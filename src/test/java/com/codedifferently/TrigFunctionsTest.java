/**
 * @author Kaveesha Weerasiri
 * @author Giovane Barnes
 */

package com.codedifferently;

import org.junit.*;

public class TrigFunctionsTest {
    SciCalculator calc;
    TrigFunctions trigFunctions;

    @Before
    public void initialize() {
       calc = new SciCalculator();
       trigFunctions = new TrigFunctions();
    }

    @Test
    public void sineTest() {
       //given
       double expectedResult = 0.120;

       //when
       calc.setDisplayValue(0.12);
       double displayValue = calc.getDisplayValue();
       double newValue = trigFunctions.sine(displayValue);
       calc.setDisplayValue(newValue);
       double actualResult = calc.getDisplayValue();
       
       //then
       Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void cosineTest() {
        //given
        double expectedResult = 0.993;

        //when
        calc.setDisplayValue(0.12);
        double displayValue = calc.getDisplayValue();
        double newValue = trigFunctions.cosine(displayValue);
        calc.setDisplayValue(newValue);
        double actualResult = calc.getDisplayValue();
        
        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void tangentTest() {
        //given
        double expectedResult = 0.121;

        //when
        calc.setDisplayValue(0.12);
        double displayValue = calc.getDisplayValue();
        double newValue = trigFunctions.tangent(displayValue);
        calc.setDisplayValue(newValue);
        double actualResult = calc.getDisplayValue();
        
        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
        
        
    }

    @Test
    public void inverseSineTest() {
        //given
        double expectedResult = 0.120;

        //when

        calc.setDisplayValue(0.12);
        double displayValue = calc.getDisplayValue();
        double newValue = trigFunctions.inverseSine(displayValue);
        calc.setDisplayValue(newValue);
        double actualResult = calc.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void inverseCosineTest() {
        //given
        double expectedResult = 1.451;

        //when
        calc.setDisplayValue(0.12);
        double displayValue = calc.getDisplayValue();
        double newValue = trigFunctions.inverseCosine(displayValue);
        calc.setDisplayValue(newValue);
        double actualResult = calc.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void inverseTangentTest() {
        //given
        double expectedResult = 0.119;

        //when

        //normal
        calc.setDisplayValue(0.12);
        double displayValue = calc.getDisplayValue();
        double newValue = trigFunctions.inverseTangent(displayValue);
        calc.setDisplayValue(newValue);
        double actualResult = calc.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void isValNaNTest() {
        //given
        boolean expectedResult = true;

        //when
        //doing integer division raises an exception, floating point division gives you NaN
        boolean actualResult = trigFunctions.isValNaN(0.0/0);

        //then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @After
    public void resetData() {
        calc.setDisplayValue(0.0);
        //nothing is stored in trig functions so nothing to reset
    }
}