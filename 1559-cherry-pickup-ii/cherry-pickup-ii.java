import java.util.*;

class Solution {

    int solve(int row, int col1, int col2,
              int[][] grid, int n, int m, int[][][] dp) {

        // Out of bounds
        if (col1 < 0 || col1 >= m ||
            col2 < 0 || col2 >= m) {
            return Integer.MIN_VALUE;
        }

        // Last row
        if (row == n - 1) {

            if (col1 == col2) {
                return grid[row][col1];
            }

            return grid[row][col1] + grid[row][col2];
        }

        // Already calculated
        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        // Current row cherries
        int cherry = grid[row][col1];

        if (col1 != col2) {
            cherry += grid[row][col2];
        }

        int maxi = Integer.MIN_VALUE;

        // 9 possibilities
        for (int i = -1; i < 2; i++) {

            for (int j = -1; j < 2; j++) {

                maxi = Math.max(
                    maxi,
                    solve(
                        row + 1,
                        col1 + i,
                        col2 + j,
                        grid,
                        n,
                        m,
                        dp
                    )
                );
            }
        }

        // Store answer
        return dp[row][col1][col2] = cherry + maxi;
    }

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, m - 1, grid, n, m, dp);
    }
}