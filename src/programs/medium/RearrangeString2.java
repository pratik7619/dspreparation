package programs.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString2 {

    static String rearrangeString(String string) {

        //Step 1 : Count the frequency of a Character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : string.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        //Step : 2 Use max heap to store characters by their frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(frequencyMap.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prevEntry = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            result.append(currentEntry.getKey());

            if (currentEntry.getValue() > 1) {
                currentEntry.setValue(currentEntry.getValue() - 1);
                prevEntry = currentEntry;
            }

            //Step 3 : If there are prev entry that can be added back, push it into the heap
            if (prevEntry != null) {
                maxHeap.offer(prevEntry);
                prevEntry = null;
            }
        }

        return result.length() == string.length() ? result.toString() : null;
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("aaabbc"));
        System.out.println(rearrangeString("aaab"));
    }
}
