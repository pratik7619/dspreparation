package leetcode.top75;

import java.util.ArrayList;
import java.util.List;

public class GreatestExtraCandies {

    static List<Boolean> kidsWithExtraCandies(int[] candies, int extraCandies) {

        List<Boolean> results = new ArrayList<>();
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        for (int candy : candies) {
            results.add(candy + extraCandies >= maxCandies);
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(
                kidsWithExtraCandies(
                        new int[]{2, 3, 5, 1, 3},
                        3
                )
        );
    }
}
