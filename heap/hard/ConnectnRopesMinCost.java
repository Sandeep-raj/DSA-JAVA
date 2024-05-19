package heap.hard;

import java.util.PriorityQueue;

/*
 * Connect n ropes with minimum cost
 * 
 * Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
 * 
 * Input: arr[] = {4,3,2,6} , N = 4
Output: 29
Explanation: 

First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5. 
Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9. 
Finally connect the two ropes and all ropes have connected.




Input: arr[] = {1, 2, 3} , N = 3
Output: 9
Explanation: 

First, connect ropes of lengths 1 and 2. Now we have two ropes of lengths 3 and 3. 
Finally connect the two ropes and all ropes have connected.
 */

public class ConnectnRopesMinCost {
    public static int cost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < arr.length; i++){
            pq.add(arr[i]);
        }

        while (pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();

            pq.add(a+b);
        }

        return pq.remove();
    }
}
