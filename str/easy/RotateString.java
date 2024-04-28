package str.easy;

/*
 * Rotate String
 * 
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
 */

public class RotateString {
    public static Boolean rotate(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        for(int start = 0 ; start < str2.length(); start++) {
            int ptr1 = 0, ptr2 = start;

            if (str1.charAt(ptr1) == str2.charAt(ptr2)) {
               ptr1++;
               ptr2 = (ptr2 + 1)%str2.length();

               while (ptr2 != start && str1.charAt(ptr1) == str2.charAt(ptr2)) {
                ptr1++;
                ptr2 = (ptr2 + 1)%str2.length();
               }

               if(ptr2 == start) {
                return true;
               }
            }
        }

        return false;
    }
}
