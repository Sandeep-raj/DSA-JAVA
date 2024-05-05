package stack_queues.connversions;

import java.util.HashMap;
import java.util.Stack;

/*
 * Infix to Prefix
 * Problem Statement: Given an infix expression, Your task is to convert the given infix expression to a prefix expression.
 * 
 * Example 1:
Input: x+y*z/w+u
Output: ++x/*yzwu
Explanation: Infix to prefix

Example 2:
Input: a+b
Output: +ab
Explanation: Infix to prefix

What is infix expression?
The traditional method of writing mathematical expressions is called infix expressions.
It is of the form <operand><operator><operand>.
As the name suggests, here the operator is fixed inside between the operands. e.g. A+B here the plus operator is placed inside between the two operators, (A*B)/Q.
Such expressions are easy to understand and evaluate for human beings. However, the computer finds it difficult to parse - Information is needed about operator precedence and associativity rules, and brackets that override these rules.
Hence we have postfix and prefix notations which make the computer take less effort to solve the problem.
What is prefix expression?
The prefix expression as the name suggests has the operator placed before the operand is specified.
It is of the form <operator><operand><operand>.
It works entirely in the same manner as the postfix expression.
While evaluating a prefix expression, the operators are applied to the operands immediately on the right of the operator.
For evaluation, we evaluate it from left to right. Prefix expressions are also called polish notation.
Approach:
First, reverse the infix expression given in the problem.
Scan the expression from left to right.
Whenever the operands arrive, print them.
If the operator arrives and the stack is found to be empty, then simply push the operator into the stack.
If the incoming operator has higher precedence than the TOP of the stack, push the incoming operator into the stack.
If the incoming operator has the same precedence with a TOP of the stack, push the incoming operator into the stack.
If the incoming operator has lower precedence than the TOP of the stack, pop, and print the top of the stack. Test the incoming operator against the top of the stack again and pop the operator from the stack till it finds the operator of lower precedence or same precedence.
If the incoming operator has the same precedence with the top of the stack and the incoming operator is ^, then pop the top of the stack till the condition is true. If the condition is not true, push the ^ operator.
When we reach the end of the expression, pop, and print all the operators from the top of the stack.
If the operator is ')', then push it into the stack.
If the operator is '(', then pop all the operators from the stack till it finds the ‘)’ bracket in the stack.
If the top of the stack is ')', push the operator on the stack.
In the end, reverse the output. And print it.
 */

public class Infix2Prefix {
    public static String convert(String exp) {
        char[] cArr = exp.toCharArray();
        String result = "";
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Integer> cMap = new HashMap<>();
        cMap.put('+', 1);
        cMap.put('-', 1);
        cMap.put('*', 2);
        cMap.put('/', 2);
        cMap.put('^', 3);
        cMap.put('(', 100);
        cMap.put(')', 100);

        for(int i = cArr.length - 1; i >= 0; i--) {
            if(cMap.containsKey(cArr[i])) {
                if(stack.isEmpty()) {
                    stack.push(cArr[i]);
                }else {
                    while (!stack.isEmpty() && cMap.get(stack.peek()) > cMap.get(cArr[i])) {
                        result = stack.pop() + result;
                    }

                    stack.push(cArr[i]);
                }
            }else {
                result = cArr[i] + result;
            }
        }

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}
