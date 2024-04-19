package array.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMat0 {
    public static int[][] setZeros(int[][] arr) {
        // Set Approach

        // Set<Integer> rows = new HashSet<Integer>();
        // Set<Integer> cols = new HashSet<Integer>();

        // for (int i = 0; i < arr.length; i++) {
        //     for(int j = 0 ; j < arr[0].length; j++) {
        //         if(arr[i][j] == 0) {
        //             rows.add(i);
        //             cols.add(j);
        //         }
        //     }
        // }

        // for (int i = 0; i < arr.length; i++) {
        //     for(int j = 0 ; j < arr[0].length; j++) {
        //         if(rows.contains(i) || cols.contains(j)){
        //             arr[i][j] = 0;
        //         }
        //     }
        // }

        // return arr;


        // Array Approach
        // int[] rows = new int[arr.length];
        // int[] cols = new int[arr[0].length];

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         if(arr[i][j] == 0) {
        //             rows[i]  = 1;
        //             cols[j] = 1;
        //         }
        //     }
        // }

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         if(rows[i] == 1 || cols[j] == 1) {
        //             arr[i][j] = 0;
        //         }
        //     }
        // }

        // return arr;



        // Use Same Matrix 1st row and col to save space
        
        boolean row0 = false;
        boolean col0 = false;
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;

                    if(i == 0) {
                        col0 = true;
                    }

                    if (j == 0 ) {
                        row0 = true;
                    }
                }
            }
        }

        for(int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if(row0) {
            for (int i = 0; i < arr[0].length; i++) {
                arr[0][i] = 0;
            }
        }

        if(col0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }

        return arr;
    }
}
