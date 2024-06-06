package binary_tree.medium;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import binary_tree.medium.VerticalOrderTraversalBinaryTree.AuxNode;
import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Bottom view of a Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, return its Bottom View. The Bottom View of a Binary Tree is the set of nodes visible when we see the tree from the bottom.
 * 
 * Example 1:
Input:Binary Tree: 1 2 3 4 10 9 11 -1 5 -1 -1 -1 -1 -1 -1 -1 6
Output:Bottom View Traversal: [4, 5, 6, 3, 11]
Explanation: The bottom view of the binary tree would comprise of the nodes that are the last encountered nodes for each vertical index.


Example 2:
Input:Binary Tree: 2 7 5 2 6 -1 9 -1 -1 5 11 4 -1
Output : Bottom View: [2 5 6 11 4 9]


 */

public class BottomViewBinaryTree {
    public static int[] bottom(int[] arr) {
        Node head = Create.createBinTree(arr);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        ArrayList<AuxNode> q = new ArrayList<>();
        q.add(new AuxNode(head, 0, 0));

        while (!q.isEmpty()) {
            AuxNode n = q.remove(0);

            map.put(n.vertical, n.node.key);
            
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
