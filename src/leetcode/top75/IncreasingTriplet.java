package leetcode.top75;

/*
* Given an integer array nums, return true if there exists a triple of
* indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
* If no such indices exists, return false.

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.

Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.

* */

public class IncreasingTriplet {

    static boolean increasingTripletBruteForce(int[] array) {

        int len = array.length;
        if (len < 3) return false;

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (array[i] < array[j] && array[j] < array[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean increasingTriplet(int[] array) {
        int leftMin = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : array) {
            if (num <= leftMin) {
                leftMin = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                increasingTriplet(new int[]{2,4,-2,-3})
        );
    }
}
