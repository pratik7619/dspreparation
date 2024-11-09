package leetcode.top75;

public class CanPlaceFlowers {

    static boolean canPlaceFlower(int[] flowerBed, int n) {
        int count = 0;

        for (int i = 0; i < flowerBed.length; i++) {
            if (flowerBed[i] == 0) {

                int prev = (i == 0 || flowerBed[i - 1] == 0) ? 0 : 1;
                int next = (i == flowerBed.length - 1 || flowerBed[i + 1] == 0) ? 0 : 1;

                if (prev == 0 && next == 0) {
                    flowerBed[i] = 1;
                    count++;
                }
            }

            if (count>=n) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(
                canPlaceFlower(new int[]{1,0,0,0,1}, 1)
        );

        System.out.println(
                canPlaceFlower(new int[]{1,0,0,0,1}, 2)
        );
    }
}
