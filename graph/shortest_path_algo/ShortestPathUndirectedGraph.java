package graph.shortest_path_algo;

import java.util.ArrayList;

/*
 * Shortest path in Undirected Graph
 * 
 * You are given an Undirected Graph having unit weight of the edges, find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
 * 
 * Input:
n = 9, m= 10
edges=[[0,1],[0,3],[3,4],[4,5],[5,6],[1,2],[2,6],[6,7],[7,8],[6,8]] 
src=0
Output:
0 1 2 1 2 3 3 4 4


Input:
n = 4, m= 4
edges=[[0,0],[1,1],[1,3],[3,0]] 
src=3
Output:
1 1 -1 0

Your Task:
You don't need to print or input anything. Complete the function shortest path() which takes a 2d vector or array of edges representing the edges of an undirected graph with unit weight, an integer n as the number of nodes, an integer m as a number of edges and an integer src as the input parameters and returns an integer array or vector, denoting the vector of distance from src to all nodes.

Constraint:
1<=n,m<=10000
0<=edges[i][j]<=n-1

Expected Time Complexity: O(N + E), where N is the number of nodes and E is the edges
Expected Space Complexity: O(N)
 */

public class ShortestPathUndirectedGraph {
    public static int[] dist(int n, int m, int[][] edges, int src) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < m; i++) {
            if(adjList[edges[i][0]] == null) {
                adjList[edges[i][0]] = new ArrayList<Integer>();
            }

            adjList[edges[i][0]].add(edges[i][1]);

            if(adjList[edges[i][1]] == null) {
                adjList[edges[i][1]] = new ArrayList<Integer>();
            }

            adjList[edges[i][1]].add(edges[i][0]);
        }

        int[] dist = new int[n];
        for(int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        ArrayList<int[]> q = new ArrayList<>();
        q.add(new int[]{src,0});
        dist[src] = 0;

        while (q.size() > 0) {
            int[] curr = q.remove(0);

            if(adjList[curr[0]] != null) {
                for(int x : adjList[curr[0]]) {
                    if(dist[x] > curr[1] + 1) {
                        dist[x] = curr[1] + 1;
                        q.add(new int[]{x,curr[1] + 1});
                    }
                }
            }
        }

        return dist;
    }
}
