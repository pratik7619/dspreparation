package leetcode.top75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    static String reverseVowels(String string) {

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] chars = string.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {

        System.out.println(
                reverseVowels("apple")
        );

    }
}
