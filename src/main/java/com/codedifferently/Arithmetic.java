package com.codedifferently;

public class Arithmetic {
    public static void main(String[] args) {
        System.out.println("I can do many computations");
    }

    public double add(double newAmount, double amountAlready) {
        return newAmount + amountAlready;
    }

    public double subtract(double amount, double amountAlready) {
        return amountAlready - amount;
    }

    public double multiply(double amount, double amountAlready) {
        return amountAlready * amount;
    }

    public double divide(double divideAmount, double amountAlready) {
        if(divideAmount <= 0.0) {
            System.out.println("Cannot divide by zero");
            return amountAlready;
        }
        return amountAlready / divideAmount;
    }

}