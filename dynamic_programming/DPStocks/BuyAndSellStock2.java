package dynamic_programming.DPStocks;

/*
 * Best Time to Buy and Sell Stock II
 * 
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */

public class BuyAndSellStock2 {
    public static int maxProf(int[] prices) {
        // return solve(prices, 1, 1);
        // return solveTab(prices);
        return solveOpt(prices);
    }

    static int solveOpt(int[] prices) {
        int[] ahead = new int[2];

        for(int i = prices.length-1; i >= 0; i--) {
            int[] curr = new int[2];
            curr[1] = Math.max(-1*prices[i] + ahead[0], ahead[1]);
            curr[0] = Math.max(prices[i] + ahead[1], ahead[0]);

            ahead = curr;
        }

        return ahead[1];
    }

    static int solveTab(int[] prices) {
        int[][] dp = new int[prices.length+1][2];

        for(int i = prices.length-1; i >= 0; i--) {
            for(int j = 0; j <= 1; j++) {
                if(j == 1) {
                    dp[i][j] = Math.max(-1* prices[i] + dp[i+1][0], dp[i+1][1]);
                }else {
                    dp[i][j] = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }

    static int solve(int[] prices, int day, int buy) {
        if(day > prices.length) {
            return 0;
        }

        if(buy == 1) {
            return Math.max(-1 * prices[day-1] + solve(prices, day+1, 0), solve(prices, day+1, 1));
        }else {
            return Math.max(prices[day - 1] + solve(prices, day+1, 1), solve(prices, day+1, 0));
        }
    }
}
