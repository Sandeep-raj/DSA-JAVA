package heap.medium;

/*
 * Kth Largest Element in an Array
 * 
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */

public class KthLargest {
    public static int largest(int[] arr, int k) {
        // Priority Queue (O(nlogn))
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        // for(int i = 0; i < arr.length; i++) {
        //     pq.add(arr[i]);
        // }

        // int result = -1;
        // while (k > 0) {
        //     result = pq.remove();
        //     k--;
        // }

        // Quick Selection algorithm
        int result = -1;
        int pivot = 0;
        int left = pivot+1;
        int right = arr.length -1;
        while (left < right) {
            
        }

        // Counter Based(O(n)) 
        // int result = -1;
        // int[] counter = new int[20001];
        // for(int i = 0; i < arr.length; i++) {
        //     counter[arr[i] + 10000]++;
        // }

        // int x = 20000;
        // while (k > 0 && x >= 0) {
        //     if(counter[x] > 0) {
        //         counter[x]--;
        //         k--;
        //         result = x - 10000;
        //     }else {
        //         x--;
        //     }
        // }

        return result;
    }
}
