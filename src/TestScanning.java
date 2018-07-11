import java.util.Scanner;

public class TestScanning {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	String x;
    	Scanner reader = new Scanner(System.in);
    	System.out.println("Enter a text: ");
    	x = reader.nextLine();
    	System.out.println("You entered: " + x);
    	reader.close();
    	
    }
}
