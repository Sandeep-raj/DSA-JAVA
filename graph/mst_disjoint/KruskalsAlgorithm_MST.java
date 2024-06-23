package graph.mst_disjoint;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Kruskal's Algorithm - Minimum Spanning Tree
 * 
 * Problem Statement: Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

Example 1:
Input Format: 
V = 5, edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}
Result: 16
Explanation: The minimum spanning tree for the given graph is drawn below:
MST = {(0, 1), (0, 3), (1, 2), (1, 4)}


Example 2:
Input Format: 
V = 5, 
edges = { {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}
Result: 5
Explanation: The minimum spanning tree is drawn below:
MST = {(0, 2), (1, 2), (2, 3), (3, 4)}

 */

public class KruskalsAlgorithm_MST {
    public static int[][] kruskal(int v, int[][] edges) {
        ArrayList<int[]> mst = new ArrayList<>();
        int minWt = 0;

        Arrays.sort(edges, (a,b) -> (a[2] - b[2]));
        DisjointSet_Size ds = new DisjointSet_Size(v);
        for(int[] edge : edges) {
            int uNode = edge[0], vNode = edge[1], wt = edge[2];

            int uParent = ds.getUParent(uNode);
            int vParent = ds.getUParent(vNode);

            if(uParent != vParent) {
                ds.unionBySize(uParent, vParent);
                wt += wt;
                mst.add(new int[]{uNode, vNode});
            }
        }

        return mst.toArray(new int[mst.size()][]);
    }

    public static void test() {
        int[][] result = kruskal(5, new int[][]{ {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}});
        System.out.println(Arrays.deepToString(result));
    }
}

