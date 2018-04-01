public class Quiz {
	public static void main(String[] args) {
		double radius = 0;		//=0 is added to avoid the thrown compilation error
		final double PI = 3.15169;
//		radius = 7;		//added to see the result
		double area = radius * radius * PI;
		System.out.println("Area is " + area);
	}
}