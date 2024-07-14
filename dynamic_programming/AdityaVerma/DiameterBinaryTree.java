package dynamic_programming.AdityaVerma;

import binary_tree.utils.Create.Node;

/*
 * Diameter of a Binary Tree
 * 
 * Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Input: root = [1,2]
Output: 1
 */

public class DiameterBinaryTree {
    public static int diameter(int[] arr) {
        Node root = binary_tree.utils.Create.createBinTree(arr);
        int[] ans = new int[1];
        solve(root, ans);
        return ans[0];
    }

    static int solve(Node root, int[] ans) {
        if(root == null) {
            return 0;
        }

        int left = solve(root.left, ans);
        int right = solve(root.right, ans);

        int temp = Math.max(left, right) + 1;
        ans[0] = Math.max(ans[0], left + right + 1);
        return temp;
    }
}
