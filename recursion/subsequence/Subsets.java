package recursion.subsequence;

import java.util.ArrayList;

/*
 * Subsets
 * 
 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

public class Subsets {
    public static String subsets(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        process(arr, 0, result, "");

        StringBuilder sb = new StringBuilder();
        for(String cRes : result) {
            sb.append("["+cRes+ "] ,");
        }

        return sb.toString();
    }

    static void process(int[] arr, int i, ArrayList<String> result, String currRes) {
        if(i == arr.length){
            result.add(currRes);
            return;
        }

        process(arr, i+1, result, currRes);
        process(arr, i+1, result, currRes+","+arr[i]);
    }
}
