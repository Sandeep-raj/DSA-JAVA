package heap.hard;

import java.util.PriorityQueue;

/*
 * Kth Largest Element in a Stream
 * 
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.



Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8



Constraints:

1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 */

public class KthLargestElementStream {
    static class KLargest {
        private int k;
        private PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a-b));

        public KLargest(int k, int[] arr) {
            this.k = k;
            for(int a : arr) {
                pq.add(a);
            }

            while (pq.size() > k) {
                pq.remove();
            }
        }

        public int Add(int val) {
            pq.add(val);

            while (pq.size() > k) {
                pq.remove();
            }

            return pq.peek();
        }
    }

    public static void test() {
        KLargest kl = new KLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kl.Add(3));
        System.out.println(kl.Add(5));
        System.out.println(kl.Add(10));
        System.out.println(kl.Add(9));
        System.out.println(kl.Add(4));
    }
}
