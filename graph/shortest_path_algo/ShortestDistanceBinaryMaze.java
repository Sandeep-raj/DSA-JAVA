package graph.shortest_path_algo;

import java.util.PriorityQueue;

/*
 * Shortest Distance in a Binary Maze
 * 
 * Given an n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1. 
If the path is not possible between the source cell and the destination cell, then return -1.
Note: You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of four directions, Up, Down, Left, and Right.

Example 1:

Input:
grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}}
source = {0, 1}
destination = {2, 2}
Output:
3

Explanation: 

1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 1
The highlighted part in the above matrix denotes the shortest path from source to destination cell.

Example 2:

Input:
grid[][] = {{1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1}}
source = {0, 0}
destination = {3, 4}
Output:
-1 
Explanation: 
Since, there is no path possible between the source cell and the destination cell, hence we return -1.
 */

public class ShortestDistanceBinaryMaze {
    public static int mindist(int[][] grid, int[] src, int[] dst) {
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{src[0],src[1],0});
        dist[src[0]][src[1]] = 0;

        while (pq.size() > 0) {
            int[] curr = pq.remove();
            int curri = curr[0], currj = curr[1], currd = curr[2];

            if(curri == dst[0] && currj == dst[1]) {
                return currd;
            }

            if(curri - 1 >= 0 && grid[curri - 1][currj] == 1 && dist[curri - 1][currj] > currd + 1) {
                pq.add(new int[]{curri - 1, currj, currd + 1});
                dist[curri - 1][currj] = currd + 1;
            } 
            if(currj - 1 >= 0 && grid[curri][currj - 1] == 1 && dist[curri][currj - 1] > currd + 1) {
                pq.add(new int[]{curri, currj - 1, currd + 1});
                dist[curri][currj - 1] = currd + 1;
            } 
            if(curri + 1 < grid.length && grid[curri + 1][currj] == 1 && dist[curri + 1][currj] > currd + 1) {
                pq.add(new int[]{curri + 1, currj, currd + 1});
                dist[curri + 1][currj] = currd + 1;
            } 
            if(currj + 1 < grid[0].length && grid[curri][currj + 1] == 1 && dist[curri][currj + 1] > currd + 1) {
                pq.add(new int[]{curri, currj + 1, currd + 1});
                dist[curri][currj + 1] = currd + 1;
            }
        }

        return -1;
    }
}
