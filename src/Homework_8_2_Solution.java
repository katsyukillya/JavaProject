import java.util.Scanner;

public class Homework_8_2_Solution {

	public static void main(String[] args) {

		System.out.println("\nUsing methods: ");

		// utilizing the variables from above

		Scanner input1 = new Scanner(System.in);

		int x, y;
		char hChar1, vChar1;
		int ht1, wd1;
		char answer = 'y';

		while (answer == 'y') {
			System.out.print("\nPlease enter height of a box: ");
			ht1 = input1.nextInt();
			System.out.print("\nPlease enter width of a box: ");
			wd1 = input1.nextInt();
			input1.nextLine(); // clean the buffer
			System.out.print("\nPlease enter the horizontal charcters to draw box: ");
			hChar1 = input1.nextLine().charAt(0);
			System.out.print("\nPlease enter the vertical charcters to draw box: ");
			vChar1 = input1.nextLine().charAt(0);
			drawBox(wd1, ht1, hChar1, vChar1);
			System.out.print("Continue? Type 'y' for yes: ");
			answer = input1.nextLine().charAt(0);
		}

		System.out.println("\n\nThank you for using my drawbox program");
	}

	static void drawHorizontalLines(int wd1, char hChar1) {
		int x;
		for (x = 1; x <= wd1; x++) {
			System.out.print("" + hChar1);
		}
		System.out.print("\n");
	}

	static void drawVerticalLines(int wd1, int ht1, char vChar1) {
		int x, y;
		for (x = 1; x <= ht1 - 2; x++) {
			System.out.print("" + vChar1);
			for (y = 1; y <= wd1 - 2; y++)
				System.out.print(" ");
			System.out.print("" + vChar1 + "\n");
		}
	}

	static void drawBox(int wd1, int ht1, char hChar1, char vChar1) {
		drawHorizontalLines(wd1, hChar1);
		drawVerticalLines(wd1, ht1, vChar1);
		drawHorizontalLines(wd1, hChar1);
		System.out.print("\n\n");
	}

}
