package greedy.med_hard;

import java.util.Arrays;

/*
 * N meetings in one room
 * 
 * There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)


Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output: 
1
Explanation:
Only one meetings can be held
with given start and end timings.



Your Task :
You don't need to read inputs or print anything. Complete the function maxMeetings() that takes two arrays start[] and end[] along with their size N as input parameters and returns the maximum number of meetings that can be held in the meeting room.


Expected Time Complexity : O(N*LogN)
Expected Auxilliary Space : O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ start[i] < end[i] ≤ 105
 */

public class NMeetingsOneRoom {
    static class Room {
        int id;
        int start;
        int end;

        public Room(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }
    public static int max(int[] start, int[] end) {
        // O(n) +O(n log n) + O(n) ~O(n log n)
        Room[] room = new Room[start.length];
        for(int i = 0; i < start.length; i++) {
            room[i] = new Room(start[i], end[i], i+1);
        }

        Arrays.sort(room,(a,b) -> (a.end - b.end));

        int endTime = 0,count = 0;

        for(int i = 0; i < start.length; i++) {
            if(room[i].start > endTime) {
                count++;
                endTime = room[i].end;
            }
        }

        return count;
    }
}
