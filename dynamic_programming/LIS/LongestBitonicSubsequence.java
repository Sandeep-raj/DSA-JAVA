package dynamic_programming.LIS;

/*
 * Longest Bitonic subsequence
 * 
 * Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing. Return the maximum length of bitonic subsequence.
Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence

Input: n = 5, nums[] = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is increasing and the sequence {3, 2} is decreasing so merging both we will get length 5.

Input: n = 8, nums[] = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 6
Explanation: The bitonic sequence {1, 2, 10, 4, 2, 1} has length 6.

Expected Time Complexity: O(n2)
Expected Space Complexity: O(n)

Constraints:
1 ≤ length of array ≤ 103
1 ≤ arr[i] ≤ 104
 */

public class LongestBitonicSubsequence {
    public static int longestBitonic(int[] nums) {
        int[] leftDP = new int[nums.length];
        int[] rightDP = new int[nums.length];

        leftDP[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            leftDP[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && leftDP[i] < 1 + leftDP[j]) {
                    leftDP[i] = 1 + leftDP[j];
                }
            }
        }

        rightDP[nums.length - 1] = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            rightDP[i] = 1;
            for(int j = nums.length-1; j > i; j--) {
                if(nums[j] < nums[i] && rightDP[i] < 1 + rightDP[j]) {
                    rightDP[i] = 1 + rightDP[j];
                }
            }
        }

        int max = 0;

        for(int i = 0 ; i < nums.length; i++) {
            max=Math.max(max, leftDP[i] + rightDP[i] - 1);
        }

        return max;
    }
}
