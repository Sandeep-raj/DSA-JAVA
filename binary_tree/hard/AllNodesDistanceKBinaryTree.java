package binary_tree.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * All Nodes Distance K in Binary Tree
 * 
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
 */

public class AllNodesDistanceKBinaryTree {
    public static int[] kdist(int[] arr, int k, int target) {
        Node head = Create.createBinTree(arr);
        HashMap<Node,Node> ParentMap =  new HashMap<>();

        Node tarNode = getParentAndTarget(head, ParentMap, target);


        ArrayList<Node> q = new ArrayList<>();
        ArrayList<Node> auxq = new ArrayList<>();
        HashSet<Node> visited = new HashSet<>();
        q.add(tarNode);

        while (k > 0) {
            
            while (!q.isEmpty()) {
                Node n = q.remove(0);
                visited.add(n);

                Node p = ParentMap.get(n);
                if(p != null && !visited.contains(p)) {
                    auxq.add(p);
                }
                if(n.left != null && !visited.contains(n.left)) {
                    auxq.add(n.left);
                }
                if(n.right != null && !visited.contains(n.right)) {
                    auxq.add(n.right);
                }
                
            }

            q =auxq;
            auxq = new ArrayList<>();
            k--;

        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Node n = q.remove(0);
            result.add(n.key);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static Node getParentAndTarget(Node curr, HashMap<Node,Node> map, int target) {
        Node left = null, right = null;
        if(curr.left != null) {
            map.put(curr.left, curr);
            left = getParentAndTarget(curr.left, map, target);
        }
        
        if(curr.right != null) {
            map.put(curr.right, curr);
            right = getParentAndTarget(curr.right, map, target);
        }

        if(curr.key == target) {
            return curr;
        }

        if (left == null) {
            return right;
        }else {
            return left;
        }
    }


}
