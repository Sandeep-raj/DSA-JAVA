package binary_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


Input: p = [1,2,3], q = [1,2,3]
Output: true


Input: p = [1,2], q = [1,null,2]
Output: false

Input: p = [1,2,1], q = [1,1,2]
Output: false

Input:Binary Tree 1: 1 2 3 -1 -1 4 5, Binary Tree 2: 1 2 3 -1 -1 4 5
Output: True, these trees are identical.
 */

public class SameTree {
    public static boolean same(int[] arr1, int[] arr2) {
        Node n1 = Create.createBinTree(arr1);
        Node n2 = Create.createBinTree(arr2);

        return isSame(n1, n2);
    }

    public static boolean isSame(Node curr1 , Node curr2) {
        if(curr1 == null || curr2 == null) {
            if(curr1 == curr2) {
                return true;
            }else {
                return false;
            }
        }

        if(curr1.key != curr2.key) {
            return false;
        }

        boolean left = isSame(curr1.left, curr2.left);
        boolean right = isSame(curr1.right, curr2.right);

        return left & right;
    }
}
