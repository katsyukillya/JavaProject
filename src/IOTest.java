import java.io.File;
import java.util.Scanner;

public class IOTest {

	public static void main(String[] args) {

		String fileName = "input_final.txt";

		File myFile = new File(fileName);

		if (myFile.exists()) {

			// File name is: input_final.txt
			// File is: C:\Work_Space\Java_060\Projects\Java063\input_final.txt

			System.out.println("File name is: " + myFile.getName());
			System.out.println("File is: " + myFile.getAbsolutePath());
		}
	}

}