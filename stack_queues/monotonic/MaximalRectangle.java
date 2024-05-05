package stack_queues.monotonic;

/*
 * Maximal Rectangle
 * 
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * 
 * Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
 */

public class MaximalRectangle {
    public static int maxArea(String[][] arr) {
        int[] cumArr = new int[arr[0].length];
        int maxArea = 0;
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[0].length; col++) {
                int x = 0;
                if(arr[row][col] == "1") {
                    x = 1;
                }
                cumArr[col] = x * (cumArr[col] + x);
            }

            int curMax = stack_queues.monotonic.LargestRectangleHistogram.largestArea(cumArr);
            maxArea = Math.max(maxArea, curMax);
        }

        return maxArea;
    }
}
