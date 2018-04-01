import java.util.Scanner;

/**
 * Created by Illya Katsyuk on 3/14/18.
 */
public class Homework_8_2 {

	private static char hChar1, vChar1;
	private static int ht1, wd1;

	public static void main(String[] args) {
		System.out.println("\nUsing for-loop and user values: ");

		char answer = 'y';
		Scanner input1 = new Scanner(System.in);
		while (answer == 'y') {
			System.out.print("\nPlease enter height of a box: ");
			ht1 = input1.nextInt();
			System.out.print("\nPlease enter width of a box: ");
			wd1 = input1.nextInt();
			input1.nextLine(); // clean the buffer
			System.out.print("\nPlease enter the horizontal characters to draw box: ");
			hChar1 = input1.nextLine().charAt(0);
			System.out.print("\nPlease enter the vertical characters to draw box: ");
			

			vChar1 = input1.nextLine().charAt(0);

			drawBox();
			System.out.print("Continue? Type 'y' for yes: ");

			answer = input1.nextLine().charAt(0);
		}
		System.out.println("\n\nThank you for using my draw box program");

		input1.close(); // closing the scanner
	}

	private static void drawHorizontalLine() {
		for (int x = 1; x <= wd1; x++) {
			System.out.print("" + hChar1);
		}
		System.out.print("\n");

	}

	private static void drawVerticalLine() {
		for (int x = 1; x <= ht1 - 2; x++) {
			System.out.print("" + vChar1);
			for (int y = 1; y <= wd1 - 2; y++)
				System.out.print(" ");
			System.out.print("" + vChar1 + "\n");
		}
		for (int x = 1; x <= wd1; x++) {
			System.out.print(hChar1);
		}

	}

	private static void drawBox() {
		drawHorizontalLine();

		drawVerticalLine();
		System.out.print("\n\n");

	}

}