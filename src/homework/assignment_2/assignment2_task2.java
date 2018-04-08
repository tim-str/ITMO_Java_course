package homework.assignment_2;

import java.util.Arrays;

public class assignment2_task2 {
    public static void main(String[] args) {
        int a = 1; // the left end of the interval
        int b = 199; // the right end of the interval
        int n;
        int trueLeft;
        int trueRight;

        if (a % 2 != 0 && b % 2 != 0) { trueLeft = a; trueRight = b; n = (trueRight - trueLeft)/2 + 1; }
        else if (a % 2 != 0 && b % 2 == 0) { trueLeft = a; trueRight = b - 1; n = (trueRight - trueLeft)/2 + 1; }
        else { trueLeft = a + 1; trueRight = b - 1; n = (trueRight - trueLeft)/2 + 1; }

        int[] intArray = new int[n];

        int index = 0;

        for (int i = trueLeft; i <= trueRight; i+=2) {
            intArray[index] = i;
            index++;
        }

        System.out.println(Arrays.toString(intArray)); // outputting the array as a string enclosed in square brackets

        int[] intArrayReversed = new int[n];

        for (index = 0; index <= n - 1; index++) {
            intArrayReversed[index] = intArray[n - 1 - index];
        }

        System.out.println(Arrays.toString(intArrayReversed)); // outputting the array elements in reversed order
    }
}
