/**
 * @author Kaveesha Weerasiri
 * @author Giovane Barnes
 */

package com.codedifferently;

//no longer need to put Math.method, just call the method
import static java.lang.Math.*;

public class Arithmetic {
    public static void main(String[] args) {
        System.out.println("I can do many computations");
        Arithmetic alu = new Arithmetic();
        System.out.println(alu.computeQuadraticFormula(3.0, 6.0, 2.0, "pos", 0.0));
        System.out.println(alu.computeQuadraticFormula(1.0, 2.0, 3.0, "neg", 0.0));
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
        if(divideAmount == 0.0) {
            System.out.println("Cannot divide by zero. Returning back the original value before the function call.");
            return amountAlready;
        }
        return amountAlready / divideAmount;
    }

    public double calculateSquare(double amountAlready) {
        return amountAlready * amountAlready;
    }

    public double calculateSquareRoot(double amountAlready) {
        if(amountAlready < 0.0) {
            System.out.println("Cannot calculate squareRoot less than 0.0. Returning back the original value before the function call.");
            return amountAlready;
        }
        return sqrt(amountAlready);
    }

    public double calculateExponential(double exponent, double amountAlready) {
        return pow(amountAlready, exponent);
    }

    public double calculateInverse(double amountAlready) {
        if(amountAlready == 0.0) {
            System.out.println("Cannot take the inverse of zero. Returning back the original value before the function call.");
            return amountAlready;
        }
        return 1 / amountAlready;
    }

    public double invertSign(double amountAlready) {
        return -amountAlready;
    }

    public double computeDistanceFormula(double x1, double y1, double x2, double y2, double amountAlready) {
        return sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
    }

    public double computeQuadraticFormula(double a, double b, double c, String posOrNeg, double amountAlready) {
        if(a == 0.0) {
            System.out.println("Cannot do quadratic formula with a as 0. Returning back the original value before the function call.");
            return amountAlready;
        }
        //avoiding square root returning NAN because it's trying to take the sqrt of a negative
        if(pow(b, 2) - (4.0 * a * c) < 0.0) {
            System.out.println();
            System.out.println("Cannot take the square root of a negative number (after computing the top half under the square root).");
            System.out.println("(4 times " + a + " times " + c +  " is bigger than the square of " + b + "). ");
            System.out.println("Returning back the original value before the function call.");
            System.out.println();
            return amountAlready;
        }
        double newB = invertSign(b);
        if(posOrNeg.equals("positive") || posOrNeg.equals("pos")) {
            double posTopPart = newB + sqrt(pow(b, 2) - (4.0 * a * c));
            //System.out.println("This is the top part pos: " + posTopPart);
            return posTopPart / (2.0 * a);
        }
        else if(posOrNeg.equals("negative") || posOrNeg.equals("neg")) {
            double negTopPart =  newB - sqrt(pow(b, 2) - (4.0 * a * c));
            //System.out.println("This is the top part neg: " + negTopPart);
            return negTopPart / (2.0 * a);
        }
        return 0.0;
    }

    public double computeHypotenus(double a, double b) {
        return sqrt(pow(a, 2) + pow(b, 2));
    }

    public double computeLog(double amountAlready) {
        if(amountAlready < 0.0) {
            System.out.println("value you entered is not applicable to log. Returing value entered into method.");
            return amountAlready;
        }
        return log(amountAlready);
    }

}