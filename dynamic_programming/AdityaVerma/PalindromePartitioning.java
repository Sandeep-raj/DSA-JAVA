package dynamic_programming.AdityaVerma;

/*
 * Palindrome Partitioning
 * 
 * Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome, the task is to find the minimum number of cuts needed for palindrome partitioning of the given string.
 * 
 * Input: str = “geek” 
Output: 2 
Explanation: We need to make minimum 2 cuts, i.e., “g ee k”

Input: str = “aaaa” 
Output: 0 
Explanation: The string is already a palindrome.

Input: str = “abcde” 
Output: 4

Input: str = “abbac” 
Output: 1 
 */

public class PalindromePartitioning {
    public static int parts(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for(int i = 0; i <= str.length(); i++) {
            for(int j = 0; j <= str.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return solve(str, 0, str.length() - 1, dp);
    }

    static int solve(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (pallindrome(str, i, j)) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int minParts = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            minParts = Math.min(minParts, solve(str, i, k, dp) + solve(str, k + 1, j, dp) + 1);
        }

        dp[i][j] = minParts;

        return minParts;
    }

    static boolean pallindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
