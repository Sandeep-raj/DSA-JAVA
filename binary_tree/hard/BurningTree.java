package binary_tree.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Burning Tree
 * 
 * Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
Note: The tree contains unique values.

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 
8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.




Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    / 
 8    10
Target Node = 10
Output: 5




Your Task:  
You don't need to read input or print anything. Complete the function minTime() which takes the root of the tree and target as input parameters and returns the minimum time required to burn the complete binary tree if the target is set on fire at the 0th second.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ N ≤ 104
 */

public class BurningTree {
    public static int burn(int[] arr, int target) {
        Node head = Create.createBinTree(arr);

        HashMap<Node,Node> ParentMap = new HashMap<>();
        HashSet<Node> UnVisitedNodes = new HashSet<>();
        Node tarNode = getParents(head, ParentMap, UnVisitedNodes, target);

        int k = 0;
        ArrayList<Node> q = new ArrayList<>();
        ArrayList<Node> auxq = new ArrayList<>();
        q.add(tarNode);

        while (!q.isEmpty()) {
            Node n = q.remove(0);
            UnVisitedNodes.remove(n);

            Node p = ParentMap.get(n);
            if(p != null && UnVisitedNodes.contains(p)) {
                auxq.add(p);
            }

            if(n.left != null && UnVisitedNodes.contains(n.left)) {
                auxq.add(n.left);
            }

            if(n.right != null && UnVisitedNodes.contains(n.right)) {
                auxq.add(n.right);
            }

            if(q.isEmpty()) {
                q = auxq;
                auxq = new ArrayList<>();

                if(UnVisitedNodes.size() > 0) {
                    k++;
                }
            }
        }


        return k;
    }

    public static Node getParents(Node curr, HashMap<Node,Node> map, HashSet<Node> set, int target) {
        set.add(curr);
        Node l = null, r = null;
        if(curr.left != null) {
            map.put(curr.left, curr);
            l = getParents(curr.left, map, set, target);
        }

        if(curr.right != null) {
            map.put(curr.right, curr);
            r = getParents(curr.right, map, set, target);
        }

        if(curr.key == target) {
            return curr;
        }

        if(l == null) {
            return r;
        }
        return l;
    }
}
