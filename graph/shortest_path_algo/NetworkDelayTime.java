package graph.shortest_path_algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Network Delay Time

 You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2


Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1


Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 */

public class NetworkDelayTime {
    public static int delay(int[][] times, int n, int k) {
        int maxTime  = 0;
        ArrayList<int[]>[] adjList = new ArrayList[n];
        for(int i = 0; i < times.length; i++) {
            if(adjList[times[i][0] - 1] == null) {
                adjList[times[i][0] - 1] = new ArrayList<>();
            }
            adjList[times[i][0] - 1].add(new int[]{times[i][1] - 1,times[i][2]});
        }

        int[] timeArr = new int[n];
        for(int i = 0; i < n; i++) {
            timeArr[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->(a[1] - b[1]));
        pq.add(new int[]{k-1, 0, 0});
        timeArr[k-1] =0;
        int nodeVists = 1;

        while (pq.size() > 0) {

            int[] curr = pq.remove();
            int currN = curr[0], currD = curr[1], currM = curr[2];
            maxTime = Math.max(maxTime, currM);

            if(adjList[currN] != null) {
                for(int[] x : adjList[currN]) {
                    if(timeArr[x[0]] > currD + x[1]) {
                        if(timeArr[x[0]] == Integer.MAX_VALUE) {
                            nodeVists++;
                        }
                        pq.add(new int[]{x[0],currD + x[1], currM + 1});
                        timeArr[x[0]] = currD + x[1];
                    }
                }
            }
        }

        if(nodeVists < n) {
            return -1;
        }

        return maxTime;
    }
}
