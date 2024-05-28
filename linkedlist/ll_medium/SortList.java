package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Sort List
 * 
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * 
 * Input: head = [4,2,1,3]
Output: [1,2,3,4]

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Input: head = []
Output: []

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 */

public class SortList {
    public static Node mergeSortedList(Node head1, Node head2) {
        Node head = null;
        Node chead = null;

        while (head1 != null && head2 != null) {
            Node curr = null;
            if(head1.Key < head2.Key) {
                curr = head1;
                head1 = head1.next;
                curr.next = null;
            }else {
                curr = head2;
                head2 = head2.next;
                curr.next = null;
            }

            if(head == null) {
                head = curr;
                chead = curr;
            }else {
                chead.next = curr;
                chead = curr;
            }
        }

        if (head1 != null) {
            chead.next = head1;
        }

        if (head2 != null) {
            chead.next = head2;
        }

        return head;
    }

    public static Node midNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if(fast != null) {
                slow = slow.next;
            }
        }

        return slow;
    }

    public static Node mergeSort(Node head) {
        if(head.next == null) {
            return head;
        }

        Node middle = midNode(head);
        Node rhead = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rhead);

        return mergeSortedList(left, right);
    }

    public static void sort(int[] arr) {
        LinkedList ll = new LinkedList();
        for(int i = 0; i < arr.length; i++) {
            ll.insert(arr[i]);
        }

        Node head = mergeSort(ll.head);

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
