import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This program is written as per assignment on Homework #6
 * Java Programming for Beginners
 * Course CMPR.X412
 * by Illya Katsyuk
 * 02/18/2018
 */

public class GettingTwoFloats {
	
	private static Scanner scan;

	public static void main(String[] args) {

		//Here we are just assigning a value to a previously defined class variable
		scan = new Scanner(System.in);
		
		System.out.println("Welcome to a bonus get two floats program");
		
		System.out.println("\n\n");
		
		int ask = 0;
		
		do {
			
			try{
				
				System.out.print("Enter two floats separated by space: ");
				
				//Get user choice
				List <Float> choices = getTwoFloats();
				
				//Since at this point we know that all values in the array are of type 'long'
				//all we have left is to make sure that the user has provided only 2 numbers
				if (choices.size() == 2) {
					System.out.println("You entered "+ choices.get(0) +" and " + choices.get(1) +" successfully!");
					System.out.println("Thank you for giving your choice of two floats.");
					ask = 1;
				}
				
				else {
					System.out.println("You have entered an invalid input. Try again.");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("You have entered an invalid input. Try again.");
			}
		} while (ask == 0);
	}
		
		private static List <Float> getTwoFloats() throws NumberFormatException {
		
			//We need to make sure that the scanner has been created before we can use it
			if (scan == null) {
				throw new RuntimeException("You must initialize the scanner first!");
				
			}
			
			//Initialize the return value
			List <Float> rv = new ArrayList<>();
			
			//Get entry from the user
			String getInput = scan.next();
			
			// Finish reading the input to the end of line
			getInput += scan.nextLine();
			
			//Split the input based on the space divider
			String[] inputArr = getInput.split(" ");
			
			//Iterate over every item in the list
			for(String curItem : inputArr) {
				
				//Try to parse float and add it to the return list
				float f = Float.parseFloat(curItem);
				rv.add(f);
			}
			
			//Try to parse entered value as an integer
			return rv;
	}

}
