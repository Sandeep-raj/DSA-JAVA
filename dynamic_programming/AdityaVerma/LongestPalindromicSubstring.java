package dynamic_programming.AdityaVerma;

/*
 * Longest Palindromic Substring
 * 
 * Given a string str, the task is to find the longest substring which is a palindrome.
 * 
 * Input: str = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.

Input: str = “Geeks” 
Output: “ee”

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

 */

public class LongestPalindromicSubstring {
    public static int longestPallindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        String revStr = sb.reverse().toString();

        return LongestCommonSubsequence.lcs(str, revStr);
    }
}
