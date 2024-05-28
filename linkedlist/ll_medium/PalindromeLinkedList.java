package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * 
 * Input: head = [1,2,2,1]
Output: true


Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9


 */

public class PalindromeLinkedList {
    public static Node isPallindrome(Node head, Node curr) {
        Node leftNode = head;
        if(curr.next != null) {
            leftNode = isPallindrome(head, curr.next);
        }
        
        if(leftNode != null && leftNode.Key == curr.Key) {
            if(curr == head) {
                return head;
            }else {
                return leftNode.next;
            }
        }else {
            return null;
        }
    }

    public static void isPallindrome(int[] arr) {
        LinkedList ll = new LinkedList();
        for(int i = 0; i < arr.length; i++) {
            ll.insert(arr[i]);
        }

        Node n  = isPallindrome(ll.head, ll.head);
        System.out.println(n != null);
    }
}
