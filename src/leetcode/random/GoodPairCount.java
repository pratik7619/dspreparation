package leetcode.random;

/*
* Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

Example 3:

Input: nums = [1,2,3]
Output: 0

* */

import java.util.HashMap;

public class GoodPairCount {

    static int countPairs(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;

        for (int num : array) {
            if (map.containsKey(num)) {
                pairCount += map.get(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return pairCount;
    }

    static int bruteForce(int[] array) {
        int pairCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j] && i < j) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        System.out.println(
                bruteForce(
                        new int[]{1, 2, 3, 1, 1, 3}
                )
        );
    }
}
