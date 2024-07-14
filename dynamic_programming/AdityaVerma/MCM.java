package dynamic_programming.AdityaVerma;

/*
 * Matrix Chain Multiplication
 * 
 * Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]), the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum.
 * 
 * Input: arr[] = {40, 20, 30, 10, 30}
Output: 26000
Explanation:There are 4 matrices of dimensions 40×20, 20×30, 30×10, 10×30.
Let the input 4 matrices be A, B, C and D.
The minimum number of  multiplications are obtained by 
putting parenthesis in following way (A(BC))D.
The minimum is 20*30*10 + 40*20*10 + 40*10*30

Input: arr[] = {1, 2, 3, 4, 3}
Output: 30
Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3. 
Let the input 4 matrices be A, B, C and D.  
The minimum number of multiplications are obtained by 
putting parenthesis in following way ((AB)C)D.
The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30

Input: arr[] = {10, 20, 30}
Output: 6000  
Explanation: There are only two matrices of dimensions 10×20 and 20×30. 
So there  is only one way to multiply the matrices, cost of which is 10*20*30
 */

public class MCM {
    public static int mcm(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for(int i = 0; i <= arr.length; i++) {
            for(int j = 0; j <= arr.length; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(arr, 1, arr.length-1, dp);
    }

    static int solve(int[] arr,int i ,int j, int[][] dp) {
        if(i >= j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int minVal = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            minVal = Math.min(minVal, solve(arr, i, k, dp) + solve(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j]);
        }
        
        dp[i][j] = minVal;

        return minVal;
    }
}
