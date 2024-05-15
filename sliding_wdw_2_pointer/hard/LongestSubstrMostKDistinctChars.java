package sliding_wdw_2_pointer.hard;

/*
 * Longest Substring with At Most K Distinct Characters
 * 
 * Problem statement
You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

For example:
You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.

Constraints:
1 <= T <= 10
1 <= K <= 26
1 <= |str| <= 10^6

The string str will contain only lowercase alphabets.    

Time Limit: 1 sec
Note:
You do not need to print anything. It has already been taken care of. Just implement the function.

Sample Input 1:
2
2
abbbbbbc
3
abcddefg
Sample Output 1:
7
4
Explanation:
For the first test case, ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.

For the second test case, ‘str’ = ‘abcddefg’ and ‘K’ = 3, then the substrings that can be formed is [‘cdde’, ‘ddef’]. Hence the answer is 4.
Sample Input 2:
2
3
aaaaaaaa
1
abcefg
Sample Output 2:
8   
1   


Hints:
1. Try to think of a brute force approach.
2. Try to think of a two-pointer solution.
 */

public class LongestSubstrMostKDistinctChars {
    public static int longest(String str, int k) {
        char[] cArr = str.toCharArray();
        int[] cMap = new int[26];

        for(int i = 0; i < 26; i++) {
            cMap[i] = -1;
        }

        int start=0, end=0, uniqEle = 0,result = 0;
        while (end < cArr.length) {
            if (cMap[cArr[end] - 'a'] == -1) {
                uniqEle++;
            }

            cMap[cArr[end] - 'a'] = end;

            if(uniqEle > k) {
                int leastIdx = -1, leastVal = Integer.MAX_VALUE;
                for(int i = 0; i < 26; i++) {
                    if(cMap[i] != -1 && cMap[i] < leastVal) {
                        leastVal = cMap[i];
                        leastIdx = i;
                    }
                }
                start = leastVal+1;
                cMap[leastIdx] = -1;
                uniqEle--;
            }

            result = Math.max(result, end - start + 1);
            end++;
        }

        return result;
    }
}
