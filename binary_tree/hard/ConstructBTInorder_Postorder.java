package binary_tree.hard;

import java.util.Hashtable;

import binary_tree.utils.Create.Node;

/*
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * 
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 */

public class ConstructBTInorder_Postorder {
    public static void contruct(int[] inorder, int[] postorder) {
        Hashtable<Integer,Integer> map = new Hashtable<>();
        for(int i =0; i < postorder.length; i++) {
            map.put(inorder[i], i);
        }

        Node head = contructTree(inorder, postorder, map, 0, postorder.length - 1, 0, postorder.length - 1);
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

    public static Node contructTree(int[] inorder, int[] postorder, Hashtable<Integer,Integer> map, int pstart, int pend, int istart, int iend) {
        if(pstart > pend || istart > iend) {
            return null;
        }

        int inIdx = map.get(postorder[pend]);
        Node node = new Node(postorder[pend]);

        int leftLen = inIdx - istart;

        node.left = contructTree(inorder, postorder, map, pstart, pstart + leftLen - 1, istart, inIdx - 1);
        node.right = contructTree(inorder, postorder, map, pstart + leftLen, pend - 1 , inIdx + 1, iend);

        return node;
    }
}
