package binary_search_tree.medium;

import java.util.Stack;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Two Sum IV - Input is a BST
 * 
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 * 
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Input: root = [5,3,6,2,4,null,7], k = 28
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 */

class AscBST {
    Node root = null;
    Stack<Node> stack = null;

    AscBST(int[] arr) {
        this.root = Create.createBinTree(arr);
        this.stack = new Stack<>();

        Node curr = this.root;
        while (curr != null) {
            this.stack.push(curr);
            curr = curr.left;
        }
    }

    boolean hasNext() {
        return this.stack.size() > 0;
    }

    Node next() {
        Node n = this.stack.pop();

        if(n.right != null) {
            Node curr = n.right;
            while (curr != null) {
                this.stack.push(curr);
                curr = curr.left;
            }
        }

        return n;
    }
}

class DscBST {
    Node root = null;
    Stack<Node> stack = null;

    DscBST(int[] arr) {
        this.root = Create.createBinTree(arr);
        this.stack = new Stack<>();

        Node curr = this.root;
        while (curr != null) {
            this.stack.push(curr);
            curr = curr.right;
        }
    }

    boolean hasNext() {
        return this.stack.size() > 0;
    }

    Node next() {
        Node n = this.stack.pop();

        if(n.left != null) {
            Node curr = n.left;
            while (curr != null) {
                this.stack.push(curr);
                curr = curr.right;
            }
        }

        return n;
    }
}

public class TwoSumIVInputBST {
    public static boolean twosum(int[] arr , int k) {
        AscBST ascArr = new AscBST(arr);
        DscBST dscArr = new DscBST(arr);

        int left = ascArr.next().key, right = dscArr.next().key;
        while (ascArr.hasNext() && dscArr.hasNext()) {
            if(left + right == k) {
                return true;
            }else if(left + right > k) {
                right = dscArr.next().key;
            }else {
                left = ascArr.next().key;
            }
        }

        return false;
    }
}
