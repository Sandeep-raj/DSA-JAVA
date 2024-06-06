package binary_tree.hard;

import java.util.HashMap;

import binary_tree.utils.Create.Node;

/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]


Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */

public class ConstructBTPreorder_Inorder {
    public static void contruct(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Node head = contructTree(preorder, inorder, map, 0, inorder.length - 1, 0, inorder.length - 1);
        inorderTraversal(head);
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }

    public static Node contructTree(int[] preorder, int[] inorder, HashMap<Integer,Integer> map, int pstart, int pend, int istart, int iend) {

        if(pstart > pend || istart > iend) {
            return null;
        }

        Node node = new Node(preorder[pstart]);
        int inIdx = map.get(node.key);

        int left_inorder_len = inIdx - istart;

        node.left = contructTree(preorder, inorder, map, pstart + 1, pstart + left_inorder_len,istart, inIdx - 1);
        node.right = contructTree(preorder, inorder, map, pstart + left_inorder_len + 1, pend,inIdx + 1, iend);

        return node;
    }
}
