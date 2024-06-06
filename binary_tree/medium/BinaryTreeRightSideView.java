package binary_tree.medium;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import binary_tree.medium.VerticalOrderTraversalBinaryTree.AuxNode;
import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Binary Tree Right Side View
 * 
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Input: root = [1,null,3]
Output: [1,3]


Input: root = []
Output: []
 * 
 */

public class BinaryTreeRightSideView {
    public static int[] right(int[] arr) {
        Node head = Create.createBinTree(arr);
        ArrayList<AuxNode> q= new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();

        q.add(new AuxNode(head, 0, 0));

        while (!q.isEmpty()) {
            AuxNode n = q.remove(0);

            map.put(n.level, n.node.key);

            if(n.node.left != null) {
                q.add(new AuxNode(n.node.left, n.vertical - 1, n.level + 1));
            }

            if(n.node.right != null) {
                q.add(new AuxNode(n.node.right, n.vertical + 1, n.level + 1));
            }
        }

        int[] result = new int[map.size()];
        int cnt = 0;
        for(Entry<Integer,Integer> kv : map.entrySet()) {
            result[cnt] = kv.getValue();
            cnt++;
        }

        return result;
    }
}
