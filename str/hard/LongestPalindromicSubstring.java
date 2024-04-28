package str.medium;

/*
 * Longest Palindromic Substring
 * 
 * Given a string s, return the longest 
palindromic
 
substring
 in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring {
    public static String longest(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = "";
        for (int i = 0; i < s.length() - 1; i++) {

            // search around i as center
            int displacement = 0;
            while (i - displacement >= 0 && i + displacement < s.length()
                    && s.charAt(i - displacement) == s.charAt(i + displacement)) {
                displacement++;
            }

            if (displacement > 0) {
                String curr = s.substring(i - displacement + 1, i + displacement);
                if (maxStr.length() < curr.length()) {
                    maxStr = curr;
                }
            }

            // serach around i + 1/2 as center
            if (s.charAt(i) == s.charAt(i + 1)) {
                displacement = 0;
                while (i - displacement >= 0 && i + displacement + 1 < s.length() && s.charAt(i - displacement) == s.charAt(i + displacement+1)) {
                    displacement++;
                }

                String curr = s.substring(i - displacement + 1, i + displacement + 1);
                if (maxStr.length() < curr.length()) {
                    maxStr = curr;
                }
            }
        }

        return maxStr;
    }
}
