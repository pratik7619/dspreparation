package programs.medium;

import java.util.Arrays;

public class ZeroTripletSum {
    private static void zeroTripletSum(int[] array) {

        if (array == null || array.length < 3) return;

        //Lets sort the elements
        Arrays.sort(array);

        int n = array.length;

        for (int i = 0; i < n - 2; i++) {
            int requiredArray = -array[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = array[left] + array[right];
                if (sum > requiredArray) {
                    right--;
                } else if(sum < requiredArray) {
                    left++;
                } else {
                    System.out.println(array[i] + " " + array[left] + " " + array[right]);
                    left++;
                    right--;
                }
            }
        }
    }
}
