package graph.bfs_dfs;

import java.util.ArrayList;

/*
 * Detect Cycle in an Undirected Graph (using BFS)
 * 
 * Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
 * 
Input:  
V = 5, E = 5
adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
Output: 1
Explanation: 
1->2->3->4->1 is a cycle.


Input: 
V = 4, E = 2
adj = {{}, {2}, {1, 3}, {2}}
Output: 0
Explanation: 

No cycle in the graph.

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.
NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.
Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

Constraints:
1 ≤ V, E ≤ 105
 */

public class DetectCycleBFS {
    public static boolean detect(int[][] adjList, int vertex, int edge) {
        boolean[] visited = new boolean[vertex];
        ArrayList<int[]> q = new ArrayList<>();
        ArrayList<int[]> aux = new ArrayList<>();

        while (true) {
            int idx = -1;

            for(int i = 0; i < visited.length; i++) {
                if(!visited[i]) {
                    idx = i;
                    break;
                }
            }

            if(idx == -1) {
                break;
            }

            visited[idx] = true;
            q.add(new int[]{idx,-1});

            while (q.size() > 0) {
                int[] curr = q.remove(0);
                int node = curr[0], parent = curr[1];
                for(int i = 0; i < adjList[node].length; i++) {
                    if(!visited[adjList[node][i]]) {
                        aux.add(new int[]{adjList[node][i], node});
                        visited[adjList[node][i]] = true;
                    }else {
                        if(adjList[node][i] != parent) {
                            return true;
                        }
                    }
                }

                if(q.size() == 0) {
                    q = aux;
                    aux = new ArrayList<>();
                }
            }
        }
        
        return false;
    }
}
