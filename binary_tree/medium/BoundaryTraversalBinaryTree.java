package binary_tree.medium;

import java.util.ArrayList;
import java.util.Stack;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Boundary Traversal of a Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, perform the boundary traversal of the tree. The boundary traversal is the process of visiting the boundary nodes of the binary tree in the anticlockwise direction, starting from the root.
 * 
 * Example 1:
Input:Binary Tree: 1 2 7 3 -1 -1 8 -1 4 9 -1 5 6 10 11
Output: Boundary Traversal: [1, 2, 3, 4, 5, 6, 10, 11, 9, 8, 7]
Explanation: The boundary traversal of a binary tree involves visiting its boundary nodes in an anticlockwise direction:
				
Starting from the root, we traverse from: 1
The left side traversal includes the nodes: 2, 3, 4
The bottom traversal include the leaf nodes: 5, 6, 10, 11
The right side traversal includes the nodes: 9, 8, 7
We return to the  root and the boundary traversal is complete.



Example 2:
Input:Binary Tree: 10, 5, 20, 3, 8, 18, 25, -1, 7, -1, -1
Output : Boundary Traversal: [10, 5, 3, 7, 8, 18, 25, 20]
Explanation: The boundary traversal of a binary tree involves visiting its boundary nodes in an anticlockwise direction:
				
Starting from the root, we traverse from: 10
The left side traversal includes the nodes: 5
The bottom traversal include the leaf nodes: 3, 7, 8, 18, 25
The right side traversal includes the nodes: 20
We return to the  root and the boundary traversal is complete.

 */

public class BoundaryTraversalBinaryTree {
    public static int[] boundary(int[] arr) {
        Node head = Create.createBinTree(arr);
        ArrayList<Node> traversal = new ArrayList<Node>();

        traversal.add(head);

        leftBound(head, traversal);
        leafNodes(head, traversal);
        rightBound(head, traversal);

        return traversal.stream().mapToInt(Node::getKey).toArray();
    }

    public static void leftBound(Node curr, ArrayList<Node> traversal) {
        while (!isleaf(curr)) {
            if(curr.left != null) {
                curr = curr.left;
            }else {
                curr = curr.right;
            }

            if(!isleaf(curr)) {
                traversal.add(curr);
            }
        }
    }

    public static void rightBound(Node curr, ArrayList<Node> traversal) {
        Stack<Node> temp = new Stack<>();
        while (!isleaf(curr)) {
            if(curr.right != null) {
                curr = curr.right;
            }else {
                curr = curr.left;
            }

            if(!isleaf(curr)) {
                temp.push(curr);
            }
        }

        while (!temp.isEmpty()) {
            traversal.add(temp.pop());
        }
    }

    public static void leafNodes(Node curr, ArrayList<Node> traversal) {
        if(isleaf(curr)) {
            traversal.add(curr);
            return;
        }

        if(curr.left != null) {
            leafNodes(curr.left, traversal);
        }

        if(curr.right != null) {
            leafNodes(curr.right, traversal);
        }
    }

    public static boolean isleaf(Node curr) {
        if(curr.left == null && curr.right == null) {
            return true;
        }
        return false;
    }
}
