import java.util.Scanner;

public class Homework_8_1_Solution {
	
	public static void main(String[] args) {
		System.out .println("\nCalling methods to do the work:");
		int [] weeklyTemp = new int[7];
		getTemperatures(weeklyTemp, 7);
		printTemperatures(weeklyTemp, 7);
		printStatistics(weeklyTemp, 7);
		//in turn calls getMin, getMax, and getAverage;
		}

	static void getTemperatures(int[] temps, int arraySize) {
		int i;
		Scanner readInput = new Scanner(System.in);
		for (i = 0; i < arraySize; i++) {
			System.out.printf("Enter the temp: ");
			temps[i] = readInput.nextInt();
		}
		System.out.printf("\n\n");
		
		readInput.close();
	}

	static void printTemperatures(int[] T, int size) {
		int i;
		for (i = 0; i < size; i++) {
			System.out.printf("\nThe temperature on day %d was %d: ", i + 1, T[i]);
		}
		System.out.printf("\n\n");
	}

	static int getMax(int[] T, int size) {
		int i, max = 0;
		// find the min temperature
		for (i = 0; i < 7; i++) {
			if (i == 0)
				max = T[i];
			if (T[i] > max)
				max = T[i];
		}
		return max;
	}

	static int getMin(int[] T, int size) {
		int i, min = 0;
		// find the min temperature
		for (i = 0; i < 7; i++) {
			if (i == 0)
				min = T[i];
			if (T[i] < min)
				min = T[i];
		}
		return min;
	}

	static float getAverage(int[] weeklyTemp, int arraySize) {
		int i;
		float total = 0, average;
		for (i = 0; i < 7; i++)
			total += weeklyTemp[i];
		average = total / arraySize;
		return average;
	}

	static void printStatistics(int[] T, int size) {
		System.out.printf("The minimum of weekly temperature is: %d\n", getMin(T, size));
		System.out.printf("The maximum of weekly temperature is: %d\n", getMax(T, size));
		System.out.printf("The average of weekly temperature is: %5.2f\n", getAverage(T, size));
	}

}
