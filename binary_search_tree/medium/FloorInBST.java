package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Floor in a Binary Search Tree
 * 
 * Problem Statement: Given a Binary Search Tree and a key, return the floor of the given key in the Binary Search Tree.

>   Floor of a value refers to the value of the largest node in the Binary Search Tree that is smaller than or equal to the given key.
>   If the floor node does not exist, return nullptr.

Example 1:
Input:Binary Search Tree: 10 5 15 2 6 -1 -1, Key = 7
Output:6
Explanation: In the given BST, the largest value greater or equal to 7 is 6. 
Example 2:
Input:Binary Search Tree: 8 5 12 4 7 10 14 -1 -1 6 -1 -1 -1 13, Key = 9
Output: 8
Explanation:  In the given BST, the smallest value greater or equal to 9 is 8. 
 */

public class FloorInBST {
    public static int floor(int[] arr, int k) {
        Node root = Create.createBinTree(arr);
        int floor = Integer.MIN_VALUE;

        while (root != null) {
            if(root.key > k) {
                root = root.left;
            }else if(root.key < k) {
                floor = Math.max(root.key, floor);
                root = root.right;
            }else {
                floor = root.key;
                break;
            }
        }

        return floor == Integer.MIN_VALUE ? -1 : floor;
    }
}
