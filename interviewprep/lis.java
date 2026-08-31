// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
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
Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        System.out.println(lis(new int[]{7,7,7,7,7,7,7}, 7, -1));
        listab(new int[]{10,9,2,5,3,7,101,18});
        lisbin(new int[]{0,1,0,3,2,3});
    }
    // O(nlogn)
    static void lisbin(int[] arr) {
        int[] list = new int[arr.length];
        Arrays.fill(list, Integer.MAX_VALUE);

        for(int x : arr) {
            int idx = upperBound(list, x);
            list[idx] = x;
        }

        int res = -1;
        for(int i = 0; i < list.length; i++) {
            if(list[i] != Integer.MAX_VALUE) {
                res = i + 1;
            }
        }

        System.out.println(res);
    }

    static int upperBound(int[] arr, int val) {
        int start = 0, end = arr.length-1;
        int res = -1;
        while(start <= end) {
            int mid = (start+end)/2;

            if(arr[mid] == val) {
                return mid;
            }
            if(arr[mid] < val) {
                start = mid+1;
            }else {
                res = mid;
                end = mid-1;
            }
        }

        return res;
    }

    // O(n^2)
    static void listab(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for(int i = arr.length-1; i >= 0; i--) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = 0;
        for(int x : dp) {
            res = Math.max(res,x);
        }

        System.out.println(res);
    }

    // O(2^n)
    static int lis(int[] arr, int idx, int prev) {
        if(idx == 0) {
            return 0;
        }

        int take = 0;
        if(prev == -1 || arr[idx-1] < arr[prev-1]) {
            take = 1 + lis(arr, idx-1, idx);
        }
        int notake = lis(arr, idx-1,prev);

        return Math.max(take, notake);
    }
}
