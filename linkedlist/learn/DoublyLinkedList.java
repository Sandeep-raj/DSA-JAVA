package linkedlist.learn;

import java.util.Random;

/*
 * Doubly Linked List
 * 
 * Geek is learning data structures and is familiar with linked lists, but he's curious about how to access the previous element in a linked list in the same way that we access the next element. His teacher explains doubly linked lists to him.
Given an integer array arr of size n. Construct the doubly linked list from arr and return the head of it.

Input:
n = 5
arr = [1,2,3,4,5]
Output:
1 2 3 4 5
Explanation: Linked list for the given array will be 1<->2<->3<->4<->5.


Input:
n = 5
arr = [1,2,3,4,5]
Output:
1 2 3 4 5
Explanation: Linked list for the given array will be 1<->2<->3<->4<->5.

Constraints:
1 <= n <= 105
1 <= arr[i] <= 100

Your Task:
You don't need to read input or print anything. Your task is to complete the function constructDLL() which takes arr[] as input parameters and returns the head of the Linked List.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
 */

public class DoublyLinkedList {
    public static class Node {
        public int key;
        public Node next;
        public Node prev;

        public Node(int key) {
            this.key = key;
        }
    }

    private int size = 0;
    public Node head = null;
    private Node tail = null;

    public Node insert(int key) {
        Node n = new Node(key);
        if(this.size > 0) {
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
        }else {
            this.head = n;
            this.tail = n;
        }

        this.size++;
        return n;
    }

    public Node remove(int key) {
        Node curr = this.head;
        
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        if(curr != null) {
            Node left = curr.prev;
            Node right = curr.next;

            if(this.size == 1) {
                this.head = null;
                this.tail = null;
            }else {
                if(this.head == curr) {
                    this.head = this.head.next;
                }else if (this.tail == curr) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                }else {
                    left.next = right;
                    right.prev = left;
                }
            }
            this.size--;
            return curr;
        }else {
            return null;
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Node curr = this.head;

        while (curr != null) {
            sb.append(curr.key);
            if(curr.next != null ) {
                sb.append(" <> ");
            }

            curr = curr.next;
        }

        return sb.toString();
    }

    public int size() {
        return this.size;
    }

    public void reverse() {
        Node head = null;
        Node tail = null;

        Node curr = this.head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = null;
            curr.prev = null;
            if(head == null) {
                head = curr;
                tail = curr;
            }else {
                curr.next = head;
                head.prev = curr;
                head = curr;
            }


            if(next != null) {
                next.prev = null;
            }
            curr = next;
        }

        this.head = head;
        this.tail = tail;
    }

    public static void test() {
        DoublyLinkedList dll =  new DoublyLinkedList();
        int[] inp = new int[]{1,2,3,4,5};

        for (int  i = 0; i < inp.length; i++) {
            dll.insert(inp[i]);
        }

        System.out.println(dll.print());
        dll.reverse();
        System.out.println(dll.print());

        Random rand = new Random();
        while (dll.size() > 0) {
            int r = 1 + rand.nextInt(6);

            System.out.println("removing "+r+" from the dll");
            dll.remove(r);
            System.out.println(dll.print());
        }
    }
}
