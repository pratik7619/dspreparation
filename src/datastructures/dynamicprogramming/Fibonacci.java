package datastructures.dynamicprogramming;

public class Fibonacci {

    static Integer[] memo = new Integer[100];

    static int fib(int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        if (n == 0 || n == 1) return n;
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    static int fibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int index = 2; index <= n; index++) {
            fib[index] = fib[index - 1] + fib[index-2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
}
