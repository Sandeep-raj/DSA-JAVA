package sliding_wdw_2_pointer.medium;

/*
 * Number of Substrings Containing All Three Characters
 * 
 * Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
 */

public class NumSubstrContainsAll3Chars {
    public static int count(String str) {
        char[] cArr = str.toCharArray();
        int[] hash = new int[]{-1,-1,-1};
        int count = 0;

        for(int i = 0; i < cArr.length; i++) {
            hash[cArr[i] - 'a'] = i;
            int minIdx = Math.min(hash[2], Math.min(hash[0], hash[1]));
            if(minIdx > -1) {
                count += minIdx+1;
            }
        }

        return count;
    }
}
