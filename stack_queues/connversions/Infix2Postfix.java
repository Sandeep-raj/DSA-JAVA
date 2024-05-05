package stack_queues.connversions;

import java.util.HashMap;
import java.util.Stack;

/*
 * Infix To Postfix
 * 
 * Problem statement
You are given a string 'exp' which is a valid infix expression.
Convert the given infix expression to postfix expression.

Note:
Infix notation is a method of writing mathematical expressions in which operators are placed between operands. 

For example, "3 + 4" represents the addition of 3 and 4.

Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands. 
For example, "3 4 +" represents the addition of 3 and 4.
Expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’. 


Example:
Input: exp = ‘3+4*8’

Output: 348*+

Explanation:
Here multiplication is performed first and then the addition operation. Hence postfix expression is  3 4 8 * +.


Sample Input 1:
3^(1+1)

Expected Answer:
311+^


Output printed on console:
311+^


Explanation of Sample Input 1:
For this testcase, we will evaluate 'b' = (1+1) first. 

Hence it's equivalent postfix expression will be "11+". 

Next we will evaluate 3^b. It's equivalent postfix expression will be "3b^". 

Replacing 'b' with it's equivalent postfix we get "311+^".


Sample Input 2:
a+b+c+d-e


Expected Answer:
ab+c+d+e-


Output printed on console:
ab+c+d+e-


Expected Time Complexity:
Try to do this in O(n).


Constraints:
1 <= 'n' <= 5000 

‘n’, is the length of EXP
The expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’. 

Time Limit: 1 sec



Approach: To convert Infix expression to Postfix
1. Scan the infix expression from left to right. 

2. If the scanned character is an operand, Print it. 

3. Else, 

If the precedence of the scanned operator is greater than the precedence of the operator in the stack or the stack is empty or the stack contains a ‘(‘, push the character into the stack. 
Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. 
4. If the scanned character is an ‘(‘, push it into the stack. 

5. If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis. 

6. Repeat steps 2-5 until the entire infix expression is scanned. 

7. Print the output.

8. Pop and print the output from the stack until it is not empty.


 */

public class Infix2Postfix {
    public static String convert(String str) {
        char[] cArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        HashMap<Character,Integer> cMap = new HashMap<>();
        cMap.put('+', 1);
        cMap.put('-', 1);
        cMap.put('*', 2);
        cMap.put('/', 2);
        cMap.put('^', 3);
        cMap.put('(', 100);
        cMap.put(')', 100);

        for(char c : cArr) {
            if(c == ' ') {
                continue;
            }

            if(c == '(' ) {
                stack.push(c);
            }else if (c == ')')  {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }else if(cMap.containsKey(c)) {
                if(stack.isEmpty()) {
                    stack.push(c);
                }else {
                    while (!stack.isEmpty() && stack.peek() != '(' && cMap.get(stack.peek()) >= cMap.get(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
