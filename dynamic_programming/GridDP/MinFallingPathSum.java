package dynamic_programming.GridDP;

/*
 * Minimum Falling Path Sum
 * 
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
 */

public class MinFallingPathSum {
    public static int minSum(int[][] mat) {
        int r = mat.length, c = mat[0].length;

        // int[][] dp = new int[r][c];

        // int min = Integer.MAX_VALUE;
        // for(int i = 0; i < c; i++) {
        //     min = Math.min(min, sumRec(mat, r-1, i, c, dp));
        // }
        // return min;

        return sumTab(mat, r, c);
    }

    static int sumRec(int[][] mat, int x, int y, int c, int[][] dp) {
        if(y < 0 || y >= c) {
            return Integer.MAX_VALUE;
        }

        if(x == 0) {
            return mat[x][y];
        }

        if(dp[x][y] != 0) {
            return dp[x][y];
        }

        int min = Integer.MAX_VALUE;
        min = Math.min(min, sumRec(mat, x-1, y-1, c, dp));
        min = Math.min(min, sumRec(mat, x-1, y, c, dp));
        min = Math.min(min, sumRec(mat, x-1, y+1, c, dp));

        dp[x][y] = min + mat[x][y];

        return dp[x][y];
    }

    static int sumTab(int[][] mat, int r, int c) {
        int[] dp = new int[c];

        for(int i = 0; i < c; i++) {
            dp[i] = mat[0][i];
        }

        for(int i = 1; i < r; i++) {
            int[] ndp = new int[c];

            for(int j = 0; j < c; j++) {
                int min = Integer.MAX_VALUE;

                if(j > 0) {
                    min = Math.min(dp[j-1] + mat[i][j], min);
                }
                min = Math.min(dp[j] + mat[i][j], min);
                if(j < c-1) {
                    min = Math.min(dp[j+1] + mat[i][j], min);
                }
                ndp[j] = min;
            }

            dp = ndp;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < c; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }
}
