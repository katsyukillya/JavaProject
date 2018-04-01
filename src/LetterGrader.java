import utility.*;

import java.io.*;
import java.util.*;

/**
 * Created by Illya Katsyuk on 3/30/2018.
 * This code is part of the Final assignment
 * for the class CMPR.X412.(802) 
 * 5185 Java Programming for Beginners
 * Instructor: Bineet Sharma
 */

/*
 * To run this set of programs through the Eclipse IDE,
 * Add the Arguments to this particular class by
 * opening the Properties --> Run/Debug Settings -->
 * Select the TestLetterGrader class name (or add it if it is not there) -->
 * Click Edit --> Select (x)Arguments tab -->
 * Type into the field the following line:
 * input_data.txt output_data.txt -->
 * Save the input by clicking OK twice.
 * In addition, place the input_data.txt file in the folder
 * C:\Users\<UserName>\<workspaceName>\<ProjectName>
 */
public class LetterGrader implements IGrader {

    private String inputFile;
    private String outputFile;
    private BufferedReader br;
    private BufferedWriter bw;
    private List<Student> students;
    private int longestNameLength;

    private boolean isError;

    public LetterGrader(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.longestNameLength = 0;
        this.br = null;
        this.bw = null;
        this.students = new ArrayList<>();
    }


    @Override
    public boolean readScore() {
        try {
            br = new BufferedReader(new FileReader(new File(this.inputFile)));

            String curLine;
            while ((curLine = br.readLine()) != null) {
                Student s = new Student(curLine);
                if (s.getName().length() > this.longestNameLength) {
                    this.longestNameLength = s.getName().length();
                }
                this.students.add(s);
            }

            this.students.sort(StudentComparators.nameComparator);

            isError = false;
            return true;
        } catch (IOException e) {
            System.err.println("Error while opening input file..." + e.getMessage());
            isError = true;
            return false;
        }
    }

    @Override
    public void calcLetterGrade() {
        // this method is not actually needed as all the information has
        // already been processed as part of the reading file
        if (isError) {
            System.err.println("There was an error while reading file. skipping execution of 'calcLetterGrade'");
        }
    }

    @Override
    public void printGrade() {
        if (isError) {
            System.err.println("There was an error while reading file. skipping execution of 'printGrade'");
            return;
        }

        try {
            bw = new BufferedWriter(new FileWriter(new File(this.outputFile)));
        } catch (IOException e) {
            System.err.println("Failed to open file for writing..." + e.getMessage());
        }
        // sort students by name
        this.students.sort(StudentComparators.nameComparator);
        for (Student student : this.students) {
            // add 10 to longest name
            int gradePosition = this.longestNameLength + 10;
            String studentName = student.getName();
            int padding = gradePosition - studentName.length();
            String paddingStr = "";
            for (int i = 0; i < padding; i++) {
                paddingStr += " ";
            }
            String line = studentName + ":" + paddingStr + student.getLetterGrade() + "\n";
            try {
                bw.write(line);
            } catch (IOException e) {
                System.err.println("Failed to add record to file. continuing on to next student");
            }
        }
    }

    @Override
    public void displayAverages() {
        if (isError) {
            System.err.println("There was an error while reading file. Skipping execution of the 'displayAverages'");
            return;
        }

        Number[] average = new Number[7];
        Number[] min = new Number[7];
        Number[] max = new Number[7];

        int numStudents = this.students.size();
        // get minimum and maximum for the scores
        for (int i = 0; i < 7; i++) {
            this.students.sort(StudentComparators.getScoreComparatorAtIndex(i));
            int sum = 0;
            for (int j = 0; j < numStudents; j++) {
                sum += this.students.get(j).getScoreAtIndex(i);
            }
            min[i] = this.students.get(0).getScoreAtIndex(i);
            max[i] = this.students.get(numStudents - 1).getScoreAtIndex(i);
            average[i] = (double)(sum * 100 / numStudents) / 100;
        }

        // print formatted header
        System.out.println("Here is the class averages: \n");
        System.out.println("\t\tQ1     Q2     Q3     Q4     Mid1   Mid2  Final");
        printLine("Average", average);	
        printLine("Minimum", min);		
        printLine("Maximum", max);		
    }

    private void printLine(String title, Number[] data) {
        String line = title + ":\t";
        for (int i = 0; i < data.length; i++) {
            line += data[i];
            // compute number of spaces to fill
            int spaceBuf = 7 - data[i].toString().length();
            for (int j = 0; j < spaceBuf; j++) {
                line += " ";
            }
        }

        System.out.println(line.trim());
    }

    @Override
    public void doCleanup() {
        closeCloseable(br);		// CLosing the buffered reader
        closeCloseable(bw);		// Closing the buffered writer
    }

    private void closeCloseable(Closeable obj) {
        if (obj != null) {
            try {
                obj.close();
            }
            catch (IOException e) {
                System.err.println("Failure while closing " + obj.toString());
            }
        }
    }



}