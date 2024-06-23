package graph.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Bridges in Graph - Using Tarjan's Algorithm of time in and low time
 * 
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other servers.
Return all critical connections in the network in any order.

Input Format: N = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Result: [[1, 3]]
Explanation: The edge [1, 3] is the critical edge because if we remove the edge the graph will be divided into 2 components.


Input Format:
connections = {{1,2},{1,4},{2,3},{4,3},{4,5},{5,6},{6,7},{6,9},{7,8},{9,8},{8,10},{10,12},{10,11}}
Result: [[4, 5], [5, 6], [8, 10]]
Explanation: If we remove any of the three edges, the graph will be divided into 2 or more components.
 */

public class TarjansAlgo {
    private static int timer = 1;
    private static void dfs(int node, int parent, int[] vis,
                     ArrayList<ArrayList<Integer>> adj, int tin[], int low[],
                     List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for (Integer it : adj.get(node)) {
            if (it == parent) continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    public static int[][] criticalConnections(int n, int[][] connections) {
        n = n+1;
        ArrayList<ArrayList<Integer>> adj =
            new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] it : connections) {
            int u = it[0]; int v = it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(1, -1, vis, adj, tin, low, bridges);
        return bridges.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
