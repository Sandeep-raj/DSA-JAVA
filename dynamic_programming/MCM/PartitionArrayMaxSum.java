package dynamic_programming.MCM;

/*
 * Partition Array for Maximum Sum
 * 
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]
Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83
Example 3:

Input: arr = [1], k = 1
Output: 1
 

Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 109
1 <= k <= arr.length
 */

public class PartitionArrayMaxSum {
    public static int maxSum(int[] arr, int k) {
        // return solve(arr, 0, k);
        return solveTab(arr, k);
    }

    static int solve(int[] arr, int i, int k) {
        if(i == arr.length){
            return 0;
        }

        int currmax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(i+k, arr.length); j++) {
            currmax = Math.max(currmax, arr[j]);
            max = Math.max(max, currmax*(j-i+1) + solve(arr, j+1, k));
        }

        return max;
    }

    static int solveTab(int[] arr, int k) {
        int[] dp = new int[arr.length+1];

        for(int i = arr.length-1; i >= 0; i--) {
            int currmax = Integer.MIN_VALUE, max = Integer.MIN_VALUE, len = 0;
            for(int j = i; j < Math.min(i+k, arr.length); j++){
                len++;
                currmax = Math.max(currmax, arr[j]);

                max = Math.max(max, (currmax * len) + dp[j+1]);
            }
            dp[i] = max;
        }

        return dp[0];
    }
}
