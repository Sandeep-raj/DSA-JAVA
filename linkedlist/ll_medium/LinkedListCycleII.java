package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Linked List Cycle II
 * 
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * 
 * Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class LinkedListCycleII {
    public static void cycle(int[] arr, int intersect) {
        LinkedList ll = new LinkedList();
        Node interPoint = null;
        for(int i = 0; i < arr.length; i++) {
            Node n = ll.insert(arr[i]);
            if(arr[i] == intersect) {
                interPoint = n;
            }
        }
        ll.tail.next = interPoint;

        System.out.println(cycle(ll.head).Key);
    }

    public static Node cycle(Node head) {
        Node h = head;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }

        if(slow == fast) {
            while (h != slow) {
                h = h.next;
                slow = slow.next;
            }

            return slow;
        }else {
            return null;
        }
    }
}
