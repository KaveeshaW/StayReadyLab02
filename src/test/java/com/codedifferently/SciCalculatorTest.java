package com.codedifferently;

import org.junit.Assert;
import org.junit.Test;


public class SciCalculatorTest 
{
    public static void main(String[] args) {
        System.out.println("yo");
    }
    
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
    public void getDisplayTest() { 
        //Given
        double expectedDisplay = 0.0;
        
        //When 
        SciCalculator calc = new SciCalculator();
        double actualDisplay = calc.getDisplayValue(); 
    
        //Then
        Assert.assertEquals(expectedDisplay , actualDisplay, 0.01);
    }

    @Test
    public void setDisplayTest() {
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
        String expectedDisplay = "Err";

        //when
        SciCalculator calc = new SciCalculator();
        //String actualDisplay = calc.displayError();

        //then (placeholder, not actual test)
        Assert.assertEquals(expectedDisplay , "a");

    }

    @Test
    public void sayHelloTest(){ 
        //given 
        String expectedDisplay = "Welcome to Kaveesha's and Gio's Calculator" ;

       //when
       SciCalculator calc = new SciCalculator();
       calc.sayHello();
       String actualDisplay = "wow";

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
        
}
