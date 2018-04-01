
class WeeklyTempsStatistics {
	public static void main(String args[]) {

		int [] weeklyTemp = { 69, 70, 71, 68, 66, 71, 70 };
		int day = 0;
		
		for (day = 0; day < weeklyTemp.length; day++) 
			System.out.printf("The temperature on day %d was %d\n", day + 1, weeklyTemp[day]);
		
		System.out.println();
		
		int min = weeklyTemp[0];
		
		for (day = 1; day < weeklyTemp.length; day++) {
			if (min > weeklyTemp[day])
				min = weeklyTemp[day];
		}
		
		System.out.printf("The Minimum temperature is: %d\n", min);
		
		int max = weeklyTemp[0];
		
		for (day = 1; day < weeklyTemp.length; day++) {
			if (max < weeklyTemp[day])
				max = weeklyTemp[day];
		}
		
		System.out.printf("The Maximum temperature is: %d\n", max);
		
		int total = 0;
		
		for (day = 0; day < weeklyTemp.length; day++) 
			total += weeklyTemp[day];
		
		float days = (float) weeklyTemp.length;
		
		System.out.printf("The average temperature for the week is: %5.2f\n", total / days);
		
		System.out.println("\nThank you for using my nomework #5 solution");
	}
}
