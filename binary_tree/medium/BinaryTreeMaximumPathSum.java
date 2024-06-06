package binary_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Maximum Sum Path in Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, determine the maximum sum achievable along any path within the tree. A path in a binary tree is defined as a sequence of nodes where each pair of adjacent nodes is connected by an edge. Nodes can only appear once in the sequence, and the path is not required to start from the root. Identify and compute the maximum sum possible along any path within the given binary tree.
 * 
 * Example 1:
Input:Binary Tree: [-10,9,20,-1,-1,15,7]
Output: 42
Explanation: Out of all the paths possible in the Binary Tree, 15 -> 20 -> 7 has the greatest sum ie. 42.

Example 2:
Input:Binary Tree: [-2,2,1]
Output : 2
Explanation: Out of all the paths possible in the Binary Tree, a path starting and ending at the node with value 2 has the greatest sum ie. 2.


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.


Input: root = [-10,9,20,-1,-1,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */

public class BinaryTreeMaximumPathSum {
    public static int maxsum(int[] arr) {
        int[] maxsum = new int[1];
        Node head = Create.createBinTree(arr);
        max(head, maxsum);
        return maxsum[0];
    }

    public static int max(Node curr, int[] maxsum) {
        if(curr == null) {
            return 0;
        }

        int lsum = max(curr.left, maxsum);
        int rsum = max(curr.right, maxsum);

        maxsum[0] = Math.max(maxsum[0], (lsum + rsum + curr.key));

        return curr.key + Math.max(lsum, rsum);
    }
}
