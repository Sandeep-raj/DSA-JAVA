package basic.recursion;

/*
 * You are given an array. The task is to reverse the array and print it. 

Examples:

Example 1:
Input: N = 5, arr[] = {5,4,3,2,1}
Output: {1,2,3,4,5}
Explanation: Since the order of elements gets reversed the first element will occupy the fifth position, the second element occupies the fourth position and so on.

Example 2:
Input: N=6 arr[] = {10,20,30,40}
Output: {40,30,20,10}
Explanation: Since the order of elements gets reversed the first element will occupy the fifth position, the second element occupies the fourth position and so on.


Recursive method

Approach: The recursive method has an approach almost similar to the iterative one. The approach has been broken down into some steps for simplicity.

Create a function that takes an array, start index, and end index of the array as parameters.
Swap the elements present  at the start and end index, 
The portion of the array left to be reversed is arr[start+1,end-1]. Make a recursive call to reverse the rest of the array. While calling recursion pass start +1  and ends - 1 as parameters for the shrunk array. Repeat step 2.
Continue recursion as long as the ‘start < end’ condition is satisfied. This is the base case for our recursion.
 */

public class RevArray {
    public static int[] rev(int[] arr) {
        int[] resArr = revRec(arr, 0, arr.length - 1);
        for (int i =0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        return resArr;
    }

    static int[] revRec(int[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }
        swap(arr, start, end);

        return revRec(arr, start+ 1, end -1);
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    } 
}
