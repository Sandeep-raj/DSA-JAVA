package binary_tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Map.Entry;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Vertical Order Traversal of a Binary Tree
 * 
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.


Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.



Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.


Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 */

public class VerticalOrderTraversalBinaryTree {
    public static class AuxNode {
        public Node node;
        public int vertical;
        public int level;

        public AuxNode(Node node, int vert, int lvl) {
            this.node = node;
            this.vertical = vert;
            this.level = lvl;
        }
    }

    public static int[][] vertical(int[] arr) {
        Node head =  Create.createBinTree(arr);
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> result = new TreeMap<>();
        List<AuxNode> q = new ArrayList<AuxNode>();

        q.add(new AuxNode(head, 0, 0));

        while (!q.isEmpty()) {
            AuxNode n = q.remove(0);

            TreeMap<Integer,PriorityQueue<Integer>> temp = result.get(n.vertical);
            if(temp == null) {
                temp = new TreeMap<Integer,PriorityQueue<Integer>>();
                result.put(n.vertical, temp);
            }

            if(temp.get(n.level) == null) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                temp.put(n.level, pq);
                pq.add(n.node.key);
            }else {
                temp.get(n.level).add(n.node.key);
            }

            if(n.node.left != null) {
                q.add(new AuxNode(n.node.left, n.vertical - 1, n.level + 1));
            }

            if(n.node.right != null) {
                q.add(new AuxNode(n.node.right, n.vertical + 1, n.level + 1));
            }
        }

        ArrayList<ArrayList<Integer>> traversalresult = new ArrayList<>();
        for(Entry<Integer, TreeMap<Integer,PriorityQueue<Integer>>> vertical : result.entrySet()) {
            ArrayList<Integer> tempTraversal = new ArrayList<Integer>();
            for(Entry<Integer,PriorityQueue<Integer>> level : vertical.getValue().entrySet()) {
                PriorityQueue<Integer> tempPq = level.getValue();
                while (!tempPq.isEmpty()) {
                    tempTraversal.add(tempPq.remove());
                }
            }
            traversalresult.add(tempTraversal);
        }

        return traversalresult.stream()
        .map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
    }
}
