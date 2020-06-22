package com.codedifferently;

import org.junit.*;

public class TrigUnitsTest {

    @Test
    public void constructorTest() {
        //given
        String expectedValue = "radians";

        //when
        TrigUnits units = new TrigUnits();
        String actualValue = units.getMode();

        //then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getModeTest() {
        //given
        String expectedValue = "radians";
        
        //when
        TrigUnits units = new TrigUnits();
        String actualValue = units.getMode();

        //then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void switchUnitsWithArgsTest() {
        //given
        String expectedValue = "radians";
        
        //when
        TrigUnits units = new TrigUnits();
        units.switchUnitsMode("radians");
        String actualValue = units.getMode();

        //then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void switchUnitsNoArgsTest() {
        //given
        //by default, the calc should be using radians, so the first time you switch you should expect degrees
        String expectedValue = "degrees";
        String expectedValue2 = "radians";
        
        //when
        TrigUnits units = new TrigUnits();
        units.switchUnitsMode();
        String actualValue = units.getMode();

        units.switchUnitsMode();
        String actualValue2 = units.getMode();

        //then
        Assert.assertEquals(expectedValue, actualValue);
        Assert.assertEquals(expectedValue2, actualValue2); 
    }
}