package recursion.hard;

import java.util.ArrayList;

/*
 * Rat in a Maze
 * 
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and the rat cannot move to it while value 1 at a cell in the matrix represents that rat can travel through it.
 * 
 * Input:
N = 4
m[][] = {{1, 0, 0, 0},
        {1, 1, 0, 1}, 
        {1, 1, 0, 0},
        {0, 1, 1, 1}}
Output: DDRDRR DRDDRR
Explanation:
The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

Example 2:
Input: N = 2
       m[][] = {{1, 0},
                {1, 0}}

Output:
 No path exists and the destination cell is blocked.
 */

public class RatInMaze {
    public static String ratmaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        boolean[][] vis = new boolean[maze.length][maze.length];
        ratRun(maze, 0, 0, result, "", vis);

        return result.toString();
    }

    static void ratRun(int[][] maze, int x, int y, ArrayList<String> result, String path, boolean[][] vis) {
        if(x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            result.add(path);
            return;
        }
        
        if(x >= 0 && y >= 0 && x < maze.length && y < maze.length && !vis[x][y] && maze[x][y] == 1) {
            vis[x][y] = true;
            ratRun(maze, x+1, y, result, path + "D", vis);
            ratRun(maze, x-1, y, result, path + "U", vis);
            ratRun(maze, x, y+1, result, path + "R", vis);
            ratRun(maze, x, y-1, result, path + "L", vis);
            vis[x][y] = false;
        }
    }
}
