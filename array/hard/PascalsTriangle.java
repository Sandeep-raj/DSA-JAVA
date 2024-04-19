package array.hard;

import java.util.Arrays;

public class PascalsTriangle {
    public static void print(int n, int c) {
        // variant 1 get value in pascla's trianfle at nth row cth column
        System.out.println(ncr(n, c - 1));

        // variant 2 print all the values for a row
        int[] result = new int[n]; 
        result[0] =1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * (n-i)/i;
        }
        System.out.println(Arrays.toString(result));

        // variant 3 print complete pascals triangle till nth row
        for(int i = 1; i <= n; i++) {
            int[] res = new int[i];
            res[0] = 1;
            for (int j = 1; j < i; j++) {
                res[j] = res[j-1] * (i - j)/j;
            }

            System.out.println(Arrays.toString(res));
        }
    }

    static int ncr(int n, int r) {
        if (n == 0 || r == 0) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n-i);
            result = result / i;
        }

        return result; 
    }
}
