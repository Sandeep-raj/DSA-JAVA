package binary_tree.hard;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Flatten Binary Tree to Linked List
 * 
 * Problem Statement: Given a Binary Tree, convert it to a Linked List where the linked list nodes follow the same order as the pre-order traversal of the binary tree.
Use the right pointer of the Binary Tree as the ‘next’ pointer for the linked list and set the left pointer to null. Do this in place and do not create extra nodes.

Example 1:
Input:Binary Tree: 1 2 5 3 4 -1 6 -1 -1 -1 -1 7
Output: 1 -1 2 -1 3 -1 4 -1 5 -1 6 -1 7
 */

public class FlattenBinaryTreeLinkedList {
    public static void flatten(int[] arr) {
        Node head = Create.createBinTree(arr);

        Node curr = head;
        while (curr != null) {
            if(curr.right != null && curr.left != null) {
                Node next = curr.left;
                while (next.right != null) {
                    next = next.right;
                }

                next.right = curr.right;
            }
                
            if(curr.left != null) {
                curr.right = curr.left;
                curr.left = null;
            }
            
            curr = curr.right;
        }

        curr = head;
        while (curr != null) {
            System.out.print(curr.key + " -> ");
            curr = curr.right;
        }
    }
}
