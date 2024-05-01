package bitmanipulation.medium;

import java.util.Arrays;

/*
 * Single Number II


 Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 */

public class SingleNumber2 {
    public static int solve(int[] arr) {

        // Bit Manipulation 
        // int result = 0;
        // for (int i = 0; i < 32; i++) {
        //     int count = 0;
        //     for(int j = 0; j < arr.length; j++) {
        //         if(((arr[j] >> i) & 1) > 0) {
        //             count++;
        //         }
        //     }

        //     if(count % 3 > 0) {
        //         result += (1<<i);
        //     } 
        // }

        // return result;


        // Sorting and Checking
        // Arrays.sort(arr);
        // int idx = 1;
        // while (idx < arr.length) {
        //     if(arr[idx - 1] != arr[idx + 1]) {
        //         break;
        //     }
        //     idx += 3;
        // }

        // return arr[idx-1];


        // Magic (Most Optimal)
        int ones = 0, tows = 0;
        for(int i = 0; i < arr.length; i++) {
            ones = (ones ^ arr[i]) & (~tows);
            tows = (tows ^ arr[i]) & (~ones);
        }

        return ones;
    }
}
