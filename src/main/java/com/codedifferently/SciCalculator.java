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
    private Memory memory;

    //list function names
    //let user choose a function
    public static void main( String[] args )
    {
        SciCalculator calc = new SciCalculator();
        calc.sayHello();
        System.out.println(calc.getDisplayValue());

        Scanner userChoice = new Scanner(System.in);
        double numInput = 0.0;
        double [] userNumArr = new double [4];
        String posOrNeg = "";

        System.out.println("Please enter a command name.");
        //hasNext checks to see if there is any input
        while(userChoice.hasNext()) {
            

            //first gets the method name, then the inputted numbers
            String method = userChoice.next();
            
            if(method.equals("quit")) {
                System.out.println("Have a nice day!!!");
                break;
            }
            if(!method.toLowerCase().equals("trig")) {
                System.out.println("How many numbers are you going to input?");
                numInput = userChoice.nextDouble();
                //only print out this statement if greater than 0
                if(numInput > 0) {
                    System.out.println("Enter the inputs one at a time, then press enter"); 
                }
                if(numInput < 0) {
                    System.out.println("cannot enter a negative number. Please try again.");
                    continue;
                }
                
                for(int i = 0; i < numInput; i++) {
                    userNumArr[i] = userChoice.nextDouble();
                }
                // for(int i = 0; i < numInput; i++) {
                //     System.out.println("inputted numbers: " + userNumArr[i]);
                // }
                
                if(method.toLowerCase().equals("quad")) {
                    System.out.println("Positive or negative?");
                    posOrNeg = userChoice.next();
                }
            }
            //System.out.println("userInput: " + userNumber);
            //System.out.println("method: " + method);
            

            //2. call functions with if statements
            if(method.toLowerCase().equals("add")) {
                double addition = calc.alu.add(userNumArr[0], calc.displayValue);
                calc.setDisplayValue(addition);
                System.out.println("After performing add, we get: " + calc.getDisplayValue());
            }
            else if(method.toLowerCase().equals("subtract")) {
                double subtraction = calc.alu.subtract(userNumArr[0], calc.displayValue);
                calc.setDisplayValue(subtraction);
                System.out.println("After performing subtract, we get: " + calc.getDisplayValue());
            }
            else if(method.toLowerCase().equals("multiply")) {
                double multiply = calc.alu.multiply(userNumArr[0], calc.displayValue);
                calc.setDisplayValue(multiply);
                System.out.println("After performing multiply, we get: " + calc.getDisplayValue());
            }
            else if(method.toLowerCase().equals("divide")) {
                double divide = calc.alu.divide(userNumArr[0], calc.displayValue);
                calc.setDisplayValue(divide);
                System.out.println("After performing divide, we get: " + calc.getDisplayValue());
            }
            else if(method.toLowerCase().equals("square")) {
                double square = calc.alu.calculateSquare(calc.displayValue);
                calc.setDisplayValue(square);
                System.out.println("After performing calculateSquare, we get: " + calc.getDisplayValue());
            }  
            else if(method.toLowerCase().equals("squareroot")) {
                double squareRoot = calc.alu.calculateSquareRoot(calc.displayValue);
                calc.setDisplayValue(squareRoot);
                System.out.println("After performing calculateSquareRoot, we get: " + calc.getDisplayValue());
            } 
            else if(method.toLowerCase().equals("exp")) {
                double exp = calc.alu.calculateExponential(userNumArr[0], calc.displayValue);
                calc.setDisplayValue(exp);
                System.out.println("After performing calculateExponential, we get: " + calc.getDisplayValue());
            } 
            else if(method.toLowerCase().equals("inverse")) {
                double inverse = calc.alu.calculateInverse(calc.displayValue);
                calc.setDisplayValue(inverse);
                System.out.println("After performing calculateInverse, we get: " + calc.getDisplayValue());
            } 
            else if(method.toLowerCase().equals("invert")) {
                double invertedNum = calc.alu.invertSign(calc.displayValue);
                calc.setDisplayValue(invertedNum);
                System.out.println("After performing invertSign, we get: " + calc.getDisplayValue());
            } 
            else if(method.toLowerCase().equals("distance")) {
                double distance = calc.alu.computeDistanceFormula(userNumArr[0], userNumArr[1], userNumArr[2], userNumArr[3], calc.displayValue);
                calc.setDisplayValue(distance);
                System.out.println("After performing computeDistanceFormula, we get: " + calc.getDisplayValue());
            }
            else if(method.toLowerCase().equals("quad")) {
                double distance = calc.alu.computeQuadraticFormula(userNumArr[0], userNumArr[1], userNumArr[2], posOrNeg, calc.displayValue);
                calc.setDisplayValue(distance);
                System.out.println("After performing computeQuadraticFormula, we get: " + calc.getDisplayValue());
            }
            else if(method.toLowerCase().equals("hyp")) {
                double hyp = calc.alu.computeHypotenus(userNumArr[0], userNumArr[1]);
                calc.setDisplayValue(hyp);
                System.out.println("After performing computeHypotenus, we get: " + calc.getDisplayValue());
            } 
            //three more if statements with the names M+ MRC MC
            // else if(method.toLowerCase().equals("M+")){ 
            //     double newMemory = calc.memory.addMemory(calc.displayValue);
            //     calc.setDisplayValue(newMemory);
            //     System.out.println("After performing addMemory, we get: " + calc.getDisplayValue());
            // } 
            else if(method.toLowerCase().equals("trig")) {
                    System.out.println("Is the value that you're entering in degrees or radians? Please enter degrees or radians");  
                    
                    //takes in whether it is degrees or radians, .next() takes in the next string
                    String userTrigMode = userChoice.next(); 

                    //is it degrees or radians??
                    boolean trigMode = TrigUnits.toTrigModeForUser(userTrigMode);

                    System.out.println("What trig method do you want to use?");
                    //gets the method name i.e cos, sin, tan, etc.
                    String trigMethod = userChoice.next();
                    
                    if(method.equals("quit")) {
                        System.out.println("Have a nice day!!!");
                        break;
                    }
                    
                    System.out.println("How many numbers are you going to input?");
                    numInput = userChoice.nextDouble();
                    System.out.println("Enter the inputs one at a time, then press enter");
                    
                    for(int i = 0; i < numInput; i++) {
                        userNumArr[i] = userChoice.nextDouble();
                    }

                    //once you get all of the inputs, if its not radians, convert
                    if(trigMode == false) {
                        userNumArr = TrigUnits.toTrigModeForCalc(userNumArr);
                    }
                    // start the if statements for the different trig functions
                    if(trigMethod.equals("sine")) {
                        double sin = calc.trigFunctions.sine(userNumArr[0]);
                        calc.setDisplayValue(sin);
                        System.out.println("After performing sine, we get: " + calc.getDisplayValue());
                    }
            }
            System.out.println("Please enter a command: ");
        }
        //do not want leaks in memory because the resource is not closed
        userChoice.close();
}
// Prompt user to enter Trig Method (Settng)
// Once there, have a initially asks the user the user what mode they would like to be in RADIANS or DEGREES
// Moreover, ask create a keyword, similar to "quit", that can bring up this options maybe "trigMode"
// Anyway, then continue regularly like we did for the simple math, inputs etc

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
    public Memory getMemory() {
        return this.memory;
    }
}
 