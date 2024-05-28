package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Odd Even Linked List
 * 
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]


Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
 * 
 */

public class OddEvenLinkedList {
    public static Node oddEven(Node head) {
        Node oddHead = null;
        Node oddCurr = null;
        Node evenHead = null;
        Node evenCurr = null;

        Node curr = head;
        int cnt = 1;

        while (curr != null) {
            Node next = curr.next;
            curr.next = null;

            if((cnt&1) == 1) {
                if(oddHead == null) {
                    oddHead = curr;
                    oddCurr = curr;
                }else {
                    oddCurr.next = curr;
                    oddCurr = curr;
                }
            }else {
                if(evenHead == null) {
                    evenHead = curr;
                    evenCurr = curr;
                }else {
                    evenCurr.next = curr;
                    evenCurr = curr;
                }
            }

            cnt++;
            curr = next;
        }

        oddCurr.next = evenHead;
        return oddHead;
        
    }

    public static void oell(int[] arr) {
        LinkedList ll = new LinkedList();
        for(int i = 0; i < arr.length; i++) {
            ll.insert(arr[i]);
        }

        Node n = oddEven(ll.head);
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.Key);
            if(n.next != null) {
                sb.append(" -> ");
            }

            n = n.next;
        }

        System.out.println(sb.toString());
    }
}
