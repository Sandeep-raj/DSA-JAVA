package binary_tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Zig Zag Traversal Of Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, print the zigzag traversal of the Binary Tree. Zigzag traversal of a binary tree is a way of visiting the nodes of the tree in a zigzag pattern, alternating between left-to-right and right-to-left at each level.
 * 
 * Input:Binary Tree: 1 2 3 4 5 -1 6
 * Output: [[1],[3, 2],[4, 5, 6]]
Explanation: 
Level 1 (Root): Visit the root node 1 from left to right. Zigzag Traversal: [1]
Level 2: Visit nodes at this level in a right-to-left order. Zigzag Traversal:  [1], [3, 2]
Level 3: Visit nodes at this level in a left-to-right order. Zigzag Traversal:  [1], [3, 2], [4, 5, 6]

Input:Binary Tree: 1 2 -1 4 5 -1 -1 7 8
Output : [[1], [2], [4, 5], [8, 7]]
Explanation: 
Level 1 (Root): Visit the root node 1 from left to right. Zigzag Traversal: [1]
Level 2: Visit nodes at this level in a right-to-left order. Zigzag Traversal:  [1], [2]
Level 3: Visit nodes at this level in a left-to-right order. Zigzag Traversal:  [1], [3, 2], [4, 5]
Level 4: Visit nodes at this level in a right-to-left order. Zigzag Traversal:  [1], [3, 2], [4, 5], [8, 7]


 */

public class ZigzagLevelOrderTraversal {
    public static String zigzag(int[] arr) {
        Node head = Create.createBinTree(arr);

        ArrayList<Node> q  = new ArrayList<Node>();
        ArrayList<Node> auxq = new ArrayList<Node>();
        
        ArrayList<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        
        q.add(head);
        list.add(head.key);
        result.add(list);
        list = new LinkedList<>();

        int cnt = 1;

        while (!q.isEmpty()) {
            Node n = q.remove(0);

            if(n.left != null) {
                auxq.add(n.left);
                if(cnt%2 == 0){
                    list.add(n.left.key);
                }else {
                    list.add(0, n.left.key);
                }
            }

            if(n.right != null) {
                auxq.add(n.right);
                if(cnt%2 == 0){
                    list.add(n.right.key);
                }else {
                    list.add(0, n.right.key);
                }
            }

            if(q.isEmpty()) {
                result.add(list);
                q = auxq;
                cnt++;
                auxq = new ArrayList<>();
                list = new LinkedList<>();
            }
        }

        return result.toString();
    }
}
