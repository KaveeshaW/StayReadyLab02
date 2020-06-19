package com.codedifferently;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class SciCalculator 
{
    public static void main( String[] args )
    {
    }

    private double displayValue;
    private Arithmetic alu;
    //private DisplayMode displayMode;

    public SciCalculator() {
        this.displayValue = 0.0;
    }
    
    public double getDisplayValue() {
        return this.displayValue;
    }

    public void setDisplayValue(Double value) {
        this.displayValue = value;
    }

    public void clearDisplay() { 
        this.displayValue = 0.0; 
        System.out.println();
    }
    
    public void displayError() { 
        System.out.println("Err");  
        clearDisplay();   
    }

    public Arithmetic getArithmetic() {
        return this.alu;
    }

    public void sayHello() { 
        System.out.println("Welcome to Kaveesha's and Gio's Calculator");
    }
    
    public void getDisplayMode() { 
        Scanner userChoice = new Scanner(System.in);
        System.out.println("Please select a number for your display mode. /n 1 = Decimal /n 3 = Binary /n 4 = Hexadecimal /n 2 = Octal");
        int userInput = userChoice.nextInt();
        if(userInput == 1) {
            //Decimal
        }
        else if(userInput == 2) {
            //set to binary
        } 
        else if  (userInput == 3){
            //set to Hexadecimal 
        }
        else if(userInput = 4) { 
            // set to Octal
        }
        
        // String[] options = {"binary", "octal", "decimal", "decimal"};
        // for(int counter = 0; counter <= userInput; counter++){
        //     System.out.println(options[counter]);
        // }
    }
    
}
