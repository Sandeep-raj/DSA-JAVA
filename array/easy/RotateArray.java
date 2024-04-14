package array.easy;

import java.util.Arrays;

/*
 * Given an array of integers, rotating array of elements by k elements either left or right.

Examples:

Example 1:
Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
Output: 6 7 1 2 3 4 5
Explanation: array is rotated to right by 2 position .

Example 2:
Input: N = 6, array[] = {3,7,8,9,10,11} , k=3 , left 
Output: 9 10 11 3 7 8
Explanation: Array is rotated to right by 3 position.
 */

public class RotateArray {
    public static int[] rotate(int[] arr, int k, String direction) {
        if (direction == "left") {
            int[] leftArr = Arrays.copyOfRange(arr, 0, k);
            int[] rightArr = Arrays.copyOfRange(arr, k, arr.length);
            rightArr = Arrays.copyOf(rightArr, arr.length);
            System.arraycopy(leftArr, 0 , rightArr, arr.length -k,k);
            return rightArr;
        }else {
            int[] rightArr = Arrays.copyOfRange(arr, arr.length - k, arr.length);
            int[] leftArr = Arrays.copyOfRange(arr, 0, arr.length - k);
            rightArr = Arrays.copyOf(rightArr, arr.length);
            System.arraycopy(leftArr, 0, rightArr, k, arr.length - k);
            return rightArr;
        }
    }
}
