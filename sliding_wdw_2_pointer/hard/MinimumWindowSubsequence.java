package sliding_wdw_2_pointer.hard;

/*
 * Minimum Window Subsequence
 * 
 * Problem statement
You are given two strings ‘S’ and ‘T’. Your task is to find the minimum (Contiguous) substring ‘W’ of ‘S’, such that ‘T’ is a subsequence of ‘W’

A subsequence is a sequence that can be derived from another sequence by removing zero or more elements, without changing the order.

A substring is a contiguous part of a string.

For example:
For the given string “CodingNinjas”: “Ninja” is a substring while “dinas” is a subsequence. 
If there is no such Window in ‘S’ that covers all characters in ‘T’, return an empty string "". If there are multiple such minimum length windows, return the one with the smallest starting index.


Constraints :
1 <= S <= 1000      
1 <= T <= 100

Sample Input 1 :
2
rdew
u
abcdebdde
bde
Sample Output 1 :
""
bcde
Explanation For Sample Output 1 :
For test case 1 :
Since there is no window in ‘S’ which covers all characters of ‘T’ so therefore we returned an empty string.

For test case 2 :
“bcde” is the substring of minimum length in which we find “bde”. “bdde” is also a substring of minimum length however the index of “bcde” occurs first, therefore we returned bcde
Sample Input 2:
2
hello
eo
goodbye
dy
Sample Output 2:
ello
dby
 */

public class MinimumWindowSubsequence {
    public static String minSubSequence(String str, String t) {
        char[] arr = str.toCharArray();
        char[] searchArr = t.toCharArray();

        int start = 0, end = 0, searchPtr = 0, startIdx = -1, minlen = Integer.MAX_VALUE;

        while (end < arr.length) {
            if(arr[end] == searchArr[searchPtr]) {
                searchPtr++;
            }

            if(searchPtr == searchArr.length) {
                start = end;
                searchPtr--;
                while (searchPtr >= 0) {
                    if(arr[start] == searchArr[searchPtr]) {
                        searchPtr--;
                    }
                    start--;
                }

                start++;
                searchPtr++;
                if(minlen > end - start + 1) {
                    minlen = end - start + 1;
                    startIdx = start;
                }
                end = start;
            }

            end++;
        }

        if(startIdx == -1) {
            return "";
        }else {
            return str.substring(startIdx, startIdx + minlen);
        }
    }
}
