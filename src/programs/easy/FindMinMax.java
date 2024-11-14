package programs.easy;

class Pair<T1, T2> {
    T1 first;
    T2 second;

    Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
}

public class FindMinMax {

    static Pair<Integer, Integer> findMinMax(int[] array) {

        int min = 0;
        int max = 0;

        for (int num : array) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        Pair<Integer, Integer> pair = findMinMax(new int[]{4, 5, 6, 7, 2, -1, 0});
        System.out.println(pair.first + " " + pair.second);
    }
}
