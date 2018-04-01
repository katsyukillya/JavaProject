import java.util.Scanner;


public class BoxUserEntryRepeatedRun {

	public static void main(String[] args) {
	
		int height, width;
		char side, topBottom, reply;
		
		do {
		Scanner readInput = new Scanner(System.in);
		
		System.out.printf("Please enter the height of the rectangle: ");
		height = readInput.nextInt();
		
		System.out.printf("Please enter the width of the rectangle:");
		width = readInput.nextInt();
		
		System.out.printf("What characters do you want to use for top and bottom of the rectangle? ");
		topBottom = readInput.next().charAt(0);
		
		System.out.printf("What characters do you want to use for sides of the rectangle? ");
		side = readInput.next().charAt(0);

		System.out.println("Using smart force: \nfor the 'for' loop \nwith User entry \n");
		
		for(int x=0; x<width; x++) {
			System.out.print(topBottom);
		}
		
		System.out.printf("\n");
		
		for (int i=0; i<(height-2); i++) {
			System.out.print(side);
			
			for(int z = 0; z < (width-2); z++) {
				System.out.printf(" ");
			}
			
			System.out.print(side + "\n");
		}
		for(int y=0; y<width; y++) {
			System.out.print(topBottom);
		}
		
		System.out.printf("\n\n");
		System.out.printf("Continue? Type 'y' for yes: \n");
		reply = readInput.findWithinHorizon(".", 0).charAt(0);
		
		readInput.close();
		
		} while (reply == 'y');

		System.out.println("Thank you for using the drawing program. \nGoodbye!");


	}
	

}
