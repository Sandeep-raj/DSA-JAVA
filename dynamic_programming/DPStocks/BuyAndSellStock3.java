package dynamic_programming.DPStocks;

/*
 * Best Time to Buy and Sell Stock III
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105
 */

public class BuyAndSellStock3 {
    public static int maxProf(int[] prices) {
        // int[][][] dp = new int[prices.length + 1][2][3];
        // return solve(prices, 1, 1, 2, dp);
        return solveTab(prices);
    }

    static int solveTab(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];

        for (int day = prices.length - 1; day >= 0; day--) {
            for (int tx = 2; tx > 0; tx--) {
                dp[day][1][tx] = Math.max(-1 * prices[day] + dp[day + 1][0][tx], dp[day + 1][1][tx]);
                dp[day][0][tx] = Math.max(prices[day] + dp[day + 1][1][tx - 1], dp[day + 1][0][tx]);
            }
        }

        return dp[0][1][2];
    }

    static int solve(int[] prices, int day, int buy, int tx, int[][][] dp) {
        if (tx == 0) {
            return 0;
        }
        if (day > prices.length) {
            return 0;
        }

        if (dp[day][buy][tx] != 0) {
            return dp[day][buy][tx];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-1 * prices[day - 1] + solve(prices, day + 1, 0, tx, dp),
                    solve(prices, day + 1, 1, tx, dp));
        } else {
            profit = Math.max(prices[day - 1] + solve(prices, day + 1, 1, tx - 1, dp),
                    solve(prices, day + 1, 0, tx, dp));
        }

        dp[day][buy][tx] = profit;
        return profit;
    }
}
