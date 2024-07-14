package dynamic_programming.LIS;

import java.util.ArrayList;

/*
 * Print Longest Increasing Subsequence
 * 
 * Given an integer n and an array of integers arr, return the Longest Increasing Subsequence which is Index-wise lexicographically smallest.
Note - A subsequence S1 is Index-wise lexicographically smaller than a subsequence S2 if in the first position where S1 and S2 differ, subsequence S1 has an element that appears earlier in the array  arr than the corresponding element in S2.
LIS  of a given sequence is defined as that longest possible subsequence all of whose elements are in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and the LIS is {10, 22, 33, 50, 60, 80}. 

Input:
n = 16
arr = [0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15]
Output:
0 4 6 9 13 15 
Explanation:
longest Increasing subsequence is 0 4 6 9 13 15  and the length of the longest increasing subsequence is 6.


Input:
n = 1
arr = [1]
Output:
1


Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)

Constraint:
1 <= n < = 103
0 <= arr[i] <= 109
 */

public class PrintLIS {
    public static String print(int[] nums) {
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            hash[i] = i;
        }

        int max = 0, max_idx = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }

            if(dp[i] > max) {
                max = dp[i];
                max_idx = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (max_idx != hash[max_idx]) {
            res.add(0, nums[max_idx]);
            max_idx = hash[max_idx];
        }

        return res.toString();
    }
}
