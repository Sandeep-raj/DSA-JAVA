package graph.bfs_dfs;

/*
 * Detect cycle in a directed graph
 * 
Given a directed graph with V vertices and E edges, check whether it contains any cycle or not. 
Example 1:
Input: N = 10, E = 11
AdjList = {{1},{2},{3,6},{4},{5},{},{4},{1,8},{9},{7}}
Output: true
Explanation: 8->9->10 is a cycle.


Input Format: N = 10, E = 10
AdjList = {{1},{2},{3,6},{4},{5},{},{4},{1,8},{9},{}}
Result: false
Explanation: No cycle detected.
 */

public class DetectCycleDirectedGraph {
    public static boolean detect(int[][] adjList) {
        boolean[] visited = new boolean[adjList.length];
        boolean[] path = new boolean[adjList.length];
        
        for(int i = 0; i < adjList.length; i++) {
            if(!visited[i] && dfs(adjList, visited, path, i) == true) {
                return true;
            }
        }

        return false;
    }

    static boolean dfs(int[][] adjList, boolean[] visited, boolean[] path, int node) {
        visited[node] = true;
        path[node] = true;

        for(int i = 0; i < adjList[node].length; i++) {
            if(!visited[adjList[node][i]]) {
                if(dfs(adjList, visited, path, adjList[node][i]) == true) {
                    return true;
                }
            }else {
                if(path[adjList[node][i]]) {
                    return true;
                }
            }
        }

        path[node] = false;
        return false;
    }
}
