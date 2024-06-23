package graph.shortest_path_algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Dijkstra’s Algorithm 
 * 
 * Given a weighted, undirected, and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is an edge between i and j, second integers corresponds to the weight of that edge. You are given the source vertex S and You have to Find the shortest distance of all the vertex from the source vertex S. You have to return a list of integers denoting the shortest distance between each node and Source vertex S.
 * 
Example 1:
Input:
V = 2
adj [] = {{{1, 9}}, {{0, 9}}}
S = 0
Output:
0 9

Explanation: :
The source vertex is 0. Hence, the shortest distance of node 0 
from the source is 0 and the shortest distance of node 1 from 
source will be 9.

Example 2:
Input:
V = 3, E = 3
adj = {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}
S = 2
Output:
4 3 0
Explanation: 
For nodes 2 to 0, we can follow the path 2-1-0. 
This has a distance of 1+3 = 4, whereas the path 2-0 
has a distance of 6. So, the Shortest path from 2 to 0 is 4.

The shortest distance from 0 to 1 is 1.
 */

public class DijkstrasAlgorithm {
    public static String djikstra(int v, int e, int[][][] adjList, int src) {
        int[] srcNode = new int[v];
        int[] dist = new int[v];

        for(int i =0; i< v;i++) {
            srcNode[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{src,0});
        dist[src] = 0;

        while (pq.size() > 0) {
            int[] curr = pq.remove();
            int node = curr[0], curr_dist = curr[1];

            for(int i =0; i< adjList[node].length;i++){
                int tempNode = adjList[node][i][0], tempDist = adjList[node][i][1];
                if(dist[tempNode] > curr_dist + tempDist) {
                    pq.add(new int[]{tempNode , curr_dist + tempDist});
                    dist[tempNode] = curr_dist + tempDist;
                    srcNode[tempNode] = node;
                }
            }
        }

        String path = "" + v;
        int srcN = v - 1;
        while (srcN != srcNode[srcN]) {
            int temp = srcNode[srcN];
            path = (temp + 1) + " -> " + path;
            srcN = temp;
        }

        return path;
    }
}
