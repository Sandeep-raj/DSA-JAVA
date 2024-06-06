package binary_tree.hard;

import java.util.ArrayList;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Morris Inorder Traversal of a Binary tree
 * 
 * Problem Statement: Given a Binary Tree, implement Morris Inorder Traversal and return the array containing its inorder sequence.

Morris Inorder Traversal is a tree traversal algorithm aiming to achieve a space complexity of O(1) without recursion or an external data structure. The algorithm should efficiently visit each node in the binary tree in inorder sequence, printing or processing the node values as it traverses, without using a stack or recursion.

Example 1:
Input:Binary Tree: 4 2 5 3 -1 7 6 -1 9 -1 -1 8 -1 1
Output: [3, 1, 9, 2, 4, 7, 5, 8, 6]
Explanation: We traverse the binary tree in the order of Left, Root then Right recursively resulting in the following traversal:

Example 2:
Input:Binary Tree: 1 2 3 4 5 6 7 -1 -1 8 -1 -1 -1 9 10
Output: [4,2,8,5,1,6,3,9,7,10]
Explanation: We traverse the binary tree in the order of Left, Root then Right recursively resulting in the following traversal:


 */

public class MorrisInorderTraversalBT {
    public static String inorder(int[] arr) {
        Node head = Create.createBinTree(arr);
        ArrayList<Integer> result = new ArrayList<>();

        Node curr = head;
        while (curr != null) {
            if(curr.left == null) {
                result.add(curr.key);
                curr = curr.right;
            }else {
                Node next = curr.left;

                while (next.right != null && next.right != curr) {
                    next = next.right;
                }

                if(next.right == null) {
                    next.right = curr;
                    curr = curr.left;
                }else {
                    next.right = null;
                    result.add(curr.key);
                    curr = curr.right;
                }
            }
        }

        return result.toString();
    }
}
