package linkedlist.ll_hard;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Reverse Nodes in k-Group
 * 
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 */

public class ReverseNodeskGroup {
    public static Node[] reverse(Node head) {
        Node chead = null;
        Node ctail = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = null;

            if (chead == null) {
                chead = curr;
                ctail = curr;
            } else {
                curr.next = chead;
                chead = curr;
            }

            curr = next;
        }

        return new Node[] { chead, ctail };
    }

    public static Node revNodek(Node head, int k) {
        Node resHead = null;
        Node resTail = null;

        Node nextNode = head;
        while (nextNode != null) {
            Node cHead = nextNode;
            int cnt = 2;
            for (; nextNode.next != null && cnt <= k; cnt++) {
                nextNode = nextNode.next;
            }

            if (cnt <= k) {
                if (resHead == null) {
                    resHead = cHead;
                } else {
                    resTail.next = cHead;
                }
                nextNode = nextNode.next;
            } else {
                Node next = nextNode.next;
                nextNode.next = null;

                Node[] revNodes = reverse(cHead);
                if (resHead == null) {
                    resHead = revNodes[0];
                    resTail = revNodes[1];
                } else {
                    resTail.next = revNodes[0];
                    resTail = revNodes[1];
                }

                nextNode = next;
            }
        }

        return resHead;
    }

    public static void reverse(int[] arr, int k) {
        LinkedList ll = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            ll.insert(arr[i]);
        }

        Node head = revNodek(ll.head, k);
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
