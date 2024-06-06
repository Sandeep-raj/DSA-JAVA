package binary_search_tree.easy;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Minimum element in BST
 * 
 * Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST.
 * 
 * Input:
           5
         /    \
        4      6
       /        \
      3          7
     /
    1
Output: 1 7

Input:
             9
              \
               10
                \
                 11
Output: 9 11


Your Task:
The task is to complete the function minValue() which takes root as the argument and returns the minimum element of BST. If the tree is empty, there is no minimum element, so return -1 in that case.

Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(1).

Constraints:
0 <= n <= 104
 */

public class MinMaxinBST {
    public static int[] minmax(int[] arr) {
        Node head = Create.createBinTree(arr);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Node curr = head;
        while (curr.left != null) {
            curr = curr.left;
        }
        min = curr.key;

        curr = head;
        while (curr.right != null) {
            curr = curr.right;
        }
        max = curr.key;

        return new int[]{min,max};
    }
}
