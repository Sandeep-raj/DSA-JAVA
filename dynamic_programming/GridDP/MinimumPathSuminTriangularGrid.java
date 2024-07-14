package dynamic_programming.GridDP;

/*
 * Minimum path sum in Triangular Grid
 * 
 * Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 */

public class MinimumPathSuminTriangularGrid {
    public static int minPath(int[][] grid) {
        // int[][] dp = new int[grid.length][grid[grid.length - 1].length];
        // return pathRec(grid, 0, 0, dp);

        return pathTab(grid);
    }

    static int pathRec(int[][] grid, int n, int m, int[][] dp) {
        if(n == grid.length - 1) {
            return grid[n][m];
        }

        if(dp[n][m] != 0) {
            return dp[n][m];
        }

        int min = pathRec(grid, n+1, m+1, dp);
        min = Math.min(min, pathRec(grid, n+1, m, dp));
        
        dp[n][m] = min + grid[n][m];

        return dp[n][m];
    }

    static int pathTab(int[][] grid) {
        int n = grid[grid.length - 1].length;
        int[] dp =  new int[n];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = grid[grid.length - 1][i];
        }

        for(int i = grid.length - 2; i >= 0; i--) {
            int[] ndp = new int[n];
            for(int j = 0; j <= i; j++) {
                ndp[j] = Math.min(dp[j] + grid[i][j], dp[j+1] + grid[i][j]);
            }
            dp = ndp;
        }

        return dp[0];
    }
}
