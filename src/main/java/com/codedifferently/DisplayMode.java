package com.codedifferently;

public class DisplayMode {
    private String whichMode;
    private final String [] MODES = {"decimal", "hexadecimal", "binary", "octal"};

    public static void main(String[] args) {
        DisplayMode mode = new DisplayMode();
        mode.switchDisplayMode();
    }

    //constructor
    public DisplayMode() {
        whichMode = "decimal";
    }
    
    public void switchDisplayMode() {
        whichMode = MODES[1];
        System.out.println(whichMode);
    }

    public void switchDisplayMode(String mode) {
        this.whichMode = mode;
    }

    public String getMode() {
        return this.whichMode;
    }
}