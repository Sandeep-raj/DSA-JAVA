package dynamic_programming.AdityaVerma;

/*
 * Printing Shortest Common Supersequence
 * 
 * Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest super-sequence exists, print any one of them.
 * 
Input: X = "AGGTAB",  Y = "GXTXAYB"
Output: "AGXGTXAYB" OR "AGGXTXAYB" 
OR Any string that represents shortest supersequence of X and Y

Input: X = "HELLO",  Y = "GEEK"
Output: "GEHEKLLO" OR "GHEEKLLO"
OR Any string that represents shortest supersequence of X and Y
 */

public class PrintShortestCommonSupersequence {
    public static String print(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int sn = n, sm = m;
        while (sn > 0 && sm > 0) {
            if(s1.charAt(sn-1) == s2.charAt(sm-1)) {
                sb.append(s1.charAt(sn-1));
                sn--;
                sm--;
            }else {
                if(dp[sn-1][sm] > dp[sn][sm-1]) {
                    sb.append(s1.charAt(sn-1));
                    sn--;
                }else {
                    sb.append(s2.charAt(sm-1));
                    sm--;
                }
            }
        }

        while (sn > 0) {
            sb.append(s1.charAt(sn-1));
            sn--;
        }

        while (sm > 0) {
            sb.append(s2.charAt(sm-1));
            sm--;
        }

        return sb.reverse().toString();
    }
}
