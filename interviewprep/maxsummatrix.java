// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*
Given an N*N matrix. The task is to find the index of a row with the maximum sum. That is the row whose sum of elements is maximum.
Examples: 
Input : mat[][] = {
            { 1, 2, 3, 4, 5 },
            { 5, 3, 1, 4, 2 },
            { 5, 6, 7, 8, 9 },
            { 0, 6, 3, 4, 12 },
            { 9, 7, 12, 4, 3 },
            }; 

Output : Row 3 has max sum 35

Input : mat[][] = { 
          { 1, 2, 3 },
          { 4, 2, 1 },
          { 5, 6, 7 },
          };
Output : Row 3 has max sum 18
*/

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        System.out.println(kadane(new int[]{5,4,-1,7,8}));
        System.out.println(maxsummatrix(new int[][]{
  {-5, -6, 3, 1, 0},
  {9, 7, 8, 3, 7},
  {-6, 2, -1, 2, -4},
  {-7, 5, 5, 2, -6},
  {3, 2, 9, -5, 1}
} ));
    }

    static int maxsummatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int res = 0;
        for(int i = 0; i < c; i++) {
            int[] csum = new int[r];
            for(int j = i; j < c; j++) {
                for(int k = 0; k < r; k++) {
                    csum[k] += mat[k][j];
                }

                int val = kadane(csum);
                res = Math.max(res, val);
            }
        }

        return res;
    }

    static int kadane(int[] num) {
        int max = 0, curr = 0;
        for(int i = 0; i < num.length; i++) {
            curr += num[i];
            if(curr < 0) {
                curr = 0;
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}
