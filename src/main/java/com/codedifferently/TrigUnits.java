package com.codedifferently;

//degrees and radians
public class TrigUnits {
    private String whichUnit;

    public TrigUnits() {
        this.whichUnit = "radians";
    }

    public String getMode() {
        return this.whichUnit;
    }

    public void switchUnitsMode() {
        if(this.whichUnit.equals("radians")) {
            this.whichUnit = "degrees";
        }
        else if(this.whichUnit.equals("degrees")) {
            this.whichUnit = "radians";
        }
    }

    public void switchUnitsMode(String mode) {
        this.whichUnit = mode;
    }

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

    //converts input into radians
    public static double [] toTrigModeForCalc(double [] userNumArr){
        for(int i = 0; i < userNumArr.length; i++) {
            //convert to radians
            userNumArr[i] = Math.toRadians(userNumArr[i]);
        }
        return userNumArr;
    }      
}