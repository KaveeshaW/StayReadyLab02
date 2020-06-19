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
       double actualDisplay = calc.getDisplayValue();

       //then (placeholder, not actual test)
       Assert.assertEquals(expectedDisplay, "e");

    }
}
