package dynamic_programming.AdityaVerma;

/*
 * Minimum number of deletions to make a string palindrome
 * 
 * Given a string of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome. 
 * 
 * Input : aebcbda
Output : 2
Remove characters 'e' and 'd'
Resultant string will be 'abcba' which is a palindromic string
Input : geeksforgeeks
Output : 8
 */

public class MinNoDeletionsForPalindrome {
    public static int minDel(String str) {
        StringBuilder sb = new StringBuilder(str);
        String revStr = sb.reverse().toString();

        int lcs = LongestCommonSubsequence.lcs(str, revStr);
        return str.length() - lcs;
    }
}
