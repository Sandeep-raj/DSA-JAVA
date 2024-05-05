package stack_queues.monotonic;

import java.util.Stack;

/*
 * Remove K Digits
 * 
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 * 
 * Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */

public class RemoveKDigits {
    public static String remove(String str, int k) {
        char[] cArr = str.toCharArray();
        Stack<Integer> stk = new Stack<>();
        String result = "";

        for (char c : cArr) {
            int cInt = Integer.parseInt("" + c);

            while (k > 0 && !stk.isEmpty() && stk.peek() >= cInt) {
                stk.pop();
                k--;
            }

            stk.push(cInt);
        }

        int len = stk.size() - k;
        while (len > 0) {
            result = stk.pop() + result;
            len--;
        }

        return result;
    }
}
