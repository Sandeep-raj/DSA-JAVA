package array.easy;

/*
 * Given an array, we have to find the largest element in the array.

Examples
Example 1:
Input:
 arr[] = {2,5,1,3,0};
Output:
 5
Explanation:
 5 is the largest element in the array. 

Example2:
Input:
 arr[] = {8,10,5,7,9};
Output:
 10
Explanation:
 10 is the largest element in the array. 
 */

public class LargestElement {
    public static int solve(int[] inpArr) {

        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < inpArr.length; i++) {
            if(maxVal < inpArr[i]) {
                maxVal = inpArr[i];
            }
        }

        return maxVal;
    }
}
