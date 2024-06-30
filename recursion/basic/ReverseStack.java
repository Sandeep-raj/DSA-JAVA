package recursion.basic;

import java.util.Stack;

/*
 * Reverse a Stack
 * 
 * You are given a stack St. You have to reverse the stack using recursion.
 * 
 * Example 1:

Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}
Explanation:
Input stack after reversing will look like the stack in the output.
Example 2:

Input:
St = {4,3,9,6}
Output:
{6,9,3,4}
Explanation:
Input stack after reversing will look like the stack in the output.
Your Task:

You don't need to read input or print anything. Your task is to complete the function Reverse() which takes the stack St as input and reverses the given stack.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= size of the stack <= 104
-109 <= Each element of the stack <= 109
Sum of N over all test cases doesn't exceeds 106
Array may contain duplicate elements. 
 */

public class ReverseStack {
    public static String reverse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        revStack(stack);
        return stack.toString();
    }

    static void revStack(Stack<Integer> st) {
        if(st.size() == 1) {
            return;
        }

        int curr = st.pop();
        revStack(st);

        insertBottom(st, curr);
    }

    static void insertBottom(Stack<Integer> st, int num) {
        if(st.size() == 0) {
            st.push(num);
            return;
        }

        int x = st.pop();
        insertBottom(st, num);
        st.push(x);
    }
}
