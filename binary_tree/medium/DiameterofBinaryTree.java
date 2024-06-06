package binary_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Calculate the Diameter of a Binary Tree
 * 
 * Problem Statement: Given the root of the Binary Tree, return the length of its diameter. The Diameter of a Binary Tree is the longest distance between any two nodes of that tree. This path may or may not pass through the root.
 * 
 * Input:
    arr = [1,2,3,4,5]
   Output: 4


   Input : [1,2,3,-1,-1, 4, 7, 5, -1, -1, 8, 6, -1, -1, 9]
   Output : 7

 */

public class DiameterofBinaryTree {
    // <<< solution diff of extreme node in a tree >>>
    // public static int diameter(int[] arr) {
    //     Node head = Create.createBinTree(arr);
    //     int left = leftWidth(head, 0);
    //     int right = rigthWidth(head, 0);
    //     return left + right + 1;
    // }

    // public static int leftWidth(Node curr, int width) {
    //     if(curr == null) {
    //         return width - 1;
    //     }

    //     int lwidth = leftWidth(curr.left, width + 1);
    //     int rwidth = leftWidth(curr.right, width - 1);

    //     return Math.max(lwidth, rwidth);
    // }

    // public static int rigthWidth(Node curr, int width) {
    //     if(curr == null) {
    //         return width - 1;
    //     }

    //     int lwidth = leftWidth(curr.left, width - 1);
    //     int rwidth = leftWidth(curr.right, width + 1);

    //     return Math.max(lwidth, rwidth);
    // }

    /// xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    public static int diameter(int[] arr) {
        Node head = Create.createBinTree(arr);
        int[] diameter = new int[1];

        maxHeight(head, diameter);
        return diameter[0];
    }

    public static int maxHeight(Node curr ,int[] diameter) {
        if(curr == null) {
            return 0;
        }

        int lheight = maxHeight(curr.left, diameter);
        int rheight = maxHeight(curr.right, diameter);

        diameter[0] = Math.max(diameter[0], (lheight + rheight + 1));

        return 1 + Math.max(lheight, rheight);
    }
}
