package dynamic_programming.AdityaVerma;

/*
 * Subset Sum Problem
 * 
 * Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set whose sum is equal to the given sum. 
 * 
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
Explanation: There is no subset that add up to 30.
 */

public class SubsetSum {
    public static boolean subsetSum(int[] set, int sum) {
        // return subsetRec(set, sum, set.length);
        return subsetTab(set, sum);
    }

    static boolean subsetRec(int[] set, int sum, int n) {
        if(n == 0 || sum == 0) {
            if(sum == 0) {
                return true;
            }else {
                return false;
            }
        }

        if(sum >= set[n-1]) {
            boolean take = subsetRec(set, sum - set[n-1], n-1);
            boolean notake = subsetRec(set, sum, n-1);

            return take || notake;
        }else {
            return subsetRec(set, sum, n-1);
        }
    }

    static boolean subsetTab(int[] set, int sum) {
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for(int i = 0; i < set.length; i++) {
            boolean[] ndp = new boolean[sum+1];
            ndp[0] = true;
            for(int j = 1; j <= sum; j++) { 
                if(j >= set[i]) {
                    ndp[j] = dp[j] | dp[j - set[i]];
                }else {
                    ndp[j] = dp[j];
                }
            }

            dp = ndp;
        }

        return dp[sum];
    }
}
