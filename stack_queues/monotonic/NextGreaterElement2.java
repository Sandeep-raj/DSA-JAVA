package stack_queues.monotonic;

import java.util.Stack;

/*
 * Next Greater Element II
 * 
 * Problem statement
You are given a circular array 'a' of length 'n'.
A circular array is an array in which we consider the first element is next of the last element. That is, the next element of 'a[n - 1]' is 'a[0]'.
Find the Next Greater Element(NGE) for every element.
The Next Greater Element for an element 'x' is the first element on the right side of 'x' in the array, which is greater than 'x'.

If no greater elements exist to the right of 'x', consider the next greater element as -1.

Example:
Input: 'a' = [1, 5, 3, 4, 2]
Output: NGE = [5, -1, 4, 5, 5]

Explanation: For the given array,
- The next greater element for 1 is 5.
- There is no greater element for 5 on the right side. So we consider NGE as -1.
- The next greater element for 3 is 4.
- The next greater element for 4 is 5, when we consider the next elements as 4 -> 2 -> 1 -> 5.
- The next greater element for 2 is 5, when we consider the next elements as 2 -> 1 -> 5.


Sample Input 1 :
5
1 5 3 4 2


Sample Output 1 :
5 -1 4 5 5


Explanation Of Sample Input 1 :
For the given array,

- The next greater element for 1 is 5.

- There is no greater element for 5 on the right side. So we consider NGE as -1.

- The next greater element for 3 is 4.

- The next greater element for 4 is 5, when we consider the next elements as 4 -> 2 -> 1 -> 5.

- The next greater element for 2 is 5, when we consider the next elements as 2 -> 1 -> 5.


Sample Input 2:
5
5 5 5 5 5


Sample Output 2:
-1 -1 -1 -1 -1


Expected time complexity :
The expected time complexity is O(n).


Constraints :
1 <= 'n' <= 10^5
1 <= 'a[i]' <= 10^9

Time Limit: 1 sec
 */

public class NextGreaterElement2 {
    public static int[] nge2(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            stack.push(arr[i]);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }
}
