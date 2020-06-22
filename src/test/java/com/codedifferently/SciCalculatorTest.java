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
        double  actualDisplay = calc.getDisplayValue();

        // Then
        Assert.assertEquals(expectedDisplay, actualDisplay, 0.01);
    }

    @Test
    public void getDisplayValueTest() { 
        //Given
        double expectedDisplay = 0.0;
        
        //When 
        SciCalculator calc = new SciCalculator();
        double actualDisplay = calc.getDisplayValue(); 
    
        //Then
        Assert.assertEquals(expectedDisplay , actualDisplay, 0.01);
    }

    @Test
    public void setDisplayValueTest() {
        // given
        double expectedDisplay = 14.3;

        //when
        SciCalculator calc = new SciCalculator();
        calc.setDisplayValue(14.3);
        Double actualValue = calc.getDisplayValue();    

        //then
        Assert.assertEquals(expectedDisplay, actualValue, 0.01);
    }

    @Test 
    public void clearDisplayTest() { 
        //Given 
        double expectedDisplay = 0.0;

        //When
        SciCalculator calc = new SciCalculator();
        double actualDisplay = calc.getDisplayValue();

        //Then 
        Assert.assertEquals(expectedDisplay , actualDisplay, 0.01);
    }

    @Test
    public void displayErrorTest(){
        //Given 
        String expectedDisplay = "Error";

        //when
        SciCalculator calc = new SciCalculator();
        String actualDisplay = calc.displayError();

        //then (placeholder, not actual test)
        Assert.assertEquals(expectedDisplay , actualDisplay);

    }

    @Test
    public void sayHelloTest(){ 
        //given 
        String expectedDisplay = "Welcome to Kaveesha's and Gio's Calculator" ;

       //when
       SciCalculator calc = new SciCalculator();
       String actualDisplay = calc.sayHello();

       //then (placeholder, not actual test)
       Assert.assertEquals(expectedDisplay, actualDisplay);

    }
    @Test
    public void getArithmeticTest(){
        Double expectedValue  = 5.0;

        SciCalculator calc = new SciCalculator();
        Arithmetic alu = calc.getArithmetic();
        double amount = calc.getDisplayValue();
        double newAmount = alu.add(5.0, amount);
        calc.setDisplayValue(newAmount);
        double actualValue = calc.getDisplayValue();

        Assert.assertEquals(expectedValue, actualValue, 0.01);
    }

    @Test
    public void getDisplayModeTest() {
        //given
        String expectedValue  = "decimal";

        //when
        SciCalculator calc = new SciCalculator();
        DisplayMode calcMode = calc.getDisplayMode();
        String actualValue = calcMode.getMode();

        //then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getTrigFunctionsTest() {
        //given
        double expectedValue = 1.0; 

        //when
        //cosine of 0
        SciCalculator calc = new SciCalculator();
        //value is equal to 0.0 on the calculator
        double value = calc.getDisplayValue();
        double cosValue = calc.getTrigFunctions().cosine(value);
        //sets the display to 1.0
        calc.setDisplayValue(cosValue);

        //then
        Assert.assertEquals(expectedValue, cosValue, 0.01);
    }

    @Test
    public void getMemoryTest() { 
        //given
        double expectedValue = 0.0; 

        //when 
        //the memory is being cleared
        SciCalculator calc = new SciCalculator(); 
        double actualResult = calc.getMemory().recallValue();

        //then 
        Assert.assertEquals(expectedValue, actualResult, 0.0);
    }

    @Test
    public void getMapTest() {
        //given
        int addExpected = 1;

        //when
        //cosine of 0
        SciCalculator calc = new SciCalculator();
        //value is equal to 0.0 on the calculator
        calc.instantiateMap(calc.getMap());
        double addValue = calc.getMap().get("add");
        //sets the display to 1.0
        calc.setDisplayValue(addValue);
        double addActual = calc.getDisplayValue();

        //then
        Assert.assertEquals(addExpected, addActual, 0.01);
    }

    @Test
    public void getDescriptionsMapTest() {
        //given
        int addExpected = 1;

        //when
        //cosine of 0
        SciCalculator calc = new SciCalculator();
        //value is equal to 0.0 on the calculator
        calc.instantiateMap(calc.getMap());
        double addValue = calc.getMap().get("add");
        //sets the display to 1.0
        calc.setDisplayValue(addValue);
        double addActual = calc.getDisplayValue();

        //then
        Assert.assertEquals(addExpected, addActual, 0.01);
    }

    @Test
    public void instantiateMapTest() {
        //given
        String descriptionExpected = "Takes in 1 parameter. Adds that parameter to the current value displayed.";

        //when
        //cosine of 0
        SciCalculator calc = new SciCalculator();
        //value is equal to 0.0 on the calculator
        calc.fillDescriptions(calc.getDescriptionsMap());
        String descriptionActual = calc.getDescriptionsMap().get("add");

        //then
        Assert.assertEquals(descriptionExpected, descriptionActual);
    }

    @Test
    public void fillDescriptionsTest() {
        //given
        String descriptionExpected = "Takes in 1 parameter. Adds that parameter to the current value displayed.";

        //when
        //cosine of 0
        SciCalculator calc = new SciCalculator();
        //value is equal to 0.0 on the calculator
        calc.fillDescriptions(calc.getDescriptionsMap());
        String descriptionActual = calc.getDescriptionsMap().get("add");

        //then
        Assert.assertEquals(descriptionExpected, descriptionActual);
    }

    @Test
    public void doCalculationWithInputOrDisplayTest() {
        //given
        double expectedDisplayVal = 0.0;
        double expectedInputVal = 0.851;

        //when
        //tests the display functionality
        SciCalculator calc = new SciCalculator();
        //should be 0 by default
        double [] userNumArr = new double [1];
        //value is equal to 0.0 on the calculator
        double returnedDisplay = calc.doCalculationWithInputOrDisplay("display", calc, "sin", userNumArr);
        calc.setDisplayValue(returnedDisplay);
        double actualDisplayVal = calc.getDisplayValue();

        userNumArr[0] = 45.0;
        System.out.println(calc.getTrigFunctions().sine(45.0));
        double returnedInput = calc.doCalculationWithInputOrDisplay("input", calc, "sin", userNumArr);
        calc.setDisplayValue(returnedInput);
        double actualInputVal = calc.getDisplayValue();

        //then
        //displayFunctionality
        Assert.assertEquals(expectedDisplayVal, actualDisplayVal, 0.01);
        Assert.assertEquals(expectedInputVal, actualInputVal, 0.01);
    }
}
