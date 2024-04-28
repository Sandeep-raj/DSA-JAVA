package str.easy;

/*
 * Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */

public class LongestCommonPrefix {
    public static String longest(String[] str) {
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < str[0].length()) {
            for(int i = 1; i < str.length; i++){
                if(idx == str[i].length() || str[i-1].charAt(idx) != str[i].charAt(idx)) {
                    return sb.toString();
                }
            }
            sb.append(str[0].charAt(idx));
            idx++;
        }

        return sb.toString();
    }
}
