package datastructures.slidingwindow;

import java.util.*;

public class FirstNegativeNumber {

    static ArrayList<Integer> firstNegativeNumber(int[] array, int k) {

        if (array == null || k > array.length) return new ArrayList<>();

        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (array[i] < 0) {
                deque.add(i);
            }
        }

        for (int i = k; i < array.length; i++) {
            if (!deque.isEmpty()) {
                negativeNumbers.add(array[deque.peek()]);
            } else {
                negativeNumbers.add(0);
            }

            if (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            if (array[i] < 0) deque.add(i);
        }

        if (!deque.isEmpty()) {
            negativeNumbers.add(array[deque.peek()]);
        } else {
            negativeNumbers.add(0);
        }

        return negativeNumbers;
    }

    public static void main(String[] args) {
        System.out.println(
                firstNegativeNumber(
                        new int[] {-8, 2, 3, -6, 10},
                        2
                )
        );
    }
}
