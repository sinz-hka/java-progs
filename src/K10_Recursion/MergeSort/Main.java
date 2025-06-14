package K10_Recursion.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] a = { 7, 9, 3, 2, 1, 4, -8, 10, 1, 17 };

        // print original array
        System.out.println("Original array: " + Arrays.toString(a));

        // merge sort
        Sorting.sort(a);

        // print result
        System.out.println("Sorted array: " + Arrays.toString(a));
    }
}