import java.util.Scanner;
import static java.lang.System.out;

public class Calculator {

	public static void main(String[] args) {

		int firstN;
		int secondN;
		char operator, cycle;

		Scanner scan = new Scanner(System.in);
		do {
			out.printf("Type a number, operator, number --" + "separated by a space: ");

			firstN = scan.nextInt();
			operator = scan.next().charAt(0);
			secondN = scan.nextInt();

			if (operator == '+')
				System.out.printf("%d + %d = %d", firstN, secondN, firstN + secondN);
			else if (operator == '-')
				System.out.printf("%d - %d = %d", firstN, secondN, firstN - secondN);
			else if (operator == '*')
				System.out.printf("%d * %d = %d", firstN, secondN, firstN * secondN);
			else if (operator == '/')
				System.out.printf("%d / %d = %d", firstN, secondN, firstN / secondN);
			else if (operator == '%')
				System.out.printf("%d %% %d = %d", firstN, secondN, firstN % secondN);
			else
				System.out.printf("Unknown operator");
			System.out.printf("\n\n");

			System.out.printf("Do you want to try again? (y/n) ");
			cycle = scan.findWithinHorizon(".", 0).charAt(0);
			System.out.printf("\n\n");

		} while (cycle == 'y');

		System.out.printf("Goodbye");
		
		scan.close();

	}

}
