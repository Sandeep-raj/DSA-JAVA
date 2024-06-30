package recursion.subsequence;

import java.util.ArrayList;

/*
 * Combination Sum II
 * 
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */

public class CombinationSumII {
    public static String combo(int[] arr, int target) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        process(arr, 0, target, result, curr);

        StringBuilder sb = new StringBuilder();
        for(String s : result) {
            sb.append(s+",");
        }

        return sb.toString();
    }

    static void process(int[] arr, int i, int sum, ArrayList<String> result, ArrayList<Integer> cArr) {

        if(i == arr.length) {
            if(sum == 0) {
                result.add(cArr.toString());
            }
            return;
        }

        if(arr[i] <= sum) {
            cArr.add(arr[i]);
            process(arr, i+1, sum - arr[i], result, cArr);
            cArr.remove(cArr.size() - 1);
        }

        process(arr, i+1, sum, result, cArr);
    }
}
