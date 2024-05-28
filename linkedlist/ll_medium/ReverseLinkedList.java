package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 *  Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * 
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Input: head = [1,2]
Output: [2,1]

Input: head = []
Output: []
 *  
 */

public class ReverseLinkedList {
    public static Node reverse(Node llhead) {
        Node head = null;

        while (llhead != null) {
            Node curr = llhead;
            llhead = llhead.next;

            curr.next = null;
            if(head == null) {
                head = curr;
            }else {
                curr.next = head;
                head = curr;
            }
        }

        return head;
    }

    public static Node[] revRecursion(Node node) {
        if(node == null) {
            return new Node[]{null,null};
        }

        Node[] revNode = revRecursion(node.next);
        if(revNode[0] == null) {
            node.next = null;
            return new Node[]{node,node};
        }else {
            node.next=null;
            revNode[1].next = node;
            revNode[1] = revNode[1].next;
            return revNode;
        }
    }

    public static void reverse(int[] inp) {
        LinkedList ll = new LinkedList();
        for(int i =0; i < inp.length; i++) {
            ll.insert(inp[i]);
        }


        StringBuilder sb = new StringBuilder();
       //  Node head = reverse(ll.head);
        Node head = revRecursion(ll.head)[0];
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
