package graph.shortest_path_algo;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Cheapest Flights Within K Stops
 * 
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
 */

public class CheapestFlightsWithinKStops {
    public static int cheapest(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] adjList = new ArrayList[n];
        for(int i = 0; i < flights.length; i++) {
            if(adjList[flights[i][0]] == null) {
                adjList[flights[i][0]] = new ArrayList<int[]>();
            }

            adjList[flights[i][0]].add(new int[]{flights[i][1], flights[i][2]});
        }

        int[] cityPrice = new int[n];
        for(int i = 0; i < n; i++) {
            cityPrice[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        pq.add(new int[]{src, 0, k+1});
        cityPrice[src] = 0;

        while (pq.size() > 0) {
            int[] curr = pq.remove();
            int city = curr[0], dist = curr[1], stops = curr[2];

            if(stops < 0) {
                continue;
            }

            if(city == dst) {
                return dist;
            }

            for(int[] nextCity : adjList[city]) {
                if(cityPrice[nextCity[0]] > dist + nextCity[1]) {
                    pq.add(new int[]{nextCity[0], dist + nextCity[1], stops - 1});
                }
            }
        }

        return -1;
    }
}
