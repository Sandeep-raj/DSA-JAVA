package dynamic_programming.AdityaVerma;

/*
 * 0/1 Knapsack Problem
 * 
 * Given N items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 
Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].

Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0
 */

public class KnapSack01 {
    public static int knapsack(int[] profit, int[] wt, int W) {
        // int[][] dp  = new int[wt.length+1][W+1];
        // return knapsackRec(W, profit, wt, wt.length, dp);
        return knapsackTab(W, profit, wt);
    }

    static int knapsackRec(int W, int[] profit, int[] wt, int n, int[][] dp) {
        if(n == 0 || W == 0) {
            return 0;
        }

        if(dp[n][W] != 0) {
            return dp[n][W];
        }

        if(wt[n-1] <= W) {
            int take = profit[n-1] + knapsackRec(W - wt[n-1], profit, wt, n-1, dp);
            int notake = knapsackRec(W, profit, wt, n-1, dp);

            dp[n][W] = Math.max(take, notake);
            return dp[n][W];
        }else {
            dp[n][W] = knapsackRec(W, profit, wt, n-1, dp);
            return dp[n][W];
        }
    }

    static int knapsackTab(int W, int[] profit, int[] wt) {
        int[] dp = new int[W+1];

        for(int i =0; i < wt.length; i++) {
            int[] ndp = new int[W+1];
            for(int j = 1; j <= W; j++) {
                if(j >= wt[i]) {
                    ndp[j] = Math.max(profit[i] + dp[j-wt[i]], dp[j]);
                }else {
                    ndp[j] = dp[j];
                }
            }
            dp = ndp;
        }

        return dp[W];
    }
}
