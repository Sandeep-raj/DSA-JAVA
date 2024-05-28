package linkedlist.learn;

import java.util.Random;

/*
 * Introduction to Linked List
 * 
 * Geek loves linked list data structure. Given an array of integer arr of size n, Geek wants to construct the linked list from arr.

Construct the linked list from arr and return the head of the linked list.

Input:
n = 5
arr = [1,2,3,4,5]
Output:
1 2 3 4 5
Explanation: Linked list for the given array will be 1->2->3->4->5.


Input:
n = 2
arr = [2,4]
Output:
2 4
Explanation: Linked list for the given array will be 2->4.


Constraints:
1 <= n <= 105
1 <= arr[i] <= 100

Your Task:
You don't need to read input or print anything. Your task is to complete the function constructLL() which takes arr[] as input parameters and returns the head of the Linked List.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
 */

public class LinkedList {
    public static class Node {
        public int Key;
        public Node next;

        public Node(int key) {
            this.Key = key;
        }
    }

    public Node head = null;
    public Node tail = null;
    private int size = 0;

    public Node insert(int k) {
        Node n = new Node(k);
        if(size == 0) {
            this.head = n;
            this.tail = n;
        }else {
            this.tail.next = n;
            this.tail = n;
        }
        this.size++;

        return n;
    }

    public Node removeFirst() {
        if(this.size > 0) {
            Node n = this.head;
            this.head = this.head.next;
            this.size--;

            if(this.size == 0) {
                this.tail = null;
            }
            return n;
        }else {
            return null;
        }
    }

    public Node remove(int key) {
        if(this.size > 0) {
            if(this.head.Key == key) {
                return removeFirst();
            }else {
                Node curr = this.head;
                while (curr.next != null && curr.next.Key != key) {
                    curr = curr.next;
                }

                if(curr.next != null) {
                    Node n = curr.next;
                    curr.next = curr.next.next;
                    if(this.tail == n) {
                        this.tail = curr;
                    }
                    this.size--;
                    return n;
                }else {
                    return null;
                }
            }
        }else {
            return null;
        }
    }

    public Node search(int key) {
        Node curr = this.head;
        while (curr != null && curr.Key != key) {
            curr = curr.next;
        }

        return curr;
    }

    public int size() {
        return this.size;
    }

    public String print() {
        Node curr = this.head;
        StringBuilder sb = new StringBuilder();

        while (curr != null) {
            sb.append(curr.Key);
            if(curr.next != null) {
                sb.append(" -> ");
            }
            curr = curr.next;
        }

        return sb.toString();
    }

    public Node getMiddle() {
        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void test() {
        int[] inp = new int[]{1,2,3,4,5};
        LinkedList ll = new LinkedList();

        for(int i = 0; i < inp.length; i++) {
            ll.insert(inp[i]);
        }

        System.out.println(ll.search(3).Key);

        System.out.println(ll.print());
        Random rand  = new Random();
        while (ll.size() > 0) {
            int r = 1 + rand.nextInt(5);
            System.out.print("removing "+ r +" from ll\n");

            ll.remove(r);
            System.out.println(ll.print());
        }
    }
}
