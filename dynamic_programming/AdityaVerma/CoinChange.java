package dynamic_programming.AdityaVerma;

/*
 * Coin Change
 * 
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 * 
 */

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 1; i <= amount; i++) {
            dp[i] = 1000000;
        }

        for(int i = 0; i < coins.length; i++) {
            int[] ndp = new int[amount+1];
            for(int j = 1; j <= amount; j++) {
                ndp[j] = 1000000;
                if(j >= coins[i]) {
                    ndp[j] = Integer.min(dp[j], 1 + ndp[j - coins[i]]);
                }else {
                    ndp[j] = dp[j];
                }
            }
            dp = ndp;
        }

        return dp[amount];
        // return coinChgRec(coins, amount, coins.length);
    }

    static int coinChgRec(int[] coins, int amount, int n) {
        if(n == 0 || amount == 0) {
            if(amount == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }

        if(amount >= coins[n-1] ) {
            int take = 1 + coinChgRec(coins, amount - coins[n-1], n);
            int notake = coinChgRec(coins, amount, n - 1);

            return Math.min(take, notake);
        }else {
            return coinChgRec(coins, amount, n-1);
        }
    }
}
