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

        // Scanner userChoice = new Scanner(System.in);
        // System.out.println("Please select a number for your display mode. /n 1 = Decimal /n 3 = Binary /n 4 = Hexadecimal /n 2 = Octal");
        // double userInput = userChoice.nextDouble();
        // if(userInput == 1.0) {
        //     //Decimal
        // }
        // else if(userInput == 2.0) {
        //     //set to binary
        // } 
        // else if  (userInput == 3.0){
        //     //set to Hexadecimal 
        // }
        // else if(userInput == 4.0) { 
        //     // set to Octal
        // }
        
        // String[] options = {"binary", "octal", "decimal", "decimal"};
        // for(int counter = 0; counter <= userInput; counter++){
        //     System.out.println(options[counter]);
        // }
    }

    public void switchDisplayMode(String mode) {
        this.whichMode = mode;
    }

    public String getMode() {
        return this.whichMode;
    }
}