package graph.topologicalSort;

import java.util.Stack;

/*
 * Topological Sort Algorithm | DFS: G-21
 * 
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
Note: In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).

Example 1:

Input: V = 6, E = 6
AdjList: {{},{},{3},{1},{0,1},{0,2}}
Output: 5, 4, 2, 3, 1, 0
Explanation: A graph may have multiple topological sortings. 
The result is one of them. The necessary conditions 
for the ordering are:
According to edge 5 -> 0, node 5 must appear before node 0 in the ordering.
According to edge 4 -> 0, node 4 must appear before node 0 in the ordering.
According to edge 5 -> 2, node 5 must appear before node 2 in the ordering.
According to edge 2 -> 3, node 2 must appear before node 3 in the ordering.
According to edge 3 -> 1, node 3 must appear before node 1 in the ordering.
According to edge 4 -> 1, node 4 must appear before node 1 in the ordering.

The above result satisfies all the necessary conditions. 
[4, 5, 2, 3, 1, 0] is also one such topological sorting 
that satisfies all the conditions.
Example 2:

Input: V = 4, E = 3
AdjList: {{},{0},{0},{0}}
Result: 3, 2, 1, 0
Explanation: The necessary conditions for the ordering are:
For edge 1 -> 0 node 1 must appear before node 0.
For edge 2 -> 0 node 1 must appear before node 0.
For edge 3 -> 0 node 1 must appear before node 0.

[2, 3, 1, 0] is also another topological sorting for the graph.
 */

public class TopologicalSort {
    public static int[] topological(int[][] adjList) {
        boolean[] visited = new boolean[adjList.length];
        Stack<Integer> result = new Stack<>();

        for(int i = 0; i < adjList.length; i++) {
            if(!visited[i]) {
                dfs(adjList, visited, i, result);
            }
        }

        int[] res = new int[adjList.length];
        int count = 0;
        while (result.size() > 0) {
            res[count] = result.pop();
            count++;
        }

        return res;
    }

    static void dfs(int[][] adjList, boolean[] visited, int node, Stack<Integer> result) {
        visited[node] = true;

        for(int i = 0; i < adjList[node].length; i++) {
            if(!visited[adjList[node][i]]) {
                dfs(adjList, visited, adjList[node][i], result);
            }
        }

        result.push(node);
    }
}
