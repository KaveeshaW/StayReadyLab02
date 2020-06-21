package com.codedifferently;
import java.util.*;

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
    private HashMap <String, Integer> map;

    //constructor
    public SciCalculator() {
        this.displayValue = 0.0;
        this.alu = new Arithmetic();
        this.displayMode = new DisplayMode();
        this.trigUnits = new TrigUnits();
        this.trigFunctions = new TrigFunctions();
        this.map = new HashMap<String, Integer>();
    }

    //list function names
    //let user choose a function
    public static void main( String[] args )
    {
        SciCalculator calc = new SciCalculator();
        calc.instantiateMap(calc.map);
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
            //saves typing toLowerCase for every if statement
            method = method.toLowerCase();
            
            if(method.equals("quit")) {
                System.out.println("Have a nice day!!!");
                break;
            }
            //trig goes right into asking about degrees or radians, so we want to skip this part of the loop
            if(!method.equals("trig")) {
                //the map does not have the method, reprompt the user
                if(calc.map.containsKey(method) == false) {
                    System.out.println("That method cannot be found. Please try again.");
                    System.out.println("Please enter a command name. To quit, type 'quit'.");
                    continue;
                }
                //tracks how many inputs one has to enter for each method to work
                int numInputs = calc.map.get(method);
                //if the number of inputs is zero, there is nothing to print out here, so go call the function
                if(numInputs != 0) {
                    System.out.println("Enter " + numInputs + " input(s) one at a time, then press enter"); 
                }
                for(int i = 0; i < numInputs; i++) {
                    userNumArr[i] = userChoice.nextDouble();
                }
                
                if(method.toLowerCase().equals("quad")) {
                    System.out.println("Do you want the positive or negative value? Type positive (can also just type 'pos') or negative (can also just type 'neg').");
                    System.out.println("Note that typing positive does not gaurentee getting a positive number, it just gaurentees it gives you the answer with the + sign on the top of the fraction.");
                    posOrNeg = userChoice.next();
                }
            }            

            //2. call functions with if statements
            if(method.equals("add")) {
                double addition = calc.alu.add(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, addition, "add");
            }
            else if(method.equals("subtract")) {
                double subtraction = calc.alu.subtract(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, subtraction, "subtract");
            }
            else if(method.equals("multiply")) {
                double multiply = calc.alu.multiply(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, multiply, "multiply");
            }
            else if(method.equals("divide")) {
                double divide = calc.alu.divide(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, divide, "divide");
            }
            else if(method.equals("square")) {
                double square = calc.alu.calculateSquare(calc.displayValue);
                calc.displayResult(calc, square, "calculateSquare");
            }  
            else if(method.equals("squareroot")) {
                double squareRoot = calc.alu.calculateSquareRoot(calc.displayValue);
                calc.displayResult(calc, squareRoot, "calculateSquareRoot");
            } 
            else if(method.equals("exp")) {
                double exp = calc.alu.calculateExponential(userNumArr[0], calc.displayValue);
                calc.displayResult(calc, exp, "calculateExponential");
            } 
            else if(method.equals("inverse")) {
                double inverse = calc.alu.calculateInverse(calc.displayValue);
                calc.displayResult(calc, inverse, "calculateInverse");
            } 
            else if(method.equals("invert")) {
                double invertedNum = calc.alu.invertSign(calc.displayValue);
                calc.displayResult(calc, invertedNum, "invertSign");
            } 
            else if(method.equals("distance")) {
                calc.valueNotUsedWarning("computeDistanceFormula");
                double distance = calc.alu.computeDistanceFormula(userNumArr[0], userNumArr[1], userNumArr[2], userNumArr[3], calc.displayValue);
                calc.displayResult(calc, distance, "computeDistanceFormula");
            }
            else if(method.equals("quad")) {
                calc.valueNotUsedWarning("computeQuadraticFormula");
                double quadResult = calc.alu.computeQuadraticFormula(userNumArr[0], userNumArr[1], userNumArr[2], posOrNeg, calc.displayValue);
                calc.displayResult(calc, quadResult, "computeQuadraticFormula");
            }
            else if(method.equals("hyp")) {
                calc.valueNotUsedWarning("computeHypotenus");
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
                    //saves typing toLowerCase for every if statement
                    userTrigMode = userTrigMode.toLowerCase();

                    //is it degrees or radians??
                    boolean trigMode = TrigUnits.toTrigModeForUser(userTrigMode);

                    System.out.println("What trig method do you want to use?");
                    //gets the method name i.e cos, sin, tan, etc.
                    String trigMethod = userChoice.next();
                    //saves typing toLowerCase for every if statement
                    trigMethod = trigMethod.toLowerCase();
                    
                    if(trigMethod.equals("quit")) {
                        System.out.println("Have a nice day!!!");
                        break;
                    }
                    
                    // System.out.println("How many numbers are you going to input?");
                    // numInput = userChoice.nextDouble();
                    // System.out.println("Enter the inputs one at a time, then press enter");
                    
                    // for(int i = 0; i < numInput; i++) {
                    //     userNumArr[i] = userChoice.nextDouble();
                    // }

                    //the map does not have the method, reprompt the user
                    if(calc.map.containsKey(trigMethod) == false) {
                        System.out.println("That method cannot be found. Please try again.");
                        System.out.println("Please enter a command name. To quit, type 'quit'.");
                        continue;
                    }
                    //tracks how many inputs one has to enter for each method to work
                    int numInputs = calc.map.get(trigMethod);
                    //if the number of inputs is zero, there is nothing to print out here, so go call the function
                    if(numInputs != 0) {
                        System.out.println("Enter " + numInputs + " input(s) one at a time, then press enter"); 
                    }
                    for(int i = 0; i < numInputs; i++) {
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

    public void valueNotUsedWarning(String whichMethod) {
        System.out.println();
        System.out.println("Note that " + whichMethod + " will not use the current value as part of the calculation.");
        System.out.println("If an error occurred the function will just return the previous display value.");
        System.out.println();
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

    //maps to each function how many inputs is needed to make life simpler for the user when using the UI
    public void instantiateMap(HashMap <String, Integer> map) {
        this.map.put("add", 1);;
        this.map.put("subtract", 1);
        this.map.put("multiply", 1);
        this.map.put("divide", 1);
        this.map.put("square", 0);
        this.map.put("squareroot", 0);
        this.map.put("exp", 1);
        this.map.put("inverse", 0);
        this.map.put("invert", 0);
        this.map.put("distance", 4);
        this.map.put("quad", 3);
        this.map.put("hyp", 2);
        this.map.put("sine", 1);
    }
}
 