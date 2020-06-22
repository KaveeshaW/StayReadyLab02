package com.codedifferently;

public class Memory {
    private double valueInMemory;
 
    public Memory() {
        this.valueInMemory = 0.0;
    }

    public void addMemory(double amount) {
        this.valueInMemory = amount;
    }

    public void resetMemory() {
        this.valueInMemory = 0.0;
    }

    public double recallValue() {
        return this.valueInMemory;
    }
}