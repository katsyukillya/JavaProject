import java.util.Scanner;

public class SecondTest {

	public static void main(String[] args) {

		// hard coded temperature 7 elements 0-6 index == it is zero-based index
		int[] weeklyTemp = { 69, 70, 71, 68, 66, 71, 70 };

		int day = 0;

		getTemperatures(weeklyTemp);

		System.out.println();

		int min = weeklyTemp[0];

		for (day = 1; day < 7; day++) {

			if (min > weeklyTemp[day])
				min = weeklyTemp[day];
		}

		System.out.printf("The Minimun temperature is: %d\n", min);

		int max = weeklyTemp[0];

		for (day = 1; day < 7; day++) {
			if (max < weeklyTemp[day])
				max = weeklyTemp[day];
		}

		System.out.printf("The Maximun temperature is: %d\n", max);

		int total = weeklyTemp[0];

		for (day = 1; day < 7; day++)
			total += weeklyTemp[day];

		System.out.printf("The average of weekly temperature is: %5.2f\n", total / 7.0);
	}

	static void getTemperatures(int[] tempArray) {

		Scanner getInput = new Scanner(System.in);

		int day;
		for (day = 0; day < 7; day++) {
			System.out.printf("Enter the temperature: ");
			tempArray[day] = getInput.nextInt();
		}

		getInput.close();
	}
}
