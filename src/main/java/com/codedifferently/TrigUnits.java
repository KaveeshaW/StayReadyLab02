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