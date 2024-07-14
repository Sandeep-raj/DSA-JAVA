package dynamic_programming.SubsequenceDP;

/*
 * Partition Equal Subset Sum
 * 
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * 
 * Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */

public class PartitionEqualSubsetSum {
    public static boolean eqPart(int[] nums) {
        int sum = 0;
        for(int x : nums) {
            sum += x;
        }
        if(sum % 2 == 1) {
            return false;
        }else {
            int mid = sum/2;
            int[][] dp = new int[nums.length][mid+1];
            return subsetRec(nums, mid, nums.length-1, dp);
        }
    }

    static boolean subset(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length][sum+1];
        for(int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;

        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < sum+1;j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= arr[i]) {
                    dp[i][j] |= dp[i-1][j-arr[i]];
                }
            }
        }

        return dp[arr.length-1][sum];
    }

    static boolean subsetRec(int[] arr, int sum, int n, int[][] dp) {
        if(sum == 0){
            return true;
        }

        if(n == 0){
            return arr[n] == sum;
        }

        if(dp[n][sum] != 0) {
            if(dp[n][sum] == 1) {
                return true;
            }else {
                return false;
            }
        }

        boolean notake = subsetRec(arr, sum, n-1, dp);
        boolean take = false;
        if(sum >= arr[n]) {
            take = subsetRec(arr, sum - arr[n], n-1, dp);
        }

        if(take | notake){
            dp[n][sum] = 1;
        }else {
            dp[n][sum] = -1;
        }
        return take | notake;
    }
}
