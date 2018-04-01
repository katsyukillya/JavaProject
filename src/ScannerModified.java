import java.util.Scanner;

public class ScannerModified {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// extra line feed
		System.out.println();
		System.out.print("Enter the radius: ");
		int radius = scan.nextInt();
		System.out.println();
		System.out.print("Enter the Pi value: ");
		double pi = scan.nextFloat();
		
		double area = pi * radius * radius;
		
		System.out.print("The area is: ");
		System.out.println(area);

		scan.close();
	}

}
