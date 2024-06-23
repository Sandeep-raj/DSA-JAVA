package graph.bfs_dfs;

import java.util.Stack;

/*
 * Is Graph Bipartite?
 * 
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.


Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.
 */

public class BipartiteGraph {
    static class AdjNode {
        public int node;
        public int color;

        public AdjNode(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }
    public static boolean isbipartite(int[][] adjList) {
        int[] colorNode = new int[adjList.length];

        Stack<AdjNode> stack = new Stack<>();
        stack.push(new AdjNode(0, 1));
        colorNode[0] = 1;

        while (!stack.isEmpty()) {
            AdjNode n = stack.pop();

            for(int i = 0; i < adjList[n.node].length; i++) {
                if(n.color == 1) {
                    if(colorNode[adjList[n.node][i]] == 0 ) {
                        colorNode[adjList[n.node][i]] = 2;
                        stack.push(new AdjNode(adjList[n.node][i], 2));
                    }else {
                        if(colorNode[adjList[n.node][i]] == 1){
                            return false;
                        }
                    }
                }else {
                    if(colorNode[adjList[n.node][i]] == 0 ) {
                        colorNode[adjList[n.node][i]] = 1;
                        stack.push(new AdjNode(adjList[n.node][i], 1));
                    }else {
                        if(colorNode[adjList[n.node][i]] == 2){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
