package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.


Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

public class AddTwoNumbers {
    public static Node add2nums(Node node1, Node node2) {
        Node resulth = null;
        Node resultc = null;
        int carry = 0;

        while (node1 != null && node2 != null) {
            int sum = node1.Key + node2.Key + carry;
            int key = sum % 10;
            carry = sum / 10;

            Node node = new Node(key);

            if(resulth == null) {
                resulth = node;
                resultc = node;
            }else {
                resultc.next = node;
                resultc = node;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            int sum = node1.Key + carry;
            int key = sum % 10;
            carry = sum / 10;

            Node node = new Node(key);
            resultc.next = node;
            resultc = node;
        }

        while (node2 != null) {
            int sum = node2.Key + carry;
            int key = sum % 10;
            carry = sum / 10;

            Node node = new Node(key);
            resultc.next = node;
            resultc = node;
        }

        if(carry > 0){
            Node node = new Node(carry);
            resultc.next = node;
            resultc = node;
        }

        return resulth;
    }

    public static void add2nums(int[] arr1, int[] arr2) {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        for(int i = 0; i < arr1.length; i++) {
            ll1.insert(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++) {
            ll2.insert(arr2[i]);
        }


        Node head = add2nums(ll1.head, ll2.head);
        
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.Key);
            head = head.next;
        }

        System.out.println(sb.toString());
    }
}
