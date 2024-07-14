package dynamic_programming.AdityaVerma;

import java.util.HashMap;

/*
 * Check if a string is a scrambled form of another string
 * 
 * Given two strings S1 and S2 of equal length, the task is to determine if S2 is a scrambled form of S1.
Scrambled string: 
Given string str, we can represent it as a binary tree by partitioning it into two non-empty substrings recursively.
Note: Scrambled string is not same as an Anagram

Below is one possible representation of str = “coder”:
    coder
   /    \
  co    der
 / \    /  \
c   o  d   er
           / \
          e   r

To scramble the string, we may choose any non-leaf node and swap its two children. 
Suppose, we choose the node “co” and swap its two children, it produces a scrambled string “ocder”.

    ocder
   /    \
  oc    der
 / \    /  \
o   c  d   er
           / \
          e   r

Thus, “ocder” is a scrambled string of “coder”.
Similarly, if we continue to swap the children of nodes “der” and “er”, it produces a scrambled string “ocred”.

    ocred
   /    \
  oc    red
 / \    /  \
o   c  re  d
       / \
      r   e

Input: S1=”coder”, S2=”ocder” 
Output: Yes 
Explanation: 
“ocder” is a scrambled form of “coder”
Input: S1=”abcde”, S2=”caebd” 
Output: No 
Explanation: 
“caebd” is not a scrambled form of “abcde”
 */

public class ScrambledString {
    public static boolean isScramble(String s1, String s2) {
        HashMap<String,Boolean> map = new HashMap<>();
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }

        return solve(s1, s2, map);
    }

    static boolean solve(String s1, String s2, HashMap<String, Boolean> dp) {
        if (s1.length() == 0) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        if(dp.containsKey(s1 + " " + s2)) {
            return dp.get(s1 + " " + s2);
        }

        for (int i = 1; i < s1.length(); i++) {
            if (solve(s1.substring(0, i), s2.substring(s2.length() - i, s2.length()), dp) &&
                    solve(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i), dp)) {
                return true;
            }

            if (solve(s1.substring(0, i), s2.substring(0, i), dp) &&
                    solve(s1.substring(i, s1.length()), s2.substring(i, s2.length()), dp)) {
                return true;
            }
        }

        dp.put(s1 + " " + s2, false);

        return false;
    }
}
