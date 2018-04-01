import java.util.Scanner;

public class Sorting {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to sorting program\n");
		System.out.println("\t1. Title");
		System.out.println("\t2. Rank");
		System.out.println("\t3. Date");
		System.out.println("\t4. Stars");
		System.out.println("\t5. Likes");

		System.out.println("\n\n"); // empty line feed

		int ask = 0;

		do {
			try { // Catching the exception

				System.out.print("Enter your choice between 1 and 5 only: ");

				String input = scan.next(); // Getting a user input as a String
				int choice = Integer.parseInt(input); // Parsing an integer from
														// the user entry

				if (choice < 1 || choice > 5) { // Checking if the user entry
												// lies outside the range of 1
												// and 5

					System.out.println("You have not entered a number between 1 and 5. Try again.");
				}

/*
				else if (!scan.hasNextInt()) { // Checking whether the user
												// entry is not an integer



					System.out.println("You have entered an invalid choice. Try again.");
				}
*/

				else { // If the user entry lies between 1 and 5 and is an
						// integer, nicely finish the program

					System.out.println("You entered valid choice " + choice);
					System.out.println("Thank you for giving your choice");
					ask = 1;		//Assigning value 1 to the variable ask, so do -- while loop finish
				}
			}

			catch (Exception e) { // Catching a throwable exception by showing
									// the following message.
				System.out.println("You have entered an invalid choice. Try again.");
			}

		} while (ask == 0);			//Checking if the variable ask has value 0. If not, the loop will terminate.

		scan.close();				//Closing an InputStream
	}

}
