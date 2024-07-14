package dynamic_programming.AdityaVerma;

/*
 * Longest Common Substring
 * 
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring. 
 * 
 * Input : X = “GeeksforGeeks”, y = “GeeksQuiz” 
Output : 5 
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd” 
Output : 4 
Explanation:
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx” 
Output : 6 
Explanation:
The longest common substring is “abcdez” and is of length 6.
 */

public class LongestCommonSubstring {
    public static int lcsubstring(String x, String y) {
        return lcaRec(x, y, x.length(), y.length(), 0);
    }

    static int lcaTab(String x, String y) {
        int n = x.length(), m = y.length();
        int[] dp = new int[m+1];
        int maxCount = 0;

        for(int i = 0; i < n; i++) {
            int[] ndp =  new int[m+1];
            for(int j = 1; j <= m; j++) {
                if(x.charAt(i) == y.charAt(j-1)) {
                    ndp[j] = dp[j-1] + 1;
                    maxCount = Math.max(ndp[j], maxCount);
                }else {
                    ndp[j] = 0;
                }
            }
            dp = ndp;
        }

        return maxCount;
    }


    static int lcaRec(String x, String y, int n, int m, int count) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(x.charAt(n-1) == y.charAt(m-1)) {
            return 1 + lcaRec(x, y, n-1, m-1, count+1);
        }else {
            return Math.max(count,Math.max(lcaRec(x, y, n-1, m, 0),lcaRec(x, y, n, m-1, 0)));
        }
    }
}
