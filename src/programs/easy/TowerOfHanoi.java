package programs.easy;

public class TowerOfHanoi {

    static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 0) return;

        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disc " + n + " from rod " + fromRod + " to rod " + toRod);
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'C', 'B');
    }
}
