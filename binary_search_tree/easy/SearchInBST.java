package binary_search_tree.easy;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Search in a Binary Search Tree
 * 
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 * 
 * Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
 */

public class SearchInBST {
    public static String search(int[] arr, int k) {
        Node root = Create.createBinTree(arr);
        
        Node resultN = null;

        while (root != null) {
            if(root.key < k) {
                root = root.right;
            }else if(root.key > k) {
                root = root.left;
            }else {
                resultN = root;
                break;
            }
        }

        return Create.LvlTraversal(resultN);
    }
}
