package stack_queues.connversions;

import java.util.HashSet;
import java.util.Stack;

/*
 * PostFix To Prefix
 * 
 * Problem statement
You are given a string denoting a valid Postfix expression containing ‘+’, ’-’, ’*’, ‘/’ and lowercase letters.
Convert the given Postfix expression into a Prefix expression.
Note:
Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands. For example, "a b +" represents the addition of a and b.
Prefix notation is a method of writing mathematical expressions in which operators are placed before the operands. For example, "+ a b" represents the addition of a and b.
Expression contains lowercase English letters, ‘+’, ‘-’, ‘*’, and  ‘/’. 

Example:
Input: abc*+

Output: +a*bc

Explanation:
For the given postfix expression, infix expression is a+b*c. And it's corresponding prefix expression is +a*bc.


Sample Input 1:
ab+cd-*


Expected Answer:
*+ab-cd 


Output on console:
*+ab-cd 


Explanation Of Sample Input 1:
For this testcase, the infix expression will be (a + b) * (c - d). Hence, our prefix expression will be *+ab-cd.


Sample Input 2:
ab+c-


Expected Answer:
-+abc


Output on console:
-+abc


Expected Time Complexity:
Try to solve this in O(n), where n is the length of expression.    


Constraints:
1 <= |s| <= 10^5
 */

public class PostFix2Prefix {
    public static String convert(String exp) {
        char[] cArr = exp.toCharArray();
        Stack<String> stack = new Stack<>();
        HashSet<Character> cSet = new HashSet<>();
        cSet.add('*');
        cSet.add('+');
        cSet.add('-');
        cSet.add('/');

        for(int i = 0; i < cArr.length; i++) {
            if(cSet.contains(cArr[i])) {
                String op1 = stack.pop();
                String op2 = stack.pop();

                stack.push("" + cArr[i] + op2 + op1);
            }else {
                stack.push("" + cArr[i]);
            }
        }

        return stack.pop();
    }
}
