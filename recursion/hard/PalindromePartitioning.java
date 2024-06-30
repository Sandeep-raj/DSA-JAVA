package recursion.hard;

import java.util.ArrayList;

/*
 * Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * 
 * Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */

public class PalindromePartitioning {
    public static String parts(String str) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<String>();
        process(str, curr, res);

        StringBuilder sb = new StringBuilder();
        for(String s : res) {
            sb.append(s + ",");
        }

        return sb.toString();
    }

    static void process(String str, ArrayList<String> curr, ArrayList<String> result) {
        if(str == "") {
            result.add(curr.toString());
            return;
        }

        String temp = "";
        for(int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);
            if(isPallindrome(temp)) {
                curr.add(temp);
                process(str.substring(i+1), curr, result);
                curr.remove(temp);
            }
        }
    }

    static boolean isPallindrome(String s) {
        if(s == "") {
            return false;
        }

        if(s.length() == 1) {
            return true;
        }

        for(int i = 0; i <= s.length()/2; i++) {
            int last = s.length() - 1 - i;
            if(i > last) {
                break;
            }

            if(s.charAt(i) != s.charAt(last)) {
                return false;
            }
        }

        return true;
    }
}
