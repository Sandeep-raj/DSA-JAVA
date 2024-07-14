package dynamic_programming.AdityaVerma;

/*
 * Egg dropping problem
 * 
 * There is a building with floors 1 to ‘FLOORS’. You are given a basket full of identical eggs. ‘EGGS’ identical eggs. 
 * As the eggs are identical, they follow the same properties. These properties are given below:

Each egg breaks only if it is dropped from a certain floor ‘EGGBREAKER’ or above.
An egg that is not broken after being dropped from a floor can be used to drop again.

‘FLOORS’: Total number of floors in the building.
 ‘EGGS’ : Total number of eggs in the basket.
 Your task is to find the minimum number of egg drops required in the worst case to find out the ‘EGGBREAKER’ floor. 
Dropping from different floors leads to a different number of moves required to find the ‘EGGBREAKER’ floor.  

Input
Enter Eggs: 2
Enter Floors: 6
Output
Minimum number of moves required:  3


You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
Return the minimum number of moves that you need to determine with certainty what the value of f is.


Example 1:

Input: k = 1, n = 2
Output: 2
Explanation: 
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
Example 2:

Input: k = 2, n = 6
Output: 3
Example 3:

Input: k = 3, n = 14
Output: 4
 */

public class EggDropping {
    public static int minDrops(int eggs, int floors) {
        int[][] dp = new int[eggs+1][floors+1];
        for(int i = 0; i <= eggs; i++) {
            for(int j =0; j<= floors; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(eggs, floors, dp);
    }

    static int solve(int e, int f, int[][] dp) {
        if(e == 1) {
            return f;
        }

        if(f == 0 || f == 1) {
            return f;
        }

        if(dp[e][f] != -1) {
            return dp[e][f];
        }

        int minMoves = Integer.MAX_VALUE;
        for(int i = 1; i <= f; i++) {
            int brk = -1, notbrk = -1;
            if(dp[e-1][i-1] != -1) {
                brk = dp[e-1][i-1];
            }else {
                brk = solve(e-1, i-1, dp);
            }
            if(dp[e][f-i] != -1) {
                notbrk = dp[e][f-i];
            }else {
                notbrk = solve(e, f - i, dp);
            }

            minMoves = Math.min(minMoves, Math.max(brk, notbrk)+1);
        }

        dp[e][f] = minMoves;
        return minMoves;
    }
}
