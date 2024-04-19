package array.medium;

/*
 * Given a Matrix, print the given matrix in spiral order.

Examples:

Example 1:
Input: Matrix[][] = { { 1, 2, 3, 4 },
		      { 5, 6, 7, 8 },
		      { 9, 10, 11, 12 },
	              { 13, 14, 15, 16 } }

Outhput: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
Explanation: The output of matrix in spiral form.

Example 2:
Input: Matrix[][] = { { 1, 2, 3 },
	              { 4, 5, 6 },
		      { 7, 8, 9 } }
			    
Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
Explanation: The output of matrix in spiral form.
 */

public class SpiralTraversalMatrx {
    public static void traverse(int[][] arr) {
        int top = 0, bottom = arr.length - 1, left = 0, right = arr[0].length -1;

        while(top <= bottom && left <= right) {
            // left -> right
            for (int i = left; i <= right; i++) {
                System.out.println(arr[top][i]);
            }


            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.println(arr[i][right]);
            }

            right--;

            for(int i = right; i >= left; i--) {
                System.out.println(arr[bottom][i]);
            }

            bottom--;

            for (int i = bottom; i >= top; i--) {
                System.out.println(arr[i][left]);
            }

            left++;
        }
    }
}
