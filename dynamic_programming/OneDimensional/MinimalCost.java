package dynamic_programming.OneDimensional;

import java.util.LinkedList;

/*
 * Minimal Cost
 * 
 * There are n stones and an array of heights and Geek is standing at stone 1 and can jump to one of the following: Stone i+1, i+2, ... i+k stone and cost will be [hi-hj] is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches Stone n.
 * 
 * Input: n = 5, k = 3 heights = {10, 30, 40, 50, 20}
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30, which is minimum

Input: n = 3, k = 1 heights = {10,20,10}
Output: 20
Explanation: Geek will follow the path 1->2->3, the total cost would be |10 - 20| + |20 - 10| = 20.


Your Task:
You don't need to read input or print anything. Your task is to complete the function minimizeCost() which takes the array height, and integer n, and integer k and returns the minimum energy that is lost.

Expected Time Complexity: O(n*k)
Expected Space Complexity: O(n)

Constraint:
2 <= n <= 105
1 <= k <= 100
1 <= heights[i] <= 104
 */

public class MinimalCost {
    public static int minCost(int n, int k, int[] ht) {
        int[] dp = new int[n+1];
        return costRec(n-1, k, ht, dp);
        // return costTab(n, k, ht);
    }

    static int costRec(int n, int k, int[] ht, int[] dp) {
        if(n == 0) {
            return 0;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++) {
            if( n >= i) {
                min = Math.min(min, costRec(n - i, k, ht, dp) + Math.abs(ht[n] - ht[n-i]));
            }
        }

        dp[n] = min;
        return min;
    }

    static int costTab(int n, int k, int[] ht) {
        LinkedList<Integer> lastK = new LinkedList<>();
        lastK.add(0);
        for(int i = 1; i < k; i++) {
            int min = Integer.MAX_VALUE;

            for(int x = 0; x < lastK.size(); x++) {
                min = Math.min(min, Math.abs(ht[i] - ht[x]) + lastK.get(x));
            }
            lastK.add(min);
        }

        for(int i = k; i < n; i++ ){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++) {
                if(i >= j) {
                    min = Math.min(min, lastK.get(k-j) + Math.abs(ht[i] - ht[i-j]));
                }
            }

            lastK.remove(0);
            lastK.add(min);
        }

        return lastK.removeLast();
    }
}
