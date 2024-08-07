package dynamic_programming.SubsequenceDP;

/*
 * 0 - 1 Knapsack Problem
 * 
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or dont pick it (0-1 property).

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3. 

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).


Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000
 * 
 */

public class Knapsack01 {
    public static int sack(int W, int[] wt, int[] val) {
        // return sack01(W, wt, val, wt.length-1);
        return sackTab(W, wt, val);
    }

    static int sack01(int W, int[] wt, int[] val, int n) {
        if(n == 0) {
            if(W >= wt[n]) {
                return val[n];
            }else{
                return 0;
            }
        }

        int notake = sack01(W, wt, val, n-1);
        int take = 0;
        if(wt[n] <= W){
            take = val[n] + sack01(W-wt[n], wt, val, n-1);
        }

        return Math.max(take,notake);
    }

    static int sackTab(int W, int[] wt, int[] val) {
        int[] dp = new int[W+1];
        if(W >= wt[0]) {
            for(int i = wt[0]; i <= W; i++) {
                dp[wt[0]] = val[0];
            }
        }

        for(int i = 1; i < wt.length; i++) {
            int[] ndp = new int[W+1];
            for(int j = 1; j <= W; j++) {
                ndp[j] = dp[j];
                if(j >= wt[i]) {
                    ndp[j] = Math.max(ndp[j], val[i] + dp[j-wt[i]]);
                }
            }
            dp = ndp;
        }

        return dp[W];
    }
}
