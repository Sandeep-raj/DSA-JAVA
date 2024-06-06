package binary_tree.hard;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Check for Children Sum Property in a Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, convert the value of its nodes to follow the Children Sum Property. The Children Sum Property in a binary tree states that for every node, the sum of its children's values (if they exist) should be equal to the node's value. If a child is missing, it is considered as having a value of 0.
 * 
 * Note:
The node values can be increased by any positive integer any number of times, but decrementing any node value is not allowed.
A value for a NULL node can be assumed as 0.
We cannot change the structure of the given binary tree.

Example 1:
Input:Binary Tree: 2 35 10 2 3 5 2
Output: Binary Tree: 45 35 10 30 5 8 2
Explanation: We cannot decrement the value of the node but only increment. There are many different ways to do this but we have to ensure that we are only increasing the values of the nodes in such a way that its value is equal to the sum of its left and right children.


Example 2:
Input:Binary Tree: 50 7 2 3 5 1 30
Output : Binary Tree: 50 55 5 86 1 31 30 
Explanation: We modify the tree in such a way that the value of each node becomes the value of its left and right children. If a node is a left or right child and its parent is of a greater value, since we cannot decrease the value of the parent, we increase the value of the children nodes so that the Binary Tree follows the children sum property.
 */

public class ChildrenSumProperty {
    public static void childrenSumProperty(int[] arr) {
        Node head = Create.createBinTree(arr);
        adjust(head);
        inorderTraversal(head);
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }

    public static void adjust(Node curr) {
        if(curr == null) {
            return;
        }

        int count = 0;
        if(curr.left != null) {
            count += curr.left.key;
        }
        if(curr.right != null) {
            count += curr.right.key;
        }


        if(curr.key > count) {
            if(curr.left != null){
                curr.left.key = count;
            }
            if(curr.right != null){
                curr.right.key = count;
            }
        }else {
            curr.key = count;
        }


        adjust(curr.left);
        adjust(curr.right);


        int tot = 0;
        if(curr.left != null) {
            tot += curr.left.key;
        }
        if(curr.right != null) {
            tot += curr.right.key;
        }

        if(tot > 0) {
            curr.key = tot;
        }
    }
}
