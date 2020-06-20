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
}