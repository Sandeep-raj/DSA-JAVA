package sliding_wdw_2_pointer.medium;

/*
 * Max Consecutive Ones III
 * 
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * 
 * Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */

public class MaxConsecutiveOnes3 {
    public static int longest(int[] arr, int k) {
        int start = 0, end = 0;
        int result = 0, zeros = 0;

        while (end < arr.length) {
            if(arr[end] == 0) {
                zeros++;
            }

            if(zeros > k) {
                if(arr[start] == 0) {
                    zeros--;
                }
                start++;
            }

            if(zeros <= k) {
                result = Math.max(result, end-start+1);
            }

            end++;
        }

        return result;
    }
}