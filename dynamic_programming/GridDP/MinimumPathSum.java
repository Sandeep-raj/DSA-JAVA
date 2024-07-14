package dynamic_programming.GridDP;

/*
 * Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.


Input: grid = [[1,2,3],[4,5,6]]
Output: 12


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
 */

public class MinimumPathSum {
    public static int minPath(int[][] grid) {
        // int[][] dp = new int[grid.length][grid[0].length];
        // return pathRec(grid, grid.length - 1, grid[0].length - 1, dp);

        return pathTab(grid);
    }

    static int pathRec(int[][] grid, int n, int m, int[][] dp) {
        if(n == 0 && m == 0) {
            return grid[n][m];
        }

        if(dp[n][m] != 0) {
            return dp[n][m];
        }

        int min = Integer.MAX_VALUE;
        if(n > 0) {
            min = Math.min(pathRec(grid, n-1, m, dp), min);
        }

        if(m > 0) {
            min = Math.min(pathRec(grid, n, m-1, dp), min);
        }

        dp[n][m] = min + grid[n][m];
        return dp[n][m];
    }

    static int pathTab(int[][] grid) {
        int n = grid[0].length;
        int[] dp = new int[n];
        int x = 0;
        for(int i = 0; i < n; i++ ){
            dp[i] = x + grid[0][i];
            x = dp[i];
        }

        for(int i = 1; i < grid.length; i++) {
            int[] ndp = new int[n];
            ndp[0] = grid[i][0];
            for(int j = 1; j < n; j++) {
                ndp[j] = Math.min(ndp[j-1], dp[j]) + grid[i][j];
            }
            dp = ndp;
        }

        return dp[n-1];
    }
}
