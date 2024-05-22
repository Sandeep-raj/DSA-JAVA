package greedy.med_hard;

import java.util.Arrays;

/*
 * Non-overlapping Intervals
 * 
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * 
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.



Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.


Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
 */

public class NonOverlappingIntervals {
    public static int erase(int[][] intervals) {
        // Sorting Method (O(nlogn))
        // Arrays.sort(intervals, (a,b) -> (a[1] - b[1]));
        // int[][] result = new int[intervals.length][];
        // int size = 0;

        // int start = Integer.MIN_VALUE;
        // for (int i = 0; i < intervals.length; i++) {
        //     if(start <= intervals[i][0]) {
        //         result[size] = intervals[i];
        //         size++;
        //         start = intervals[i][1];
        //     }
        // }

        // return result;

        int max = intervals[0][1];
        int min = max;
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }
        int shift = 1 - min;
        int maxIntervalRange = 2 + max - min;
        int[] rightEnds = new int[maxIntervalRange];

        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (left > rightEnds[right]) {
                rightEnds[right] = left;
            }
        }
        int start = 1;
        int count = 1;
        for (int i = 2; i < maxIntervalRange; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }
        return intervals.length - count;
    }
}
