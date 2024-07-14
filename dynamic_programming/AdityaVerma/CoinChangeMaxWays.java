package dynamic_programming.AdityaVerma;

/*
 * Coin change problem: Maximum number of ways
 * 
 * Given an integer array of coins[ ] of size N representing different types of denominations and an integer sum, the task is to count all combinations of coins to make a given value sum.  
Note: Assume that you have an infinite supply of each type of coin. 

Input: sum = 4, coins[] = {1,2,3}, 
Output: 4
Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}. 

Input: sum = 10, coins[] = {2, 5, 3, 6}
Output: 5
Explanation: There are five solutions: 
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */

public class CoinChangeMaxWays {
    public static int maxWays(int[] coins, int sum) {
        // return maxRec(coins, sum, coins.length);
        return maxTab(coins, sum);
    }

    static int maxRec(int[] coins, int sum, int n) {
        if(n == 0 || sum == 0) {
            if(sum == 0) {
                return 1;
            }
            return 0;
        }

        if(sum >= coins[n-1]) {
            int take = maxRec(coins, sum - coins[n-1], n);
            int notake = maxRec(coins, sum, n-1);

            return take + notake;
        }else {
            return maxRec(coins, sum, n-1);
        }
    }

    static int maxTab(int[] coins, int sum) {
        int[] dp =  new int[sum+1];
        dp[0] = 1;

        for(int i = 0; i < coins.length; i++) {
            int[] ndp = new int[sum+1];
            ndp[0] = 1;
            for(int j = 1; j <= sum; j++) {
                if(j >= coins[i]) {
                    ndp[j] = dp[j] + ndp[j - coins[i]];
                }else {
                    ndp[j] = dp[j];
                }
            }
            dp = ndp;
        }

        return dp[sum];
    }
}
