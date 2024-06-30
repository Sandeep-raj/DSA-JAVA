package recursion.basic;

import java.util.Stack;

/*
 * Sort a stack
 * 
 * Given a stack, the task is to sort it such that the top of the stack has the greatest element.
 * 
 * 
 * Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
1<=N<=100
 */

public class SortStack {
    public static String sort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        Stack<Integer> result = sortStack(stack);
        return result.toString();
    }

    static Stack<Integer> sortStack(Stack<Integer> stack) {
        if(stack.size() == 1) {
            return stack;
        }

        int curr =  stack.pop();
        sortStack(stack);

        Stack<Integer> vals = new Stack<>();
        while (stack.size() > 0) {
            if(stack.peek() > curr) {
                vals.push(stack.pop());
            }else {
                break;
            }
        }

        stack.push(curr);
        while (vals.size() > 0) {
            stack.push(vals.pop());
        }

        return stack;
    }
}
