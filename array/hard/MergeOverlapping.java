package array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Merge Overlapping Sub-intervals
Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

Examples
Example 1:
Example 1:
Input:
 intervals=[[1,3],[2,6],[8,10],[15,18]]

Output:
 [[1,6],[8,10],[15,18]]

Explanation:
 Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.

Example 2:
Input:
 [[1,4],[4,5]]

Output:
 [[1,5]]

Explanation:
 Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
 */

public class MergeOverlapping {
    public static String merge(int[][] arr) {
        // Prfix Sum   [[1,3],[2,5]] --> [0,1,2,2,1,1,0,0,0]
        // ArrayList<String> result = new ArrayList<String>();
        // int arrMin = Integer.MAX_VALUE;
        // int arrMax = Integer.MIN_VALUE;

        // for (int i = 0; i < arr.length; i++) {
        //     arrMin = Math.min(arrMin, arr[i][0]);
        //     arrMax = Math.max(arrMax, arr[i][1]);
        // }

        // int[] prefixSum = new int[arrMax - arrMin + 1];

        // for (int i = 0; i < arr.length; i++) {
        //     prefixSum[arr[i][0] - arrMin] = 1;
        //     prefixSum[arr[i][1] - arrMin] = -1;
        // }

        // int cumSum = 0;
        // int startIdx = -1;
        // for (int i = 0; i < prefixSum.length; i++) {
        //     if(cumSum == 0 && cumSum + prefixSum[i] > 0) {
        //         startIdx = i;
        //     }else if (cumSum > 0 && cumSum + prefixSum[i] == 0) {
        //         result.add((startIdx + arrMin) + " - " + (i + arrMin));
        //     }

        //     cumSum += prefixSum[i];
        // }
        // return result.toString();



        // sort and merge
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < arr.length; i++) {
            if(result.size() == 0 || result.get(result.size() - 1).get(1) < arr[i][0] ) {
                result.add(Arrays.asList(arr[i][0], arr[i][1]));
            }else {
                result.get(result.size() - 1).set(1, arr[i][1]);
            }
        }

        return result.toString();
    }
}
