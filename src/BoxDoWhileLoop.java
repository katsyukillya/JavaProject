
public class BoxDoWhileLoop {

	public static void main(String[] args) {

		int i = 0;
		int x = 0;
		int y = 0;
		int z = 0;

		System.out.println("Using smart force: \nfor the do...while loop \n");
			do {		
			System.out.printf("-");
			} while (++x < 20);
			
			System.out.printf("\n");

			do {
				System.out.printf("|");
				
				do {
				System.out.printf(" ");
				} while (++z < 18);
				
				System.out.printf("|\n");
				z = 0;
			} while (++i < 8);

			do {		
			System.out.printf("-");
			} while (++y < 20);

	}

}
