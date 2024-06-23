package graph.bfs_dfs;

import java.util.ArrayList;

/*
 * 01 Matrix
 * 
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
 */

public class BFS01Matrix {
    public static int[][] dist(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                result[i][j] = bfs(i, j, mat);
            }
        }

        return result;
    }

    static int bfs(int x, int y, int[][] mat) {
        ArrayList<int[]> q = new ArrayList<>();
        ArrayList<int[]> aux = new ArrayList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        if(mat[x][y] == 0) {
            return 0;
        }

        q.add(new int[]{x,y});
        visited[x][y] = true;
        int dist = 0;

        while (true) {
            while (q.size() > 0) {
                int[] cords = q.remove(0);
                int currx = cords[0], curry = cords[1];

                
                if(currx - 1 >= 0 && !visited[currx - 1][curry]) {
                    if(mat[currx - 1][curry] == 0) {
                        return dist+1;
                    }

                    visited[currx - 1][curry] = true;
                    aux.add(new int[]{currx - 1,curry});
                }

                if(curry - 1 >= 0 && !visited[currx][curry - 1]) {
                    if(mat[currx][curry - 1] == 0) {
                        return dist+1;
                    }

                    visited[currx][curry - 1] = true;
                    aux.add(new int[]{currx,curry - 1});
                }

                if(currx + 1 < mat.length && !visited[currx + 1][curry]) {
                    if(mat[currx + 1][curry] == 0) {
                        return dist+1;
                    }


                    visited[currx + 1][curry] = true;
                    aux.add(new int[]{currx + 1,curry});
                }

                if(curry + 1 < mat[currx].length && !visited[currx][curry + 1]) {
                    if(mat[currx][curry + 1] == 0) {
                        return dist+1;
                    }


                    visited[currx][curry + 1] = true;
                    aux.add(new int[]{currx,curry + 1});
                }
            }

            if(aux.size() > 0 ) {
                q = aux;
                aux = new ArrayList<>();
                dist++;
            }else {
                break;
            }
        }

        return dist;
    }
}
