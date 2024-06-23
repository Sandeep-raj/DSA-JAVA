package graph.bfs_dfs;

import java.util.ArrayList;

/*
 * Flood Fill
 * 
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.


Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
 */

public class FloodFill {
    public static int[][] fill(int[][] mtx, int sr, int sc, int color) {
        int pixel = mtx[sr][sc];
        ArrayList<int[]> bfs = new ArrayList<>();

        mtx[sr][sc] = color;
        bfs.add(new int[]{sr,sc});

        while (bfs.size() > 0) {
            int[] curr = bfs.remove(0);

            updatePixel(mtx, bfs, pixel, color, curr[0], curr[1]);
        }

        return mtx;
    }

    static void updatePixel(int[][] mtx, ArrayList<int[]> bfs ,int pixel, int color, int x, int y) {
        if(x - 1 >= 0 && mtx[x-1][y] == pixel) {
            mtx[x-1][y] = color;
            bfs.add(new int[]{x-1, y});
        }

        if( y - 1 >= 0 && mtx[x][y-1] == pixel) {
            mtx[x][y-1] = color;
            bfs.add(new int[]{x, y-1});
        }

        if(x + 1 < mtx.length && mtx[x+1][y] == pixel) {
            mtx[x+1][y] = color;
            bfs.add(new int[]{x+1, y});
        }

        if(y + 1 < mtx[0].length && mtx[x][y+1] == pixel) {
            mtx[x][y+1] = color;
            bfs.add(new int[]{x, y+1});
        }
    }
}
