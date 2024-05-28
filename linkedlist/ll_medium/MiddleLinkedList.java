package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Middle of the Linked List
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 */

public class MiddleLinkedList {
    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void getMiddle(int[] inp) {
        LinkedList ll = new LinkedList();
        for(int i =0; i < inp.length; i++) {
            ll.insert(inp[i]);
        }

        Node n = getMiddle(ll.head);
        System.out.println(n.Key);
    }
}
