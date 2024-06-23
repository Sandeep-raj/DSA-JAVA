package graph.shortest_path_algo;

import java.util.ArrayList;

/*
 * Minimum Multiplications to reach End
 * 
 * Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.
Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30


Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 63 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175


Your Task:
You don't need to print or input anything. Complete the function minimumMultiplications() which takes an integer array arr, an integer start and an integer end as the input parameters and returns an integer, denoting the minumum steps to reach in which end can be achieved starting from start.
Expected Time Complexity: O(105)
Expected Space Complexity: O(105)

Constraints:

1 <= n <= 104
1 <= arr[i] <= 104
1 <= start, end < 105
 */

public class MinimumMultiplicationsReachEnd {
    public static int min(int[] arr, int start, int end) {
        ArrayList<int[]> q  = new ArrayList<>();
        int[] steps = new int[100000];
        for(int i = 0; i < 100000; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        q.add(new int[]{start,0});
        steps[start] = 0;

        while (q.size() > 0) {
            int[] curr = q.remove(0);
            int currN = curr[0], currS = curr[1];

            if(currN == end) {
                return currS;
            }

            for(int x : arr) {
                int temp = currN*x;
                temp = temp % 100000;

                if(steps[temp] > currS + 1) {
                    q.add(new int[]{temp, currS + 1});
                    steps[temp] = currS + 1;
                }
            }
        }

        return -1;
    }
}
