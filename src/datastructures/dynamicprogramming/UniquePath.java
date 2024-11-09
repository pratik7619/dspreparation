package datastructures.dynamicprogramming;

public class UniquePath {

    static int uniquePath(int m, int n) {

        // Initialize DP table with dimensions m x n
        int[][] dp = new int[m][n];

        // Fill the first row and first column with 1s
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the result in the bottom-right corner
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePath(3, 7)); // Output: 28
    }
}
