package graph.mst_disjoint;

import java.util.PriorityQueue;

/*
 * Swim in Rising Water
 * 
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.



Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n2
Each value grid[i][j] is unique.
 */

public class SwimInRisingWater {
    public static int swim(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2] - b[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;

        int t = grid[0][0];
        while (pq.size() > 0) {
            int[] curr = pq.remove();
            int x = curr[0], y = curr[1], lvl = curr[2];
            if(t < lvl) {
                t = lvl;
            }
            visited[x][y] = true;

            if(x == grid.length-1 && y == grid[0].length - 1 ){
                return t;
            }

            if(x - 1 >= 0 && !visited[x-1][y]) {
                pq.add(new int[]{x-1,y,grid[x-1][y]});
            }
            if(y - 1 >= 0 && !visited[x][y-1]) {
                pq.add(new int[]{x,y-1,grid[x][y-1]});
            }
            if(x + 1 < grid.length && !visited[x+1][y]) {
                pq.add(new int[]{x+1,y,grid[x+1][y]});
            }
            if(y + 1 < grid[0].length && !visited[x][y+1]) {
                pq.add(new int[]{x,y+1,grid[x][y+1]});
            }
        }

        return -1;
    }
}
