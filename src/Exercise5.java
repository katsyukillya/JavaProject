import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Homework #9
 * Created by Illya Katsyuk on 3/27/18.
 * 
 * 
 * Before running this program through the Eclipse, please 
 * add args to the file properties as follows
 * input_final.txt output_final.txt
 * 
 * Additionally, please place the input_final.txt file into the 
 * project's folder. For example,
 * C:\Users\UserName\WorkspaceName\ProjectName for Windows based
 * computer
 */
public class Exercise5 {

    public static void main(String[] args) {
        // call method that processes CLA args
        processCLArguments(args);

        // we have exactly 2 arguments, we're processing those files
        if (args.length == 2) {
            processInputOutputFiles(args);
        }
    }

    public static void processCLArguments(String[] args) {
        // if there are less than 2 elements, display error message
        // technically this should be != instead of < 2, but those are
        // my instructor's requirements
        if (args.length < 2) {
            System.err.println("Usage: java Exercise5 inputFile outputFile");
        }
        else {
            // otherwise, we are going to take the first 2 arguments
            // and print them out. Remember, Java has 0-based arrays
            // meaning that first element is always 0 and last element
            // is array.length - 1
            System.out.println("Input will be read from: " + args[0]);
            System.out.println("Output will be written into: " + args[1]);
        }
    }

    public static void processInputOutputFiles(String[] args) {
        // since this method is being called from main and main has checked
        // argument count, we don't have to do it here
        String input = args[0];
        String output = args[1];

        // create a handles to the files (input and output)
        File inputFile = new File(input);
        File outputFile = new File(output);


        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            // try to create a file reader object
            reader = new BufferedReader(new FileReader(inputFile));

            // try to create file writer object
            writer = new BufferedWriter(new FileWriter(outputFile));

            // read file 1 line at a time
            String curLine;
            int counter = 0;
            while ((curLine = reader.readLine()) != null) {
                // split each line based on ','
                String[] lineItems = curLine.trim().split(",");
                if (lineItems.length == 0) {
                    continue;
                }

                // increment counter
                counter++;
                String studentName = lineItems[0];
                String scores = "";
                // loop through scores (notice we are starting with
                // the index 1 as index 0 is for student name)
                for (int i = 1; i < lineItems.length; i++) {
                    scores += lineItems[i] + ", ";
                }
                // remove trailing ',' We are doing substring with '-3' because
                // length - 1 is the last character (which is space)
                // length - 2 is the comma
                // length - 3 is what we need
                scores = scores.trim().substring(0, scores.length() - 3);
                System.out.println("Student #:" + counter + " " + studentName + ", " + scores);
                // replace scores string for file writing
                scores = scores.replace(',', ':');
                String strToWrite = "Student #" + counter + " is: \"" + studentName + "\" whose raw scores are: " + scores + ":\n";
                writer.write(strToWrite);
            }
        }
        catch (FileNotFoundException e) {	//Starting with the most specific exception to catch
            System.err.println("File " + input + " was not found");
        }
        catch (IOException e) {
            System.err.println("There was an error while reading the file");
        }
        catch (Exception e) {	//Finishing with the most generic exception to catch
            System.err.println("There was a generic error while reading the file");
        }
        finally {
            // close file reader
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    System.err.println("Error closing the input file");
                }
            }
            // close file writer
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (IOException e) {
                    System.err.println("Error closing the output file");
                }
            }
        }
    }
}