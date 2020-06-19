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
            System.out.println("Cannot divide by zero. Returning back original value");
            return amountAlready;
        }
        return amountAlready / divideAmount;
    }

    public double calculateSquare(double amountAlready) {
        return amountAlready * amountAlready;
    }

    public double calculateSquareRoot(double amountAlready) {
        return Math.sqrt(amountAlready);
    }

    public double calculateExponential(double exponent, double amountAlready) {
        return Math.pow(amountAlready, exponent);
    }

    public double calculateInverse(double amountAlready) {
        if(amountAlready <= 0.0) {
            System.out.println("Cannot take the inverse of zero. Returning back original value");
            return amountAlready;
        }
        return 1 / amountAlready;
    }

    public Double invertSign(double amountAlready) {
        return -amountAlready;
    }

    public Double computeDistanceFormula(double x1, double x2, double x3, double x4) {
        return 0.0;
    }

}