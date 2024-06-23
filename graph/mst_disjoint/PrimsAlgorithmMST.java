package graph.mst_disjoint;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Prim's Algorithm - Minimum Spanning Tree
 * 
 * Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
(Sometimes it may be asked to find the MST as well, where in the MST the edge-informations will be stored in the form {u, v}(u = starting node, v = ending node).)

Input Format: 
V = 5, edges = { {0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {4, 2, 7}}
Result: 16
Explanation: 
The minimum spanning tree for the given graph is drawn below:
MST = {(0, 1), (0, 3), (1, 2), (1, 4)}


Input Format: 
V = 5, edges = { {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}}
Result: 5
Explanation: 
The minimum spanning tree is drawn below:

MST = {(0, 2), (1, 2), (2, 3), (3, 4)}
 */

public class PrimsAlgorithmMST {
    public static int[][] prims(int v, int[][]edges) {
        int min_sum = 0;
        boolean[] visited = new boolean[v];
        ArrayList<int[]> MST = new ArrayList<>();

        ArrayList<int[]>[] adjList = new ArrayList[v];
        for(int i = 0; i < edges.length; i++) {
            if(adjList[edges[i][0]] == null) {
                adjList[edges[i][0]] = new ArrayList<>();
            }
            adjList[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});

            if(adjList[edges[i][1]] == null) {
                adjList[edges[i][1]] = new ArrayList<>();
            }
            adjList[edges[i][1]].add(new int[]{edges[i][0], edges[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] -b[2]));
        pq.add(new int[]{-1,0,0});

        while (pq.size() > 0) {
            int[] curr = pq.remove();
            int s = curr[0], d = curr[1], w = curr[2];

            if(visited[d]) {
                continue;
            }

            visited[d] = true;
            min_sum += w;

            if(s >= 0) {
                MST.add(new int[]{s,d});
            }

            if(adjList[d] != null) {
                for(int[] node : adjList[d]) {
                    if(!visited[node[0]]) {
                        pq.add(new int[]{d, node[0], node[1]});
                    }
                }
            }
        }

        return MST.toArray(new int[MST.size()][]);
    }
}
