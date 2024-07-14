package dynamic_programming.LIS;

/*
 * Longest Increasing Subsequence | Binary Search
 * 
 * The longest increasing subsequence is described as a subsequence of an array where:
All elements of the subsequence are in increasing order.
This subsequence itself is of the longest length possible.

We need to return the length of the longest increasing subsequence as the answer.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */

public class LIS_BinarySearch {
    public static int seqlen(int[] nums) {
        int end = 1;
        int[] res = new int[nums.length];
        res[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(res[end-1] < nums[i]) {
                res[end] = nums[i];
                end++;
            }else {
                int sidx = 0, eidx = end;
                while (sidx >=0 && sidx < eidx) {
                    int mid = (sidx+eidx)/2;

                    if(res[mid] < nums[i]) {
                        sidx = mid+1;
                    }else {
                        eidx = mid;
                    }
                }

                res[sidx] = nums[i];
            }
        }

        return end;
    }
}
