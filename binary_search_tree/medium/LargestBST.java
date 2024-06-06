package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Largest BST
 * 
 * Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.


Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2
Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8


Your Task:
You don't need to read input or print anything. Your task is to complete the function largestBst() that takes the root node of the Binary Tree as its input and returns the size of the largest subtree which is also the BST. If the complete Binary Tree is a BST, return the size of the complete Binary Tree. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106
 */

public class LargestBST {
    static class AuxNode {
        int maxLen = 0;
        int maxElem = 0;
        int minElem = 0;

        public AuxNode(int len, int max,int min) {
            this.maxElem = max;
            this.minElem = min;
            this.maxLen = len;
        }
    }

    public static int largest(int[] arr) {
        Node root = Create.createBinTree(arr);
        AuxNode result = postorder(root);   
        return result.maxLen;     
    }

    static AuxNode postorder(Node curr) {
        if(curr == null) {
            return new AuxNode(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        AuxNode left = postorder(curr.left);
        AuxNode right = postorder(curr.right);

        if(curr.key > left.maxElem && curr.key < right.minElem) {
            return new AuxNode(1 + left.maxLen + right.maxLen, Math.max(curr.key, right.maxElem), Math.min(curr.key, left.minElem));
        }else {
            if(curr.key > left.maxElem) {
                return new AuxNode(Math.max(left.maxLen, right.maxLen), Integer.MAX_VALUE, Integer.MIN_VALUE);
            }else {
                return new AuxNode(Math.max(left.maxLen, right.maxLen), Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
        }
    }
}
