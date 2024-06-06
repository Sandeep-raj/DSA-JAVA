package binary_tree.medium;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import binary_tree.medium.VerticalOrderTraversalBinaryTree.AuxNode;
import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Top view of a Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, return its Top View. The Top View of a Binary Tree is the set of nodes visible when we see the tree from the top.
 * 
 * Example 1:
Input:Binary Tree: 1, 2, 3, 4, 10, 9, 11, -1, 5, -1, -1, -1, -1, -1, -1, -1, 6
Output: Top View: [4, 2, 1, 3, 11]

Example 2:
Input:Binary Tree: 2 7 5 2 6 -1 9 -1 -1 5 11 4 -1
Output : Top View: [2, 7, 2, 5, 9]
 */

public class TopViewBinaryTree {
    public static int[] top(int[] arr) {
        Node head = Create.createBinTree(arr);
        TreeMap<Integer, Integer> map = new TreeMap<>();

        ArrayList<AuxNode> q = new ArrayList<>();
        q.add(new AuxNode(head, 0, 0));

        while (!q.isEmpty()) {
            AuxNode n = q.remove(0);

            if(!map.containsKey(n.vertical)) {
                map.put(n.vertical, n.node.key);
            }

            if(n.node.left != null) {
                q.add(new AuxNode(n.node.left, n.vertical - 1, n.level + 1));
            }

            if(n.node.right != null) {
                q.add(new AuxNode(n.node.right, n.vertical + 1, n.level + 1));
            }
        }

        int[] result = new int[map.size()];
        int cnt = 0;
        for(Entry<Integer,Integer> entry : map.entrySet()) {
            result[cnt] = entry.getValue();
            cnt++;
        }

        return result;
    }
}
