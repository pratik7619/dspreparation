package datastructures.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {

    static int countAnagrams(String text, String pattern) {
        if (text.isEmpty() || pattern.isEmpty()) return 0;

        int count = 0;
        int patternLength = pattern.length();
        int textLength = text.length();

        //Count frequency of each char
        Map<Character, Integer> patMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patMap.put(c, patMap.getOrDefault(c, 0) + 1);
        }

        //count for the first window
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < patternLength; i++) {
            char c = text.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        if (windowMap.equals(patMap)) count++;

        //slid the window across the text
        for (int i = patternLength; i < textLength;i++) {
            //remove the going out char
            char outGoingCharacter = text.charAt(i - patternLength);
            windowMap.put(outGoingCharacter, windowMap.get(outGoingCharacter) - 1);
            if (windowMap.get(outGoingCharacter) == 0) {
                windowMap.remove(outGoingCharacter);
            }

            // add new char
            char incomingChar = text.charAt(i);
            windowMap.put(incomingChar, windowMap.getOrDefault(incomingChar, 0) + 1);
            if (windowMap.equals(patMap)) {
                count++;
            }
        }

        return count;
    }
}
