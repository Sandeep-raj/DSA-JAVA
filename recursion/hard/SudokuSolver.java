package recursion.hard;

/*
 * Sudoku Solver
 * 
 * Problem Statement:

Given a 9x9 incomplete sudoku, solve it such that it becomes valid sudoku. Valid sudoku has the following properties.

         1. All the rows should be filled with numbers(1 - 9) exactly once.

         2. All the columns should be filled with numbers(1 - 9) exactly once.

         3. Each 3x3 submatrix should be filled with numbers(1 - 9) exactly once.


board= {
                    {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                    {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                    {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                    {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                    {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                    {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                    {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                    {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                    {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
                    }


Output:

9 5 7 6 1 3 2 8 4
4 8 3 2 5 7 1 9 6
6 1 2 8 4 9 5 3 7
1 7 8 3 6 4 9 5 2
5 2 4 9 7 1 3 6 8
3 6 9 5 2 8 7 4 1
8 4 5 7 9 2 6 1 3
2 9 1 4 3 6 8 7 5
7 3 6 1 8 5 4 2 9

9 5 7 6 1 3 2 8 4
4 8 3 2 5 7 1 9 6
6 1 2 8 4 9 5 3 7
1 7 8 3 6 4 9 5 2
5 2 4 9 7 1 3 6 8
3 6 9 5 2 8 7 4 1
8 4 5 7 9 2 6 1 3
2 9 1 4 3 6 8 7 5
7 3 6 1 8 5 4 2 9

Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.
Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.
 */

public class SudokuSolver {
    public static String sudokuSolver(char[][] sudoku) {
        return solve(sudoku, 0);
    }

    static String solve(char[][] sudoku, int curr) {
        if (curr == 81) {
            StringBuilder sb = new StringBuilder();
            for (int z = 0; z < 9; z++) {
                for (int w = 0; w < 9; w++) {
                    sb.append(sudoku[z][w] + " ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }

        int x = curr / 9, y = curr % 9;

        if (sudoku[x][y] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                if (check(sudoku, x, y, c)) {
                    sudoku[x][y] = c;
                    String solve = solve(sudoku, curr + 1);
                    if (solve != "") {
                        return solve;
                    }
                    sudoku[x][y] = '.';
                }
            }
        } else {
            String solve = solve(sudoku, curr + 1);
            if (solve != "") {
                return solve;
            }
        }

        return "";
    }

    static boolean check(char[][] sudoku, int x, int y, char c) {
        int xstart = 3*(x / 3), ystart = 3*(y / 3);
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == c) {
                return false;
            }

            if (sudoku[i][y] == c) {
                return false;
            }

            if (sudoku[xstart + (i / 3)][ystart + (i % 3)] == c) {
                return false;
            }
        }
        return true;
    }
}
