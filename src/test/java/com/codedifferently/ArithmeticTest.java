package com.codedifferently;

import org.junit.*;

public class ArithmeticTest {
    @Test
    public void addTest() {
        //given
        double expectedResult = 10.4;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();

        double displayValue = unit.getDisplayValue();
        double newValue = alu.add(10.4, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void subtractTest() {
        //given
        double expectedResult = -13.4;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();

        double displayValue = unit.getDisplayValue();
        double newValue = alu.subtract(13.4, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void multiplyTest() {
        //given
        double expectedResult = 16.89;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();
        
        //otherwise will just give you 0
        unit.setDisplayValue(1.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.multiply(16.89, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void divideTest() {
        //given
        double expectedResult = 5.0;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();
        
        //regular divide
        unit.setDisplayValue(20.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.divide(4.0, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //used for divide by zero
        //using actual result because I do not want to create another SciCalculator
        double divideByZeroExpected = actualResult;

        //divide by zero
        double actualDivideByZero = alu.divide(0.0, actualResult);

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
        Assert.assertEquals(divideByZeroExpected, actualDivideByZero, 0.01);
    }

    @Test
    public void calculateSquareTest() {
        //given
        double expectedResult = 16.0;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();
        
        //otherwise will just give you 0
        unit.setDisplayValue(4.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.calculateSquare(displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void calculateSquareRootTest() {
        //given
        double expectedResult = 2.0;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();
        
        //otherwise will just give you 0
        unit.setDisplayValue(4.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.calculateSquareRoot(displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void calculateExponentialTest() {
        //given
        double expectedResult = 16.0;

        //when
        SciCalculator unit = new SciCalculator();
        Arithmetic alu = new Arithmetic();
        
        //otherwise will just give you 0
        unit.setDisplayValue(2.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.calculateExponential(4.0, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }
    
}