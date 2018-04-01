package utility;


import java.util.*;

/**
 * Created by Illya Katsyuk on 3/30/2018.
 * This code is part of the Final assignment
 * for the class CMPR.X412.(802) 
 * 5185 Java Programming for Beginners
 * Instructor: Bineet Sharma
 */
public class StudentComparators {

    public static Comparator<Student> nameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Student> getScoreComparatorAtIndex(int index) {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScoreAtIndex(index) == o2.getScoreAtIndex(index)) {
                    return 0;
                } else if (o1.getScoreAtIndex(index) > o2.getScoreAtIndex(index)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
    }
}