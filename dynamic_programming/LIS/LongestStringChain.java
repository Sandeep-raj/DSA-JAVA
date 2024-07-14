package dynamic_programming.LIS;

import java.util.Arrays;

/*
 * Longest String Chain
 * 
 * You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
Return the length of the longest possible word chain with words chosen from the given list of words.

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.
 */

public class LongestStringChain {
    public static int longest(String[] words) {
        Arrays.sort(words, (w1, w2) -> {
            return w1.length() - w2.length();
        });

        int[] dp = new int[words.length];
        int[] hash = new int[words.length];

        for(int i = 0; i < words.length; i++) {
            dp[i] = 1;
            hash[i] = i;
        }

        int max = 1;
        for(int i = 1; i < words.length; i++) {
            for(int j = 0; j < i; j++) {
                if(strDif(words[j], words[i]) == 1) {
                    if(dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }

            if(max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    static int strDif(String word1, String word2) {
        int dif = 0, l1 = 0, l2 =0;
        while (l1 < word1.length() && l2 < word2.length()) {
            if(word1.charAt(l1) == word2.charAt(l2)) {
                l1++;
                l2++;
            }else {
                dif++;
                l2++;
            }
        }

        return dif + (word1.length() - l1) + (word2.length() - l2);
    } 
}
