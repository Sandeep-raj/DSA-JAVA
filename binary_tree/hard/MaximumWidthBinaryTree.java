package binary_tree.hard;

import java.util.ArrayList;

import binary_tree.medium.VerticalOrderTraversalBinaryTree.AuxNode;
import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Maximum Width of a Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, return its maximum width. The maximum width of a Binary Tree is the maximum diameter among all its levels. The width or diameter of a level is the number of nodes between the leftmost and rightmost nodes.
 * 
 * Example 1:
Input:Binary Tree: 1 2 3 5 6 -1 9
Output: Maximum Width: 4
Explanation: Level 3 is the widest level of the Binary Tree and whose end-to-end width is 4 comprising of nodes: {5, 6, null, 9}.

Example 2:
Input:Binary Tree: 1 2 3 5
Output : Maximum Width: 2
Explanation: Level 2 is the widest level of the Binary Tree and whose end-to-end width is comprised of nodes: {2, 3}.


 */

public class MaximumWidthBinaryTree {
    public static int maxwidth(int[] arr) {
        Node head = Create.createBinTree(arr);

        ArrayList<AuxNode> q = new ArrayList<>();
        ArrayList<AuxNode> auxq = new ArrayList<>();

        q.add(new AuxNode(head, 1, 1));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int maxWidth = -1;

        while(!q.isEmpty()) {
            AuxNode n = q.remove(0);

            min = Math.min(min, n.vertical);
            max = Math.max(max, n.vertical);

            if(n.node.left != null) {
                auxq.add(new AuxNode(n.node.left, 2 * n.vertical, 1));
            }
            if(n.node.right != null) {
                auxq.add(new AuxNode(n.node.right, 2 * n.vertical + 1, 1));
            }

            if(q.isEmpty()) {
                q = auxq;
                auxq = new ArrayList<AuxNode>();

                maxWidth = Math.max(maxWidth, max - min + 1);
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }

        return maxWidth;
    }
}
