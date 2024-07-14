package dynamic_programming.AdityaVerma;

/*
 *  Partition Equal Subset Sum
 * 
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */

public class PartitionEqualSubsetSum {
    public static boolean equalsubset(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }else {
            int eqsum = sum/2;
            return dynamic_programming.AdityaVerma.SubsetSum.subsetSum(nums, eqsum);
        }
    }
}
