package graph.shortest_path_algo;

import java.util.PriorityQueue;

/*
 * Path With Minimum Effort
 * 
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.


Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
 */

public class PathWithMinimumEffort {
    public static int minPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        int[][] absDist = new int[r][c];
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                absDist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0,0,0});
        absDist[0][0] = 0;

        while (pq.size() > 0) {
            int[] curr = pq.remove();
            int curri = curr[0], currj = curr[1], currd = curr[2];

            if(curri == r - 1 && currj == c - 1) {
                return currd;
            }

            if(curri - 1 >= 0 && absDist[curri - 1][currj] > Math.abs(heights[curri][currj] - heights[curri - 1][currj])) {
                pq.add(new int[]{curri - 1, currj, Math.abs(heights[curri][currj] - heights[curri - 1][currj])});
                absDist[curri - 1][currj] = Math.abs(heights[curri][currj] - heights[curri - 1][currj]);
            } 
            if(currj - 1 >= 0 && absDist[curri][currj - 1] > Math.abs(heights[curri][currj] - heights[curri][currj - 1])) {
                pq.add(new int[]{curri, currj - 1, Math.abs(heights[curri][currj] - heights[curri][currj - 1])});
                absDist[curri][currj - 1] = Math.abs(heights[curri][currj] - heights[curri][currj - 1]);
            } 
            if(curri + 1 < heights.length && absDist[curri + 1][currj] > Math.abs(heights[curri][currj] - heights[curri + 1][currj])) {
                pq.add(new int[]{curri + 1, currj, Math.abs(heights[curri][currj] - heights[curri + 1][currj])});
                absDist[curri + 1][currj] = Math.abs(heights[curri][currj] - heights[curri + 1][currj]);
            } 
            if(currj + 1 < heights[0].length && absDist[curri][currj + 1] > Math.abs(heights[curri][currj] - heights[curri][currj + 1])) {
                pq.add(new int[]{curri, currj + 1, Math.abs(heights[curri][currj] - heights[curri][currj + 1])});
                absDist[curri][currj + 1] = Math.abs(heights[curri][currj] - heights[curri][currj + 1]);
            }
        }

        return -1;
    }
}
