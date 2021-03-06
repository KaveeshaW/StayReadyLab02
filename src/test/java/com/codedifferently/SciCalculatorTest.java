/**
 * @author Kaveesha Weerasiri
 * @author Giovane Barnes
 */

package com.codedifferently;

import org.junit.*;
//import java.util.*;

public class SciCalculatorTest 
{ 
    SciCalculator calc;
    @Before
    public void initialize() {
       calc = new SciCalculator();
    }

    @Test
    public void constructorSciCalculatorTest() {
        // Given
        double expectedDisplay = 0.0;

        // When
        double actualDisplay = calc.getDisplayValue();

        // Then
        Assert.assertEquals(expectedDisplay, actualDisplay, 0.001);
    }

    @Test
    public void getDisplayValueTest() { 
        //Given
        double expectedDisplay = 0.0;
        
        //When 
        double actualDisplay = calc.getDisplayValue(); 
    
        //Then
        Assert.assertEquals(expectedDisplay , actualDisplay, 0.001);
    }

    @Test
    public void setDisplayValueTest() {
        // given
        double expectedDisplay = 14.3;

        //when
        calc.setDisplayValue(14.3);
        Double actualValue = calc.getDisplayValue();    

        //then
        Assert.assertEquals(expectedDisplay, actualValue, 0.001);
    }

    @Test 
    public void clearDisplayTest() { 
        //Given 
        double expectedDisplay = 0.0;

        //When
        double actualDisplay = calc.getDisplayValue();

        //Then 
        Assert.assertEquals(expectedDisplay , actualDisplay, 0.001);
    }

    @Test
    public void displayErrorTest(){
        //Given 
        String expectedDisplay = "Error";

        //when
        String actualDisplay = calc.displayError();

        //then (placeholder, not actual test)
        Assert.assertEquals(expectedDisplay , actualDisplay);
    }

    @Test
    public void sayHelloTest(){ 
       //given 
       String expectedDisplay = "Welcome to Kaveesha's and Gio's Calculator" ;

       //when
       String actualDisplay = calc.sayHello();

       //then (placeholder, not actual test)
       Assert.assertEquals(expectedDisplay, actualDisplay);
    }
    @Test
    public void getArithmeticTest(){
        Double expectedValue  = 5.0;

        Arithmetic alu = calc.getArithmetic();
        double amount = calc.getDisplayValue();
        double newAmount = alu.add(5.0, amount);
        calc.setDisplayValue(newAmount);
        double actualValue = calc.getDisplayValue();

        Assert.assertEquals(expectedValue, actualValue, 0.001);
    }

    @Test
    public void getDisplayModeTest() {
        //given
        String expectedValue  = "decimal";

        //when
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
        //value is equal to 0.0 on the calculator
        double value = calc.getDisplayValue();
        //cosine of 0.0
        double cosValue = calc.getTrigFunctions().cosine(value);
        //sets the display to 1.0
        calc.setDisplayValue(cosValue);

        //then
        Assert.assertEquals(expectedValue, cosValue, 0.001);
    }

    @Test
    public void getMemoryTest() { 
        //given
        double expectedValue = 0.0; 

        //when 
        //the memory is being cleared
        double actualResult = calc.getMemory().recallValue();

        //then 
        Assert.assertEquals(expectedValue, actualResult, 0.0);
    }

    @Test
    public void getInputErrorTest() { 
        //given
        boolean expectedValue = false; 

        //when 
        //calc should return the input error value, which should be false
        boolean actualResult = calc.getInputError();

        //then 
        Assert.assertEquals(expectedValue, actualResult);
    }

    @Test
    public void setnputErrorTest() { 
        //given
        boolean expectedValue = true; 

        //when 
        //inputError should be set to true
        calc.setInputError(true);
        boolean actualValue = calc.getInputError();

        //then 
        Assert.assertEquals(expectedValue, actualValue);
    }


    @Test
    public void getMapTest() {
        //given
        int addExpected = 1;

        //when
        calc.instantiateMap();
        double addValue = calc.getMap().get("add");
        //sets the display to 1.0
        calc.setDisplayValue(addValue);
        double addActual = calc.getDisplayValue();

        //then
        Assert.assertEquals(addExpected, addActual, 0.001);
    }

    @Test
    public void getDescriptionsMapTest() {
        //given
        //since everything is basically a string, I'm just going to test one of them
        String addDescriptionExpected = "Takes in 4 parameters. Uses the distance formula to find the distance between two points (x1, y1, x2, y2).";

        //when
        //makes sure that the descriptions hashmap has a value
        calc.fillDescriptions();
        String addDescriptionActual = calc.getDescriptionsMap().get("distance");

        //then
        Assert.assertEquals(addDescriptionExpected, addDescriptionActual);
    }

    @Test
    public void instantiateMapTest() {
        //given
        //testing all of the different numbers that can be outputted from the map
        int valExpected = 0;
        int valExpected2 = 1;
        int valExpected3 = 2;
        int valExpected4 = 3;
        int valExpected5 = 4;

        //when    
        calc.instantiateMap();
        int valActual = calc.getMap().get("square");
        int valActual2 = calc.getMap().get("exp");
        int valActual3 = calc.getMap().get("hyp");
        int valActual4 = calc.getMap().get("quad");
        int valActual5 = calc.getMap().get("distance");

        //then
        Assert.assertEquals(valExpected, valActual);
        Assert.assertEquals(valExpected2, valActual2);
        Assert.assertEquals(valExpected3, valActual3);
        Assert.assertEquals(valExpected4, valActual4);
        Assert.assertEquals(valExpected5, valActual5);
    }

    @Test
    public void fillDescriptionsTest() {
        //given
        String descriptionExpected = "Takes in 3 parameters. Uses the quadratic formula on the three inputted values (a, b, c). You can enter positive or negative to change the sign at the top of the fraction";

        //when
        calc.fillDescriptions();
        String descriptionActual = calc.getDescriptionsMap().get("quad");

        //then
        Assert.assertEquals(descriptionExpected, descriptionActual);
    }

    // @Test
    // public void getUserValuesTest() {
    //     //given
    //     Scanner scanner = new Scanner(System.in);
    //     double [] userInput = new double [4];
    //     boolean expectedAnswer = true;

    //     //when
    //     calc.getUserValues(scanner, calc, "distance", userInput);
    //     boolean actualAnswer =calc.getInputError();

    //     Assert.assertEquals(expectedAnswer, actualAnswer);
    // }

    @Test
    public void doCalculationWithInputOrDisplayTest() {
        //given
        double expectedDisplayVal = 0.0;
        double expectedInputVal = 0.851;

        //when
        double [] userNumArr = new double [1];
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
        Assert.assertEquals(expectedDisplayVal, actualDisplayVal, 0.001);
        Assert.assertEquals(expectedInputVal, actualInputVal, 0.001);
    }

    @After
    public void resetData() {
        calc.setDisplayValue(0.0);
    }
}
