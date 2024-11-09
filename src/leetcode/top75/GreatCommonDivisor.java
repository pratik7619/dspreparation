package leetcode.top75;

public class GreatCommonDivisor {

    static String greatCommonDivisor(String string1, String string2) {
        int gcdLength = gcd(string1.length(), string2.length());

        String candidate = string1.substring(0, gcdLength);

        if (string1.equals(candidate.repeat(string1.length() / gcdLength)) &&
                string2.equals(candidate.repeat(string2.length() / gcdLength))
        ) {
            return candidate;
        } else {
            return "";
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(greatCommonDivisor("ABCABC", "ABC"));
    }
}
