package recursion.subsequence;

import java.util.HashSet;

/*
 * Subset Sums
 * 
 * Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.
 * 
Input:
n = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.


Input:
n = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8
 */

public class SubsetSums {
    public static String subsets(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        process(arr, 0, 0, set);

        StringBuilder sb = new StringBuilder();
        for(int x : set) {
            sb.append("[" + x + "]");
        }

        return sb.toString();
    }

    static void process(int[] arr, int i, int sum, HashSet<Integer> result) {
        if(i == arr.length) {
            result.add(sum);
            return;
        }

        process(arr, i+1, sum + arr[i], result);
        process(arr, i+1, sum, result);
    }
}
