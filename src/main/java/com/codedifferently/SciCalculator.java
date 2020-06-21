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

    //constructor
    public SciCalculator() {
        this.displayValue = 0.0;
        this.alu = new Arithmetic();
        this.displayMode = new DisplayMode();
        this.trigUnits = new TrigUnits();
        this.trigFunctions = new TrigFunctions();
    }

    //list function names
    //let user choose a function
    public static void main( String[] args )
    {
        SciCalculator calc = new SciCalculator();
        System.out.println(calc.sayHello());
        System.out.println(calc.getDisplayValue());

        Scanner userChoice = new Scanner(System.in);
        double numInput = 0.0;
        double [] userNumArr = new double [4];
        String posOrNeg = "";

        System.out.println("Please enter a command name. To quit, type 'quit'.");
        //hasNext checks to see if there is any input
        while(userChoice.hasNext()) {
            

            //first gets the method name, then the inputted numbers
            String method = userChoice.next();
            
            if(method.toLowerCase().equals("quit")) {
                System.out.println("Have a nice day!!!");
                break;
            }
            //trig goes right into asking about degrees or radians, so we want to skip this part of the loop
            if(!method.toLowerCase().equals("trig")) {
                System.out.println("How many numbers are you going to input?");
                numInput = userChoice.nextDouble();
                //only print out this statement if greater than 0
                //do not want user to be prompted again if its a method that does not take in any parameters
                if(numInput > 0 && numInput <= 4) {
                    System.out.println("Enter the inputs one at a time, then press enter"); 
                }
                if(numInput > 4) {
                    System.out.println("A number greater than 4 is not allowed because the maximum number of inputs you can have is 4. Please try again.");
                    System.out.println("Please enter a command name. To quit, type 'quit'.");
                    continue;
                }
                if(numInput < 0) {
                    System.out.println("Cannot enter a negative number. Please try again.");
                    System.out.println("Please enter a command name. To quit, type 'quit'.");
                    continue;
                }
                
                for(int i = 0; i < numInput; i++) {
                    userNumArr[i] = userChoice.nextDouble();
                }

                //TESTING PURPOSES
                // for(int i = 0; i < numInput; i++) {
                //     System.out.println("inputted numbers: " + userNumArr[i]);
                // }
                
                if(method.toLowerCase().equals("quad")) {
                    System.out.println("Do you want the positive or negative value? Type positive (can also just type 'pos') or negative (can also just type 'neg').");
                    System.out.println("Note that typing positive does not gaurentee getting a positive number, it just gaurentees it gives you the answer with the + sign on the top of the fraction.");
                    posOrNeg = userChoice.next();
                }
            }
            //TESTING PURPOSES
            //System.out.println("userInput: " + userNumber);
            //System.out.println("method: " + method);
            

            //2. call functions with if statements
            if(method.toLowerCase().equals("add")) {
                double addition = calc.alu.add(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, addition, "add");
            }
            else if(method.toLowerCase().equals("subtract")) {
                double subtraction = calc.alu.subtract(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, subtraction, "subtract");
            }
            else if(method.toLowerCase().equals("multiply")) {
                double multiply = calc.alu.multiply(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, multiply, "multiply");
            }
            else if(method.toLowerCase().equals("divide")) {
                double divide = calc.alu.divide(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, divide, "divide");
            }
            else if(method.toLowerCase().equals("square")) {
                double square = calc.alu.calculateSquare(calc.displayValue);
                calc.displayResult(calc, square, "calculateSquare");
            }  
            else if(method.toLowerCase().equals("squareroot")) {
                double squareRoot = calc.alu.calculateSquareRoot(calc.displayValue);
                calc.displayResult(calc, squareRoot, "calculateSquareRoot");
            } 
            else if(method.toLowerCase().equals("exp")) {
                double exp = calc.alu.calculateExponential(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, exp, "calculateExponential");
            } 
            else if(method.toLowerCase().equals("inverse")) {
                double inverse = calc.alu.calculateInverse(calc.displayValue);
                calc.displayResult(calc, inverse, "calculateInverse");
            } 
            else if(method.toLowerCase().equals("invert")) {
                double invertedNum = calc.alu.invertSign(calc.displayValue);
                calc.displayResult(calc, invertedNum, "invertSign");
            } 
            else if(method.toLowerCase().equals("distance")) {
                double distance = calc.alu.computeDistanceFormula(userNumArr[0], userNumArr[1], userNumArr[2], userNumArr[3], calc.displayValue);
                calc.displayResult(calc, distance, "computeDistanceFormula");
            }
            else if(method.toLowerCase().equals("quad")) {
                double quadResult = calc.alu.computeQuadraticFormula(userNumArr[0], userNumArr[1], userNumArr[2], posOrNeg, calc.displayValue);
                calc.displayResult(calc, quadResult, "computeQuadraticFormula");
            }
            else if(method.toLowerCase().equals("hyp")) {
                double hyp = calc.alu.computeHypotenus(userNumArr[0], userNumArr[1]);
                calc.displayResult(calc, hyp, "computeHypotenus");
            } 
            //three more if statements with the names M+ MRC MC
            // else if(method.toLowerCase().equals("M+")){ 
            //     double newMemory = calc.memory.addMemory(calc.displayValue);
            //     calc.setDisplayValue(newMemory);
            //     System.out.println("After performing addMemory, we get: " + calc.getDisplayValue());
            // } 
            else if(method.toLowerCase().equals("trig")) {
                    System.out.println("Is the value that you're entering in degrees or radians? Please enter degrees or radians.");  
                    
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
                        calc.displayResult(calc, sin, "sine");
                    }
            }
            System.out.println("Please enter a command. To quit, type 'quit'.");
        }
        //do not want leaks in memory because the resource is not closed
        userChoice.close();
    }
    //end main()
    //************************************************************** 
    
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

    //although the return type of this function is void, because I am passing a reference to the calculator object, the calculator in main will update itself
    public void displayResult(SciCalculator calc, double result, String functionName) {
        calc.setDisplayValue(result);
        System.out.println("After performing " + functionName + " we get: " + calc.getDisplayValue());
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

    public String sayHello() { 
        return "Welcome to Kaveesha's and Gio's Calculator";
    }
    public Memory getMemory() {
        return this.memory;
    }
}
 