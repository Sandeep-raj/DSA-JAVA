package graph.other;

import java.util.ArrayList;

/*
 * Articulation Point in Graph
 * 
 * Problem Statement: Given an undirected connected graph with V vertices and adjacency list adj. You are required to find all the vertices removing which (and edges through it) disconnect the graph into 2 or more components.
Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.

Example 1:

Input Format:
connections: {{0,1}.{0,2},{0,3},{2,3},{2,4},{2,5},{4,6},{5,6}}
Result: {0, 2}
Explanation: If we remove node 0 or node 2, the graph will be divided into 2 or more components.


Input Format:
connections: {{0,1},{1,4},{4,3},{4,2},{2,3}}
Result: {1, 4}
Explanation: If we remove either node 1 or node 4, the graph breaks into multiple components.
 */

public class ArticulationPoint {
    public static int timer = 1;

    public static int[] criticalPoint(int n, int[][] conections) {
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i < conections.length; i++) {
            if (adj[conections[i][0]] == null) {
                adj[conections[i][0]] = new ArrayList<Integer>();
            }
            adj[conections[i][0]].add(conections[i][1]);

            if (adj[conections[i][1]] == null) {
                adj[conections[i][1]] = new ArrayList<Integer>();
            }
            adj[conections[i][1]].add(conections[i][0]);
        }

        ArrayList<Integer> points = new ArrayList<>();
        int[] tin = new int[n + 1];
        int[] low = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        dfs(0, -1, tin, low, visited, points, adj);
        return points.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void dfs(int node, int parent, int[] tin, int[] low, boolean[] visited, ArrayList<Integer> points,
            ArrayList<Integer>[] adj) {
        visited[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        if (adj[node] != null) {
            for (int x : adj[node]) {
                if (x == parent)
                    continue;
                if (!visited[x]) {
                    dfs(x, node, tin, low, visited, points, adj);
                    low[node] = Math.min(low[node], low[x]);
                    // node --- it
                    if (low[x] >= tin[node] && parent != -1) {
                        points.add(node);
                    }
                    child++;
                } else {
                    low[node] = Math.min(low[node], low[x]);
                }
            }
            if (child > 1 && parent == -1) {
                points.add(node);
            }
        }
    }
}
