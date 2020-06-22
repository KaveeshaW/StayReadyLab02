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
        return sinValue;
    }
    public double cosine(double display){
        double cosValue = Math.cos(display);
        return cosValue;
    }
    public double tangent(double display){
        double tanValue = Math.tan(display);
        return tanValue;
    }
    public double inverseSine(double display){
        double inverseSineValue = Math.asin(display);
        return inverseSineValue;

    }
    public double inverseCosine(double display){
        double inverseCosValue = Math.acos(display);
        return inverseCosValue;
       
    }
    public double inverseTangent(double display){
        double inverseTangentValue = Math.atan(display);
        return inverseTangentValue;
    }

    public boolean checkIfValIsNaN(double val, String method) {
        boolean isNaN = false;
        Double check = (Double) val;
        if(check.isNaN()) {
            System.out.println("Value you gave returns NaN when computing " + method + ". Overriding display value with inputted value.");
            isNaN = true;
        }
        return isNaN;
    }

    
}
