package programs.medium;

/**
 * You are given an N by 2d Matrix of lowercase letters.
 * Your task is to determine the minimum number of columns that need
 * to be removed to ensure that the matrix is lexicographically ordered from top to bottom for each row.
 *
 * In other words, for each column, the letters should be in lexicographical order as you move
 * down the rows. It is not necessary for the rows themselves to be ordered.
 *
 * ================================================================================
 * To solve this problem, we need to determine the minimum number of columns to remove so that each remaining column is in lexicographical order from top to bottom. The approach here is to iterate through each column, check if it’s already lexicographically sorted, and, if not, mark it for removal.
 *
 * Solution Approach
 * Iterate Through Columns: For each column, check if the characters from top to bottom are in non-decreasing (lexicographical) order.
 * Count Columns to Remove: If a column isn’t in lexicographical order, increment a counter to track the number of columns that need to be removed.
 * Complexity
 * Time Complexity:
 * 𝑂
 * (
 * 𝑁
 * ×
 * 𝑀
 * )
 * O(N×M), where
 * 𝑁
 * N is the number of rows and
 * 𝑀
 * M is the number of columns.
 * Space Complexity:
 * 𝑂
 * (
 * 1
 * )
 * O(1), since we only need a counter for columns to remove.
 *
 * Explanation
 * Loop Through Columns: For each column, we check if each character in the column is lexicographically greater than or equal to the character above it.
 * Remove Columns If Necessary: If we find any column that is not sorted, we increment the columnsToRemove counter and break out of the inner loop, moving to the next column.
 * Return Result: Finally, we return the count of columns to remove.
 * Example
 * For the input matrix:
 *
 * plaintext
 * Copy code
 * abc
 * bce
 * cae
 * The output would be 1 since removing the third column ensures all remaining columns are lexicographically ordered from top to bottom.
 * */

public class Lexicographical {
    public static int minColumnsToRemove(String[] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length();
        int columnsToRemove = 0;

        // Iterate through each column
        for (int col = 0; col < cols; col++) {
            for (int row = 1; row < rows; row++) {
                // Check if the current column is lexicographically sorted
                if (matrix[row].charAt(col) < matrix[row - 1].charAt(col)) {
                    columnsToRemove++;
                    break; // Move to the next column as this one is not sorted
                }
            }
        }

        return columnsToRemove;
    }

    public static void main(String[] args) {
        String[] matrix = {"abc", "bce", "cae"};
        System.out.println("Minimum columns to remove: " + minColumnsToRemove(matrix));
    }
}

