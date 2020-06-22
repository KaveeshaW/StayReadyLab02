package com.codedifferently;

public class TrigFunctions {
    public static void main(String[] args) {
        SciCalculator unit = new SciCalculator();
        TrigFunctions trigFunctions = new TrigFunctions();

        unit.setDisplayValue(0.12);
        double displayValue = unit.getDisplayValue();
        System.out.println(displayValue);
        
        double newValue = trigFunctions.inverseSine(displayValue);
        System.out.println(newValue);
        unit.setDisplayValue(newValue);
    }

    public double sine(double display){
        double sinValue = Math.sin(display);
        if(isValNaN(sinValue)) {
            printNaNError("sine");
            return display;
        }
        return sinValue;
    }
    public double cosine(double display){
        double cosValue = Math.cos(display);
        if(isValNaN(cosValue)) {
            printNaNError("cosine");
            return display;
        }
        return cosValue;
    }
    public double tangent(double display){
        double tanValue = Math.tan(display);
        if(isValNaN(tanValue)) {
            printNaNError("tangent");
            return display;
        }
        return tanValue;
    }
    public double inverseSine(double display){
        double inverseSineValue = Math.asin(display);
        if(isValNaN(inverseSineValue)) {
            printNaNError("inverseSine");
            return display;
        }
        return inverseSineValue;

    }
    public double inverseCosine(double display){
        double inverseCosValue = Math.acos(display);
        if(isValNaN(inverseCosValue)) {
            printNaNError("inverseCosine");
            return display;
        }
        return inverseCosValue;
       
    }
    public double inverseTangent(double display){
        double inverseTangentValue = Math.atan(display);
        if(isValNaN(inverseTangentValue)) {
            printNaNError("inverseTangent");
            return display;
        }
        return inverseTangentValue;
    }

    //checks to see if value is NaN
    public boolean isValNaN(double val) {
        boolean isNaN = false;
        Double check = (Double) val;
        if(check.isNaN()) {
            isNaN = true;
        }
        return isNaN;
    }

    //prints NaN error
    public void printNaNError(String method) {
        System.out.println("Value you gave returns NaN when computing " + method + ". Overriding display value with inputted value.");
    }

    
}
