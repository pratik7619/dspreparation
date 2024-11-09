package datastructures.sorting;

import java.util.Arrays;

public class MergeSort {

    static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;
        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
        return merge(left, right);
    }

    static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                mergedArray[index] = array1[i];
                i++;
            } else {
                mergedArray[index] = array2[j];
                j++;
            }
            index++;
        }
        while (i < array1.length) {
            mergedArray[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            mergedArray[index] = array2[j];
            index++;
            j++;
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] array = merge(
                new int[]{1, 3, 5, 7},
                new int[]{2, 4, 6, 8}
        );
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(mergeSort(new int[]{2,6,9,5,4,1})));
    }
}
