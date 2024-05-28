package linkedlist.ll_hard;

import java.util.Random;

import linkedlist.learn.LinkedList;

/*
 * Copy List with Random Pointer
 * 
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.
The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

- val: an integer representing Node.val
- random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
 */

public class CopyListRandomPointer {
    static class Node {
        int key;
        Node next;
        Node random;
        
        public Node(int key) {
            this.key = key;
        }
    }

    public static Node[] deepcopy(Node head) {
        Node curr = head;
        // add copy nodes 
        while (curr != null) {
            Node next = curr.next;
            Node n = new Node(curr.key);
            curr.next = n;
            n.next = next;

            curr = next;
        }

        // update random pointers
        curr = head;
        while (curr != null) {
            Node n = curr.next;
            n.random = curr.random;
            curr = curr.next.next;
        }

        // remove the old nodes
        Node oldhead = null;
        Node oldcurr = null;
        Node newhead = null;
        Node newcurr = null;
        curr = head;
        int cnt = 0;
        while (curr != null) {
            Node next = curr.next;
            curr.next = null;
            if(cnt % 2 == 0) {
                if(oldhead == null) {
                    oldcurr = curr;
                    oldhead = curr;
                }else {
                    oldcurr.next = curr;
                    oldcurr = curr;
                }
            }else {
                if(newhead == null) {
                    newcurr = curr;
                    newhead = curr;
                }else {
                    newcurr.next = curr;
                    newcurr = curr;
                }
            }
            cnt++;
            curr = next;
        }

        return new Node[]{oldhead,newhead};
    }

    public static void copy(int[] arr) {
        Node[] narr = new Node[arr.length];
        for(int i =0; i < arr.length; i++) {
            narr[i] = new Node(arr[i]);
        }

        Random rand = new Random();
        Node head = null,curr = null;
        for(int i = 0; i < arr.length; i++) {
            int r = rand.nextInt(arr.length);
            narr[i].random = narr[r];
            if(head == null) {
                head = narr[i];
                curr = narr[i];
            }else {
                curr.next = narr[i];
                curr = narr[i];
            }
        }

        Node[] heads = deepcopy(head);
        StringBuilder oldsb = new StringBuilder();
        StringBuilder newsb = new StringBuilder();

        while (heads[0] != null) {
            oldsb.append(heads[0].key+"("+heads[0].random.key+")");
            if(heads[0].next != null) {
                oldsb.append(" -> ");
            }
            heads[0] = heads[0].next;
        }

        while (heads[1] != null) {
            newsb.append(heads[1].key+"("+heads[1].random.key+")");
            if(heads[1].next != null) {
                newsb.append(" -> ");
            }
            heads[1]  = heads[1].next;
        }

        System.out.println(oldsb.toString());
        System.out.println(newsb.toString());
    }
}

