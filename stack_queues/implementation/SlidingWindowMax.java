package stack_queues.implementation;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Sliding Window Maximum
 * 
 * Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * 
 * Example 1:

Input: arr = [4,0,-1,3,5,3,6,8], k = 3

Output: [4,3,5,5,6,8]

Explanation: 

Window position                   Max
------------------------         -----
[4  0  -1] 3  5  3  6  8           4
 4 [0  -1  3] 5  3  6  8           3
 4  0 [-1  3  5] 3  6  8           5
 4  0  -1 [3  5  3] 6  8           5
 4  0  -1  3 [5  3  6] 8           6
 4  0  -1  3  5 [3  6  8]          8

For each window of size k=3, we find the maximum element in the window and add it to our output array.

Example 2:

Input: arr= [20,25], k = 2

Output: [25]

Explanation: There’s just one window is size 2 that is possible and the maximum of the two elements is our answer.



 */

public class SlidingWindowMax {
    public static int[] max(int[] arr, int k) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] result = new int[arr.length-k + 1];
        int cnt = 0;

        for(int i = 0 ; i < k ;i++) {
            if(queue.isEmpty()) {
                queue.addLast(arr[i]);
            }else {
                while (!queue.isEmpty() && queue.peekLast() < arr[i]) {
                    queue.removeLast();
                }

                queue.addLast(arr[i]);
            }
        }

        result[0] = queue.peekFirst();
        cnt++;

        for(int i = k ; i < arr.length; i++) {
            if(arr[i-k] == queue.peekFirst()) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.peekLast() < arr[i]) {
                queue.removeLast();
            }

            queue.addLast(arr[i]);

            result[cnt] = queue.peekFirst();
            cnt++;
        }

        return result;
    }
}