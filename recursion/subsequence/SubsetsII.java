package recursion.subsequence;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Subsets II
 * 
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */

public class SubsetsII {
    public static String subsetsII(int[] arr) {
        HashSet<String> result = new HashSet<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Arrays.sort(arr);
        process(arr, 0, result, curr);

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s + ",");
        }

        return sb.toString();
    }

    static void process(int[] arr, int i, HashSet<String> result, ArrayList<Integer> curr) {
        if (i == arr.length) {
            result.add(curr.toString());
            return;
        }

        curr.add(arr[i]);
        process(arr, i + 1, result, curr);
        curr.remove(curr.size() - 1);

        process(arr, i + 1, result, curr);
    }
}
