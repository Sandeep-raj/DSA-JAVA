package heap.medium;

import java.util.PriorityQueue;

/*
 * Merge k sorted arrays
 * 
 * Given K sorted arrays of size N each, merge them and print the sorted output.
 * 
 * Input: K = 3, N = 4, arr = { {1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}}
Output: 0 1 2 3 4 5 6 7 8 9 10 11 
Explanation: The output array is a sorted array that contains all the elements of the input matrix. 

Input: k = 4, n = 4, arr = { {1, 5, 6, 8}, {2, 4, 10, 12}, {3, 7, 9, 11}, {13, 14, 15, 16}} 
Output: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
Explanation: The output array is a sorted array that contains all the elements of the input matrix. 


 */

public class MergeKSortedArrays {
    public static class Node {
        public int Val;
        public int Idx;

        public Node(int val, int idx) {
            this.Val = val;
            this.Idx = idx;
        }
    }
    public static int[] merge(int[][] arr) {
        // Priority Queue (nklog(k))
        int n = arr.length;
        int k = arr[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.Val-b.Val));

        for(int i = 0; i < n; i++) {
            Node node = new Node(arr[i][0],i);
            pq.add(node);
        }

        int totElems = n*k;
        int[] result = new int[totElems];
        int[] firstIdx = new int[n];
        int idx = 0;

        while (pq.size() > 0) {
            Node node = pq.remove();
            result[idx] = node.Val;
            firstIdx[node.Idx]++;

            if(firstIdx[node.Idx] < k) {
                Node newNode = new Node(arr[node.Idx][firstIdx[node.Idx]], node.Idx);
                pq.add(newNode);
            }
            idx++;
        }

        return result;
    }
}
