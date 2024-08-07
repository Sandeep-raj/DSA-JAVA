package dynamic_programming.OneDimensional;

/*
 * House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:x
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

public class HouseRobber {
    public static int rob(int[] nums) {
        // int[] dp = new int[nums.length + 1];
        // return robberRec(nums.length - 1, nums, dp);
        return robberTab(nums);
    }
    
    static int robberRec(int n, int[] nums, int[] dp) {
        if(n == 0){
            return nums[n];
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int max = Integer.MIN_VALUE;
        max = Math.max(max, robberRec(n-1, nums, dp));
        if(n > 1) {
            max = Math.max(max, nums[n] + robberRec(n-2, nums, dp));
        }

        dp[n] = max;
        return max;
    }

    static int robberTab(int[] nums) {
        int prev2 = nums[0];
        int prev = nums[1];
        
        for(int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev, prev2 + nums[i]);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}


