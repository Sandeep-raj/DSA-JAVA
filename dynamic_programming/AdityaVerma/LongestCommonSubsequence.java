package dynamic_programming.AdityaVerma;

/*
 * Longest Common Subsequence
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.


Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */

public class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        // return lcsRec(s1, s1.length(), s2, s2.length());
        return lcsTab(s1, s2);
    }

    static int lcsRec(String s1, int n, String s2, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcsRec(s1, n-1, s2, m-1);
        }else {
            return Math.max(lcsRec(s1, n - 1, s2, m), lcsRec(s1, n, s2, m-1));
        }
    }

    static int lcsTab(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] dp = new int[m+1];

        for(int i = 1; i <= n; i++) {
            int[] ndp = new int[m+1];
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    ndp[j] = 1 + dp[j-1];
                }else {
                    ndp[j] = Math.max(dp[j], ndp[j-1]);
                }
            }
            dp = ndp;
        }

        return dp[m];
    }
}
