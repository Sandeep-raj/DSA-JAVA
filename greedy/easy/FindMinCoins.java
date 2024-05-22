package greedy.easy;

/*
 * Find minimum number of coins to make a given value (Coin Change)
 * 
 * Given an array coins[] of size N and a target value V, where coins[i] represents the coins of different denominations. You have an infinite supply of each of coins. The task is to find minimum number of coins required to make the given value V. If it’s not possible to make a change, print -1.
 * 
 * coin denomination - 1, 2, 5, 10, 20, 50, 100, 500, 1000
 * Example 1:
Input: V = 70
Output: 2
Explaination: We need a 50 Rs note and a 20 Rs note.

Example 2:
Input: V = 121
Output: 3

Explaination: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents
 */

public class FindMinCoins {
    public static int min(int[] coins, int v) {
        int min_count = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] > v) {
                continue;
            }

            int temp_count = 0, ptr = i, temp_val = v;
            while (ptr < coins.length && temp_val > 0) {
                if(temp_val >= coins[ptr]) {
                    temp_count += (temp_val/coins[ptr]);
                    temp_val = temp_val%coins[ptr];
                }
                ptr++;
            }

            if(temp_val == 0) {
                min_count = Math.min(temp_count, min_count);
            }

        }

        return min_count;
    }
}
