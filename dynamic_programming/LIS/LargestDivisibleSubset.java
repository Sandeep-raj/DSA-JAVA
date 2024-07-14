package dynamic_programming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Largest Divisible Subset
 * 
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.


Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.
 */

public class LargestDivisibleSubset {
    public static String subset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] hash= new int[nums.length];

        for(int i = 0 ; i < nums.length; i++) {
            dp[i] = 1;
            hash[i] = i;
        }

        int max = 1, max_idx = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] < 1 + dp[j]) {
                        dp[i] = 1 + dp[j];
                        hash[i] = j;
                    }
                }
            }

            if(max < dp[i]) {
                max= dp[i];
                max_idx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        if(max_idx != -1) {
            while (max_idx != hash[max_idx]) {
                res.add(0, nums[max_idx]);
                max_idx = hash[max_idx];
            }
            res.add(0,nums[max_idx]);
        }
        

        return res.toString();
    }
}
