package graph.bfs_dfs;

import java.util.Stack;

/*
 * Number of Enclaves
 * 
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.


Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
 */

public class NumberofEnclaves {
    public static int enclaves(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < mat.length; i++) {
            if(mat[i][0] == 1) {
                visited[i][0] = true;
                stack.push(new int[]{i,0});
            }

            if(mat[i][mat[0].length - 1] == 1) {
                visited[i][mat[0].length - 1] = true;
                stack.push(new int[]{i, mat[0].length - 1});
            }
        }

        for(int i = 0; i < mat[0].length; i++) {
            if(mat[0][i] == 1) {
                visited[0][i] = true;
                stack.push(new int[]{0,i});
            }

            if(mat[mat.length - 1][i] == 1) {
                visited[mat.length - 1][i] = true;
                stack.push(new int[]{mat.length - 1, i});
            }
        }

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int currx = curr[0], curry = curr[1];

            if(currx - 1 >= 0 && !visited[currx - 1][curry] && mat[currx - 1][curry] == 1) {
                visited[currx - 1][curry] = true;
                stack.push(new int[]{currx - 1,curry});
            }
            if(curry - 1 >= 0 && !visited[currx][curry - 1] && mat[currx][curry - 1]== 1) {
                visited[currx][curry - 1] = true;
                stack.push(new int[]{currx,curry - 1});
            }
            if(currx + 1 < mat.length && !visited[currx + 1][curry] && mat[currx + 1][curry] == 1) {
                visited[currx + 1][curry] = true;
                stack.push(new int[]{currx + 1,curry});
            }
            if(curry + 1 < mat[0].length && !visited[currx][curry + 1] && mat[currx][curry + 1] == 1) {
                visited[currx][curry + 1] = true;
                stack.push(new int[]{currx,curry + 1});
            }
        }

        int count = 0;
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(!visited[i][j] && mat[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
