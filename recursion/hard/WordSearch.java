package recursion.hard;

/*
 * Word Search
 * 
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 */

public class WordSearch {
    public static boolean search(String[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(process(board, i, j, word, 0, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean process(String[][] board, int x, int y, String word, int i, boolean[][] vis) {
        if(i == word.length()) {
            return true;
        }


        if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && !vis[x][y]) {
            if(board[x][y].contentEquals("" + word.charAt(i))) {
                vis[x][y] = true;

                if(process(board, x-1, y, word, i+1, vis)) {
                    return true;
                }
                if(process(board, x+1, y, word, i+1, vis)) {
                    return true;
                }
                if(process(board, x, y-1, word, i+1, vis)) {
                    return true;
                }
                if(process(board, x, y+1, word, i+1, vis)) {
                    return true;
                }
                vis[x][y] = false;
            }
        }
        return false;
    }
}
