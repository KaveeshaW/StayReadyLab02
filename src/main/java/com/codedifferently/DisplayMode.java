package com.codedifferently;

public class DisplayMode {
    private String whichMode;

    public static void main(String[] args) {
        DisplayMode mode = new DisplayMode();
        mode.switchDisplayMode();
    }

    //constructor
    public DisplayMode() {
        whichMode = "decimal";
    }
 
    public void switchDisplayMode() {

        String currentMode = whichMode;


        if(currentMode.equals("decimal")) {
            whichMode = "hexadecimal";
        }
        if(currentMode.equals("hexadecimal")) {
            whichMode = "binary";
        }
        if(currentMode.equals("binary")) {
            whichMode = "octal";
        }
        if(currentMode.equals("octal")) {
            whichMode = "decimal";
        }
         
    }

    public void switchDisplayMode(String mode) {
        //if the user input does not equal any of these modes, then tell the user to try again
        //negate all of them because if any of them is true, then the value should turn false, and it should go to the else statement
        if(!(mode.toLowerCase().equals("decimal") || mode.toLowerCase().equals("hexadecimal") || mode.toLowerCase().equals("binary") || mode.toLowerCase().equals("octal"))) {
            System.out.println("This is not a mode. Call 'mode' and try again.");
        }
        else{
            this.whichMode = mode;
        }
    }

    public String getMode() {
        return this.whichMode;
    }
}