package utility;

import java.util.*;

/**
 * Created by Illya Katsyuk on 3/30/2018.
 * This code is part of the Final assignment
 * for the class CMPR.X412.(802) 
 * 5185 Java Programming for Beginners
 * Instructor: Bineet Sharma
 */
public class Student {
    private List<Grade> grades;
    private String name;
    private double gradeSum;

    public Student(String entry) {
        grades = new ArrayList<>();
        gradeSum = 0;
        parseLine(entry);

    }

    private void parseLine(String entry) {
        String[] items = entry.split(",");
        this.name = items[0];
        for (int i = 0; i < items.length; i++) {
            String curItem = items[i].trim();
            if (i == 0) {
                this.name = items[i];
            }
            else {
                int grade = Integer.parseInt(curItem);
                int weight;
                if (i > 0 && i < 5) {	// Determining the weight for 4 quizzes
                    weight = 10;
                }
                else if (i == 5) {		// Weight for the first Midterm
                    weight = 20;
                }
                else if (i == 6) {		// Weight for the second Midterm
                    weight = 15;
                }
                else {					// Weight for the Final
                    weight = 25;
                }
                Grade g = new Grade(grade, weight);
                gradeSum += g.getWeightedScore();
                this.grades.add(g);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public String getGrades() {
        String rv = "";
        for (int i = 0; i < this.grades.size(); i++) {
            String suffix = (i == this.grades.size() - 1) ? "" : ", ";
            rv += this.grades.get(i).score + suffix;
        }

        return rv;
    }

    public int getScoreAtIndex(int index) {
        if (index < 0 || index >= this.grades.size()) {
            return -1;
        }

        return this.grades.get(index).score;
    }

    public int getQuizScore(int quizNumber) {
        if (quizNumber < 1 || quizNumber > 4) {
            return -1;
        }

        return this.grades.get(quizNumber).score;
    }

    public int getMidtermScore(int midtermNumber) {
        if (midtermNumber < 1 || midtermNumber > 2) {
            return -1;
        }
        int lastQuizIndex = 3;
        return this.grades.get(lastQuizIndex + midtermNumber).score;
    }

    public int getFinalScore() {
        return this.grades.get(this.grades.size() - 1).score;
    }

    public String getLetterGrade() {
        switch ((int)(this.gradeSum / 10)) {
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
                return "D";
            default:
                return "F";
        }
    }

}