import java.util.Arrays;

public class assignment2_task4 {
    public static void main(String[] args) {
        int dimArray = 5;
        int[] rndArray1 = new int[dimArray];
        int[] rndArray2 = new int[dimArray];
        int count = 0;

        for (int index = 0; index <= dimArray - 1; index++) {
            rndArray1[index] = (int) Math.round(Math.random() * 5);
            rndArray2[index] = (int) Math.round(Math.random() * 5);
        }

        System.out.println(Arrays.toString(rndArray1)); // displaying the array generated
        System.out.println(Arrays.toString(rndArray2)); // displaying the array generated

        int sum1, sum2;
        sum1 = sum2 = 0;

        for (int index = 0; index <= dimArray - 1; index++) {
            sum1 = sum1 + rndArray1[index];
            sum2 = sum2 + rndArray2[index];
        }

        if (sum1 == sum2) { System.out.println("The averages are equal and the value of AVG is " + sum1/dimArray); }
            else if (sum1 > sum2) {
            System.out.println("The average of Array_1: " + (float) sum1/dimArray + " supersedes the same metrics for Array_2: " + (float) sum2/dimArray);
        }
            else System.out.println("The average of Array_2: " + (float) sum2/dimArray + " supersedes the same metrics for Array_1: " + (float) sum1/dimArray);

        System.out.println();
    }
}
