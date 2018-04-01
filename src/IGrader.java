
/**
 * Created by Illya Katsyuk on 3/30/2018.
 * This code is part of the Final assignment
 * for the class CMPR.X412.(802) 
 * 5185 Java Programming for Beginners
 * Instructor: Bineet Sharma
 */
public interface IGrader {

    boolean readScore();
    void calcLetterGrade();
    void printGrade();
    void displayAverages();
    void doCleanup();
}