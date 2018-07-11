import java.util.Scanner;

public class Scanning {
	
	public static void main(String[] args) {
    String randomWords;
    Scanner kb = new Scanner(System.in).useDelimiter("\n");
    
    

    System.out.print("Please enter two words separated: ");

    randomWords = kb.next();    
    System.out.println(randomWords);
	}

}
