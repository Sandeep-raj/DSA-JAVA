package binary_tree.medium;

import binary_tree.utils.Create.Node;

/*
 * Check if the Binary Tree is Balanced Binary Tree
 * 
 * Given a Binary Tree, return true if it is a Balanced Binary Tree else return false. A Binary Tree is balanced if, for all nodes in the tree, the difference between left and right subtree height is not more than 1.
Example 1:
Input:Binary Tree: 3 9 20 -1 -1 15 7
Output: True, This is a Balanced Binary Tree.
Explanation: The difference in the height of left and right subtree is 1 hence the tree is balanced.


Example 2:
Input:Binary Tree: 1 3 2 5 4 -1 -1 7 6 
Output : False, this is not a Balanced Binary Tree.
Explanation: The difference in the height of left and right subtree is 2 hence the tree is not balanced.
 */

public class BalancedBinaryTree {
    public static boolean check(int[] arr) {
        Node head = binary_tree.utils.Create.createBinTree(arr);
        int h = checkBalanced(head);
        
        if(h == - 1) {
            return false;
        }

        return true;
    }

    public static int checkBalanced(Node curr) {
        if(curr == null) {
            return 0;
        }

        int lheight = 1 + checkBalanced(curr.left);
        int rheight = 1 + checkBalanced(curr.right);

        if(lheight == -1 || rheight == -1) {
            return -1;
        }

        if(Math.abs(rheight - lheight) > 1) {
            return -1;
        }else {
            return Math.max(lheight, rheight);
        }
    }
}
