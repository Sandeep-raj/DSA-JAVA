package stack_queues.connversions;

import java.util.HashSet;
import java.util.Stack;

/*
 * Convert Prefix to Postfix
 * 
 * Problem statement
You are given a string ‘s’ of size ’n’, representing the prefix form of a valid mathematical expression

Your task is to find out its corresponding postfix expression.

The expected time and space complexity is O(n) and O(n), where ‘n’ is the size of the string ‘s’.
Note:
The only operators used in the expressions are ‘+’, ‘-’, ‘*’, ‘/’.

Example:
Input: ‘n’ = 5, ‘s’ = “/A+BC”

Output: ABC+/

Explanation: For ‘s’ = “/A+BC”, the correct postfix expression is “ABC+/”.


Sample Input 1:
5
/A+BC

Sample Output 1 :
ABC+/

Explanation Of Sample Input 1:
Input: ‘n’ = 5, ‘s’ = “/A+BC”

Output: ABC+/

Explanation: For ‘s’ = “/A+BC”, the correct postfix expression is “ABC+/”.


Sample Input 2:
9
-/A+BC*DE

Sample Output 2:
ABC+/DE*-

Explanation of sample output 2:
Input: ‘n’ = 9, ‘s’ = “-/A+BC*DE”

Output: ABC+/DE*-

Explanation: For ‘s’ = “-/A+BC*DE”, the correct postfix expression is “ABC+/DE*-”.

Constraints:
3 <= n < 10^4
The characters in ‘s’ are either one of {‘+’, ‘-’, ‘/’, ‘*’} or is one of the Uppercase Letters.
 */

public class Prefix2Postfix {
    public static String convert(String exp) {
        Stack<String> stack = new Stack<>();
        char[] cArr = exp.toCharArray();
        HashSet<Character> cSet = new HashSet<>();
        cSet.add('+');
        cSet.add('-');
        cSet.add('/');
        cSet.add('*');

        for(int i = cArr.length - 1; i >= 0; i--) {
            if(cSet.contains(cArr[i])) {
                String op1 = stack.pop();
                String op2 = stack.pop();

                stack.push(""+op1+op2+cArr[i]+"");
            }else {
                stack.push("" + cArr[i]);
            }
        }

        return stack.pop();
    }
}
