package binary_tree.hard;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Lowest Common Ancestor for two given Nodes
 * 
 * Problem Statement: Given a binary tree, Find the Lowest Common Ancestor for two given Nodes (x,y).
Lowest Common Ancestor(LCA): The lowest common ancestor is defined between two nodes x and y as the lowest node in T that has both x and y as descendants (where we allow a node to be a descendant of itself.

INPUT - [1,2,3,4,5,6,7]

Example 1: 
Input: x = 4 , y = 5
Output: 2 
Explanation: All ancestors for 4,5 are 2,1.  But we need Lowest Common ancestor, So we will consider lowest and also common ancestor that is 2

Example 2:
Input: 
x = 2 , y = 3
Output: 1
Explanation:  Lowest Common Ancestor for x,y i.e for 2,3 is 1

Example 3:
Input: 
x= 6 , y = 7
Output: 3
Explanation:  Lowest Common Ancestor for x,y i.e for 6,7 is 3 
 */

public class LCAfor2Nodes {
    public static int lca(int[] arr, int a, int b) {
        Node head = Create.createBinTree(arr);
        Node ancestor = traverse(head, a, b);
        return ancestor.key;
    }

    public static Node traverse(Node curr, int a, int b) {
        if(curr == null || curr.key == a || curr.key == b) {
            return curr;
        }

        Node l = traverse(curr.left, a, b);
        Node r = traverse(curr.right, a, b);

        if(l == null) {
            return r;
        }else if( r == null) {
            return l;
        }else {
            return curr;
        }
    }
}
