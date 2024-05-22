package greedy.med_hard;

import java.util.ArrayList;

/*
 * Merge Intervals
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].


Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.



Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // Sorting algorithm (O(nlogn))
        // ArrayList<int[]> result = new ArrayList<>();

        // Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        // for(int i =0; i < intervals.length; i++) {
        //     int[] currInterval = intervals[i];
        //     i++;

        //     while (i < intervals.length && intervals[i][0] <= currInterval[1]) {
        //         currInterval[1] = Math.max(intervals[i][1], currInterval[1]);
        //         i++;
        //     }

        //     i--;
        //     result.add(currInterval);
        // }

        // return result.toArray(new int[result.size()][]);


        // Time Range Array (O(n)) -> n ~ 10^4
        ArrayList<int[]> result = new ArrayList<>();

        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }

        int[] timeTable = new int[max - min + 1];
        for(int i = 0; i < intervals.length; i++) {
            timeTable[intervals[i][0] - min] += 1;
            timeTable[intervals[i][1] - min] -= 1;
        }

        int sum = 0;
        for(int i = 0; i < timeTable.length; i++) {
            int start = 0, end = 0;
            sum += timeTable[i];
            if(sum > 0) {
                start = i + min;
                i++;

                while (i < timeTable.length && sum > 0) {
                    sum += timeTable[i];
                    i++;
                }
                i--;
                end = i + min;
                result.add(new int[]{start,end});
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
