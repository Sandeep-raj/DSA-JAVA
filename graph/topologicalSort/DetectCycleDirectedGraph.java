package graph.topologicalSort;

import java.util.ArrayList;

/*
 * Detect cycle in a directed graph
 * 
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
 * 
 * Example 1:
 * AdjList: {{1},{2},{3},{3}}
 * Output: 1
Explanation: 3 -> 3 is a cycle


Example 2:
AdjList: {{1},{2},{}}
Output: 0
Explanation: no cycle in the graph

Your task:
You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list adj as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.
In the adjacency list adj, element adj[i][j] represents an edge from i to j.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105
 */

public class DetectCycleDirectedGraph {
    public static boolean detect(int[][] adjList) {
        int[] indegree = new int[adjList.length];

        for(int i = 0; i < adjList.length; i++) {
            for(int j =0; j < adjList[i].length; j++) {
                indegree[adjList[i][j]]++;
            }
        }

        ArrayList<Integer> q = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i =0;i < indegree.length; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while (q.size() > 0) {
            int node = q.remove(0);
            result.add(node);

            for(int i = 0; i < adjList[node].length; i++) {
                if(indegree[adjList[node][i]] > 0) {
                    indegree[adjList[node][i]]--;

                    if(indegree[adjList[node][i]] == 0) {
                        q.add(adjList[node][i]);
                    }
                }
            }
        }


        return !(result.size() == adjList.length);
    }
}
