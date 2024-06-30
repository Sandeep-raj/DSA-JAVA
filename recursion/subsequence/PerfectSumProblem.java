package recursion.subsequence;

import java.util.ArrayList;

/*
 * Perfect Sum Problem
 * Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7.

Input: 
n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
Output: 
3
Explanation: 
{5, 2, 3}, {2, 8}, {10} are possible subsets.


Input: 
n = 5, arr = [2, 5, 1, 4, 3], sum = 10
Output: 
3
Explanation: 
{2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.

Expected Time Complexity: O(n*sum)
Expected Auxiliary Space: O(n*sum)

Constraints:
1 ≤ n*sum ≤ 106
0 ≤ arr[i] ≤ 106
 */

public class PerfectSumProblem {
    public static int perfectSum(int[] arr, int sum) {
        ArrayList<String> result = new ArrayList<>();
        sum(arr,0,0,sum,result,"");

        return result.size();
    }


    static void sum(int[] arr, int curri, int currsum, int sum, ArrayList<String> result, String currstr) {
        if(arr.length == curri) {
            if(currsum == sum) {
                result.add(currstr);
            }
            return;
        }

        sum(arr,curri+1,currsum,sum,result,currstr);
        sum(arr, curri + 1, currsum + arr[curri], sum, result, currstr+arr[curri]+",");
    }
}
