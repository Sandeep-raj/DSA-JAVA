package graph.mst_disjoint;

import java.util.HashMap;
import java.util.Map;

/*
 * Making A Large Island
 * 
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
 */

public class MakingALargeIsland {
    public static int makin(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        DisjointSet_Size ds = new DisjointSet_Size(n*n);

        for(int i =0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    visited[i][j] = true;
                    int node = i * n + j;
                    if(i - 1 >= 0 && visited[i - 1][j] && grid[i - 1][j] == 1) {
                        int temp = (i - 1) * n + j;
                        if(ds.getUParent(node) != ds.getUParent(temp)) {
                            ds.unionBySize(node, temp);
                        }
                    }
                    if(i + 1 < n && visited[i + 1][j] && grid[i + 1][j] == 1) {
                        int temp = (i + 1) * n + j;
                        if(ds.getUParent(node) != ds.getUParent(temp)) {
                            ds.unionBySize(node, temp);
                        }
                    }
                    if(j - 1 >= 0 && visited[i][j - 1] && grid[i][j - 1] == 1) {
                        int temp = i * n + (j - 1);
                        if(ds.getUParent(node) != ds.getUParent(temp)) {
                            ds.unionBySize(node, temp);
                        }
                    }
                    if(j + 1 < n && visited[i][j + 1] && grid[i][j + 1] == 1) {
                        int temp = i * n + (j + 1);
                        if(ds.getUParent(node) != ds.getUParent(temp)) {
                            ds.unionBySize(node, temp);
                        }
                    }
                }
            }
        }


        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                HashMap<Integer,Integer> area = new HashMap<>();
                if(grid[i][j] == 0) {
                    if(i - 1 >= 0 && grid[i-1][j] == 1) {
                        int temp = ds.getUParent((i-1)*n + j);
                        area.put(temp, ds.size[temp]);
                    }
                    if(i + 1 < n && grid[i+1][j] == 1) {
                        int temp = ds.getUParent((i+1)*n + j);
                        area.put(temp, ds.size[temp]);
                    }
                    if(j - 1 >= 0 && grid[i][j-1] == 1) {
                        int temp = ds.getUParent(i*n + (j-1));
                        area.put(temp, ds.size[temp]);
                    }
                    if(j + 1 < n && grid[i][j+1] == 1) {
                        int temp = ds.getUParent(i*n + (j+1));
                        area.put(temp, ds.size[temp]);
                    }
                }
                int tempArea = 0;
                for(Map.Entry<Integer,Integer> aset : area.entrySet()) {
                    tempArea += aset.getValue();
                }

                maxArea = Math.max(maxArea, tempArea + 1);
            }
        }

        return maxArea;
    }
}
