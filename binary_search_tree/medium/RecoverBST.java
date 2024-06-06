package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Recover Binary Search Tree
 * 
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * 
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.


Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 

Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 */

public class RecoverBST {
    static Node prev = null;
    static Node first = null;
    static Node mid = null;
    static Node last = null;

    public static String recover(int[] arr) {
        Node root = Create.createBinTree(arr);
        inorder(root);

        if(last == null) {
            int temp = mid.key;
            mid.key = first.key;
            first.key = temp;
        }else {
            int temp = first.key;
            first.key = last.key;
            last.key = temp;
        }

        return Create.LvlTraversal(root);
    }

    static void inorder(Node curr) {
        if(curr == null) {
            return;
        }

        inorder(curr.left);

        if(prev != null && curr.key < prev.key) {
            if(first == null) {
                first = prev;
                mid = curr;
            }else {
                last = curr;
            }
        }

        prev=curr;

        inorder(curr.right);
    }
}
