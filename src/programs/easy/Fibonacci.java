package programs.easy;

public class Fibonacci {

    static int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibEfficient(int n) {
        if (n == 0) return 0;
        else if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fibEfficient(10));
    }
}
