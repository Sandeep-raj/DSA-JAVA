package linkedlist.ll_medium;

import linkedlist.learn.LinkedList;
import linkedlist.learn.LinkedList.Node;

/*
 * Add 1 to a number represented as linked list
 * 
 * A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.
 * 
 * Input:
LinkedList: 4->5->6
Output: 457
Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 

Input:
LinkedList: 1->2->3
Output: 124 

Your Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number.
Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 1021
 */

public class Add1toNumberLL {
    public static int addNumber(Node node, int num) {
        int carry = 0;
        if (node.next != null) {
            carry = addNumber(node.next, num);
            node.Key = node.Key + carry;
        }else {
            node.Key = node.Key + num;
        }

        
        int tens = node.Key / 10;
        int ones = node.Key % 10;

        node.Key = ones;
        return tens;
    }

    public static void add1(int[] arr1, int n) {
        LinkedList ll1 = new LinkedList();

        for (int i = 0; i < arr1.length; i++) {
            ll1.insert(arr1[i]);
        }

        int carry = addNumber(ll1.head, n);
        if(carry > 0) {
            Node n0de = new Node(carry);
            n0de.next = ll1.head;
            ll1.head = n0de;
        }

        StringBuilder sb = new StringBuilder();
        while (ll1.head != null) {
            sb.append(ll1.head.Key);
            ll1.head = ll1.head.next;
        }

        System.out.println(sb.toString());
    }
}
