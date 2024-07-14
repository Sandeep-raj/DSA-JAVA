package dynamic_programming.LIS;

import java.util.Arrays;

/*
 * Longest Increasing Subsequence
 * 
 * Given an integer array nums, return the length of the longest strictly increasing subsequence
Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 */

public class LongestIncreasingSubsequence {
    public static int lis(int[] nums) {
        // int[][] dp = new int[nums.length][nums.length+1];
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j <= nums.length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // return solve(nums, 0, -1, dp);
        // return solveTab(nums);
        return solveOpt(nums);
    }

    static int solveTab(int[] nums) {
        int[] dp = new int[nums.length+1];

        for(int i = nums.length-1; i >= 0; i--) {
            int[] ndp = new int[nums.length + 1];
            for(int j = i - 1; j >= -1; j--) {
                int len = dp[j+1];
                if(j == -1 || nums[i] > nums[j]) {
                    len = Math.max(len, 1 + dp[i+1]);
                }
                ndp[j+1] = len;
            }
            dp = ndp;
        }

        return dp[0];
    }

    static int solve(int[] nums, int idx, int prev_idx, int[][] dp) {
        if(idx == nums.length) {
            return 0;
        }

        if(dp[idx][prev_idx+1] != -1) {
            return dp[idx][prev_idx+1];
        }

        int len = solve(nums, idx+1, prev_idx, dp); // notake
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]) {
            len = Math.max(len, 1 + solve(nums, idx+1, idx, dp)); //take
        }

        dp[idx][prev_idx+1] = len;

        return len;
    }

    static int solveOpt(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
