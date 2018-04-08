package homework.assignment_2;

import java.util.*;

public class assignment2_task6 {

    public static void main(String[] args) {

        boolean symmetry = false;
        int dimArray = 0;

        do {

            Scanner typeIn = new Scanner(System.in);

            System.out.println("Please enter the required array's dimension: ");

            int in = typeIn.nextInt();

            if (in % 2 == 0) {
                symmetry = true;
                dimArray = in;
            }

        }

        while (!symmetry);

        int[] rndArray1 = new int[dimArray];

            for (int index = 0; index <= dimArray - 1; index++) {

                rndArray1[index] = (int) Math.round(Math.random() * 20 - 5);

            }
            System.out.println(Arrays.toString(rndArray1));

        int midRange =  dimArray/2;
        int sum1, sum2;
        sum1 = sum2 = 0;

        for (int i = 0; i <= midRange - 1; i++) {
            sum1 = sum1 + Math.abs(rndArray1[i]);
        }
        for (int i = midRange; i <= dimArray - 1; i++) {
            sum2 = sum2 + Math.abs(rndArray1[i]);
        }

        if (sum1==sum2) {System.out.println("The sums of the absolute values are equal: " + sum1);}
            else if (sum1 > sum2) {
            System.out.println("The sum of the first " + midRange + " elements is higher and equals to:  " + sum1);
        }
            else {System.out.println("The sum of the last " + midRange + " elements is higher and equals to:  " + sum2);}

        System.out.println("sum1 = " + sum1 + " || " + "sum2 = " + sum2);


    }
}
