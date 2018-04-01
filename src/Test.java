//import java.util.Scanner;
public class Test {


	public static void main(String[] args) {

//		Scanner getInput = new Scanner (System.in);
		
		//hard coded temperature 7 elements 0-6 index == it is zero-based index
		int [] weeklyTemp = {69, 70, 71, 68, 66, 71, 70};
		
		
		int day = 0;
		for (day=0; day < 7; day++)
			System.out.printf("The temperature on day %d was %d\n", day+1, weeklyTemp[day]);
		
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

}
