package str.medium;

/*
 * Sum of Beauty of All Substrings
 * 
 * The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

 

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:

Input: s = "aabcbaa"
Output: 17
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
 */

public class SumofBeautyofAllSubstrings {
    public static int getBeauty(String str) {
        int result = 0;
        char[] strC = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            int[] cMap = new int[26];
            for(int j = i; j < str.length();j++) {
                cMap[strC[j] - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int k = 0; k < 26; k++) {
                    if(cMap[k] != 0) {
                        max = Math.max(max, cMap[k]);
                        min = Math.min(min, cMap[k]);
                    }
                }

                result += (max - min);
            }
        }

        return result;
    }
}
