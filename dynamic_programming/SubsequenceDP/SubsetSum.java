package dynamic_programming.SubsequenceDP;

/*
 * Subset Sum Problem
 * 
 * Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 
 * 
 * Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 9
Output: 1 
Explanation: Here there exists a subset with
sum = 9, 4+3+2 = 9.


Input:
N = 6
arr[] = {3, 34, 4, 12, 5, 2}
sum = 30
Output: 0 
Explanation: There is no subset with sum 30.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function isSubsetSum() which takes the array arr[], its size N and an integer sum as input parameters and returns boolean value true if there exists a subset with given sum and false otherwise.
The driver code itself prints 1, if returned value is true and prints 0 if returned value is false.
 

Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum*N)
 

Constraints:
1 <= N <= 100
1<= arr[i] <= 100
1<= sum <= 104
 */

public class SubsetSum {
    public static boolean subsetsum(int[] arr, int sum) {
        // return sum(arr.length - 1, sum, arr);
        return sumTab(arr, sum);
    }

    static boolean sum(int n, int sum, int[] arr) {
        if(sum == 0) {
            return true;
        }

        if(n == 0) {
            return arr[n] == sum;
        }

        boolean take = false;
        boolean notake = sum(n-1, sum, arr);

        if(sum >= arr[n]) {
            take = sum(n-1, sum - arr[n], arr);
        }

        return take | notake;
    } 

    static boolean sumTab(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length][sum+1];
        for(int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= arr[i]) {
                    dp[i][j] |= dp[i-1][j - arr[i]];
                }
            }
        }

        return dp[arr.length - 1][sum];
    }
}
