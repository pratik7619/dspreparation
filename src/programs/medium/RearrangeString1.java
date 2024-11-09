package programs.medium;

import java.util.HashSet;
import java.util.Set;

public class RearrangeString1 {
    /*
     * Given a String with repeated characters, rearrange the string so that no two
     * adjacent characters are the same, if this is not possible return none
     * Ex : aaabbc => ababac
     *      aaab => null
     * */

    static String rearrangeString(String string) {
        //Step 1 : Generate Permutations
        Set<String> permutations = new HashSet<>();
        generatePermutations("", string, permutations);

        //Step 2: Valid adjacent
        for (String perm : permutations) {
            if (isValid(perm)) {
                return perm;
            }
        }
        return null;
    }

    static boolean isValid(String string) {
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    static void generatePermutations(String prefix, String remaining, Set<String> permutations) {

        int length = remaining.length();
        if (length == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                generatePermutations(
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        permutations
                );
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("aaabbc"));
    }
}
