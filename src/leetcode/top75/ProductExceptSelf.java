package leetcode.top75;

import java.util.Arrays;

/*
* Given an integer array nums, return an array answer such that answer[i]
* is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using
* the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

* */

public class ProductExceptSelf {

    static int[] productExceptSelf(int[] array) {
        int[] answer = new int[array.length];

        answer[0] = 1;
        for (int i = 1; i < array.length; i++) {
            answer[i] = answer[i - 1] * array[i - 1];
        }

        int suffixProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= array[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        productExceptSelf(
                                new int[]{2, 4, -2, -3}
                        )
                )
        );
    }
}
