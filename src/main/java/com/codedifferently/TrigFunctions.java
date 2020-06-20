package com.codedifferently;

public class TrigFunctions {
    public double sine(){
        double degrees = 45.0;
        double radians = Math.to(degrees);
        double sinValue = Math.sin(radians);
        return sinValue;
    }
    public double cos(){
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);
        double cosValue = Math.cos(radians);
        return cosValue;
    }
    public double tan(){
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);
        double tanValue = Math.tan(degrees);
        return tanValue;
    }
    public double invCos(){
        double degrees = 0.0;
        return degrees;
    }
}
