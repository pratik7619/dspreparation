package datastructures.slidingwindow;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

    static int longestSubArrayWithSumK(int[] array, int k) {

        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            if (currentSum == k) {
                maxLength = i + 1;
            }

            if (sumMap.containsKey(currentSum - k)) {
                maxLength = Math.max(maxLength, i - sumMap.get(currentSum - k));
            }

            if (!sumMap.containsKey(currentSum)) {
                sumMap.put(currentSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(
                longestSubArrayWithSumK(
                        new int[]{4, 1, 1, 1, 2, 3, 5},
                        5
                )
        );
    }
}
