package dynamic_programming.MCM;

/*
 * Matrix Chain Multiplication
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.
The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) where the ith matrix has the dimensions (arr[i-1] x arr[i]).

Input: N = 5
arr = {40, 20, 30, 10, 30}
Output: 26000
Explanation: There are 4 matrices of dimension 
40x20, 20x30, 30x10, 10x30. Say the matrices are 
named as A, B, C, D. Out of all possible combinations,
the most efficient way is (A*(B*C))*D. 
The number of operations are -
20*30*10 + 40*20*10 + 40*10*30 = 26000.


Input: N = 4
arr = {10, 30, 5, 60}
Output: 4500
Explanation: The matrices have dimensions 
10*30, 30*5, 5*60. Say the matrices are A, B 
and C. Out of all possible combinations,the
most efficient way is (A*B)*C. The 
number of multiplications are -
10*30*5 + 10*5*60 = 4500.
 */

public class MCM {
    public static int mcm(int[] arr){
        return solve(arr, 1, arr.length-1);
    }

    static int solve(int[] arr, int i, int j) {
        if(i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            min = Math.min(min, solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j]);
        }

        return min;
    }
}
