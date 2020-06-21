package com.codedifferently;

//degrees and radians
public class TrigUnits {
    private String whichUnit;

    public TrigUnits() {
        this.whichUnit = "degrees";
    }

    public String getMode() {
        return this.whichUnit;
    }

    //NEED TO DO
    public void switchUnitsMode() {

    }

    public void switchUnitsMode(String mode) {
        this.whichUnit = mode;
    }

    // Prompt user to enter Trig Method (Settng)
    // Once there, have a initially asks the user the user what mode they would like to be in RADIANS or DEGREES
    // Moreover, ask create a keyword, similar to "quit", that can bring up this options maybe "trigMode"
    // Anyway, then continue regularly like we did for the simple math, inputs etc
    //used to check whether input needs to be converted or not
    public static boolean toTrigModeForUser(String ans){
        boolean trigMode = false;
        if(ans.toLowerCase().equals("radians")){
             trigMode = true;
        }
        else if(ans.toLowerCase().equals("degrees")){
             trigMode = false;
        }
        return trigMode;
    } 

    public static double [] toTrigModeForCalc(double [] userNumArr){
        for(int i = 0; i < userNumArr.length; i++) {
            //convert to radians
            userNumArr[i] = Math.toRadians(userNumArr[i]);
        }
        return userNumArr;
    }      
}