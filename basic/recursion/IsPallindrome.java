package basic.recursion;

/**
 * Given a string, check if the string is palindrome or not."  A string is said to be palindrome if the reverse of the string is the same as the string.

Examples:

Example 1:
Input: Str =  “ABCDCBA”
Output: Palindrome
Explanation: String when reversed is the same as string.

Example 2:
Input: Str = “TAKE U FORWARD”
Output: Not Palindrome
Explanation: String when reversed is not the same as string.
 */
public class IsPallindrome {
    public static String check(String str) {
        Boolean ispallindrome = checkRec(str, 0, str.length() - 1);
        if(ispallindrome) {
            return "Palindrome";
        }
        return "Not Palindrome";
    }

    static Boolean checkRec(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return checkRec(str, start + 1, end -1);
    }
}
