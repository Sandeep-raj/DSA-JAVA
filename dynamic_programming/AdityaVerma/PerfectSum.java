package dynamic_programming.AdityaVerma;

/*
 * Perfect Sum Problem
 * 
 * Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7.

Examples:

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
        // return sumRec(arr, sum, arr.length);
        return sumTab(arr, sum);
    }

    static int sumRec(int[] arr, int sum, int n) {
        if(n == 0 || sum == 0) {
            if(sum == 0) {
                return 1;
            }else {
                return 0;
            }
        }


        if(sum >= arr[n-1]) {
            int take = sumRec(arr, sum - arr[n-1], n-1);
            int notake = sumRec(arr, sum, n-1);

            return take + notake;
        }else {
            return sumRec(arr, sum, n-1);
        }
    }

    static int sumTab(int[] arr, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;


        for(int i = 0;i < arr.length; i++) {
            int[] ndp = new int[sum+1];
            ndp[0] = 1;
            for(int j = 1; j <= sum; j++) {
                if(j >= arr[i]) {
                    ndp[j] = dp[j] + dp[j - arr[i]];
                }else {
                    ndp[j] = dp[j];
                }
            }

            dp = ndp;
        }

        return dp[sum];
    }
}
