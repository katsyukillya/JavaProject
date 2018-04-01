import java.util.Scanner;

public class SortingWithStaticMethod {

	private static Scanner scan;

	public static void main(String[] args) {

		// Assigning a value to a previously defined class variable
		scan = new Scanner(System.in);

		System.out.println("Welcome to sorting program\n");
		System.out.println("\t1. Title");
		System.out.println("\t2. Rank");
		System.out.println("\t3. Date");
		System.out.println("\t4. Stars");
		System.out.println("\t5. Likes");

		System.out.println("\n\n"); // empty line feed

		int ask = 0;		//Using this variable to determine if do..while loop should terminate

		do {
			try { 		// try...catch block - Catching the possible exception

				System.out.print("Enter your choice between 1 and 5 only: ");

				// Get user choice
				int choice = getUserChoice();

				if (choice < 1 || choice > 5) { // Checking if the user entry lies outside
												// the range of 1 and 5

					System.out.println("You have not entered a number between 1 and 5. Try again.");
				}

				else { 	// If the user entry lies between 1 and 5 and is an
						// integer, nicely finish the program

					System.out.println("\nYou entered valid choice " + choice);
					System.out.println("Thank you for giving your choice");
					ask = 1; // Assigning value 1 to the variable ask, so do --
								// while loop finish
				}
			}

			catch (NumberFormatException e) { 	// Catching a throwable exception by showing
												// the following message.
				System.out.println("You have entered an invalid choice. Try again.");
			}

		} while (ask == 0); // Checking if the variable ask has value 0. If not,
							// the loop will terminate.

		scan.close(); // Closing an InputStream
	}

	/*
	 * The following method gets a user choice and returns its value to the caller
	 * It returns the integer value only that the user entered
	 * It throws NumberFormatException in case we could not parse the string as integer
	 */

	private static int getUserChoice() throws NumberFormatException {

		// We need to make sure this scanner has been created before we can use it
		if (scan == null) {
			throw new RuntimeException("You must initialize the scanner first!");

		}

		// Get entry from the user
		String input = scan.next();

		// Try to parse entered value as an integer
		return Integer.parseInt(input);

	}

}
