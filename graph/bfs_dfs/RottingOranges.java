package graph.bfs_dfs;

import java.util.ArrayList;

/*
 * Rotting Oranges
 * 
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

 */

public class RottingOranges {
    public static int rotten(int[][] mtx) {
        int minute = 0;
        int[] goodOranges = new int[]{0};
        ArrayList<int[]> rottenOrange = new ArrayList<>();
        ArrayList<int[]> gettingRot = new ArrayList<>();
        boolean[][] visited = new boolean[mtx.length][mtx[0].length];

        for(int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[i].length; j++) {
                visited[i][j] = true;

                if(mtx[i][j] == 1) {
                    visited[i][j] = false;
                    goodOranges[0]++;
                }else if(mtx[i][j] == 2) {
                    rottenOrange.add(new int[]{i,j});
                }
            }
        }

        while (goodOranges[0] > 0) {
            int lastOranges = goodOranges[0];
            while (rottenOrange.size() > 0) {
                int[] curr = rottenOrange.remove(0);
                addRotten(visited, gettingRot, goodOranges,curr[0], curr[1]);
            }

            if(lastOranges > goodOranges[0]) {
                minute++;
                rottenOrange = gettingRot;
                gettingRot = new ArrayList<int[]>();
            }else{
                break;
            }
        }

        if(goodOranges[0] > 0) {
            return -1;
        }

        return minute;
    }

    static void addRotten(boolean[][] visited, ArrayList<int[]> aux,int[] goodOranges ,int x, int y) {
        if(x - 1 >= 0 && !visited[x - 1][y]) {
            visited[x-1][y] = true;
            goodOranges[0]--;
            aux.add(new int[]{x-1, y});
        }

        if(y - 1 >= 0 && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            goodOranges[0]--;
            aux.add(new int[]{x, y - 1});
        }

        if(x + 1 < visited.length && !visited[x + 1][y]) {
            visited[x+1][y] = true;
            goodOranges[0]--;
            aux.add(new int[]{x+1, y});
        }

        if(y + 1 < visited[x].length && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            goodOranges[0]--;
            aux.add(new int[]{x, y + 1});
        }
    }
}
