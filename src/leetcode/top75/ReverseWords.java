package leetcode.top75;

public class ReverseWords {

    static String reverseWords(String s) {
        // Step 1: Trim spaces from both ends
        s = s.trim();

        // Step 2: Split the string by one or more spaces
        String[] words = s.split("\\s+");

        // Step 3: Reverse the order of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello world"));
    }
}
