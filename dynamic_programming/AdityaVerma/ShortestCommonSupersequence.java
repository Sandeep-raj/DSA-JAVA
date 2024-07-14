package dynamic_programming.AdityaVerma;

/*
 * Shortest Common Supersequence
 * 
 * Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.
 * 
 * Input:   str1 = "geek",  str2 = "eke"
Output: 5
Explanation: 
String "geeke" has both string "geek" 
and "eke" as subsequences.

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output:  9
Explanation: 
String "AGXGTXAYB" has both string 
"AGGTAB" and "GXTXAYB" as subsequences.
 */

public class ShortestCommonSupersequence {
    public static int shortestSubSeq(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] dp = new int[m+1];

        for(int i = 0; i < n; i++) {
            int[] ndp = new int[m+1];
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i) == s2.charAt(j-1)) {
                    ndp[j] = 1 + dp[j-1];
                }else {
                    ndp[j] = Math.max(dp[j], ndp[j-1]);
                }
            }

            dp = ndp;
        }

        return n + m - dp[m];
    }
}
