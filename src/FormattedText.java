import java.util.Scanner;

public class FormattedText {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		//extra line feed
		System.out.println("5185 is fun course.\n\n");
		
		// Getting the user input
		
		System.out.print("Enter the first name: ");
		String firstName = scan.nextLine();
		System.out.print("Enter the last name: ");
		String lastName = scan.nextLine();
		System.out.print("Enter the city name: ");
		String cityName = scan.nextLine();
		System.out.print("Enter the ZIP Code: ");
		String ZIPCode = scan.nextLine();
		
		//Printing the results in a table
		
		System.out.printf("First Name \tLast Name \tCity     \tZIP Code\n");
		System.out.printf("----------- \t---------\t---- \t\t--------\n");
		System.out.printf(" " + firstName + "         \t " + lastName + "\t " + cityName + "\t " + ZIPCode + "\n");
		
		System.out.printf("\n");
		
		//extra line feed
		System.out .println();
		System.out .printf("How do you print double quotes?\n");
		System.out .printf("Who said \"Test Scores Can Be Used ....\"\n");

		scan.close();
	}

}
