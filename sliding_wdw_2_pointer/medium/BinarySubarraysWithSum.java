package sliding_wdw_2_pointer.medium;

/*
 * Binary Subarrays With Sum
 * 
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */

public class BinarySubarraysWithSum {
    public static int count(int[] arr, int k) {
        return countkorless(arr, k) - countkorless(arr, k-1);
    }

    static int countkorless(int[] arr, int k) {
        if(k < 0) {
            return 0;
        }

        int start = 0, end = 0, count = 0, sum = 0;

        while (end < arr.length) {
            sum += arr[end];

            while (sum > k) {
                sum -= arr[start];
                start++;
            }

            count += end - start + 1;
            end++;
        }

        return count;
    }
}
