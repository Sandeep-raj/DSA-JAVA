package stack_queues.monotonic;

/*
 * 
 * Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example 1
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

public class TrappingRainWater {
    public static int trapped(int[] arr) {
        int[] ger = new int[arr.length];
        int[] gel = new int[arr.length];
        int gmax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            ger[i] = gmax;
            if(arr[i] > gmax) {
                gmax = arr[i];
            }
        }

        gmax = -1;
        for (int i = 0; i < arr.length; i++) {
            gel[i] = gmax;
            if(arr[i] > gmax) {
                gmax = arr[i];
            }
        }

        int trappedWater = 0;
        for(int i = 0; i < arr.length; i++) {
            int currWaterTrapped = Math.min(ger[i], gel[i]) - arr[i];
            if(currWaterTrapped > 0) {
                trappedWater += currWaterTrapped;
            }
        }

        return trappedWater;
    }
}
