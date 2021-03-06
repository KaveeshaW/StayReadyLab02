/**
 * @author Kaveesha Weerasiri
 * @author Giovane Barnes
 */

package com.codedifferently;

import org.junit.*;

public class ArithmeticTest {
    SciCalculator unit;
    Arithmetic alu;
    @Before
    public void initialize() {
        unit = new SciCalculator();
        alu = new Arithmetic();
    }

    @Test
    public void addTest() {
        //given
        double expectedResult = 10.4;

        //when
        double displayValue = unit.getDisplayValue();
        double newValue = alu.add(10.4, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void subtractTest() {
        //given
        double expectedResult = -13.4;

        //when
        double displayValue = unit.getDisplayValue();
        double newValue = alu.subtract(13.4, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void multiplyTest() {
        //given
        double expectedResult = 16.89;

        //when
        unit.setDisplayValue(1.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.multiply(16.89, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void divideTest() {
        //given
        double expectedResult = 5.0;

        //when
        //regular divide
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(20.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.divide(4.0, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //used for divide by zero
        double divideByZeroExpected = actualResult;

        //divide by zero
        double actualDivideByZero = alu.divide(0.0, actualResult);

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
        Assert.assertEquals(divideByZeroExpected, actualDivideByZero, 0.001);
    }

    @Test
    public void calculateSquareTest() {
        //given
        double expectedResult = 16.0;

        //when
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(4.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.calculateSquare(displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void calculateSquareRootTest() {
        //given
        double posExpectedResult = 2.0;
        double negExpectedResult = -2.0;

        //when
        //testing positive result
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(4.0);
        double posDisplayValue = unit.getDisplayValue();
        double newPosValue = alu.calculateSquareRoot(posDisplayValue);
        unit.setDisplayValue(newPosValue);
        double actualPosResult = unit.getDisplayValue();

        //testing negative result
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(-2.0);
        double negDisplayValue = unit.getDisplayValue();
        double newNegValue = alu.calculateSquareRoot(negDisplayValue);
        unit.setDisplayValue(newNegValue);
        double actualNegResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(posExpectedResult, actualPosResult, 0.001);
        Assert.assertEquals(negExpectedResult, actualNegResult, 0.001);
    }

    @Test
    public void calculateExponentialTest() {
        //given
        double expectedResult = 16.0;

        //when    
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(2.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.calculateExponential(4.0, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void calculateInverseTest() {
        //given
        //positive check
        double expectedPosResult = 0.25;
        //divide by zero check
        double expectedZeroInverse = 0.0;
        double expectedNegResult = -0.25;

        //when
        
        //regular inverse
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(4.0);
        double posdisplayValue = unit.getDisplayValue();
        double newPosValue = alu.calculateInverse(posdisplayValue);
        unit.setDisplayValue(newPosValue);
        double actualPosResult = unit.getDisplayValue();
        
        //zero inverse
        unit.setDisplayValue(0.0);
        double zeroDisplay = unit.getDisplayValue();
        double actualZeroInverse = alu.calculateInverse(zeroDisplay);

        //negative inverse
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(-4.0);
        double negDisplayValue = unit.getDisplayValue();
        double newNegValue = alu.calculateInverse(negDisplayValue);
        unit.setDisplayValue(newNegValue);
        double actualNegResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedPosResult, actualPosResult, 0.001);
        Assert.assertEquals(expectedZeroInverse, actualZeroInverse, 0.001);
        Assert.assertEquals(expectedNegResult, actualNegResult, 0.001);
    }

    @Test
    public void invertSignTest() {
        //given
        double expectedResult = -4.0;

        //when
        //setDisplay to something other than 0 so it would not return 0
        unit.setDisplayValue(4.0);
        double displayValue = unit.getDisplayValue();
        double newValue = alu.invertSign(displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void computeDistanceFormulaTest() {
        //given
        double expectedResult = 3.606;

        //when
        double displayValue = unit.getDisplayValue();
        double newValue = alu.computeDistanceFormula(5, 4, 3, 1, displayValue);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void computeQuadraticFormulaTest() {
        //the numbers I used resulted in negative numbers for both positive and negative
        double posExpectedResult = -0.423;
        double negExpectedResult = -1.577;
        double zeroExpectedResult = 0.0;
        double negSquareRootRes = 0.0;

        //when
        //testing positive things
        double posDisplayValue = unit.getDisplayValue();
        double posValue = alu.computeQuadraticFormula(3.0, 6.0, 2.0, "positive", posDisplayValue);
        unit.setDisplayValue(posValue);
        double posActualResult = unit.getDisplayValue();

        //testing the negative things
        unit.setDisplayValue(0.0);
        double negDisplayValue = unit.getDisplayValue();
        double negValue = alu.computeQuadraticFormula(3.0, 6.0, 2.0, "negative", negDisplayValue);
        unit.setDisplayValue(negValue);
        double negActualResult = unit.getDisplayValue();

        //testing dividing by zero
        unit.setDisplayValue(0.0);
        double zeroDisplayVal = unit.getDisplayValue();
        //doesn't really matter what I pass in, just want a to be 0.0 because that is what I am dividing by
        double zeroErrorValue = alu.computeQuadraticFormula(0.0, 6.0, 2.0, "pos", zeroDisplayVal);
        unit.setDisplayValue(zeroErrorValue);
        double zeroErrorActualResult = unit.getDisplayValue();

        //testing taking the square root of a negative number
        unit.setDisplayValue(0.0);
        double negErrorDisplayVal = unit.getDisplayValue();
        //doesn't really matter what I pass in, just want a to be 0.0 because that is what I am dividing by
        double squareRootErrorValue = alu.computeQuadraticFormula(7.0, 3.0, 2.0, "neg", negErrorDisplayVal);
        unit.setDisplayValue(squareRootErrorValue);
        double negSquareRootActualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(posExpectedResult, posActualResult, 0.001);
        Assert.assertEquals(negExpectedResult, negActualResult, 0.001);
        Assert.assertEquals(zeroExpectedResult, zeroErrorActualResult, 0.001);
        Assert.assertEquals(negSquareRootRes, negSquareRootActualResult, 0.001);
    }

    @Test
    public void computeHypotenus() {
        //the numbers I used resulted in negative numbers for both positive and negative
        double expectedResult = 9.220;

         //when
        double newValue = alu.computeHypotenus(6.0, 7.0);
        unit.setDisplayValue(newValue);
        double actualResult = unit.getDisplayValue();

        //then
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void computeLog() {
        double expectedResult = 2.485;
        double negExpected = -1.0;

        double actualResult = alu.computeLog(12);
        double negActual = alu.computeLog(-1.0);

        Assert.assertEquals("testing log", expectedResult, actualResult, 0.001);
        Assert.assertEquals("testing negative numbers", negExpected, negActual, 0.001);
    }

    @After
    public void resetData() {
        unit.setDisplayValue(0.0);
        //don't need to reset the alu because it doesn't store any values
    }
    
}