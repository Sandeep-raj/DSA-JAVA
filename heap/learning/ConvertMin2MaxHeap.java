package heap.learning;

/*
 * Convert Min Heap to Max Heap
 * 
 * You are given an array arr of N integers representing a min Heap. The task is to convert it to max Heap.

A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node.

Example 1:

Input:
N = 4
arr = [1, 2, 3, 4]
Output:
[4, 2, 3, 1]
Explanation:

The given min Heap:

          1
        /   \
      2       3
     /
   4

Max Heap after conversion:

         4
       /   \
      2     3
    /
   1
Example 2:

Input:
N = 5
arr = [3, 4, 8, 11, 13]
Output:
[13, 11, 8, 3, 4]
Explanation:

The given min Heap:

          3
        /   \
      4      8
    /   \ 
  11     13

Max Heap after conversion:

          13
        /    \
      11      8
    /   \ 
   3     4


Your Task:
Complete the function int convertMinToMaxHeap(), which takes integer N and array represented minheap as input and converts it to the array representing maxheap. You don't need to return or print anything, modify the original array itself.


Approach: To solve the problem follow the below idea:

The idea is, simply build Max Heap without caring about the input. Start from the bottom-most and rightmost internal node of Min-Heap and heapify all internal nodes in the bottom-up way to build the Max heap.

Follow the given steps to solve the problem:

Call the Heapify function from the rightmost internal node of Min-Heap
Heapify all internal nodes in the bottom-up way to build max heap
Print the Max-Heap
Algorithm: Here’s an algorithm for converting a min heap to a max heap:

Start at the last non-leaf node of the heap (i.e., the parent of the last leaf node). For a binary heap, this node is located at the index floor((n – 1)/2), where n is the number of nodes in the heap.
For each non-leaf node, perform a “heapify” operation to fix the heap property. In a min heap, this operation involves checking whether the value of the node is greater than that of its children, and if so, swapping the node with the smaller of its children. In a max heap, the operation involves checking whether the value of the node is less than that of its children, and if so, swapping the node with the larger of its children.
Repeat step 2 for each of the non-leaf nodes, working your way up the heap. When you reach the root of the heap, the entire heap should now be a max heap.


Note: Only an unique solution is possible under the expected time complexity.

Expected Time Complexity: O(N * log N)
Expected Auxiliary Space: O(N)


Constraints:

1 <= N <= 105
1 <= arr[i] <= 109
 */

public class ConvertMin2MaxHeap {
    public static int[] convert2Min(int[] maxHeap) {
        // maxHeap.length - 1 <- last idx in arr 
        int lastNonLeafIdx = (maxHeap.length - 2)/2;
        for(int i = lastNonLeafIdx; i >= 0; i--) {
            percolateDown(maxHeap,i);
        }

        return maxHeap;
    }

    private static void percolateDown(int[] arr, int i) {
        while (i < arr.length) {
            int smallestIdx = -1;
            int leftIdx = 2*i + 1;
            int rightIdx = 2*i + 2;

            
            if(rightIdx < arr.length) {
                if(arr[rightIdx] < arr[leftIdx]) {
                    smallestIdx = rightIdx;
                }else {
                    smallestIdx = leftIdx;
                }
            }else if(leftIdx < arr.length) {
                smallestIdx = leftIdx;
            }

            if(smallestIdx != -1 && arr[i] > arr[smallestIdx]) {
                int temp = arr[smallestIdx];
                arr[smallestIdx] = arr[i];
                arr[i] = temp;

                i = smallestIdx;
            }else {
                break;
            }
        }
    }
}
