package graph.topologicalSort;

import java.util.ArrayList;

/*
 * Kahn's Algorithm | Topological Sort Algorithm | BFS: G-22
 * 
 * Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).

Example 1:

Input Format: V = 6, E = 6
AdjList: {{},{},{3},{1},{0,1},{0,2}}
Result: 5, 4, 0, 2, 3, 1
Explanation: A graph may have multiple topological sortings. 
The result is one of them. The necessary conditions for the ordering are:
According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.

The above result satisfies all the necessary conditions. 
[4, 5, 2, 3, 1, 0] and [4, 5, 0, 2, 3, 1] are also such 
topological sortings that satisfy all the conditions.
Example 2:

Input Format: V = 4, E = 3
AdjList: {{},{0},{0},{0}}
Result: 1, 2, 3, 0
Explanation: The necessary conditions for the ordering are:
For edge 1 -> 0 node 1 must appear before node 0.
For edge 2 -> 0 node 1 must appear before node 0.
For edge 3 -> 0 node 1 must appear before node 0.

[2, 3, 1, 0] is also another topological sorting for the graph.
 */

public class KahnsAlgorithm {
    public static String khans(int[][] adjList) {
        int[] indegree = new int[adjList.length];
        for(int i = 0; i < adjList.length; i++) {
            for(int j = 0; j < adjList[i].length; j++) {
                indegree[adjList[i][j]]++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> q = new ArrayList<>();

        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while (q.size() > 0) {
            int node = q.remove(0);
            result.add(node);

            for(int i =0; i < adjList[node].length; i++) {
                if(indegree[adjList[node][i]] > 0) {
                    indegree[adjList[node][i]]--;
                    if(indegree[adjList[node][i]] == 0) {
                        q.add(adjList[node][i]);
                    }
                }
            }
        }

        return result.toString();
    }
}
