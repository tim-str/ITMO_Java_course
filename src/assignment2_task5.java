import java.util.Arrays;

public class assignment2_task5 {

    public static void main(String[] args) {
        int dimArray = 4;
        int[] rndArray1 = new int[dimArray];

        int temp;

        boolean niceArray = false;
        int interactions = 0;

        do {
            interactions++;
            int index = 0;

            do {

                temp = (int) Math.round(Math.random() * 99);

                if (temp >= 10) {
                    rndArray1[index] = temp;
                    index++;
                }
            }
            while (index <= dimArray - 1);

            int[] rndArray2 = Arrays.copyOf(rndArray1, rndArray1.length);

            Arrays.sort(rndArray2);

            if (Arrays.equals(rndArray1, rndArray2)) {
                niceArray = true;
                System.out.println("Original array: " + Arrays.toString(rndArray1)); // displaying the array generated
                System.out.println("Ordered array: " + Arrays.toString(rndArray2)); // displaying the array sorted

                System.out.println("Have we generated an array with the strictly rising sequence of its memebers' values? " + Arrays.equals(rndArray1, rndArray2));
                System.out.println("Number of iterations that's taken to find the nice Array: " + interactions);
            }
        }
        while (!niceArray);
    }

}

