package utility;

/**
 * Created by Illya Katsyuk on 3/30/2018.
 * This code is part of the Final assignment
 * for the class CMPR.X412.(802) 
 * 5185 Java Programming for Beginners
 * Instructor: Bineet Sharma
 */

class Grade {
    int weight;
    int score;

    /**
     * Specifies a single grade
     * @param score Score for the grade
     * @param weight Weight for current score (in percent)
     */
    Grade(int score, int weight) {
        this.weight = weight;
        this.score = score;
//        System.out.println("current weight is: " + weight + " current score is: " + score);
        // Just to see if all the weights and grades are passed correctly
    }

    /**
     * Returns calculated weighted score
     * @return Weighted score
     */
    double getWeightedScore() {
        return this.score * this.weight / 100;
    }
}