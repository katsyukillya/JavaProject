public class BoxForLoopHardcoded {

	public static void main(String[] args) {


		System.out.println("Using smart force: \nfor the 'for' loop \n");
		
		for(int x=0; x<20; x++) {
			System.out.printf("-");
		}
		
		System.out.printf("\n");
		
		for (int i=0; i<8; i++) {
			System.out.printf("|");
			
			for(int z = 0; z < 18; z++) {
				System.out.printf(" ");
			}
			
			System.out.printf("|\n");
		}
		for(int y=0; y<20; y++) {
			System.out.printf("-");
		}

	}
}
