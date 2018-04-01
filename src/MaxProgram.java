import java.util.Scanner;
public class MaxProgram {

	public static void main(String[] args) {


		int max, a, b, c; 
		char reply;
		
		do {
		Scanner scan = new Scanner(System.in);
		

		// get value for a and b from user
		System.out.printf("Enter three integer numbers to find max of them -- separated by space:\n");
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		
		//using ternary operator
		max = (a > b) ? a : b; // what is the value of max between a and b?
		max = (max > c) ? max : c;  // what is the value of max between all three numbers
		
		System.out.printf("The max number is: " + max + "\n");
		
		System.out.printf("Continue? Type 'y' for yes: \n");
		reply = scan.findWithinHorizon(".", 0).charAt(0);
		
		scan.close();
		
		} while (reply == 'y');

		System.out.println("Thank you for using my max program \n");
	}

}
