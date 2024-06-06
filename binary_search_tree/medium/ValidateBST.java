package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Validate Binary Search Tree
 * 
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:

>   The left subtree of a node contains only nodes with keys less than the node's key.
>   The right subtree of a node contains only nodes with keys greater than the node's key.
>   Both the left and right subtrees must also be binary search trees.

Input: root = [2,1,3]
Output: true

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */

public class ValidateBST {
    public static boolean validate(int[] arr) {
        Node root = Create.createBinTree(arr);
        int[] range = new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
        return valid(root, range);
    }

    public static boolean valid(Node curr, int[] range) {
        if(curr == null) {
            return true;
        }

        if(curr.key < range[0] || curr.key > range[1] ) {
            return false;
        }

        boolean lvalid = valid(curr.left, new int[]{range[0],curr.key});
        boolean rvalid = valid(curr.right, new int[]{curr.key,range[1]});

        return lvalid & rvalid;
    }
}
