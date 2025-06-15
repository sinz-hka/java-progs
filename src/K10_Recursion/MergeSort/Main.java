package K10_Recursion.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] a = { 7, 9, 3, 2, 1, 4, -8, 10, 1, 17 };

        System.out.println("Original array: " + Arrays.toString(a));

        Sorting.sort(a);

        System.out.println("Sorted array: " + Arrays.toString(a));
    }
}