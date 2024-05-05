package stack_queues.connversions;

import java.util.HashSet;
import java.util.Stack;

/*
 * Postfix to Infix
 * 
 * Problem statement
You are given a mathematical expression in postfix notation. The expression consists of alphabets(both lowercase and uppercase) and operators.
Convert this expression to infix notation.

Note:
Surround every expression with a pair of parentheses “()”.

Example:
Input: ‘postfix’ = “ab+c+”

Output: ‘infix’ = “((a+b)+c)”

Explanation: The expression ((a+b)+c)” in infix is equivalent to “ab+c+” in postfix.

Sample Input 1:
5
ab+c+
Sample Output 1:
((a+b)+c)


Explanation Of Sample Input 1 :
The expression “((a+b)+c)” in infix is equivalent to “ab+c+” in postfix.


Sample Input 2 :
9
ABC/DA-*+
Sample Output 2 :
(A+((B/C)*(D-A)))


Constraints:
3 <= ‘postfix.length’ <= 10^4
 */

public class Postfix2Infix {
    public static String convert(String exp) {
        char[] cArr = exp.toCharArray();
        Stack<String> stack = new Stack<>();
        HashSet<Character> cSet = new HashSet<>();
        cSet.add('+');
        cSet.add('-');
        cSet.add('*');
        cSet.add('/');


        for(int i = 0; i < cArr.length; i++) {
            if(cSet.contains(cArr[i])) {
                String op1 = stack.pop();
                String op2 = stack.pop();

                stack.push("(" + op2 + cArr[i] + op1 + ")");
            }else {
                stack.push("" + cArr[i]);
            }
        }

        return stack.pop();
    }
}
