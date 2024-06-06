package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Predecessor and Successor
 * 
 * There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.
Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor.


Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
key = 8 Output: 
4 9 Explanation: 
In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.


Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
key = 11 Output: 
10 -1 Explanation: 
In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.



Your Task: You don't need to print anything. You need to update pre with the predecessor of the key or NULL if the predecessor doesn't exist and succ to the successor of the key or NULL if the successor doesn't exist. pre and succ are passed as an argument to the function findPreSuc(). Please note, The key may be located either inside or outside the tree.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints: 
1 <= Number of nodes <= 104
1 <= key of node <= 107
1 <= key <= 107


 */

public class PredecessorAndSuccessor {
    public static int[] find(int[] arr, int k) {
        Node root = Create.createBinTree(arr);
        int predecessor = -1;
        int successor = Integer.MAX_VALUE;

        Node curr = root;
        while (curr != null) {
            if(curr.key > k) {
                curr = curr.left;
            }else if(curr.key < k) {
                predecessor = Math.max(predecessor, curr.key);
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }

        curr = root;
        while (curr != null) {
            if(curr.key > k) {
                successor = Math.min(successor, curr.key);
                curr = curr.left;
            }else if(curr.key < k) {
                curr = curr.right;
            }else {
                curr = curr.right;
            }
        }

        return new int[]{predecessor,successor};
    }
}

