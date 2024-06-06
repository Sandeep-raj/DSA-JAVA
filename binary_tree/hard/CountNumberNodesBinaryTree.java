package binary_tree.hard;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Count Number of Nodes in a Binary Tree
 * 
 * Problem Statement: Given a Complete Binary Tree, count and return the number of nodes in the given tree. A Complete Binary Tree is a binary tree in which all levels are completely filled, except possibly for the last level, and all nodes are as left as possible.
 * 
 * Example 1:
Input: Binary Tree: 1 2 3 4 5 6
Output: 6
Explanation: There are 6 nodes in this Binary Tree.


Example 2:
Input: Binary Tree: 2 4 3 5 9 8 7 1 6
Output : 9
Explanation: There are 9 nodes in this Binary Tree.
 */

public class CountNumberNodesBinaryTree {
    public static int count(int[] arr) {
        Node head = Create.createBinTree(arr);
        return countNodes(head);
    }

    public static int countNodes(Node curr) {

        int lh = getLeftHeight(curr);
        int rh = getRightHeight(curr);

        if(lh == rh) return ((1<<lh) - 1);

        return 1 + countNodes(curr.left) + countNodes(curr.right);
    }

    public static int getLeftHeight(Node curr) {
        int cnt = 0;
        while (curr != null) {
            curr = curr.left;
            cnt++;
        }
        return cnt;
    }

    public static int getRightHeight(Node curr) {
        int cnt = 0;
        while (curr != null) {
            curr = curr.right;
            cnt++;
        }
        return cnt;
    }
}
