package stack_queues.monotonic;

import java.util.Stack;

/*
 * Largest Rectangle in Histogram
 * 
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 * 
 * Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */

public class LargestRectangleHistogram {
    public static int largestArea(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        int maxArea = arr[0];

        for(int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                int lastIdx = stk.pop();
                maxArea = Math.max(maxArea, arr[lastIdx]*(i - lastIdx));
            }

            stk.push(i);
        }

        while (!stk.isEmpty()) {
            int currIdx = stk.pop();
            int lastIdx = stk.size() > 0 ? stk.peek() : 0;

            maxArea = Math.max(maxArea, (arr.length - lastIdx - 1)*arr[currIdx]);
        }

        return maxArea;
    
    }
}
