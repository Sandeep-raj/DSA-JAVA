package dynamic_programming.SubsequenceDP;

/*
 * Perfect Sum Problem
 * 
 * Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.
Note: Answer can be very large, so, output answer modulo 109+7.

Input: 
n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.


Input: 
n = 5, arr = [2, 5, 1, 4, 3], sum = 10
Output: 
3
Explanation: 
{2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.



Expected Time Complexity: O(n*sum)
Expected Auxiliary Space: O(n*sum)

Constraints:
1 ≤ n*sum ≤ 106
0 ≤ arr[i] ≤ 106
 */

public class PerfectSum {
    public static int perfectSum(int[] arr, int sum) {
        return count(arr, sum);
    }

    static int count(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for(int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        if(arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= arr[i]) {
                    dp[i][j] += dp[i-1][j-arr[i]];
                }
            }
        }

        return dp[arr.length-1][sum];
    }
}
