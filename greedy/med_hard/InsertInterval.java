package greedy.med_hard;

import java.util.ArrayList;

/*
 * Insert Interval
 * 
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.


Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].



Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] interval) {
        // ArrayList<int[]> result = new ArrayList<>();
        // boolean found = false;
        
        // for(int i = 0;i < intervals.length; i++) {
        //     if(!found && interval[0] <= intervals[i][1] && interval[1] >= intervals[i][0]) {
        //         interval[0] = Math.min(interval[0], intervals[i][0]);
        //         interval[1] = Math.max(interval[1], intervals[i][1]);
        //     }else if (!found && interval[0] < intervals[i][1] && interval[1] < intervals[i][0]) {
        //         found = true;
        //         result.add(interval);
        //         result.add(intervals[i]);
        //     }else {
        //         result.add(intervals[i]);
        //     }
        // }

        // if(!found) {
        //     result.add(interval);
        // }

        // return result.toArray(new int[result.size()][]);



        /// More Simpler Solution
        ArrayList<int[]> result = new ArrayList<>();
        int n = intervals.length, i = 0;

        while (i < n && interval[0] > intervals[i][1]) {
            result.add(intervals[i]);
            i++;
        }


        while (i < n && interval[1] >= intervals[i][0]) {
            interval[0] = Math.min(interval[0], intervals[i][0]);
            interval[1] = Math.max(interval[1], intervals[i][1]);
            i++;
        }

        result.add(interval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
