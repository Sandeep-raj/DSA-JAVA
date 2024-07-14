package dynamic_programming.DPStrings;

import java.util.HashSet;

/*
 * Print all LCS sequences
 * 
 * You are given two strings s and t. Now your task is to print all longest common sub-sequences in lexicographical order.
Note -  A Sub-sequence is derived from another string by deleting some or none of the elements without changing the order of the remaining elements.

Input: s = abaaa, t = baabaca
Output: aaaa abaa baaa
Explanation - Length of lcs is 4, in lexicographical order they are aaaa, abaa, baaa

Input: s = aaa, t = a
Output: a


Your Task:
You do not need to read or print anything. Your task is to complete the function all_longest_common_subsequences() which takes strings s and t as first and second parameters respectively and returns a list of strings which contains all possible longest common subsequences in lexicographical order.

Expected Time Complexity: O(n3)
Expected Space Complexity: O(k * n) where k is a constant less than n.
 
Constraints:
1 ≤ Length of both strings ≤ 50

 */

public class PrintAllLCSSequences {
    public static String print(String s1, String s2) {
        HashSet<String> res = new HashSet<>();
        int[] reslen = new int[1];
        solve(s1, s2, s1.length(), s2.length(), "", res, reslen);
        return res.toString();
    }

    static void solve(String s1, String s2, int n, int m, String str, HashSet<String> res,int[] reslen) {
        if(n == 0 || m == 0 ) {
            if(res.size() > 0 && reslen[0] < str.length()) {
                res.clear();
            }

            reslen[0] = str.length();
            res.add(str);
            return;
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            solve(s1, s2, n-1, m-1, str + s1.charAt(n-1), res, reslen);
        }else {
            solve(s1, s2, n-1, m, str, res, reslen);
            solve(s1, s2, n, m-1, str, res, reslen);
        }
    }
}
