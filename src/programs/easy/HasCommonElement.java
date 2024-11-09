package programs.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HasCommonElement {

    //Brute force
    static boolean hasCommonElements(
            int[] arrayOne,
            int[] arrayTwo
    ) {
        for (int numFromArrayOne : arrayOne) {
            for (int numFromArrayTwo : arrayTwo) {
                return true;
            }
        }
        return false;
    }

    static boolean hasCommonElementsHashMap(
            int[] arrayOne,
            int[] arrayTwo
    ) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int value : arrayOne) {
            map.put(value, true);
        }

        for (int value : arrayTwo) {
            if (map.get(value) != null)
                return true;
        }

        return false;
    }

    //Efficient Way
    static boolean hasCommonArrayElements(
            Integer[] arrayOne,
            int[] arrayTwo
    ) {

        // add one array elements into one
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arrayOne));

        for (int num : arrayTwo) {
            if (set.contains(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasCommonElementsHashMap(new int[]{1, 2, 3}, new int[]{3, 4, 5}));
    }
}
