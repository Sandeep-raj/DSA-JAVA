package dynamic_programming.AdityaVerma;

/*
 * Count of Subsets with given Difference
 * 
 * Given an array arr[] of size N and a given difference diff, the task is to count the number of partitions that we can perform such that the difference between the sum of the two subsets is equal to the given difference.
Note: A partition in the array means dividing an array into two parts say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only of the subsets.

Input: N = 4, arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: We can only have a single partition which is shown below:
{5, 2} and {6, 4} such that S1 = 7 and S2 = 10 and thus the difference is 3

Input: N = 5, arr[] = [1, 2, 3, 1, 2], diff = 1
Output: 5
Explanation: We can have five partitions which is shown below
{1, 3, 1} and {2, 2} – S1 = 5, S2 = 4
{1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
{3, 2} and {1, 1, 2} – S1 = 5, S2 = 4
{1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
{3, 2} and {1, 1, 2} – S1 = 5, S2 = 4

 */

public class CountSubsetswithDiff {
    public static int count(int[] arr, int diff) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }

        int partSum = (sum + diff)/2;

        int[] dp = new int[partSum+1];
        dp[0] = 1;

        for(int i =0; i < arr.length; i++) {
            int[] ndp = new int[partSum+1];
            ndp[0] = 1;
            for(int j = 1; j <= partSum; j++) {
                if(j >= arr[i]) {
                    ndp[j] = dp[j] + dp[j-arr[i]];
                }else {
                    ndp[j] = dp[j];
                }
            }
            dp = ndp;
        }

        return dp[partSum];
    }
}
