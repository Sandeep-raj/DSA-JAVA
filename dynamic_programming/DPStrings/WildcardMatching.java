package dynamic_programming.DPStrings;

/*
 * Wildcard Matching
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 */

public class WildcardMatching {
    public static boolean match(String s, String p) {
        boolean[][] dp =  new boolean[s.length()+1][p.length() + 1];
        return solve(s, p, s.length(), p.length(), dp);
    }

    static boolean solveTab(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i++) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = true;
            }else {
                break;
            }
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    static boolean solve(String s, String p, int n, int m, boolean[][] dp) {
        if(n == 0 && m == 0) {
            return true;
        }

        if(m == 0 && n > 0) {
            return false;
        } 

        if(n == 0 && m > 0) {
            for(int i = 0; i < m; i++) {
                if(p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if(dp[n][m]) {
            return dp[n][m];
        }

        boolean res = false;
        if(s.charAt(n-1) == p.charAt(m-1) || p.charAt(m-1) == '?') {
            res = solve(s, p, n-1, m-1, dp);
        }

        if(p.charAt(m-1) == '*') {
            res = solve(s, p, n, m-1, dp) | solve(s, p, n-1, m, dp);
        }

        dp[n][m] = res;

        return res;
    }
}
