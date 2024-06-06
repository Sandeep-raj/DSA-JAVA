package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Ceil in a Binary Search Tree
 * 
 * Problem Statement: Given a Binary Search Tree and a key, return the ceiling of the given key in the Binary Search Tree.
>    Ceiling of a value refers to the value of the smallest node in the Binary Search Tree that is greater than or equal to the given key.
>    If the ceiling node does not exist, return nullptr.

Example 1:
Input:Binary Search Tree: 10 5 13 3 6 11 14 2 4 -1 9, Key = 8
Output:9
Explanation: In the given BST, the smallest value greater or equal to 8 is 9. 


Example 2:
Input:Binary Search Tree: 8 5 12 4 7 10 14 -1 -1 6 -1 -1 -1 13, Key = 8
Output: 12
Explanation:  In the given BST, the smallest value greater or equal to 11 is 12.
 */

public class CeilInBST {
    public static int ceil(int[] arr, int k) {
        Node root = Create.createBinTree(arr);
        int ceil = Integer.MAX_VALUE;

        while (root != null) {
            if(root.key > k) {
                ceil = Math.min(ceil, root.key);
                root = root.left;
            }else if(root.key < k) {
                root = root.right;
            }else {
                ceil = root.key;
                break;
            }
        }

        return ceil == Integer.MAX_VALUE ? -1 : ceil;
    }
}
