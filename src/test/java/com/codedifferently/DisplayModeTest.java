package com.codedifferently;

import org.junit.*;

public class DisplayModeTest {
    @Test
    public void displayModeConstructorTest() {
         //Given 
         String expectedMode = "decimal";

         //When
         DisplayMode mode = new DisplayMode();
         String actualMode = mode.getMode();
 
         //Then 
         Assert.assertEquals(expectedMode, actualMode);
    }

    @Test
    public void getModeTest() {
        //Given 
        String expectedMode = "decimal";

        //When
        DisplayMode mode = new DisplayMode();
        String actualMode = mode.getMode();

        //Then 
        Assert.assertEquals(expectedMode, actualMode);
   }

   //NEED TO CHANGE FUNCTIONALITY AT SOME POINT
   @Test
   public void switchDisplayModeNoArgsTest() {
       //Given 
       String expectedMode = "hexadecimal";

       //When
       DisplayMode mode = new DisplayMode();
       mode.switchDisplayMode();
       String actualMode = mode.getMode();

       //Then 
       Assert.assertEquals(expectedMode, actualMode);
   }


   @Test
   public void switchDisplayModeWithArgsTest() {
       //Given 
       String expectedMode = "hexadecimal";

       //When
       DisplayMode mode = new DisplayMode();
       mode.switchDisplayMode("hexadecimal");
       String actualMode = mode.getMode();

       //Then 
       Assert.assertEquals(expectedMode, actualMode);
   }

}