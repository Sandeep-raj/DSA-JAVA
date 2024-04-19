package array.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.

A subarray is a contiguous non-empty sequence of elements within an array.

Pre-requisite: Longest subarray with given sum

Examples
Example 1:
Input Format:
 N = 4, array[] = {3, 1, 2, 4}, k = 6
Result:
 2
Explanation:
 The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].

Example 2:
Input Format:
 N = 3, array[] = {1,2,3}, k = 3
Result:
 2
Explanation:
 The subarrays that sum up to 3 are [1, 2], and [3].
 */

public class SubarraySumEqualK {
    public static int count(int[] arr, int k) {
        // Two Pointer

        // int i = 0, j = 0;
        // int currSum = arr[0];
        // int count = 0;

        // while(j < arr.length) {
        //     if (currSum == k) {
        //         count++;
        //     }

        //     if(currSum <= k) {
        //         j++;
        //         if (j < arr.length){
        //             currSum += arr[j];
        //         }
        //     }else if(currSum > k) {
        //         currSum -= arr[i];
        //         i++;
        //     }
        // }

        // while (i < arr.length) {
        //     currSum -= arr[i];
        //     i++;
        //     if (currSum == k) {
        //         count++;
        //     }
        // }
        // return count;


        /// Prefix Sum
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0, currSum = 0;

        for (int i = 0 ; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == k){
                count++;
            }

            int rem = currSum - k;

            if(map.containsKey(rem)) {
                count++;
            }

            if(map.containsKey(currSum)) {
                map.put(currSum, map.get(currSum));
            }else {
                map.put(currSum, 1);
            }
        }

        return count;
    }
}
