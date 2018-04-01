/**
 * Created by Illya Katsyuk on 3/30/2018.
 * This code is part of the Final assignment
 * for the class CMPR.X412.(802) 
 * 5185 Java Programming for Beginners
 * Instructor: Bineet Sharma
 */
public class TestLetterGrader {
    public static void main (String args[]) {
        //test if there are two valid arguments then, create the object
        //if not give right message and exit
        LetterGrader letterGrader = new LetterGrader(args[0], args[1]);
                                                    //LetterGrader is your main class,
                                                    //args[0] has input file name, and
                                                    //args[1] has output file name

        if (!letterGrader.readScore()) { //reads score and stores the data in member variables
            System.err.println("Failure while opening file");
            letterGrader.doCleanup();
            return;
        }
        letterGrader.calcLetterGrade(); //determines letter grade and stores information
        letterGrader.printGrade(); //writes the grade in output file
        letterGrader.displayAverages(); //displays the averages in console
        letterGrader.doCleanup(); //use it to close files and other resources
        //remember you need to take care of any errors or exceptions
        // in any of these activities must be taken care of
    }
}