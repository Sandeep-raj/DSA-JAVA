package binary_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Symmetric Tree
 * 
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 
Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false
 */

public class SymmetricTree {
    public static boolean symm(int[] arr) {
        Node head = Create.createBinTree(arr);

        Node lhead = head.left;
        Node rhead = head.right;

        return issymm(lhead, rhead);
    }

    public static boolean issymm(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            if(head1 == null && head1 == null) {
                return true;
            }
            return false;
        }

        if(head1.key != head2.key) {
            return false;
        }

        boolean lsym = issymm(head1.left, head2.right);
        boolean rsym = issymm(head1.right, head2.left);

        return lsym&rsym;
    }
}
