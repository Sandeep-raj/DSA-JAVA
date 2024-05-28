package linkedlist.dll_medium;

import linkedlist.learn.DoublyLinkedList;
import linkedlist.learn.DoublyLinkedList.Node;

/*
 * Delete all occurrences of a given key in a doubly linked list
 * 
 * You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.
 * 
 * Input: 
2<->2<->10<->8<->4<->2<->5<->2
2
Output: 
10<->8<->4<->5
Explanation: 
All Occurences of 2 have been deleted.

Input: 
9<->1<->3<->4<->5<->1<->8<->4
9
Output: 
1<->3<->4<->5<->1<->8<->4
Explanation: 
All Occurences of 9 have been deleted.

Your Task:

Complete the function void deleteAllOccurOfX(struct Node** head_ref, int key), which takes the reference of the head pointer and an integer value key. Delete all occurrences of the key from the given DLL.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:

1<=Number of Nodes<=105
0<=Node Value <=109
 */

public class DeleteAllOccurrences {
    public static Node deleteOcc(Node head, int k) {
        Node curr = head;
        while (curr != null) {
            if(curr.key == k) {
                if(curr == head) {
                    Node next = curr.next;
                    curr.next = null;
                    next.prev = null;
                    head = next;
                    curr = next;
                }else {
                    Node left = curr.prev;
                    Node right = curr.next;
                    left.next = right;
                    if(right != null) {
                        right.prev = left;
                    }
                    curr = right;
                }
            }else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void delete(int[] arr, int n) {
        DoublyLinkedList dll = new DoublyLinkedList();
        for(int i = 0; i < arr.length; i++) {
            dll.insert(arr[i]);
        }


        Node delNode = deleteOcc(dll.head, n);
        StringBuilder sb = new StringBuilder();
        while (delNode != null) {
            sb.append(delNode.key);
            if(delNode.next != null) {
                sb.append(" -> ");
            }

            delNode = delNode.next;
        }

        System.out.println(sb.toString());
    }
}
