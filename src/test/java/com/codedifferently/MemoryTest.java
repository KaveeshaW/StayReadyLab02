package com.codedifferently;

import org.junit.*;

public class MemoryTest {
    @Test
    public void addMemoryTest() {
         //given
         double expectedResult = 153.4;

         //when
         Memory mem = new Memory();
 
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
         Memory mem = new Memory();
 
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
         Memory mem = new Memory();
 
         mem.addMemory(190.54);
         mem.resetMemory();
         double actualResult = mem.recallValue();
 
         //then
         Assert.assertEquals(expectedResult, actualResult, 0.01);
    }
}