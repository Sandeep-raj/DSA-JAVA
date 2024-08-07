package dynamic_programming.GridDP;

/*
 * Unique Paths
 * 
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down


Constraints:
1 <= m, n <= 100
 */

public class UniquePaths {
    public static int uniqPaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // return uniqRec(m-1, n-1,dp);
        return uniqTab(m, n);
    }

    static int uniqRec(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        int left = 0, right = 0;
        if (m > 0) {
            left = uniqRec(m - 1, n, dp);
        }

        if (n > 0) {
            right = uniqRec(m, n - 1, dp);
        }

        dp[m][n] = left + right;
        return dp[m][n];
    }

    static int uniqTab(int m, int n) {
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            int[] ndp = new int[n];
            ndp[0] = 1;
            for (int j = 1; j < n; j++) {
                ndp[j] = dp[j] + ndp[j - 1];
            }
            dp = ndp;
        }

        return dp[n - 1];
    }
}
