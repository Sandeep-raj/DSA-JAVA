package greedy.med_hard;

import java.util.Arrays;

/*
 * Minimum Platforms
 * 
 * Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.


Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains.



Your Task:
You don't need to read input or print anything. Your task is to complete the function findPlatform() which takes the array arr[] (denoting the arrival times), array dep[] (denoting the departure times) and the size of the array as inputs and returns the minimum number of platforms required at the railway station such that no train waits.

Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (this will be <= 59 and >= 0).


Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 50000
0000 ≤ A[i] ≤ D[i] ≤ 2359
 */

public class MinimumPlatforms {
    public static int min(int[] arrival, int[] depart) {
        Arrays.sort(arrival);
        Arrays.sort(depart);

        int ptr1 = 0, ptr2 = 0, platforms = 0, result = 0;
        while (ptr1 < arrival.length) {
            if(arrival[ptr1] <= depart[ptr2]) {
                while (ptr1 < arrival.length && arrival[ptr1] <= depart[ptr2]) {
                    platforms++;
                    result = Math.max(result, platforms);
                    ptr1++;
                }
            }else {
                while (ptr2 < depart.length && depart[ptr2] < arrival[ptr1]) {
                    platforms--;
                    result = Math.max(result, platforms);
                    ptr2++;
                }
            }
        }

        return result;
    }
}
