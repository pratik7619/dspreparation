package programs.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElements {

    public static int removeElement(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    static int[] removeElements(int[] array, int value) {

        List<Integer> nums = new ArrayList<>();
        for (int num : array) {
            if (num != value) {
                nums.add(num);
            }
        }

        return nums.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(removeElements(
                                new int[]{2, 5, 7, 8, 3, 1, 2, 3, 4, 5, 6, 8, 3, 2},
                                2
                        )
                )
        );
    }
}
