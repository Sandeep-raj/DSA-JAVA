package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Input: head = [1], n = 1
Output: []

Input: head = [1,2], n = 1
Output: [1]
 */

public class RemoveNthNodeFromEnd {
    public static Node removeNth(Node head, int n) {
        Node fast = head;
        Node slow = head;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if(slow == head) {
            head = head.next;
        }else {
            slow.next = slow.next.next;
        }
        
        return head;
    }

    public static void remove(int[] arr, int n) {
        LinkedList ll = new LinkedList();
        for(int i = 0; i < arr.length; i++) {
            ll.insert(arr[i]);
        }

        Node head =  removeNth(ll.head, n);
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
