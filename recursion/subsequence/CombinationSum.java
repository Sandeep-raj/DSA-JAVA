package recursion.subsequence;

import java.util.ArrayList;

/*
 * Combination Sum
 * 
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 */

public class CombinationSum {
    public static String combination(int[] candidate, int target) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        combo(candidate, target, 0, result, curr);

        StringBuilder sb = new StringBuilder();
        for(String s : result) {
            sb.append(s+",");
        }

        return sb.toString();
    }

    static void combo(int[] arr, int sum, int i, ArrayList<String> result, ArrayList<Integer> cArr) {
        if(i == arr.length) {
            if(sum == 0) {
                result.add(cArr.toString());
            }
            return;
        }
        
        if(arr[i] <= sum) {
            cArr.add(arr[i]);
            combo(arr, sum - arr[i], i, result, cArr);
            cArr.remove(cArr.size() - 1);
        }
        combo(arr, sum, i+1, result, cArr);
    }
}
