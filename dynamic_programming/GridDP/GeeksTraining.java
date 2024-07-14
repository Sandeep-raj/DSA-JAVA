package dynamic_programming.GridDP;

/*
 * Geek's Training
 * 
 * Geek is going for n day training program. He can perform any one of these three activities Running, Fighting, and Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. Help Geek to maximize his merit points as you are given a 2D array of points points, corresponding to each day and activity.
 * 
 * Example:
Input:
n = 3
points = [[1,2,5],[3,1,1],[3,3,3]]
Output:
11
Explanation:
Geek will learn a new move and earn 5 point then on second
day he will do running and earn 3 point and on third day
he will do fighting and earn 3 points so, maximum point is 11.


Example:
Input:
n = 3
points = [[1,2,5],[3,1,1],[3,2,3]]
Output:
11
Explanation:
Geek will learn a new move and earn 5 point then on second
day he will do running and earn 3 point and on third day
he will do running and earn 3 points so, maximum point is 11.


Your Task:
You don't have to read input or print anything. Your task is to complete the function maximumPoints() which takes the integer n and a 2D array points and returns the maximum points he can earn.

Expected Time Complexity: O(3*n)
Expected Space Complexity: O(3*n)

Constraint:
1 <=  n <= 105
1 <=  point[i] <= 100
 */

public class GeeksTraining {
    public static int training(int n, int[][] points) {
        // int[][] dp = new int[n][points[0].length + 1];
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < points[0].length + 1; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // return trainRec(n-1, points[0].length, points, dp);

        return trainTab(n, points);
    }

    static int trainRec(int n, int last, int[][] points, int[][] dp) {
        if(n == 0) {
            int max = 0;
            for(int i = 0; i < points[0].length; i++) {
                if(i != last) {
                    max = Math.max(max, points[n][i]);
                }
            }

            dp[n][last] = max;
            return max;
        }

        if(dp[n][last] != -1) {
            return dp[n][last];
        }

        int max  = 0;
        for(int i = 0; i < points[0].length; i++) {
            if(i != last) {
                max = Math.max(max, points[n][i] + trainRec(n-1, i, points, dp));
            }
        }
        dp[n][last] = max;
        return max;
    }

    static int trainTab(int n, int[][] points) {
        int[] dp = new int[points[0].length + 1];

        for(int i = 0; i < points[0].length + 1 ; i++) {
            int max = 0;
            for(int j = 0; j < points[0].length; j++) {
                if(i != j) {
                    max = Math.max(max, points[0][j]);
                }
            }
            dp[i] = max;
        }

        int[] ndp = new int[points[0].length + 1];
        for(int i = 1; i < n; i++) {
            ndp = new int[points[0].length + 1];
            for(int j = 0; j < points[0].length; j++) {
                ndp[j] = dp[j] + points[i][j];
            }
            dp = ndp;
        }

        int max = 0;
        for(int i = 0; i < points[0].length + 1; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
