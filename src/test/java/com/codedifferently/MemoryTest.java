/**
 * @author Kaveesha Weerasiri
 * @author Giovane Barnes
 */

package com.codedifferently;

import org.junit.*;

public class MemoryTest {
    Memory mem;
    @Before
    public void initialize() {
       mem = new Memory();
    }

    @Test
    public void memoryConstructorTest() {
          //given
          double expectedVal = 0.0;

          //when
          double actualVal = mem.recallValue();

          //then
          Assert.assertEquals(expectedVal, actualVal, 0.001);
    } 

    @Test
    public void addMemoryTest() {
         //given
         double expectedResult = 153.4;

         //when
         mem.addMemory(153.4);
         double actualResult = mem.recallValue();
 
         //then
         Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void recallValueTest() {
         //given
         double expectedResult = 190.54;

         //when
         mem.addMemory(190.54);
         double actualResult = mem.recallValue();
 
         //then
         Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @Test
    public void resetMemoryTest() {
         //given
         double expectedResult = 0.0;

         //when
         mem.addMemory(190.54);
         mem.resetMemory();
         double actualResult = mem.recallValue();
 
         //then
         Assert.assertEquals(expectedResult, actualResult, 0.01);
    }

    @After
    public void deleteBeforeData() {
        mem.resetMemory();
    }
}