package binary_tree.medium;

import binary_tree.utils.Create.Node;

/*
 * Maximum depth of a Binary Tree
 * 
 * Given the root of a Binary Tree, return the height of the tree. The height of the tree is equal to the number of nodes on the longest path from root to a leaf.
 * 
 * Input: Binary Tree: 1 2 5 -1 -1 4 6 5
 * Output: 4
Explanation: In the above example, the height of the binary tree is along the longest path from the root node 1 -> 5 -> 4 -> 5. 


Input:Binary Tree: 3 1 2
Output : 2
Explanation: We traverse the binary tree in the order of Left, RIght then Root recursively resulting in the following traversal:
 */

public class HeightOfTree {
    public static int height(int[] arr) {
        Node head = binary_tree.utils.Create.createBinTree(arr);
        return getheight(head);
    }

    public static int getheight(Node curr) {
        if(curr == null) {
            return 0;
        }

        int maxl = getheight(curr.left);
        int maxr = getheight(curr.right);

        return (1 + Math.max(maxl, maxr));
    }
}
