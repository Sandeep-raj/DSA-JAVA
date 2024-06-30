package recursion.subsequence;

import java.util.HashSet;

/*
 * Better String
 * 
 * Given a pair of strings of equal lengths, Geek wants to find the better string. The better string is the string having more number of distinct subsequences.
If both the strings have equal count of distinct subsequence then return str1.

Input:
str1 = "gfg", str2 = "ggg"
Output: "gfg"
Explanation: "gfg" have 6 distinct subsequences whereas "ggg" have 3 distinct subsequences. 


Input: str1 = "a", str2 = "b"
Output: "a"
Explanation: Both the strings have only 1 distinct subsequence. 


Your Task:
You don't need to read input or print anything. Your task is to complete the function betterString() which takes str1 and str2 as input parameters and returns the better string.

Expected Time Complexity: O( N ), where N is the length of both provided strings.

Expected Auxiliary Space: O( N )

Constraints:
1 <= N <= 30
 */

public class BetterString {
    public static String better(String str1, String str2) {
        HashSet<String> set1 = new HashSet<>();
        subseq(str1, 0, "", set1);

        HashSet<String> set2 = new HashSet<>();
        subseq(str1, 0, "", set2);

        if(set2.size() > set1.size()) {
            return str2;
        }else {
            return str1;
        }
    }

    static void subseq(String str, int i, String curr, HashSet<String> result) {
        if(str.length() == i) {
            result.add(curr);
            return;
        }

        subseq(str, i+1, curr, result);
        subseq(str, i+1, curr + str.charAt(i), result);
    }
}
