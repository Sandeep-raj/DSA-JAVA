package dynamic_programming.SubsequenceDP;

/*
 * Partitions with Given Difference
 * 
 * Given an array arr, partition it into two subsets(possibly empty) such that each element must belong to only one subset. Let the sum of the elements of these two subsets be S1 and S2. 
Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the difference between S1 and S2 is equal to d. Since the answer may be large return it modulo 109 + 7.

Input:
n = 4
d = 3
arr[] =  { 5, 2, 6, 4}
Output: 1
Explanation:
There is only one possible partition of this array. Partition : {6, 4}, {5, 2}. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.


Input:
n = 4
d = 0 
arr[] = {1, 1, 1, 1} 
Output: 6 
Explanation:
we can choose two 1's from indices {0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3} and put them in S1 and remaning two 1's in S2.
Thus there are total 6 ways for partition the array arr. 


Your Task:
You don't have to read input or print anything. Your task is to complete the function countPartitions() which takes the integer n and d and array arr and returns the count of partitions.

Expected Time Complexity: O( n*sum(arr))
Expected Space Complexity: O( sum(arr))

Constraint:
1 <= n <= 500
0 <= d  <= 25000
0 <= arr[i] <= 50
 */

public class PartitionsGivenDiff {
    public static int partDIff(int[] arr, int diff) {
        int sum = 0;
        for(int x : arr) {
            sum += x;
        }

        int target = (sum + diff)/2;

        return count(arr, target);
    }

    static int count(int[] arr, int target) {
        int[][] dp = new int[arr.length][target+1];

        for(int i =0;i < arr.length; i++ ){
            dp[i][0] = 1;
        }

        if(arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= arr[i]) {
                    dp[i][j] += dp[i-1][j-arr[i]];
                }
            }
        }

        return dp[arr.length-1][target];
    }
}
