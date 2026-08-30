import java.util.*;

/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/

class Main {
    public static void main(String[] args) {
        pallindromicsubstr("abc");
    }

    static void pallindromicsubstr(String str) {
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            int midcount = expandStr(str, i, i);
            int dualcount = expandStr(str, i, i+1);

            count += (midcount + dualcount);
        }

        System.out.println(count);
    }

    static int expandStr(String str, int left, int right) {
        int count = 0;

        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
