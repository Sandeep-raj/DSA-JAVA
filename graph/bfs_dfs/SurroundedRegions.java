package graph.bfs_dfs;

import java.util.Stack;

/*
 * Surrounded Regions
 * 
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.

A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation:
In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Input: board = [["X"]]
Output: [["X"]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */

public class SurroundedRegions {
    public static String[][] surround(String[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < mat.length; i++) {
            if(mat[i][0] == "O") {
                visited[i][0] = true;
                stack.push(new int[]{i,0});
            }

            if(mat[i][mat[0].length - 1] == "O") {
                visited[i][mat[0].length - 1] = true;
                stack.push(new int[]{i,mat[0].length - 1});
            }
        }

        for(int i = 0; i < mat[0].length; i++) {
            if(mat[0][i] == "O") {
                visited[0][i] = true;
                stack.push(new int[]{0,i});
            }

            if(mat[mat.length - 1][i] == "O") {
                visited[mat.length - 1][i] = true;
                stack.push(new int[]{mat.length - 1,i});
            }
        }

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int currx = curr[0], curry = curr[1];

            if(currx - 1 >= 0 && !visited[currx - 1][curry] && mat[currx - 1][curry] == "O") {
                visited[currx - 1][curry] = true;
                stack.push(new int[]{currx - 1,curry});
            }
            if(curry - 1 >= 0 && !visited[currx][curry - 1] && mat[currx][curry - 1]== "O") {
                visited[currx][curry - 1] = true;
                stack.push(new int[]{currx,curry - 1});
            }
            if(currx + 1 < mat.length && !visited[currx + 1][curry] && mat[currx + 1][curry] == "O") {
                visited[currx + 1][curry] = true;
                stack.push(new int[]{currx + 1,curry});
            }
            if(curry + 1 < mat[0].length && !visited[currx][curry + 1] && mat[currx][curry + 1] == "O") {
                visited[currx][curry + 1] = true;
                stack.push(new int[]{currx,curry + 1});
            }
        }

        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(!visited[i][j]) {
                    mat[i][j] = "X";
                }
            }
        }

        return mat;

    }
}
