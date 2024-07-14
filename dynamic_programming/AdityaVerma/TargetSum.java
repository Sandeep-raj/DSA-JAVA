package dynamic_programming.AdityaVerma;

/*
 * Target Sum
 * 
 * Given an array arr[] of length N and an integer target. You want to build an expression out of arr[] by adding one of the symbols ‘+‘ and ‘–‘ before each integer in arr[] and then concatenate all the integers. Return the number of different expressions that can be built, which evaluates to target.
 * 
 * Input : N = 5, arr[] = {1, 1, 1, 1, 1}, target = 3
Output: 5
Explanation:
There are 5 ways to assign symbols to
make the sum of array be target 3.

-1 + 1 + 1 + 1 + 1 = 3
+1 – 1 + 1 + 1 + 1 = 3
+1 + 1 – 1 + 1 + 1 = 3
+1 + 1 + 1 – 1 + 1 = 3
+1 + 1 + 1 + 1 – 1 = 3

Input: N = 1, arr[] = {1}, target = 1
Output: 1
 */

public class TargetSum {
    public static int count(int[] arr, int target) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }

        int partSum = (sum + target)/2;

        int[] dp = new int[partSum+1];
        dp[0] = 1;

        for(int i = 0; i < arr.length; i++) {
            int[] ndp = new int[partSum+1];
            ndp[0] = 1;
            for(int j = 1; j <= partSum; j++) {
                if(j >= arr[i]) {
                    ndp[j] = dp[j] + dp[j - arr[i]];
                }else {
                    ndp[j] = dp[j];
                }
            }

            dp = ndp;
        }

        return dp[partSum];
    }
}
