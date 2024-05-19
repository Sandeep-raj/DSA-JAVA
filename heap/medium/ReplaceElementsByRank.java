package heap.medium;

import java.util.PriorityQueue;

/*
 * Replace elements by its rank in the array
 * 
 * Given an array of N integers, the task is to replace each element of the array by its rank in the array.
 * 
 * Example 1:
Input: 20 15 26 2 98 6
Output: 4 3 5 1 6 2
Explanation: When sorted,the array is 2,6,15,20,26,98. So the rank of 2 is 1,rank of 6 is 2,rank of 15 is 3 and so…

Example 2:
Input: 1 5 8 15 8 25 9
Output: 1 2 3 5 3 6 4
Explanation: When sorted,the array is 1,5,8,8,9,15,25. So the rank of 1 is 1,rank of 5 is 2,rank of 8 is 3 and so…


 */

public class ReplaceElementsByRank {
    static class Node {
        public int val;
        public int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static int[] replace(int[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for(int i = 0; i < arr.length; i++) {
            Node n = new Node(arr[i], i);
            pq.add(n);
        }

        int[] result = new int[arr.length];
        int min = Integer.MIN_VALUE, rank = 0;
        while (pq.size() > 0) {
            Node n = pq.remove();

            if(n.val > min) {
                rank++;
                result[n.idx] = rank;
                min = n.val;
            }else {
                result[n.idx] = rank;
            }
        }

        return result;
    }
}
