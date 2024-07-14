package dynamic_programming.OneDimensional;

/*
 * Geek Jump
 * 
 * Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.
 * 
 * Example:
Input:
n = 4
height = {10 20 30 10}
Output:
20
Explanation:
Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost).
Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost).
so, total energy lost is 20 which is the minimum.


Your Task:
You don't need to read input or print anything. Your task is to complete the function MinimumEnergy() which takes the array height, and integer n, and returns the minimum energy that is lost.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraint:
1<=n<=100000
1<=height[i]<=1000
 */

public class GeekJump {
    public static int geek(int n, int[] ht) {
        // int[] dp = new int[n+1];
        // return jumpRec(n, ht, dp);
        return jumpTab(n, ht);
    }

    static int jumpRec(int n, int[] ht, int[] dp) {
        if(n == 0){
            return 0;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int right = Integer.MAX_VALUE;
        int left = jumpRec(n-1, ht, dp) + Math.abs(ht[n] - ht[n-1]);
        if(n > 1) {
            right = jumpRec(n-2, ht, dp) + Math.abs(ht[n] - ht[n-2]);
        }

        dp[n] = Math.min(right, left);

        return dp[n];
    }

    static int jumpTab(int n, int[] ht) {
        int prev2 = 0;
        int prev = Math.abs(ht[0] - ht[1]);

        for(int i = 2; i <= n; i++) {
            int step1 = prev + Math.abs(ht[i] - ht[i-1]);
            int step2 = prev2 + Math.abs(ht[i] - ht[i-2]);
            int curr = Math.min(step1, step2);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
