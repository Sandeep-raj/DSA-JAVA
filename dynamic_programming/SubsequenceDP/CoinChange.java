package dynamic_programming.SubsequenceDP;

/*
 * Coin Change
 * 
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output: -1

Input: coins = [1], amount = 0
Output: 0

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // return changeRec(coins, amount, coins.length - 1);
        return changeTab(coins, amount);
    }

    static int changeRec(int[] coins, int amount, int n) {
        if(n == 0) {
            if(amount % coins[n] == 0) {
                return amount/coins[n];
            }else {
                return 1000000;
            }
        }

        int notake = changeRec(coins, amount, n-1);
        int take = 1000000;
        if(amount >= coins[n]) {
            take = 1 + changeRec(coins, amount - coins[n], n);
        }

        return Math.min(notake, take);
    }

    static int changeTab(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0; i <= amount; i++) {
            if(i%coins[0] == 0) {
                dp[i] = i/coins[0];
            }else {
                dp[i] = 10000000;
            }
        }

        for(int i = 1; i < coins.length; i++) {
            int[] ndp = new int[amount+1];
            for(int j = 1; j <= amount; j++) {
                ndp[j] = dp[j];
                if(j >= coins[i]) {
                    ndp[j] = Math.min(ndp[j], 1 + ndp[j - coins[i]]);
                }
            }
            dp = ndp;
        }

        return dp[amount];
    }
}
