import java.util.Arrays;

public class task8 {

    public static void main(String[] args) {

        int a[] = {33,3,4,5};

        // copying an array
        // int [] NewArr3 = arr3.clone();

       int [] NewArr3 = new int[3];

       System.arraycopy(a,0,NewArr3,0, 2);
       System.out.println(Arrays.toString(a));

       // int [] neArr5 = Arrays.copyOf(newArr3,newlength:2)

        // comparing arrays via method Array.equals
        // filling an array with the same value across all elements - method Arrays.fill(arr1, val:2)

        // look-ups through an array
        // Arrays.binarySearch(array, key);
        // Arrays.binarySearch(array, start_pos, end_pos, key);

        // sorting an array before applying a look-up method
        // Array.sort(arr3);
        // Array.parallelSort(arr3);

        Arrays.parallelSort(a);
        System.out.println(Arrays.toString(a));

        int c = Arrays.binarySearch(a,5);
        System.out.println(c);

        // int [][] arr2D;
        // int [][][] arr3D;

        int [][] arr2d = new int[10][];
        for (int i=0; i < arr2d.length; i++) {
            arr2d[i] = new int[i];
            System.out.println(Arrays.deepToString(arr2d));

        }



    }
}
