package linkedlist.dll_medium;

import linkedlist.learn.DoublyLinkedList;
import linkedlist.learn.DoublyLinkedList.Node;

/*
 * Remove duplicates from a sorted doubly linked list
 * 
 * Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.
 * 
 * Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of node with value 1 is 
retained, rest nodes with value = 1 are deleted.


Input:
n = 7
1<->2<->2<->3<->3<->4<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of nodes with values 2,3 and 4 are 
retained, rest repeating nodes are deleted.


Your Task:
You have to complete the method removeDuplicates() which takes 1 argument: the head of the linked list.  Your function should return a pointer to a linked list with no duplicate element.

Constraint:
1 <= n <= 105
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)
 * 
 */

public class RemoveDuplicates {
    public static void remDups(Node head) {
        Node curr = head;

        while (curr != null) {
            Node temp = curr;
            while (curr.next != null && curr.next.key == temp.key) {
                curr = curr.next;
            }

            curr = curr.next;
            if(curr != temp) {
                temp.next = curr;
                if(curr != null) {
                    curr.prev = temp;
                }
            }
        }
    }

    public static void remove(int[] arr) {
        DoublyLinkedList dll = new DoublyLinkedList();
        for(int i = 0; i < arr.length; i++) {
            dll.insert(arr[i]);
        }

        remDups(dll.head);

        StringBuilder sb = new StringBuilder();
        Node head = dll.head;
        while (head != null) {
            sb.append(head.key);
            if(head.next != null) {
                sb.append(" -> ");
            }

            head = head.next;
        }

        System.out.println(sb.toString());
    }
}
