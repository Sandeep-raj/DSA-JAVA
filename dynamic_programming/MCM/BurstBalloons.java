package dynamic_programming.MCM;

/*
 * Burst Balloons
 * 
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10
 

Constraints:

n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100
 */

public class BurstBalloons {
    public static int burst(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            arr[i+1] = nums[i];
        }
        arr[nums.length+1] = 1;

        // return solve(arr, 1, nums.length);
        return solveTab(arr, nums.length);
    }

    static int solve(int[] nums, int i, int j) {
        if(i > j) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++) {
            max = Math.max(max, nums[i-1] * nums[k] * nums[j+1] + solve(nums, i, k-1) + solve(nums, k+1, j));
        }

        return max;
    }

    static int solveTab(int[] nums, int n) {
        int[][] dp = new int[n+2][n+2];

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= n; j++) {
                if(i > j) {
                    continue;
                }

                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    max = Math.max(max, nums[i-1]*nums[k]*nums[j+1] + dp[i][k-1] + dp[k+1][j]);
                }

                dp[i][j]= max;
            }
        }

        return dp[1][n];
    }
}
