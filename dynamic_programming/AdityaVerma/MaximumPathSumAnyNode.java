package dynamic_programming.AdityaVerma;

import binary_tree.utils.Create.Node;

/*
 * Maximum path sum from any node
 * 
 * Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
 * 
 * Input:
     10
    /  \
   2   -25
  / \  /  \
 20 1  3  4
Output: 32
Explanation: Path in the given tree goes
like 10 , 2 , 20 which gives the max
sum as 32.


Input:
     10
   /    \
  2      5
          \
          -2
Output: 17
Explanation: Path in the given tree goes
like 2 , 10 , 5 which gives the max sum
as 17.



Your Task:
You don't need to take input or print anything. Your task is to complete the function findMaxSum() that takes root as input and returns max sum between any two nodes in the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 103
1 ≤ |Data on node| ≤ 104
 */

public class MaximumPathSumAnyNode {
    public static int maxPathSum(int[] arr) {
        int[] ans = new int[1];
        Node root = binary_tree.utils.Create.createBinTree(arr);

        return solve(root, ans);
    }

    static int solve(Node root, int[] ans) {
        if(root == null) {
            return 0;
        }

        int left = solve(root.left, ans);
        int right = solve(root.right, ans);

        int temp = Math.max(Math.max(left, right) + root.key, root.key);
        ans[0] = Math.max(left + right + root.key, ans[0]);
        return temp;
    }
}
