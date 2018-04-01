import java.util.Scanner;

public class GetTwoFloats {

	public static void main(String[] args) {

		float floatA, floatB;

		String a, b;

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to get two floats program");

		System.out.println("\n\n"); // empty line feed

		int cont = 0;

		do {
			try { // Catching the exception

				System.out.print("Enter two floats separated by a space: ");

				a = scan.next();
				b = scan.next();

				floatA = Float.parseFloat(a);
				floatB = Float.parseFloat(b);

				if (!scan.hasNextFloat()) { // Checking whether the user
											// entry is not a float

					/*
					 * The following print should never appear. Instead the try
					 * -- catch for the NotAnInt Exception with its own print
					 * should be executed. Adding this only to be on a safe
					 * place.
					 */

					System.out.println("You have entered an invalid choice. Try again.");
				}

				else { // If the user entry lies between 1 and 5 and is an
						// integer, nicely finish the program

					System.out.println("You entered two valid floats " + floatA + " and " + floatB);
					System.out.println("Thank you for giving two floats");
					cont = 1; // Assigning value 1 to the variable ask, so do --
								// while loop finish
				}
			}

			catch (Exception e) { // Catching a throwable exception by showing
									// the following message.
				System.out.println("You have entered an invalid input. Try again.");
			}

		} while (cont == 0); // Checking if the variable ask has value 0. If
								// not, the loop will terminate.

		scan.close(); // Closing an InputStream
	}

}
