package stack_queues.connversions;

import java.util.HashSet;
import java.util.Stack;

/*
 * Prefix to Infix
 * 
 * Problem statement
You are given a string denoting a valid Prefix expression containing ‘+’, ’-’, ’*’, ‘/’ and lowercase letters.



Convert the given Prefix expression into an Infix expression.



Note:
Infix notation is a method of writing mathematical expressions in which operators are placed between operands. For example, "a + b" represents the addition of a and b.

Prefix notation is a method of writing mathematical expressions in which operators are placed before the operands. For example, "+ a b" represents the addition of a and b.

Expression contains lowercase English letters, ‘+’, ‘-’, ‘*’, and  ‘/’. 


Example:
Input: /-ab+-cde

Output: ((a-b)/((c-d)+e))

Explanation:
In this test case, there are four operators ‘/’, ‘-’, ‘+’, ‘-’.
Prefix expression:  /-ab+-cde. 
The operator between  ‘a’ and ‘b’ is ‘-’. Resulting expression: /(a-b)+-cde.
The operator between  ‘c’ and ‘d’ is ‘-’. Resulting expression: /(a-b)+(c-d)e.
The operator between ‘c-d’ and ‘e’ is +. Resulting expression: /(a-b)((c-d)+e).
The operator between ‘a-b’ and ‘((c-d)+e)’ is ‘/’. Resulting expression: ((a-b)/((c-d)+e)).


Sample Input 1:
*-a/bc-/dkl


Expected Answer:
((a-(b/c))*((d/k)-l))


Output on console:
((a-(b/c))*((d/k)-l))


Explanation for Sample Input 1:
In this testcase, there are five operators ‘*’, ‘-’, ‘/’, ‘-’, ‘/’.
Prefix Expression: *-a/bc-/dkl.
The operator between  ‘b’ and ‘c’ is ‘/’. Resulting expression: *-a(b/c)-/dkl.
The operator between  ‘d’ and ‘k’ is ‘/’. Resulting expression: *-a(b/c)-(d/k)l.
The operator between  ‘a’ and ‘(b/c)’ is ‘-’. Resulting expression: *(a-(b/c))-(d/k)l.
The operator between  ‘d/k’ and ‘l’ is ‘-’. Resulting expression: *(a-(b/c))((d/k)-l).
The operator between  ‘(a-(b/c))’ and ‘((d/k)-l)’ is ‘*’. Resulting expression: ((a-(b/c))*((d/k)-l)).


Sample Input 2:
*-a/bc-/del


Expected Answer:
((a-(b/c))*((d/e)-l))


Output on console:
((a-(b/c))*((d/e)-l))


Expected Time Complexity:
Try to solve this in O(n^2), where n is the length of expression.


Constraints:
1 <= n <= 500
where n is the length of expression.

Time Limit: 1 sec
 */

public class Prefix2Infix {
    public static String conversion(String exp) {
        char[] expArr = exp.toCharArray();
        Stack<String> stack = new Stack<>();
        HashSet<Character> operatorSet = new HashSet<>();
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('*');
        operatorSet.add('/');
        operatorSet.add('^');

        for(int i = expArr.length - 1; i >= 0; i--) {
            if(operatorSet.contains(expArr[i])) {
                String op2 = stack.pop();
                String op1 = stack.pop();
                stack.push("( "+ op2 + expArr[i] + op1 +" )");
            }else {
                stack.push("" + expArr[i]);
            }
        } 

        return stack.pop();
    }
}
