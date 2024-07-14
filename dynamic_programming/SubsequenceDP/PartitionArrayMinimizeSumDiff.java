package dynamic_programming.SubsequenceDP;

/*
 * Partition Array Into Two Arrays to Minimize Sum Difference
 * 
 * You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
Return the minimum possible absolute difference.

Input: nums = [3,9,7,3]
Output: 2
Explanation: One optimal partition is: [3,9] and [7,3].
The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.

Input: nums = [-36,36]
Output: 72
Explanation: One optimal partition is: [-36] and [36].
The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.


Input: nums = [2,-1,0,4,-2,-9]
Output: 0
Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.

Constraints:

1 <= n <= 15
nums.length == 2 * n
-107 <= nums[i] <= 107
 */

public class PartitionArrayMinimizeSumDiff {
    public static int minDiff(int[] nums) {
        int sum = 0;
        for(int x : nums) {
            sum += x;
        }

        int mid = sum/2;
        int partSum = partition(nums, mid);
        int nextSum = sum - partSum;
        return nextSum - partSum;
    }

    static int partition(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target+1];

        for(int i = 0 ; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j < target+1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i]) {
                    dp[i][j] |= dp[i-1][j - nums[i]];
                }
            }
        }

        for(int i = target; i >= 0; i--) {
            if(dp[nums.length-1][i]) {
                return i;
            }
        }
        return -1;
    }
}
