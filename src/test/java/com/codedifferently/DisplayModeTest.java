/**
 * @author Kaveesha Weerasiri
 * @author Giovane Barnes
 */

package com.codedifferently;

import org.junit.*;

public class DisplayModeTest {
    DisplayMode mode;
    @Before
    public void initialize() {
       mode = new DisplayMode();
    }

    @Test
    public void displayModeConstructorTest() {
         //Given 
         String expectedMode = "decimal";

         //When
         String actualMode = mode.getMode();
 
         //Then 
         Assert.assertEquals(expectedMode, actualMode);
    }

    @Test
    public void getModeTest() {
        //Given 
        String expectedMode = "decimal";

        //When
        String actualMode = mode.getMode();

        //Then 
        Assert.assertEquals(expectedMode, actualMode);
   }

   @Test
   public void switchDisplayModeNoArgsTest() {
       //Given 
       String expectedMode = "hexadecimal";
       String expectedMode2 = "binary";
       String expectedMode3 = "octal";
       String expectedMode4 = "decimal";

       //When
       mode.switchDisplayMode();
       String actualMode = mode.getMode();

       mode.switchDisplayMode();
       String actualMode2 = mode.getMode();

       mode.switchDisplayMode();
       String actualMode3 = mode.getMode();

       mode.switchDisplayMode();
       String actualMode4 = mode.getMode();

       //Then 
       Assert.assertEquals(expectedMode, actualMode);
       Assert.assertEquals(expectedMode2, actualMode2);
       Assert.assertEquals(expectedMode3, actualMode3);
       Assert.assertEquals(expectedMode4, actualMode4);
   }

   //switches from decimal to hexadecimal to binary to octal
   @Test
   public void switchDisplayModeWithArgsTest() {
       //Given 
       String firstModeExpected = "hexadecimal";
       String secondModeExpected = "binary";
       String thirdModeExpected = "octal";
       String fourthModeExpected = "decimal";

       //When
       mode.switchDisplayMode("hexadecimal");
       String firstActualMode = mode.getMode();

       mode.switchDisplayMode("binary");
       String secondActualMode = mode.getMode();

       mode.switchDisplayMode("octal");
       String thirdActualMode = mode.getMode();

       mode.switchDisplayMode("decimal");
       String fourthActualMode = mode.getMode();

       //Then 
       Assert.assertEquals(firstModeExpected, firstActualMode);
       Assert.assertEquals(secondModeExpected, secondActualMode);
       Assert.assertEquals(thirdModeExpected, thirdActualMode);
       Assert.assertEquals(fourthModeExpected, fourthActualMode);
   }

    @After
    public void resetData() {
       mode.switchDisplayMode("decimal");;
    }

}