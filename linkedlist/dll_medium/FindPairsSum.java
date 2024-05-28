package linkedlist.dll_medium;

import java.util.ArrayList;
import java.util.Arrays;

import linkedlist.learn.DoublyLinkedList;
import linkedlist.learn.DoublyLinkedList.Node;

/*
 * Find pairs with given sum in doubly linked list
 * 
 * Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
 * 
 * Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.


Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.


Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105
 */

public class FindPairsSum {
    public static int[][] findPairs(Node head, int sum) {
        ArrayList<int[]> result = new ArrayList<>();
        Node curr = head;
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (curr != tail) {
            if(curr.key + tail.key > sum) {
                tail = tail.prev;
            }else if(curr.key + tail.key < sum) {
                curr = curr.next;
            }else {
                result.add(new int[]{curr.key,tail.key});
                if(curr.next != tail && curr.next.key == curr.key) {
                    curr = curr.next;
                }
                tail = tail.prev;
            }
        }

        return result.toArray(new int[result.size()][]);
    }


    public static void find(int[] arr, int sum) {
        DoublyLinkedList dll = new DoublyLinkedList();
        for(int i = 0; i < arr.length;i++) {
            dll.insert(arr[i]);
        }

        int[][] pairs = findPairs(dll.head, sum);
        System.out.println(Arrays.deepToString(pairs));
    }
}
