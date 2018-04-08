package homework.assignment_2;

import java.util.Arrays;

public class assignment2_task7 {

    public static void main(String[] args) {

        int dim1Array = 5;
        int dim2Array = 8;

        int[][] rndArray = new int[dim1Array][dim2Array];

        for (int i = 0; i <= dim1Array - 1; i++) {
            for (int j = 0; j <= dim2Array - 1; j++) {
                rndArray[i][j] = (int) Math.floor(Math.random() * 199 - 99);
            }

            System.out.println(Arrays.toString(rndArray[i])); // printing out the array elements generated
        }

        int max = rndArray[0][0];
        for (int[] row : rndArray)
            for (int value : row)
            {
                if (value > max) {max = value;}
            }
        System.out.println("The maximum value across all the elements of the array is: " + max);

    }

}
