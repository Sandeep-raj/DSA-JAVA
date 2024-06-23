package graph.shortest_path_algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Number of Ways to Arrive at Destination
 * 
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

Example 1:
Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6

Example 2:
Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
 

Constraints:

1 <= n <= 200
n - 1 <= roads.length <= n * (n - 1) / 2
roads[i].length == 3
0 <= ui, vi <= n - 1
1 <= timei <= 109
ui != vi
There is at most one road connecting any two intersections.
You can reach any intersection from any other intersection.
 */

public class NumberWaysArriveDestination {
    public static int ways(int n, int[][]roads) {
        ArrayList<int[]>[] adjList = new ArrayList[n];
        for(int i = 0; i < roads.length; i++) {
            if(adjList[roads[i][0]] == null) {
                adjList[roads[i][0]] = new ArrayList<>();
            }

            adjList[roads[i][0]].add(new int[]{roads[i][1],roads[i][2]});

            if(adjList[roads[i][1]] == null) {
                adjList[roads[i][1]] = new ArrayList<>();
            }

            adjList[roads[i][1]].add(new int[]{roads[i][0],roads[i][2]});
        }

        int[] roadTime = new int[n];
        for(int i = 0; i < n; i++) {
            roadTime[i] = Integer.MAX_VALUE;
        }

        int ways  = 0;
        int time = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));

        pq.add(new int[]{0,0});
        roadTime[0] = 0;

        while (pq.size() > 0) {
            int[] curr = pq.remove();
            int currn = curr[0], currd = curr[1];

            if(currn == n - 1) {
                if(time > currd) {
                    ways = 1;
                    time = currd;
                }else {
                    ways++;
                }
            }

            if(adjList[currn] != null) {
                for(int[] x : adjList[currn]) {
                    if(roadTime[x[0]] >= x[1] + currd) {
                        pq.add(new int[]{x[0], x[1] + currd});
                        roadTime[x[0]] = x[1] + currd;
                    }
                }
            }
        }

        return ways;
    }
}
