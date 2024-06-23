package graph.bfs_dfs;

import java.util.ArrayList;

/*
 * Problem Statement: Given a grid of size NxM (N is the number of rows and M is the number of columns in the grid) consisting of '0's (Water) and ‘1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.


Example 1:
Input: {{0,1,1,0},{0,1,1,0},{0,0,1,0},{0,0,0,0},{1,1,0,1}}
Output: 3
Explanation:
There are 3 islands as the different components are surrounded by water (i.e. 0), and there is no land connectivity in either of the 8 directions hence separating them into 3 islands.

Example 2:
Input: {{0,1,1,0,1,0,0},{0,0,1,1,0,1,0}}
Output: 1
Explanation:
All lands are connected. So, only 1 island is present.
 */

public class NumberofIslands {
    public static int number(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        int count = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1 && !visited[i][j]){
                    bfs(mat, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void bfs(int[][] mat, boolean[][] visited, int x, int y) {
        ArrayList<int[]> q = new ArrayList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] curr = q.remove(0);
            int currx = curr[0], curry = curr[1];

            if(currx - 1 >= 0 && mat[currx - 1][curry] == 1 && !visited[currx - 1][curry]) {
                visited[currx - 1][curry] = true;
                q.add(new int[]{currx - 1, curry});
            }

            if(currx + 1 < mat.length && mat[currx + 1][curry] == 1 && !visited[currx + 1][curry]) {
                visited[currx + 1][curry] = true;
                q.add(new int[]{currx + 1, curry});
            }

            if(curry - 1 >= 0 && mat[currx][curry - 1] == 1 && !visited[currx][curry - 1]) {
                visited[currx][curry - 1] = true;
                q.add(new int[]{currx, curry - 1});
            }

            if(curry + 1 < mat[0].length && mat[currx][curry+1] == 1 && !visited[currx][curry+1]) {
                visited[currx][curry+1] = true;
                q.add(new int[]{currx, curry+1});
            }

            if(currx - 1 >= 0 && curry - 1 >= 0 && mat[currx - 1][curry - 1] == 1 && !visited[currx - 1][curry - 1]) {
                visited[currx - 1][curry - 1] = true;
                q.add(new int[]{currx - 1, curry - 1});
            }

            if(currx - 1 >= 0 && curry + 1 < mat[0].length && mat[currx - 1][curry + 1] == 1 && !visited[currx - 1][curry+1]) {
                visited[currx - 1][curry+1] = true;
                q.add(new int[]{currx - 1, curry+1});
            }

            if(currx + 1 < mat.length && curry - 1 >= 0 && mat[currx + 1][curry - 1] == 1 && !visited[currx + 1][curry - 1]) {
                visited[currx + 1][curry - 1] = true;
                q.add(new int[]{currx + 1, curry - 1});
            }


            if(currx + 1 < mat.length && curry + 1 < mat[0].length && mat[currx + 1][curry + 1] == 1 && !visited[currx + 1][curry + 1]) {
                visited[currx + 1][curry + 1] = true;
                q.add(new int[]{currx + 1, curry + 1});
            }
        }
    }
}
