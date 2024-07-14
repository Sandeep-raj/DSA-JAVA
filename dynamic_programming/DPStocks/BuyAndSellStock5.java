package dynamic_programming.DPStocks;

/*
 * Best Time to Buy and Sell Stock with Cooldown
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 */

public class BuyAndSellStock5 {
    public static int maxProf(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        return solve(prices, 1, 1, dp);
    }

    static int solve(int[] prices, int day, int buy, int[][] dp) {

        if(day > prices.length) {
            return 0;
        }

        if(dp[day][buy] != 0) {
            return dp[day][buy];
        }

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-1 * prices[day-1] + solve(prices, day+1, 0, dp), solve(prices, day+1, 1, dp));
        }else {
            profit = Math.max(prices[day - 1] + solve(prices, day+2, 1, dp), solve(prices, day+1, 0, dp));
        }

        dp[day][buy] = profit;
        return profit;
    }
}