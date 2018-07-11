import java.util.*;

/*
 * The Palindrome is a string that reads forward and backward equally, e.g. 
 * "madam", "abcba", “12321”, "c++&++c", "dad", e.t.c.
 * 
 * The following program takes a user entered string, removes all spaces from it
 * and reverses. Then, the original string without spaces and its reversed version
 * are compared. If both are equal, the entered string is a palindrome
 */
 
class Palindrome
{
   public static void main(String args[])
   {
      String original, reverse = ""; // Objects of String class
      Scanner userInput = new Scanner(System.in);							// Initiating a Scanner to read user entry
 
      System.out.println("Enter a string to check if it is a palindrome");	// Asking user to enter the string
      original = userInput.nextLine();										// Reading the user entry
      String strNoSpaces = original.replaceAll("\\s", "");					// Removing all spaces from the string
      int length = strNoSpaces.length();									// Determine the string length
 
      for ( int i = length - 1; i >= 0; i-- )								// Initiate the loop to read characters one-by-one
         reverse = reverse + strNoSpaces.charAt(i);							// Inserting the characters into the new string variable in backward order
//      System.out.println(reverse);										// Just to see what the reversed string look like
 
      if (strNoSpaces.equals(reverse))										// Comparing two strings. If they equal,
         System.out.println("Entered string is a palindrome.");				// Print the message that the entered string is a palindrome
      else																	// Otherwise,
         System.out.println("Entered string isn't a palindrome.");			// Show the message that the string was not a palindrome
 
   }
}	