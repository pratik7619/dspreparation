package leetcode.top75;

import java.util.Arrays;

/*
* Given an integer array nums, move all 0's to the end of it while
  maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]

* */

public class MoveZeroToEnd {

    static void moveZeros(int[] array) {
        int nonZeroIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (i != nonZeroIndex) {
                    array[nonZeroIndex] = array[i];
                    array[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 0, 0, 1, 3, 0, 4, 5, 6, 0, 2, 0, 9};
        moveZeros(array);
        System.out.println(Arrays.toString(array));
    }
}
