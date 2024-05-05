package stack_queues.monotonic;

import java.util.Stack;

/*
 * Sum of Subarray Minimums
 * 
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 * 
 * Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 */

public class SumofSubarrayMin {
    public static int sum(int[] arr) {
        int[] prevSamller = prevSmaller(arr);
        int[] nextSmaller = nextSmaller(arr);

        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            result += (i - prevSamller[i]) * (nextSmaller[i] - i) * arr[i];
        }
        return result;
    }

    static int[] prevSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
                stk.pop();
            }

            if(stk.isEmpty()) {
                ans[i] = -1;
            }else {
                ans[i] = stk.peek();
            }

            stk.push(i);
        }

        return ans;
    }

    static int[] nextSmaller(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }

            if(stk.isEmpty()) {
                ans[i] = arr.length;
            }else {
                ans[i] = stk.peek();
            }

            stk.push(i);
        }

        return ans;
    }
}
