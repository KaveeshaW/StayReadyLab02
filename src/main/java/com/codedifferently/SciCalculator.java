package com.codedifferently;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class SciCalculator 
{
    private double displayValue;
    private Arithmetic alu;
    private DisplayMode displayMode;
    private TrigUnits trigUnits;
    private TrigFunctions trigFunctions;

    
    public static void main( String[] args )
    {
        SciCalculator calc = new SciCalculator();
        calc.sayHello();
        System.out.println(calc.getDisplayValue());

        Scanner userChoice = new Scanner(System.in);

        //1. add while loop
        //hasNext checks to see if there is any input
        while(userChoice.hasNext()) {
            System.out.println("Please enter a command: ");

            //first gets the method name, then the inputted numbers
            String method = userChoice.next();
            
            if(method.equals("quit")) {
                System.out.println("Have a nice day!!!");
                break;
            }

            double userNumber = userChoice.nextDouble();
            
            System.out.println("userInput: " + userNumber);
            System.out.println("method: " + method);

            //2. call functions with if statements
            if(method.equals("add")) {
                double addition = calc.alu.add(userNumber, calc.displayValue);
                calc.setDisplayValue(addition);
                System.out.println(calc.getDisplayValue());
            }
            else if(method.equals("subtract")) {
                double subtraction = calc.alu.subtract(userNumber, calc.displayValue);
                calc.setDisplayValue(subtraction);
                System.out.println(calc.getDisplayValue());
            }
            else if(method.equals("multiply")) {
                double multiply = calc.alu.multiply(userNumber, calc.displayValue);
                calc.setDisplayValue(multiply);
                System.out.println(calc.getDisplayValue());
            }
            else if(method.equals("divide")) {
                double divide = calc.alu.divide(userNumber, calc.displayValue);
                calc.setDisplayValue(divide);
                System.out.println(calc.getDisplayValue());
            }       
        }
        //do not want leaks in memory because the resource is not closed
        userChoice.close();
}

    //constructor
    public SciCalculator() {
        this.displayValue = 0.0;
        this.alu = new Arithmetic();
        this.displayMode = new DisplayMode();
        this.trigUnits = new TrigUnits();
        this.trigFunctions = new TrigFunctions();
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

    public DisplayMode getDisplayMode() { 
        return this.displayMode;
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

    public TrigUnits getTrigUnits() {
        return this.trigUnits;
    }

    public TrigFunctions getTrigFunctions() {
        return this.trigFunctions;
    }

    public void sayHello() { 
        System.out.println("Welcome to Kaveesha's and Gio's Calculator");
    }
}
