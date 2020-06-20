package com.codedifferently;

import org.junit.*;

public class TrigUnitsTest {

    @Test
    public void constructorTest() {
        //given
        String expectedValue = "degrees";

        //when
        TrigUnits units = new TrigUnits();
        String actualValue = units.getMode();

        //then
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getModeTest() {
        //given
        String expectedValue = "degrees";
        
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


    //NEED TO FIX
    @Test
    public void switchUnitsNoArgsTest() {
        //given
        String expectedValue = "radians";
        
        //when
        TrigUnits units = new TrigUnits();
        units.switchUnitsMode("radians");
        String actualValue = units.getMode();

        //then
        Assert.assertEquals(expectedValue, actualValue);
    }
}