package datastructures.slidingwindow;

public class MaxSumSubArray {

    static int maxSumSubArray(int[] array, int k) {
        if (k > array.length) return 0;

        int windowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += array[i];
        }

        for (int i = k; i < array.length; i++) {
            windowSum += array[i] - array[i - k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(
                maxSumSubArray(
                        new int[]{1,2,3,4,5},
                        3
                )
        );
    }
}
