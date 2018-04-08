package homework.assignment_2;

import java.util.Arrays;

public class assignment2_task3 {
    public static void main(String[] args) {
        int dimArray = 15;
        int[] rndArray = new int[dimArray];
        int count = 0;

        for (int index = 0; index <= dimArray - 1; index++) {
            rndArray[index] = (int) Math.round(Math.random() * 10);

            if (rndArray[index] % 2 == 0) { count++; }
        }

        System.out.println(Arrays.toString(rndArray)); // displaying the array generated

        System.out.println("Number of the even numbers out of the generated sub-set is: " + count); // even numbers tally

    }
}
