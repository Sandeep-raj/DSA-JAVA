package dynamic_programming.LIS;

/*
 * Number of Longest Increasing Subsequence
 * 
 * Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
 */

public class NumberLIS {
    public static int countLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];

        dp[0] = 1;
        count[0] = 1;

        int max  = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    }else if(dp[i] == 1 + dp[j]) {
                        count[i] = count[i] + count[j];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }


        int nos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(max == dp[i]) {
                nos += count[i];
            }
        }
        return nos;
    }
}
