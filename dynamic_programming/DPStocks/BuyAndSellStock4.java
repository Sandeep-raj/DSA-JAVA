package dynamic_programming.DPStocks;

/*
 *  Best Time to Buy and Sell Stock IV
 * 
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again)

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:

1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000
 */

public class BuyAndSellStock4 {
    public static int maxprof(int k, int[] prices) {
        // return solve(prices, 1, 1, k);
        return solveTab(prices, k);
    }

    static int solveTab(int[] prices, int k) {
        int[][][] dp = new int[prices.length+1][k+1][2];

        for(int day = prices.length-1; day >= 0; day--) {
            for(int tx = 1; tx <= k ; tx++) {
                dp[day][tx][1] = Math.max(-1 * prices[day] + dp[day+1][tx][0], dp[day+1][tx][1]);
                dp[day][tx][0] = Math.max(prices[day] + dp[day+1][tx-1][1], dp[day+1][tx][0]);
            }
        }

        return dp[0][k][1];
    }

    static int solve(int[] prices, int day ,int buy, int tx) {
        if(tx == 0) {
            return 0;
        }

        if(day > prices.length) {
            return 0;
        }

        if(buy == 1) {
            return Math.max(-1 * prices[day-1] + solve(prices, day+1, 0, tx), solve(prices, day+1, 1, tx));
        }else {
            return Math.max(prices[day-1] + solve(prices, day+1, 1, tx-1), solve(prices, day+1, 0, tx));
        }
    }
}
