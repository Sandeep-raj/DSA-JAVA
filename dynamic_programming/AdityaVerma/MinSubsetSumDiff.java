package dynamic_programming.AdityaVerma;

/*
 * Partition a set into two subsets such that the difference of subset sums is minimum
 * 
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum. 
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11  
 */

public class MinSubsetSumDiff {
    public static int minDiff(int[] arr) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int i = 0; i < arr.length; i++) {
            boolean[] ndp = new boolean[sum+1];
            ndp[0] = true;
            for(int j = 1; j <= sum; j++) {
                if(j >= arr[i]) {
                    ndp[j] = dp[j] | dp[j-arr[i]];
                }else {
                    ndp[j] = dp[j];
                }
            } 

            dp = ndp;
        }

        int minDif = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++) {
            if(dp[i]) {
                minDif = Math.min(minDif, Math.abs(sum - (2*i)));
            }
        }

        return minDif;
    }
}
