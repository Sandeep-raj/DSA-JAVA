package binary_search_tree.medium;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Delete Node in a BST
 * 
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

>   Search for a node to remove.
>   If the node is found, delete the node.

Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.


Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.


Input: root = [], key = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
 */

public class DeleteNodeBST {
    public static String delete(int[] arr, int k) {
        Node root = Create.createBinTree(arr);
        Node curr = delNode(root, k);
        return Create.LvlTraversal(curr);
    }

    public static Node delNode(Node curr, int k) {
        if(curr == null) {
            return null;
        }

        if(curr.key > k) {
            Node lNode = delNode(curr.left, k);
            if(curr.left != null && curr.left.key == k) {
                curr.left = lNode;
            }
            return curr;
        }else if(curr.key < k) {
            Node rNOde = delNode(curr.right, k);
            if(curr.right != null && curr.right.key == k) {
                curr.right = rNOde;
            }
            return curr;
        }

        if(curr.left == null && curr.right == null) {
            return null;
        }else if(curr.left == null && curr.right != null) {
            return curr.right;
        }else if(curr.left != null && curr.right == null) {
            return curr.left;
        }else {
            Node rightN = curr.right;
            Node leftN = curr.left;
            Node next = leftN;

            while (next.right != null) {
                next = next.right;
            }
            next.right = rightN;
            curr.right = null;
            return curr.left;
        }
    }
}
