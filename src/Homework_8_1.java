import java.util.Scanner;

/**
 * Created by Illya Katsyuk on 3/14/18.
 */
public class Homework_8_1 {

    private static Scanner scanner;
    private static int[] weeklyTemp;


    public static void main(String[] args) {
        getTemperatures();

        printTemperatures();

        printStatistics();
    }

    private static void printStatistics() {
        System.out.printf("The Minimum temperature is: %d\n", getMin());
        System.out.printf("The Maximum temperature is: %d\n", getMax());
        System.out.println("The average temperature for the week is: " + getAverage());
    }

    private static float getAverage() {
        int sum = 0;
        for (int i = 0; i < weeklyTemp.length; i++) {
            sum += weeklyTemp[i];
        }

        float average = sum / weeklyTemp.length;
        return average;
    }

    private static int getMax() {
        int max = 0;
        for (int i = 0; i < weeklyTemp.length; i++) {
            if (i == 0) {
                max = weeklyTemp[i];
            }
            if (weeklyTemp[i] > max) {
                max = weeklyTemp[i];
            }
        }

        return max;
    }

    private static int getMin() {
        int min = 0;
        for (int i = 0; i < weeklyTemp.length; i++) {
            if (i == 0) {
                min = weeklyTemp[i];
            }
            if (weeklyTemp[i] < min) {
                min = weeklyTemp[i];
            }
        }

        return min;
    }

    private static void printTemperatures() {
        // print homework_8_1
        for (int i = 0; i < weeklyTemp.length; i++) {
            System.out.printf("\nThe temperature on day %d " +
                            "was %d: ", i + 1,
                    weeklyTemp[i]);
        }
        System.out.printf("\n\n");
    }

    private static void getTemperatures() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        weeklyTemp = new int[7];
        for (int i = 0; i < weeklyTemp.length; i++) {
            while (true) {
                System.out.printf("Please enter temperature for day %d: ", (i + 1));
                String input = (scanner.next() + scanner.nextLine()).trim();
                try {
                    weeklyTemp[i] = Integer.parseInt(input);
                    break;
                }
                catch (NumberFormatException e) {
                    System.out.println("You've entered an invalid number");
                }
            }
        }
    }
}