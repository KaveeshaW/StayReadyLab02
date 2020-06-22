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
    private HashMap <String, String> descriptions;

    //constructor
    //need to instantiate these variables otherwise functions will unexpectedly return null pointer exceptions
    public SciCalculator() {
        this.displayValue = 0.0;
        this.alu = new Arithmetic();
        this.displayMode = new DisplayMode();
        this.trigUnits = new TrigUnits();
        this.trigFunctions = new TrigFunctions();
        this.map = new HashMap<String, Integer>();
        this.descriptions = new HashMap<String, String>();
        this.memory = new Memory();
    }

    //list function names
    //let user choose a function
    public static void main( String[] args )
    {
        SciCalculator calc = new SciCalculator();
        calc.instantiateMap(calc.map);
        calc.fillDescriptions(calc.descriptions);
        System.out.println(calc.sayHello());
        System.out.println(calc.getDisplayValue());

        Scanner userChoice = new Scanner(System.in);
        //the maximum amount of inputs is 4
        double [] userNumArr = new double [4];
        String posOrNeg = "";

        System.out.println("Please enter a command. To quit, type 'quit'. To get a list of function names, type 'help'.");
        //hasNext checks to see if there is any input
        while(userChoice.hasNext()) {
            

            //first gets the method name, then the inputted numbers
            String method = userChoice.next();
            //saves typing toLowerCase for every if statement
            method = method.toLowerCase();
            //System.out.println("This is method: " + method);
            
            if(method.equals("quit")) {
                System.out.println("Have a nice day!!!");
                break;
            }
            if(method.equals("help")) {
                calc.listAvailableCommands();
            }
            if(method.equals("display")){
                System.out.println("The current value of the display is " + calc.getDisplayValue());
            }
            if(method.equals("clear")) {
                calc.clearDisplay();
            }
            
            //trig goes right into asking about degrees or radians, so we want to skip this part of the loop
            if(!method.equals("trig")) {
                //the map does not have the method, reprompt the user
                if(calc.map.containsKey(method) == false) {
                    System.out.println("That method cannot be found. Please try again.");
                    //otherwise, the program will not print out anything, confusing the user
                    System.out.println("Please enter a command. To quit, type 'quit'. To get a list of function names, type 'help'.");
                    continue;
                }

                //gets the user's inputted numbers
                calc.getUserValues(userChoice, calc, method, userNumArr);
                
                if(method.equals("quad")) {
                    System.out.println("Do you want the positive or negative value? Type positive (can also just type 'pos') or negative (can also just type 'neg').");
                    System.out.println("Note that typing positive does not gaurentee getting a positive number, it just gaurentees it gives you the answer with the + sign on the top of the fraction.");
                    posOrNeg = userChoice.next();
                }
            }  
            
            if(method.equals("mode")){
                System.out.print("Would you like to manually switch modes or have the calculator do so automatically? \nEnter 'manual' or 'auto'\n" );
                System.out.println("The order of modes are 'decimal', 'hexadecimal', 'binary', 'octal'");
                String manualOrAuto = userChoice.next();
                manualOrAuto = manualOrAuto.toLowerCase();
                if(manualOrAuto.equals("auto")){
                    calc.displayMode.switchDisplayMode();
                    System.out.println("Your display mode is now: " + calc.displayMode.getMode());
                }
                else if(manualOrAuto.equals("manual")){
                    System.out.println("Please enter the mode that you would like.");
                    calc.displayMode.switchDisplayMode(userChoice.next());
                    System.out.println("Your display mode is now: " + calc.displayMode.getMode()); 
                }   
                else{
                    System.out.println("The input that you have entered does not exist. Call 'mode' and try again. ");
                }
                //otherwise, the program will not print out anything, confusing the user
                System.out.println("Please enter a command. To quit, type 'quit'. To get a list of function names, type 'help'.");
                continue;
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
            
            // Add the currently displayed value to the value in memory (store in memory and update display) *
            //not changing display value
            else if(method.equals("m+")){ 
                calc.memory.addMemory(calc.displayValue);
                System.out.println("We have stored the value in memory. Here is the value: " + calc.memory.recallValue());
             } 
             //Recall the current value from memory to the display *
             //setting the value in memory to the display value
             else if(method.equals("mrc")){ 
                 double memVal = calc.memory.recallValue();
                 calc.setDisplayValue(memVal);
                 System.out.println("After performing recallMemory, we get: " + calc.getDisplayValue());
             }
             // Reset memory *
             //setting the display value to 0.0
             else if(method.equals("mc")){ 
                //sets the calc memory to 0.0
                calc.memory.resetMemory();
                //setting the display value to 0
                calc.setDisplayValue(calc.memory.recallValue());
                System.out.println("After performing resetMemory, we get: " + calc.getDisplayValue());
             }
            else if(method.equals("trig")) {
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
                    if(trigMethod.equals("help")) {
                        calc.listAvailableCommands();
                    }

                    //the map does not have the method, reprompt the user
                    if(calc.map.containsKey(trigMethod) == false) {
                        System.out.println("That method cannot be found. Please try again.");
                        //otherwise, the program will not print out anything, confusing the user
                        System.out.println("Please enter a command. To quit, type 'quit'. To get a list of function names, type 'help'.");
                        continue;
                    }

                    System.out.println("Do you want to use the value that is already on display or input a number?");
                    System.out.println("Enter 'display' or 'input'");
                    //gets whether they want to use the display number or input number
                    String displayOrNumber = userChoice.next();
                    //saves typing toLowerCase for every if statement
                    displayOrNumber = displayOrNumber.toLowerCase();
                    
                    System.out.println("displayOrNumber is: " + displayOrNumber);

                    //the map does not have the method, reprompt the user
                    if(displayOrNumber.equals("input")) {
                        //gets the user's inputted numbers
                        calc.getUserValues(userChoice, calc, trigMethod, userNumArr);
                    }

                    //once you get all of the inputs, if its not radians, convert
                    if(trigMode == false) {
                        userNumArr = TrigUnits.toTrigModeForCalc(userNumArr);
                    }
                    // start the if statements for the different trig functions
                    if(trigMethod.equals("sin")) {
                        double sin = calc.doCalculationWithInputOrDisplay(displayOrNumber, calc, trigMethod, userNumArr);
                        calc.displayResult(calc, sin, "sine");
                    }
                    else if(trigMethod.equals("cos")) {
                        double cosine = calc.doCalculationWithInputOrDisplay(displayOrNumber, calc, trigMethod, userNumArr);
                        calc.displayResult(calc, cosine, "cosine");
                    }
                    else if(trigMethod.equals("tan")) {
                        double tangent = calc.doCalculationWithInputOrDisplay(displayOrNumber, calc, trigMethod, userNumArr);
                        calc.displayResult(calc, tangent, "tangent");
                    }
                    else if(trigMethod.equals("invsin")) {
                        double inverseSine = calc.doCalculationWithInputOrDisplay(displayOrNumber, calc, trigMethod, userNumArr);
                        calc.displayResult(calc, inverseSine, "inverseSine");
                    }
                    else if(trigMethod.equals("invcos")) {
                        double inverseCosine = calc.doCalculationWithInputOrDisplay(displayOrNumber, calc, trigMethod, userNumArr);
                        calc.displayResult(calc, inverseCosine, "inverseCosine");
                    }
                    else if(trigMethod.equals("invtan")) {
                        double inverseTangent = calc.doCalculationWithInputOrDisplay(displayOrNumber, calc, trigMethod, userNumArr);
                        calc.displayResult(calc, inverseTangent, "inverseTangent");
                    }
                    
            }
            System.out.println("Please enter a command. To quit, type 'quit'. To get a list of function names, type 'help'.");
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
        System.out.println("The current value of the display is: " + this.displayValue);
        System.out.println();
    }
    
    public String displayError() {   
        clearDisplay();   
        return "Error";
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

    public HashMap <String, Integer> getMap() {
        return this.map;
    }

    public HashMap <String, String> getDescriptionsMap() {
        return this.descriptions;
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

    //maps to each function how many inputs is needed to make life simpler for the user and the programmer when using the UI
    public void instantiateMap(HashMap <String, Integer> map) {
        this.map.put("add", 1);
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
        this.map.put("sin", 1);
        this.map.put("cos", 1);
        this.map.put("tan", 1);
        this.map.put("invsin", 1);
        this.map.put("invcos", 1);
        this.map.put("invtan", 1);
        this.map.put("m+", 0);
        this.map.put("mc", 0);
        this.map.put("mrc", 0);
        this.map.put("mode", 0);
        this.map.put("trig", 0);
        this.map.put("help", 0);
        this.map.put("display", 0);
        this.map.put("clear", 0);
    }

    public void fillDescriptions(HashMap <String, String> descriptions) {
        this.descriptions.put("add", "Takes in 1 parameter. Adds that parameter to the current value displayed.");
        this.descriptions.put("subtract", "Takes in 1 parameter. Subtracts that parameter from the current value displayed.");
        this.descriptions.put("multiply", "Takes in 1 parameter. Multiplies that parameter to the current value displayed.");
        this.descriptions.put("divide", "Takes in 1 parameter. Divides that parameter to the current value displayed.");
        this.descriptions.put("square", "Does not take in a parameter. Squares the currently displayed value.");
        this.descriptions.put("squareroot", "Does not take in a parameter. Takes the square root the currently displayed value.");
        this.descriptions.put("exp", "Takes in 1 parameter. Returns the current value displayed to that power.");
        this.descriptions.put("inverse", "Does not take in a parameter. Returns the inverse of The currently displayed value.");
        this.descriptions.put("invert", "Does not take in a parameter. Negates the sign of the currently displayed value.");
        this.descriptions.put("distance", "Takes in 4 parameters. Uses the distance formula to find the distance between two points (x1, y1, x2, y2).");
        this.descriptions.put("quad", "Takes in 3 parameters. Uses the quadratic formula on the three inputted values (a, b, c). You can enter positive or negative to change the sign at the top of the fraction");
        this.descriptions.put("hyp", "Takes in 2 parameters. Computes the Hypotenus of the triangle based on the inputted values (a, b)");
        this.descriptions.put("sin", "Takes in 1 parameter. Returns the sine of the inputted radians. (If you put degrees it turns into radians).");
        this.descriptions.put("cos", "Takes in 1 parameter. Returns the cosine of the inputted radians. (If you put degrees it turns into radians).");
        this.descriptions.put("tan", "Takes in 1 parameter. Returns the tangent of the inputted radians. (If you put degrees it turns into radians).");
        this.descriptions.put("invsin", "Takes in 1 parameter. Returns the inverseSine of the inputted radians. (If you put degrees it turns into radians).");
        this.descriptions.put("invcos", "Takes in 1 parameter. Returns the inverseCosine of the inputted radians. (If you put degrees it turns into radians).");
        this.descriptions.put("invtan", "Takes in 1 parameter. Returns the inverseTangent of the inputted radians. (If you put degrees it turns into radians).");
        this.descriptions.put("m+", "Takes in 0 parameters. Add the currently displayed value to the value in memory (store in memory and update display) *");
        this.descriptions.put("mc", "Reset memory *");
        this.descriptions.put("mrc", "Recall the current value from memory to the display *");
        this.descriptions.put("mode", "let's user go to mode functions, which you can manually display or let it automatically do it for you");
        this.descriptions.put("trig", "allows access to different trig methods");
        this.descriptions.put("help", "lists the commads");
        this.descriptions.put("display", "get's the display");
        this.descriptions.put("clear", "clears the display, makes the display value equal to 0.0, displays the value");
    }

    //gets the user's inputted numbers
    public void getUserValues(Scanner userChoice, SciCalculator calc, String method, double [] userNumArr) {
        //tracks how many inputs one has to enter for each method to work
        int numInputs = calc.map.get(method);
        //if the number of inputs is zero, there is nothing to print out here, so go call the function
        if(numInputs != 0) {
            System.out.println("Enter " + numInputs + " input(s) one at a time, then press enter"); 
        }
        for(int i = 0; i < numInputs; i++) {
            userNumArr[i] = userChoice.nextDouble();
        }
    }
    
    public void listAvailableCommands() {
        System.out.println("The following are commands you can enter and descriptions of those commands: ");
        for(HashMap.Entry<String, Integer> entry : this.map.entrySet()) {
            String key = entry.getKey();
            String description = descriptions.get(key);
            System.out.println(key + ": " + description);
        }
        System.out.println();
    }

    public double doCalculationWithInputOrDisplay(String displayOrNumber, SciCalculator calc, String method, double [] userNumArr) {
        double val = 0.0;
        //System.out.println("here and the value of displayOrNumber is: " + displayOrNumber);
        if(displayOrNumber.equals("input")) {
            if(method.equals("sin")) {
                val = calc.trigFunctions.sine(userNumArr[0]);
            }
            else if(method.equals("cos")) {
                val = calc.trigFunctions.cosine(userNumArr[0]);
            }
            else if(method.equals("tan")) {
                val = calc.trigFunctions.tangent(userNumArr[0]);
            }
            //needs to be lower case because we convert it to lower case
            else if(method.equals("invsin")) {
                val = calc.trigFunctions.inverseSine(userNumArr[0]);
            }
            else if(method.equals("invcos")) {
                val = calc.trigFunctions.inverseCosine(userNumArr[0]);
            }
            else if(method.equals("invtan")) {
                val = calc.trigFunctions.inverseTangent(userNumArr[0]);
            }  
        }
        else if(displayOrNumber.equals("display")) {
            if(method.equals("sin")) {
                val = calc.trigFunctions.sine(calc.getDisplayValue());
            }
            else if(method.equals("cos")) {
                val = calc.trigFunctions.cosine(calc.getDisplayValue());
            }
            else if(method.equals("tan")) {
                val = calc.trigFunctions.tangent(calc.getDisplayValue());
            }
            //needs to be lower case because we convert it to lower case
            else if(method.equals("invsin")) {
                val = calc.trigFunctions.inverseSine(calc.getDisplayValue());
            }
            else if(method.equals("invcos")) {
                val = calc.trigFunctions.inverseCosine(calc.getDisplayValue());
            }
            else if(method.equals("invtan")) {
                val = calc.trigFunctions.inverseTangent(calc.getDisplayValue());
            }
        }
        return val;
    }
}
 