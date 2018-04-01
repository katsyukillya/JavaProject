import java.util.*;
import java.io.*;

public class Lecture7 {

	public static void main(String[] args) throws IOException {

/*
		// Using output streams
		PrintWriter textPrintStream = null;
		String outfileName = "output-final.txt";
		try {
			textPrintStream = new PrintWriter(new FileOutputStream(outfileName, true));
			textPrintStream.println("This output will go to the file " + outfileName);
			textPrintStream.write("This is the Final Grade \n");
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + outfileName + "\n" + e.getMessage());
			System.exit(0);
		}
		textPrintStream.close();
		System.out.println(outfileName + " been written and closed");
*/

/*
		// Working with File
		String fileName = "input_final.txt"; 
		File myFile = new File(fileName); 
		if (myFile.exists()) {
				System.out.println("File name is: " + myFile.getName());
				System.out.println("File is: " + myFile.getAbsolutePath()); }
		
		// Scanner can be used with the disk file as well
		
		Scanner readInput; 
		try { 
			readInput = new Scanner(new File(fileName));
			while (readInput.hasNextLine()) {
		
			} 
		} 
		// Start with most specific to most general exception 
		catch (FileNotFoundException e) { 
				System.out.println("File: " + fileName + " not found"); 
		} // End catch 
		catch (IOException e) {
				System.out.println("Error reading from the file: " + fileName + e.getMessage()); 
		} // End catch 
		catch (Exception e) {
				System.out.println(e); 
		} // End catch

*/
		
/*
		// Stream Tokenizer example I 
		BufferedReader bufferedReader = null;
		StreamTokenizer myTokenizer; 
		String fileName = "input_final.txt"; // Input file 
		int nextToken; 
		double numberToken; 
		String strToken;
		
		File inputFile = new File(fileName); 
		// Create a buffered stream to read from the file 
		try { 
			FileReader fileStream = new FileReader(inputFile); 
			bufferedReader = new BufferedReader(fileStream);
			// this can be achieved also like this 
			// bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
		
		} catch (FileNotFoundException err) { 
			System.out.println(err);
			System.exit(-1); // Exit if file not found
		} 
		
		myTokenizer = new StreamTokenizer(bufferedReader);
		myTokenizer.whitespaceChars(',', ','); 
		try { 
			nextToken = myTokenizer.nextToken(); 
			while (nextToken != StreamTokenizer.TT_EOF) { 
			if (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_WORD) { 
				strToken = myTokenizer.sval;
				System.out.println("Found a string: " + strToken); 
			} 
			if (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_NUMBER) {
				numberToken = myTokenizer.nval; 
				System.out.println("Found a number: " + numberToken); 
			} 
			nextToken = myTokenizer.nextToken(); // Eat up by TT_EOL 
			} // while
		
		} //try 
		catch (IOException err) { 
				// This code executes if there is an error in getting the next token 
				// from the file
				System.out.println(err); 
		} //catch
*/
		
/*
 		// Stream Tokenizer: example II
 		BufferedReader bufferedReader = null;
 		StreamTokenizer midTermTokenizer;
 		String fileName = "input_final.txt";	// input file
 		int nextToken;
 		double q1, q2, q3, q4, midTerm, finalTerm;
 		String firstName, lastName;
 		
 		File inputFile = new File(fileName);
 		// Create a buffered stream to read from the file
 		try {
 			FileReader fileStream = new FileReader(inputFile);
 			bufferedReader = new BufferedReader(fileStream);
 			// This can be achieved also like this:
 			// bufferedReader = new BufferedReader(new FileReader(new File(fileName)));

		} catch (FileNotFoundException err) {
			System.out.println(err);
			System.exit(-1);	//exit if the file not found
		}
		midTermTokenizer = new StreamTokenizer(bufferedReader);
		midTermTokenizer.whitespaceChars(',', ',');
		try {
			nextToken = midTermTokenizer.nextToken();
			while (nextToken != StreamTokenizer.TT_EOF) {
				firstName = midTermTokenizer.sval;
				nextToken = midTermTokenizer.nextToken();
				lastName = midTermTokenizer.sval;
				nextToken = midTermTokenizer.nextToken();
				q1 = midTermTokenizer.nval;
				nextToken = midTermTokenizer.nextToken();
				q2 = midTermTokenizer.nval;
				nextToken = midTermTokenizer.nextToken();
				q3 = midTermTokenizer.nval;
				nextToken = midTermTokenizer.nextToken();
				q4 = midTermTokenizer.nval;
				nextToken = midTermTokenizer.nextToken();
				midTerm = midTermTokenizer.nval;
				nextToken = midTermTokenizer.nextToken();
				finalTerm = midTermTokenizer.nval;
				// get the next token
				nextToken = midTermTokenizer.nextToken();	//last null
 				nextToken = midTermTokenizer.nextToken();
				 
 				System.out.println(firstName + " " + lastName 
 						+ " " + q1 + " " 
 						+ " " + q2 + " " 
 						+ " " + q3 + " " 
 						+ " " + q4 + " " 
 						+ " " + midTerm + " " 
 						+ " " + finalTerm + " ");
 			}	// while
 		}	// try
 		catch (IOException err) {
 			// This code executes if there is an error in getting the next token
 			// from the file
 			System.out.println(err);
 		}	// catch

*/
		
/*
		//String Tokenizer Example I
		String getLine = "This is\na,string.with four.delimiters";
		// Create a tokenizer with multiple delimiters
		StringTokenizer parseWords = new StringTokenizer(getLine, " \n.,");
		while(parseWords.hasMoreTokens())
		{
			System.out.println(parseWords.nextToken());
		}
		
		// String Tokenizer Example II
		Scanner keyboard = new Scanner(System.in);
		String getUserInput = keyboard.nextLine();
		// Create a tokenizer with multiple delimiters
		StringTokenizer parseUserInput = new StringTokenizer(getUserInput, " \n.,");
		while (parseUserInput.hasMoreTokens())
		{
			System.out.println(parseUserInput.nextToken());
		}
		

*/		
		
		//
		// Example I: Byte stream example:
		// How big is the file
		InputStream inStream;
		
		//Verifying the args passed through the file properties
		System.out.println("First argument is: " + args[0] + " Second argument is: " + args[1]);
		inStream = new FileInputStream(args[0]);
		
		int total = 0;
		while (inStream.read() != -1)
			total++;
		
		System.out.println(total + " bytes");
		inStream.close();
		
		
		
		
		
		
		
// Example II, read one-by-one byte at a line and one line at a time
		//// Text file input
		try {
			FileReader fileReader = new FileReader("input_final.txt");
			int readInt;
//			while ((readInt = fileReader.read()) != -1) {	// EOL
//				System.out.println("Byte: " + readInt + "\tChar: " + (char)readInt);
//			}
			BufferedReader finalInStream = new BufferedReader(fileReader);
//			BufferedReader smileyInStream = new BufferedReader(new FileReader("smiley.txt"));
			String s;
			while ((s=finalInStream.readLine()) != null) {
				System.out.println(s);
			}
			finalInStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	// End catch


		
	}	// End main

}	// End class
