package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Given a linked list of 0s, 1s and 2s, sort it.
 * 
 * Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.
 * 
 * Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.


Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.


Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 106
 */

public class sort012 {
    public static Node sort_012(Node head) {
        Node list0 = null;
        Node curr0 = null;
        Node list1 = null;
        Node curr1 = null;
        Node list2 = null;
        Node curr2 = null;

        while (head != null) {
            Node next = head.next;
            head.next = null;

            if(head.Key == 0) {
                if(list0 == null){
                    list0 = head;
                    curr0 = head;
                }else {
                    curr0.next = head;
                    curr0 = head;
                }
            } else if(head.Key == 1) {
                if(list1 == null){
                    list1 = head;
                    curr1 = head;
                }else {
                    curr1.next = head;
                    curr1 = head;
                }
            }else {
                if(list2 == null){
                    list2 = head;
                    curr2 = head;
                }else {
                    curr2.next = head;
                    curr2 = head;
                }
            }

            head = next;
        }

        curr0.next = list1;
        curr1.next = list2;

        return list0;
    }

    public static void sort(int[] arr) {
        LinkedList ll = new LinkedList();
        for(int i =0; i<arr.length;i++) {
            ll.insert(arr[i]);
        }

        Node head = sort_012(ll.head);
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.Key);
            if(head.next != null) {
                sb.append(" -> ");
            }
            head = head.next;
        }

        System.out.println(sb.toString());
    }
}
