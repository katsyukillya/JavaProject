import java.util.Scanner;

public class FirstJavaHelloAge {
	public static void main(String[] args) {
		int yourAge;
		
		Scanner readInput = new Scanner(System.in);
		System.out.printf("How old are you?: ");
		yourAge= readInput.nextInt();

		if (yourAge > 0 && yourAge < 13)				// Checking if the entered age is a positive number and is less than 13
			System.out.printf("You are a kid\n");
		else if (yourAge >= 13 && yourAge <= 19)		// Checking if the entered age is from 13 and up to 19
			System.out.printf("You are a teenager\n");
		else if (yourAge > 19)							// Checking if the entered age is over 19
			System.out.printf("You are an adult\n");
		else
			System.out.printf("You must entered a wrong age\n");
		readInput.close();
	}
}