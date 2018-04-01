import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/*
 * This program is created by student of course
 * 5185 Programming with Java for Beginners
 * Instructor: Bineet Sharma
 * of the UC Santa Cruz Silicon Valley Extension course CMPR.X412
 * Illya Katsyuk
 * 02/19/2018
 * For the Programming Assignment: Midterm Project
 * 
 */

public class MidtermCalculator {
    // the scope here is set to 'private' as nobody should be
    // accessing this variable except for this class. It is
    // generally good practice to NOT over-expose variables
    // it is 'static' because that is the way this variable
    // can be accessed from a static method. 
    // You can also instantiate your 'program' object and use a getter
    // to get the variable but I decided to use the 'static" methods instead.
    private static Scanner scan;

    public static void main(String[] args) {

        // here we are just assigning a value to a previously defined class variable
        scan = new Scanner(System.in);

        int mainMenuChoice = getMainMenuChoice();
        while (mainMenuChoice != 5) {
            switch (mainMenuChoice) {
                case 1:
                    addNumbers();
                    break;
                case 2:
                    subtractNumbers();
                    break;
                case 3:
                    multiplyNumbers();
                    break;
                case 4:
                    divideNumbers();
                    break;
            }

            // wait for user to press enter
            System.out.print("\nPress enter key to continue ... \n\n");
            scan.nextLine();
            mainMenuChoice = getMainMenuChoice();

        }

        System.out.print("Thank you for using Illya Katsyuk's Handy Calculator program.");
    }

    /**
     * Method for adding two numbers
     */
    private static void addNumbers() {
        // get numbers to add
        List<Number> numbers = getTwoFloats("add");

        // initialize result
        float result = 0;
        // add all the numbers together in the list
        for (Number n : numbers) {
            result += n.floatValue();
        }

        // print out the result

        System.out.printf("Result of addition " + operatingNumbers(numbers, "and", true) + " is %8.2f", result);
    }

    private static void subtractNumbers() {
        // get user input
        List<Number> numbers = getTwoFloats("subtract");

        // initialize result to the first number entered
        float result = numbers.get(0).floatValue();
        // iterate over the list starting from the 2nd number as we already got the first number out
        for (int i = 1; i < numbers.size(); i++) {
            //
            result -= numbers.get(i).floatValue();
        }

        System.out.printf("Result of subtraction " + operatingNumbers(numbers, "from", false) + " is %8.2f", result);
    }

    private static void multiplyNumbers() {
        List<Number> numbers = getTwoFloats("multiply");

        float result = numbers.get(0).floatValue();
        for (int i = 1; i < numbers.size(); i++) {
            result *= numbers.get(i).floatValue();
        }

        System.out.printf("Result of multiplying " + operatingNumbers(numbers, "by", true) + " is %8.2f", result);
    }

    private static void divideNumbers() {
        List<Number> numbers = getTwoFloats("divide");

        float result = numbers.get(0).floatValue();
        for (int i = 1; i < numbers.size(); i++) {
            result /= numbers.get(i).floatValue();
        }

        System.out.printf("Result of division " + operatingNumbers(numbers, "by", true) + " is %8.2f", result);
    }

    /**
     * Operating Numbers of numbers by a separator
     * @param numbers List of numbers
     * @param separator separator used to join numbers
     * @param isLeftToRight True = go from left -> right; False = right -> left
     * @return String of joined numbers
     */
    private static String operatingNumbers(List<Number> numbers, String separator, boolean isLeftToRight) {
        // initialize return value to empty string
        StringBuilder sb = new StringBuilder();
        // iterate over list of numbers
        if (isLeftToRight) {
            for (int i = 0; i < numbers.size(); i++) {
                Number n = numbers.get(i);
                // if return value is an empty string, set separator to "" otherwise
                // set separator to the value passed in padded with spaces from both sides
                String curSep = sb.length() == 0 ? "" : " " + separator + " ";
                // append current value to return value with separator
                sb.append(curSep).append(n.floatValue());
            }
        }
        else {
            for (int i = numbers.size() -  1; i >= 0; i--) {
                Number n = numbers.get(i);
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
     * Method to get 2 floats from the scanner
     * @param method Current method that this input is going to be used for
     * @return List of numbers
     */
    private static List<Number> getTwoFloats(String method) {
        System.out.print("Please enter two floats to " + method + " separated by a space: ");

        // loop until we've got what we need
        while (true) {
            try {
                // Get user input (asking for floats)
                List<Number> numbers = getUserChoice(true);
                // if current input does not have 2 elements, throw an exception
                if (numbers.size() != 2) {
                    throw new RuntimeException("There can be only two numbers to operate");
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
                return numbers;
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

    /**
     * Prints out main menu and gets user choice
     * @return menu id number
     */
    private static int getMainMenuChoice() {
        System.out.println("Welcome to Illya Katsyuk's Handy Calculator program");
        System.out.println("\n");
        System.out.println("\t1. Addition");
        System.out.println("\t2. Subtraction");
        System.out.println("\t3. Multiplication");
        System.out.println("\t4. Division");
        System.out.println("\t5. Exit");
        System.out.print("\n\nWhat would you like to do? ");

        while (true) {
            try {
                // get user's choice for main menu (asking for ints)
                List<Number> userChoice = getUserChoice(false);
                // if there are no entries from user, ask user for more input
                if (userChoice.size() == 0) {
                    // throw an exception that will be caught in the 'catch' clause
                    throw new RuntimeException("wrong choice");
                }

                // convert user input into 'int' and validate its value
                int mainMenuChoice = userChoice.get(0).intValue();
                if (mainMenuChoice < 1 || mainMenuChoice > 5) {
                    throw new RuntimeException("wrong choice");
                }

                return mainMenuChoice;
            }
            catch (Exception e) {
                System.out.print("You've made an invalid choice. What would you like to do? ");
            }
        }
    }

    /**
     * Gets user choice and returns its value to the caller
     * @return The int value that user entered
     * @throws NumberFormatException In case we could not parse string as int
     */
    private static List<Number> getUserChoice(boolean isFloat) throws ParseException {
        // we need to make sure that scanner has been created before we can use it
        if (scan == null) {
            throw new RuntimeException("You must initialize the input scanner first!");
        }

        // initialize return value
        List<Number> rv = new ArrayList<>();
        // get entry from user
        String input = scan.next();
        // finish reading until end of line (https://stackoverflow.com/a/35642695/2124491)
        input += scan.nextLine();

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

}
