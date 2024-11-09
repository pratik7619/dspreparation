package datastructures.slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumNumberInSlide {

    static List<Integer> maxNumber(int[] array, int k) {
        if (array == null || k > array.length) return List.of();

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1 && deque.peekFirst() != null) {
                result.add(array[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        int B = 3;
        List<Integer> result = maxNumber(A, B);
        System.out.println("Maximum of each window: " + result);
    }
}
