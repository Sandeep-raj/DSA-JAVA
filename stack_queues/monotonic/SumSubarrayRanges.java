package stack_queues.monotonic;

import java.util.Stack;

/*
 * Sum of Subarray Ranges
 * 
 * You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.

Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109
 */

public class SumSubarrayRanges {
    public static int sum(int[] arr) {
        int sumOfMin = sumOfMin(arr);
        int sumOfMax = sumOfMax(arr);

        return sumOfMax - sumOfMin;
    }

    static int sumOfMin(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                nsl[i] = -1;
            }else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                nsr[i] = arr.length;
            }else {
                nsr[i] = stack.peek();
            }

            stack.push(i);
        }

        for(int i = 0; i < arr.length; i++) {
            result += (i - nsl[i]) * (nsr[i] - i) * arr[i];
        }

        return result;
    }


    static int sumOfMax(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ngl = new int[arr.length];
        int[] ngr = new int[arr.length];
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ngl[i] = -1;
            }else {
                ngl[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        for(int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ngr[i] = arr.length;
            }else {
                ngr[i] = stack.peek();
            }

            stack.push(i);
        }

        for(int i = 0; i < arr.length; i++) {
            result += (i - ngl[i]) * (ngr[i] - i) * arr[i];
        }

        return result;
    }
}
