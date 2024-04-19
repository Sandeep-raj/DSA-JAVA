package array.medium;

import java.util.ArrayList;

/*
 * Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.

Examples
Example 1:
Input:

 arr = [4, 7, 1, 0]
Output
:
 7 1 0
Explanation:

 Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.

Example 2:
Input:

 arr = [10, 22, 12, 3, 0, 6]
Output:

 22 12 6
Explanation:

 6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.
 */

public class LeadersInArray {
    public static int[] leaders(int[] arr){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int maxVal = Integer.MIN_VALUE;
        for (int i = arr.length -1; i >= 0; i--) {
            if (arr[i] > maxVal) {
                result.add(0, arr[i]);
                maxVal = arr[i];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
