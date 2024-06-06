package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Construct Binary Search Tree from Preorder Traversal
 * 
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
 * It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
 * 
 * A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
 * A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 * 
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Input: preorder = [1,3]
Output: [1,null,3]

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.
 */

public class ConstructBSTfromPreorder {
    public static String construct(int[] preorder) {
        int[] bound = new int[]{Integer.MAX_VALUE};
        int[] idx = new int[]{0};
        Node root = constructBST(preorder, bound, idx);

        return Create.LvlTraversal(root);
    }

    public static Node constructBST(int[] preorder, int[] bound, int[] idx) {
        if(idx[0] >= preorder.length || bound[0] < preorder[idx[0]]) {
            return null;
        }

        Node n = new Node(preorder[idx[0]]);
        idx[0]++;


        n.left = constructBST(preorder, new int[]{n.key}, idx);
        n.right =constructBST(preorder, bound, idx);

        return n;
    }
}
