
public class BoxWhileLoop {

	public static void main(String[] args) {

		int i = 0;
		int x = 0;
		int y = 0;
		int z = 0;

		System.out.println("Using smart force \nfor the while loop: \n");
			while (x++ < 20) {		
			System.out.printf("-");
			}
			System.out.printf("\n");
			while (i++ < 8) {
				System.out.printf("|");
				
				while (z++ < 18) {
					System.out.printf(" ");
				}
				
				System.out.printf("|\n");
				z = 0;
			}

			while (y++ < 20) {		
			System.out.printf("-");
			}

	}

}
