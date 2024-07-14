package dynamic_programming.MCM;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Minimum Cost to Cut a Stick
 * 
 * Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
You should perform the cuts in order, you can change the order of the cuts as you wish.
The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
Return the minimum total cost of the cuts.


Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:
The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).


Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
Explanation: If you try the given cuts ordering the cost will be 25.
There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.


Constraints:

2 <= n <= 106
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
All the integers in cuts array are distinct.
 */

public class MinCostCutStick {
    public static int minCost(int n, int[] cuts) {
        ArrayList<Integer> cutsArr = new ArrayList<Integer>();
        for(int i = 0 ; i < cuts.length; i++) {
            cutsArr.add(cuts[i]);
        }
        cutsArr.add(0);
        cutsArr.add(n);

        Collections.sort(cutsArr);

        return solveTab(cutsArr, cuts.length);
    }

    static int solve(ArrayList<Integer> cuts, int i, int j) {
        if(i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            min = Math.min(min, solve(cuts, i, k-1) + solve(cuts, k+1, j) + cuts.get(j+1) - cuts.get(i-1));
        }

        return min;
    }

    static int solveTab(ArrayList<Integer> cuts, int len) {
        int[][] dp = new int[len+2][len+2];

        for(int i = len; i >= 1; i--) {
            for(int j = 1; j <= len; j++) {
                if(i > j) {
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++) {
                    min = Math.min(min, dp[i][k-1] + dp[k+1][j] + (cuts.get(j+1) - cuts.get(i-1)));
                }

                dp[i][j] = min;
            }
        }

        return dp[1][len];
    }
}
