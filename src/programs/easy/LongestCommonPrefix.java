package programs.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strings) {

        Arrays.sort(strings);

        String first = strings[0];
        String last = strings[strings.length - 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.min(first.length(), last.length()); i ++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                longestCommonPrefix(
                        new String[]{
                                "abc",
                                "abcddef",
                                "abbbcc",
                                "abssddeert"
                        }
                )
        );
    }

}
