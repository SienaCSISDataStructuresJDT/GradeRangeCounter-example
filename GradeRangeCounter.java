import java.util.Scanner;

/**
 * Example GradeRangeCounter: input a set of scores, track the number of
 * scores which fall into each of several grade ranges as defined by some
 * initialized arrays.
 * 
 * @author Jim Teresco, The College of Saint Rose, CSC 252, Fall 2013,
 *         Modified by Prof. White, Siena College, CSIS-210, Spring 2018, Fall 2020
 * @version Fall 2020
 */
public class GradeRangeCounter 
{
    public static void main(String[] args) 
    {   
        // Define our grades and thresholds as parallel arrays.
        // The index into each array relates the data; e.g., index 0 is an "A", which must be a value 
        // of 93.0 or more.
        final String [] LETTER_GRADES = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F" };
        final double [] THRESHOLDS = { 93.0, 90.0, 87.0, 83.0, 80.0, 77.0, 73.0, 70.0, 67.0, 63.0, 0.0 };
        
        // The array where we'll track the number of grades at each level.
        // In Java, these are automatically initialized to 0's.
        //
        // This is another parallel array.  E.g., the value at index 0 is the number of A's entered.
        int [] grades = new int[LETTER_GRADES.length];
        
        // A Scanner to read in our grades from the keyboard.
        Scanner keyboard = new Scanner(System.in);
        double grade;
        
        // Read grades using a do-while loop so we read at least one grade (or a number < 0
        // to immediately quit).
        do {
            System.out.print("Next grade?  (Enter value outside 0-100 to quit): ");
            grade = keyboard.nextDouble();
            
            // Make sure we're in the legal range for a grade.
            if (grade >= 0 && grade <= 100) {
                // Find the index where this grade is >= the threshold.
                int i = 0;
                while(i < THRESHOLDS.length && grade < THRESHOLDS[i]){
                    i++;
                }
                //Add one to this grade's count.
                grades[i]++;
            }
        } while (grade >= 0 && grade <= 100);
        
        // Print the resulting table.
        System.out.println("\nGrade breakdown:");
        for (int i = 0; i < THRESHOLDS.length; i++) {
            System.out.println(LETTER_GRADES[i] + ": " + grades[i]);
        }
    }
}
