package recursion.hard;

import java.util.ArrayList;

/*
 * M-Coloring Problem
 * 
 * Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.
 * 
 * Input:
N = 4
M = 3
E = 5
Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.

Input:
N = 3
M = 2
E = 3
Edges[] = {(0,1),(1,2),(0,2)}
Output: 0

Your Task:
Your task is to complete the function graphColoring() which takes the 2d-array graph[], the number of colours and the number of nodes as inputs and returns true if answer exists otherwise false. 1 is printed if the returned value is true, 0 otherwise. The printing is done by the driver's code.
Note: In Example there are Edges not the graph.Graph will be like, if there is an edge between vertex X and vertex Y graph[] will contain 1 at graph[X-1][Y-1], else 0. In 2d-array graph[ ], nodes are 0-based indexed, i.e. from 0 to N-1.Function will be contain 2-D graph not the edges.

Expected Time Complexity: O(MN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 20
1 ≤ E ≤ (N*(N-1))/2
1 ≤ M ≤ N
 */

public class MColoringProblem {
    public static boolean color(int n, int m, int e, int[][] edges) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < e; i++) {
            if(adjList[edges[i][0]] == null) {
                adjList[edges[i][0]] = new ArrayList<>();
            }
            adjList[edges[i][0]].add(edges[i][1]);

            if(adjList[edges[i][1]] == null) {
                adjList[edges[i][1]] = new ArrayList<>();
            }
            adjList[edges[i][1]].add(edges[i][0]);
        }

        int[] color = new int[n];
        return process(adjList, color, 0, m);

    }

    static boolean process(ArrayList<Integer>[] adjList, int[] color, int node, int m) {
        if(node == adjList.length) {
            return true;
        }

        for(int i = 1; i <= m; i++) {
            if(checkColor(adjList, node, color, i)) {
                color[node] = i;
                boolean found = process(adjList, color, node+1, m);
                if(found) {
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;
    }

    static boolean checkColor(ArrayList<Integer>[] adjList, int node, int[] color, int curr) {
        if(adjList[node] != null) {
            for(int nxt : adjList[node]) {
                if(curr == color[nxt]) {
                    return false;
                }
            }
        }

        return true;
    }
}
