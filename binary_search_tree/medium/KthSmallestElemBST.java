package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Kth Smallest Element in a BST
 * 
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 */

public class KthSmallestElemBST {
    public static int kth(int[] arr, int k) {
        Node root = Create.createBinTree(arr);
        int[] result = new int[]{0,-1};
        kthNode(root,result,k);
        return result[1];
    }

    static void kthNode(Node curr, int[] result, int k) {
        if(curr == null) {
            return;
        }

        kthNode(curr.left,result, k);
        result[0]++;
        if(result[0] == k) {
            result[1] = curr.key;
        }
        kthNode(curr.right, result, k);
    }
}
