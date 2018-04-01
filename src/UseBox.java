class MyBox {
	static void drawHLine(int h, String hStr) {

		int i = 0;
		while (i++ < h)
			System.out.print(hStr);
	}

	static void drawVLine(int h, int v, String hStr, String vStr) {

		int i = 0;
		while (i++ < v - 2) {
			System.out.print(vStr);
			drawHLine(h - 2, hStr);
			System.out.println(vStr);
		}
	}

	static void drawBox(int h, int v, String hStr, String vStr, String fillerStr) {

		drawHLine(h, hStr);
		System.out.printf("\n");
		drawVLine(h, v, fillerStr, vStr);
		drawHLine(h, hStr);
		System.out.printf("\n");
	}
}


public class UseBox {

	public static void main(String[] args) {

		int hSize = 20;
		int vSize = 10;

		MyBox.drawBox(hSize, vSize, "-", "|", " ");
		// Big Box
		MyBox.drawBox(30, 15, "+", "+", "$");

	}

}
