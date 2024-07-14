package dynamic_programming.AdityaVerma;

/*
 * Cutting a Rod
 * 
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length of the rod is 8 and the values of different pieces are given as the following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 
 * 
 * length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
And if the prices are as follows, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1) 

 */

public class CuttingARod {
    public static int cutRod(int[] length, int[] price, int l) {
        // return rod(length, price, l, length.length);
        return rodTab(length, price, l);
    }

    static int rod(int[] length, int[] price, int l ,int n) {
        if(l == 0 || n == 0) {
            return 0;
        }

        if(l >= length[n-1]) {
            int take = price[n-1] + rod(length, price, l - length[n-1], n);
            int notake = rod(length, price, l, n-1);

            return Math.max(take, notake);
        }else {
            return rod(length, price, l, n-1);
        }
    }

    static int rodTab(int[] length, int[] price, int l) {
        int[] dp = new int[l+1];
        
        for(int i = 0; i < length.length; i++) {
            int[] ndp = new int[l+1];
            for(int j = 1; j <= l; j++) {
                if(j >= length[i]) {
                    ndp[j] = Math.max(dp[j], price[i] + ndp[j - length[i]]);
                }else {
                    ndp[j] = dp[j];
                }
            }
            dp = ndp;
        }

        return dp[l];
    }
}
