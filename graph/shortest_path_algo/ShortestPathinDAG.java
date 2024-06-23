package graph.shortest_path_algo;

import java.util.ArrayList;

/*
 * Shortest path in Directed Acyclic Graph
 * 
 * Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.


Input:
N = 4, M = 2
edge = [[0,1,2],[0,2,1]]
Output:
0 2 1 -1
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->2 with edge weight 1.
There is no way we can reach 3, so it's -1 for 3.



Input:
N = 6, M = 7
edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
Output:
0 2 3 6 1 5
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
Shortest path from 0 to 4 is 0->4 with edge weight 1.
Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.



Your Task:

You don't need to print or input anything. Complete the function shortest path() which takes an integer N as number of vertices, an integer M as number of edges and a 2D Integer array(or vector) edges as the input parameters and returns an integer array(or vector), denoting the list of distance from src to all nodes.

Expected Time Complexity: O(N+M), where N is the number of nodes and M is edges
Expected Space Complexity: O(N)

Constraint:
1 <= N <= 100
1 <= M <= min((N*(N-1))/2,4000)
0 <= edgei,0,edgei,1 < n
0 <= edgei,2 <=105
 */

public class ShortestPathinDAG {
    public static int[] dist(int n, int m, int[][] edges) {
        ArrayList<int[]>[] adjList = new ArrayList[n];

        for(int i = 0 ; i < m; i++) {
            if(adjList[edges[i][0]] == null) {
                adjList[edges[i][0]] = new ArrayList<>();
            }

            adjList[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});
        }

        int[] dist = new int[n];
        for(int i =0; i<n;i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        ArrayList<Integer> q = new ArrayList<>();
        q.add(0);
        dist[0] = 0;

        while (q.size() > 0) {
            int node = q.remove(0);

            if(adjList[node] == null) {
                continue;
            }
            
            for(int[] x : adjList[node]) {
                if(dist[node] + x[1] < dist[x[0]]) {
                    dist[x[0]] = dist[node] + x[1];
                    q.add(x[0]);
                }
            }
        }

        return dist;
    }
}
