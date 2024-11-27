package datastructures.sorting;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }


    private static void quickSortHelper(int[] array, int left, int right) {
        // Base case: If the left index is less than the right index, continue sorting
        if (left < right) {
            // Partition the array using the pivot function, and get the new pivot index
            int pivotIndex = pivot(array, left, right);

            // Recursively call quickSortHelper on the
            // left subarray (elements before the pivot)
            quickSortHelper(array, left, pivotIndex - 1);

            // Recursively call quickSortHelper on the
            // right subarray (elements after the pivot)
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }



    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }


    public static void main(String[] args) {

        int[] myArray = {4,6,1,7,3,2,5};

        quickSort(myArray);

        System.out.println( Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7]

         */

    }

}
