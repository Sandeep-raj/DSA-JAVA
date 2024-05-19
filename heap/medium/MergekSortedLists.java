package heap.medium;

import java.util.PriorityQueue;

/*
 * Merge k Sorted Lists
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

    Merge all the linked-lists into one sorted linked-list and return it.

    Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 * 
 */
public class MergekSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int[] merge(int[][] arr) {
        int n = arr.length;
        int k = arr[0].length;
        ListNode[] lists = new ListNode[n]; 

        for(int i = 0; i < n; i++) {
            ListNode temp = null;
            for(int j = 0; j < k; j++) {
                ListNode node = new ListNode(arr[i][j]);
                if(temp == null) {
                    temp = node;
                    lists[i] = temp;
                }else{
                    temp.next = node;
                    temp = node;
                }
            }
        }

        int[] result = new int[n*k]; 
        int cnt =0;
        ListNode lresult = mergeList(lists);
        while (lresult != null) {
            result[cnt] = lresult.val;
            lresult = lresult.next;
            cnt++;
        }

        return result;
    }

    public static ListNode mergeList(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val-b.val));

        for(int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
        }

        ListNode result = null;
        ListNode head = null;

        while (pq.size() > 0) {
            ListNode node = pq.remove();
            if(node.next != null ) {
                pq.add(node.next);
            }

            node.next = null;
            if(head == null ) {
                head = node;
                result = node;
            }else {
                head.next = node;
                head = node;
            }
        }

        return result;
    }
}
