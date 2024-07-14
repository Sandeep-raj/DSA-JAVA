package dynamic_programming.AdityaVerma;

/*
 * Printing Longest Common Subsequence
 * 
 * Given two sequences, print the longest subsequence present in both of them.

Examples: 

LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. 
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */

public class PrintingLCS {
    public static String lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp =  new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int sn = n, sm = m;
        String result = "";
        while (sn > 0 && sm > 0) {
            while (dp[sn][sm] == dp[sn-1][sm-1]) {
                sn--;
                sm--;
            }

            while (dp[sn][sm] == dp[sn-1][sm] || dp[sn][sm] == dp[sn][sm-1]) {
                if(dp[sn][sm] == dp[sn-1][sm]) {
                    sn = sn-1;
                }else {
                    sm = sm-1;
                }
            }

            result = s1.charAt(sn-1) + result;
            sn--;
            sm--;
        }

        return result;
    }
}
