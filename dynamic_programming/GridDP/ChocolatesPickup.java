package dynamic_programming.GridDP;

/*
 * Chocolates Pickup
 * 
 * You are given an n rows and m cols matrix grid representing a field of chocolates where grid[i][j] represents the number of chocolates that you can collect from the (i, j) cell.

You have two robots that can collect chocolates for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of chocolates collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the chocolates.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.

Input:
n = 4, m = 3
grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output:
24
Explanation:
Path of robot #1 and #2 are described in color green and blue respectively. Chocolates taken by Robot #1, (3 + 2 + 5 + 2) = 12. Chocolates taken by Robot #2, (1 + 5 + 5 + 1) = 12. Total of Chocolates: 12 + 12 = 24.


Expected Time Complexity: O(n * m * m)
Expected Space Complexity: O(n * m * m)

Constraint:
2 <= n < = 70
0 <= grid[i][j] <= 100
 */

public class ChocolatesPickup {
    static int[] move = new int[]{-1,0,1};
    public static int pickup(int[][] grid, int r, int c) {
        int[][][] dp = new int[r][c][c];
        return pickRec(grid, 0, 0, c-1, r, c, dp);
    }

    static int pickRec(int[][] grid, int i, int j1, int j2, int r, int c, int[][][] dp) {
        if(j1 < 0 || j1 >= c || j2 < 0 || j2 >=c) {
            return Integer.MIN_VALUE;
        }

        if(i == r-1) {
            if(j1 == j2) {
                return grid[i][j1];
            }else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2] != 0) {
            return dp[i][j1][j2];
        }


        int max = Integer.MIN_VALUE;
        for(int x1 : move) {
            for(int x2 : move) {
                max = Math.max(max, pickRec(grid, i+1, j1 - x1, j2 - x2, r, c, dp));
            }
        }

        if(j1 == j2) {
            dp[i][j1][j2] = grid[i][j1] + max;
        }else {
            dp[i][j1][j2] = grid[i][j1] + grid[i][j2] + max;
        }

        return dp[i][j1][j2];
    }

    // static int pickTab(int[][] grid, int r, int c) {
    //     int[][] dp = new int[c][c];

    //     for(int i = 0; i < c; i++) {
    //         for(int j = 0; j < c; j++) {
    //             if( i == j ){
    //                 dp[i][j] = grid[r-1][j];
    //             }else {
    //                 dp[i][j] = grid[r-1][i] + grid[r-1][j];
    //             }
    //         }
    //     }

    //     for(int i = r-2; i >= 0; i--) {
    //         int[][] ndp = new int[c][c];
    //         for(int j = 0; j < c; j++) {
    //             for(int k = 0; k < c; k++) {
                    

    //                 for(int x1 : move) {
    //                     for(int x2 : move) {

    //                     }
    //                 }

    //             }
    //         }
    //     }

    // }
}
