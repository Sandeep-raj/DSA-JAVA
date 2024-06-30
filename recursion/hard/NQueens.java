package recursion.hard;

import java.util.ArrayList;

/*
 * N-Queens
 * 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Input: n = 1
Output: [["Q"]]

Constraints:
1 <= n <= 9
 */

public class NQueens {
    public static String nQueen(int n) {
        int[][] chessboard = new int[n][n];
        ArrayList<String> result = new ArrayList<>();

        dfs(chessboard, result, 0);

        return result.toString();
    }

    public static boolean validate(int[][] chessboard, int row, int col) {
        for (int i = 0; i < chessboard.length; i++) {
            if (chessboard[row][i] == 1) {
                return false;
            }
        }

        int x = row, y = col;
        while (x >= 0 && x < chessboard.length && y >= 0 && y < chessboard.length) {
            if (chessboard[x][y] == 1) {
                return false;
            }
            x = x - 1;
            y = y - 1;
        }

        x = row;
        y = col;
        while (x >= 0 && x < chessboard.length && y >= 0 && y < chessboard.length) {
            if (chessboard[x][y] == 1) {
                return false;
            }
            x = x - 1;
            y = y + 1;
        }

        x = row;
        y = col;
        while (x >= 0 && x < chessboard.length && y >= 0 && y < chessboard.length) {
            if (chessboard[x][y] == 1) {
                return false;
            }
            x = x + 1;
            y = y - 1;
        }

        x = row;
        y = col;
        while (x >= 0 && x < chessboard.length && y >= 0 && y < chessboard.length) {
            if (chessboard[x][y] == 1) {
                return false;
            }
            x = x + 1;
            y = y + 1;
        }

        return true;

    }

    public static String arrangement(int[][] chessboard) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chessboard.length; i++) {
            for(int j = 0; j < chessboard.length; j++) {
                if(chessboard[i][j] == 1) {
                    sb.append(" Q ");
                }else {
                    sb.append(" . ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void dfs(int[][] chessboard, ArrayList<String> result, int col) {
        if(col == chessboard.length) {
            result.add(arrangement(chessboard));
            return;
        }

        for(int i = 0; i < chessboard.length; i++) {
            if(validate(chessboard, i, col)) {
                chessboard[i][col] = 1;
                dfs(chessboard, result, col+1);
                chessboard[i][col] = 0;
            }
        }
    }
}
