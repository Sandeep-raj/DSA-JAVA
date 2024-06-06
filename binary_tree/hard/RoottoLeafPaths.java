package binary_tree.hard;

import java.util.ArrayList;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Root to Leaf Paths
 * 
 * Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
 * 
 * 
 * Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3


Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 
10 20 40 
10 20 60 
10 30 


Your Task:
Your task is to complete the function Paths() which takes the root node as an argument and returns all the possible paths. (All the paths are printed in new lines by the driver's code.)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1<=n<=104
 */

public class RoottoLeafPaths {
    public static String[] paths(int[] arr) {
        Node head = Create.createBinTree(arr);
        ArrayList<String> result =  new ArrayList<>();
        traverse(head, "", result);

        return result.toArray(new String[result.size()]);
    }

    public static void traverse(Node curr, String path, ArrayList<String> paths) {
        if(curr == null) {
            return;
        }

        if(isleaf(curr)) {
            paths.add(path + " -> " + curr.key);
            return;
        }

        traverse(curr.left, path + " -> " + curr.key, paths);
        traverse(curr.right, path + " -> " + curr.key, paths);
    }

    public static boolean isleaf(Node curr) {
        if(curr.left == null && curr.right == null) {
            return true;
        }

        return false;
    }
}
