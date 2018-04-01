
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Homework #7
 * Class CMPR.X412.(802) -- Java Programming for Beginners
 * Created by ikatsyuk on 2/21/18.
 */
public class OOPCalculator {
    private Scanner scanner;
    private List<Number> floats;
    private String method;

    public OOPCalculator() {
        scanner = new Scanner(System.in);
        cleanup();
    }

    public int askCalcChoice() {
        System.out.println("Welcome to Illya Katsyuk's Handy Calculator program\n\n");
        System.out.println("\t1. Addition");
        System.out.println("\t2. Subtraction");
        System.out.println("\t3. Multiplication");
        System.out.println("\t4. Division");
        System.out.println("\t5. Exit");
        System.out.print("\n\nWhat would you like to do? (Enter either a number or a first letter of the operation): ");

        while (true) {
            try {
                // get user's choice for main menu (asking for ints)
                String userChoice = getStringChoice();
                // if there are no entries from user, ask user for more input
                if (userChoice.length() == 0 || userChoice.length() > 1) {
                    // throw an exception that will be caught in the 'catch' clause
                    throw new RuntimeException("wrong choice");
                }


                // check if it is one of the expected characters
                switch (userChoice) {
                    case "a":
                    case "A":
                    case "1":
                        method = "add";
                        return 1;
                    case "s":
                    case "S":
                    case "2":
                        method = "subtract";
                        return 2;
                    case "m":
                    case "M":
                    case "3":
                        method = "multiply";
                        return 3;
                    case "d":
                    case "D":
                    case "4":
                        method = "divide";
                        return 4;
                    case "x":
                    case "X":
                    case "5":
                        return 5;
                    default:
                        throw new RuntimeException("Invalid choice");
                }
            }
            catch (Exception e) {
                System.out.print("You've made an invalid choice. What would you like to do? ");
            }
        }

    }

    public void askTwoValues() {
        System.out.print("Please enter two floats to " + method + " separated by a space: ");

        // loop until we've got a valid entry
        while (true) {
            try {
                // Get user input (asking for floats)
                List<Number> numbers = getNumericChoice(true);
                // if current input does not have 2 elements, throw an exception
                if (numbers.size() != 2) {
                    throw new RuntimeException("There can be only 2");
                }
                // if current method is division, make sure that there are no 0 in the list
                if (method.equals("divide")) {
                    // because we CAN divide 0 by something, we are starting with 2nd element
                    for (int i = 1; i < numbers.size(); i++) {
                        if (numbers.get(i).floatValue() == 0) {
                            throw new RuntimeException("divide by 0");
                        }
                    }
                }
                floats = numbers;
                break;
            } catch (Exception e) {
                // if current method is division and exception message is division by 0
                // print out division by 0 message, else print out generic method
                if (method.equals("divide") && e.getMessage().equals("divide by 0")) {
                    System.out.print("You can't divide by zero please re-enter both floats: ");
                }
                else {
                    System.out.print("You have entered invalid floats please re-enter: ");
                }
            }
        }
    }

    public void displayResults() {
        switch (method) {
            case "add":
                // print out the result
                System.out.printf("Result of addition " + operatingNumbers("and", true) + " is %8.2f", addNumbers());
                break;
            case "subtract":
                System.out.printf("Result of subtraction " + operatingNumbers("from", false) + " is %8.2f", subtractNumbers());
                break;
            case "multiply":
                System.out.printf("Result of multiplication " + operatingNumbers("by", true) + " is %8.2f", multiplyNumbers());
                break;
            case "divide":
                System.out.printf("Result of division " + operatingNumbers("by", true) + " is %8.2f", divideNumbers());
                break;
        }

        System.out.println("\n\nPress enter key to continue ... \n\n");
        scanner.nextLine();
        // clear out variables
        cleanup();
    }

    private void cleanup() {
        if (null == floats) {
            floats = new ArrayList<>();
        }
        else {
            floats.clear();
        }

        method = "";

    }

    public void displayBye() {
        System.out.println("\nThank you for using Illya Katsyuk's Handy Calculator program.\nGoodbye.");
    }


    /**
     * Operating numbers list entered by a separator
     * @param separator separator used to join numbers
     * @param isLeftToRight True = go from left -> right; False = right -> left
     * @return String of joined numbers
     */
    private String operatingNumbers(String separator, boolean isLeftToRight) {
        // initialize return value to empty string
        StringBuilder sb = new StringBuilder();
        // iterate over list of numbers
        if (isLeftToRight) {
            for (int i = 0; i < floats.size(); i++) {
                Number n = floats.get(i);
                // if return value is an empty string, set separator to "" otherwise
                // set separator to the value passed in padded with spaces from both sides
                String curSep = sb.length() == 0 ? "" : " " + separator + " ";
                // append current value to return value with separator
                sb.append(curSep).append(n.floatValue());
            }
        }
        else {
            for (int i = floats.size() -  1; i >= 0; i--) {
                Number n = floats.get(i);
                // if return value is an empty string, set separator to "" otherwise
                // set separator to the value passed in padded with spaces from both sides
                String curSep = sb.length() == 0 ? "" : " " + separator + " ";
                // append current value to return value with separator
                sb.append(curSep).append(n.floatValue());
            }

        }

        return sb.toString();
    }


    /**
     * Method for adding numbers
     */
    public float addNumbers() {
        // initialize result
        float result = 0;
        // add all the numbers together in the list
        for (Number n : floats) {
            result += n.floatValue();
        }

        return result;
    }
    
    /**
     * Method for subtracting a second number from the first one
     */
    public float subtractNumbers() {
        // initialize result to the first number entered
        float result = floats.get(0).floatValue();
        // iterate over the list starting from the 2nd number as we already got the first number out
        for (int i = 1; i < floats.size(); i++) {
            //
            result -= floats.get(i).floatValue();
        }

        return result;
    }

    /**
     * Method for multiplying numbers
     */
    public float multiplyNumbers() {
        float result = floats.get(0).floatValue();
        for (int i = 1; i < floats.size(); i++) {
            result *= floats.get(i).floatValue();
        }

        return result;
    }

    /**
     * Method for dividing the first number by the second one
     */
    public float divideNumbers() {
        float result = floats.get(0).floatValue();
        for (int i = 1; i < floats.size(); i++) {
            result /= floats.get(i).floatValue();
        }

        return result;
    }

    /**
     * Gets user choice and returns its value to the caller
     * @return The integer value that user entered
     * @throws NumberFormatException In case we could not parse string as integer
     */
    private List<Number> getNumericChoice(boolean isFloat) throws ParseException {
        // get input from user
        String input = getStringChoice();

        // initialize return value
        List<Number> rv = new ArrayList<>();

        // split input based on ' ' string
        String[] inputArr = input.split(" ");

        // iterate over every item
        for (String curItem : inputArr) {
            Number n = isFloat ? Float.parseFloat(curItem) : Integer.parseInt(curItem);
            // try to parse float and add it to the return list
            rv.add(n);
        }

        // try to parse entered value as an integer
        return rv;
    }

    private String getStringChoice() {
        if (scanner == null) {
            throw new RuntimeException("You must initialize the scanner first!");
        }

        String input = scanner.next();
        input += scanner.nextLine();

        return input;
    }


}