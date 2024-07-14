package dynamic_programming.AdityaVerma;

import binary_tree.utils.Create.Node;

/*
 * Maximum Path sum | From leaf node to leaf node
 * 
 * Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another. 
The maximum sum path may or may not go through the root. For example, in the following binary tree, the maximum sum is 27(3 + 6 + 9 + 0 – 1 + 10). Expected time complexity is O(n). If one side of the root is empty, then the function should return minus infinite (INT_MIN in case of C/C++)

input: [-15,5,6,-8,1,3,9,2,6,-1,-1,1,-1,-1,0,-1,-1,-1,-1,4,-2,-1,-1,10,-1]
output: 27

Input: [5, 6 ,2 ,4 ,3 ,-1, -1, 9, 7, -1, -1, -1, -1, -1, -1]
output: 26

input: [2, 3, -1, -1, -1]
output: -1
 */

public class MaximumPathSumFromLeaves {
    public static int maxPathSum(int[] arr) {
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

        int temp = Integer.MIN_VALUE;
        if(root.left == null && root.right == null) {
            temp = Math.max(Math.max(right, left) + root.key, root.key);
        }else {
            temp = Math.max(right, left) + root.key;
        }

        ans[0] = Math.max(left + right + root.key, ans[0]);
        return temp;
    }
}
