package sliding_wdw_2_pointer.hard;

/*
 * Minimum Window Substring
 * 
 * Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 */

public class MinimumWindowSubstring {
    public static String minWindow(String str, String t) {
        int[] hash = new int[256];
        char[] destArr = t.toCharArray();
        char[] srcArr = str.toCharArray();

        for(int i = 0; i < destArr.length; i++) {
            hash[destArr[i]]++;
        }

        int start = 0, end = 0, count = 0, startIdx = -1, minLen = Integer.MAX_VALUE;

        while (end < srcArr.length && start <= end) {
            if(hash[srcArr[end]] > 0) {
                count++;
            }
            hash[srcArr[end]]--;


            while(count == destArr.length) {
                if(end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIdx = start;
                }

                hash[srcArr[start]]++;
                if(hash[srcArr[start]] > 0) {
                    count--;
                }
                start++;
            }

            end++;
        }

        if(startIdx < 0) {
            return "";
        }

        return str.substring(startIdx, startIdx + minLen);
    }
}
