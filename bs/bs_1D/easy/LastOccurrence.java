package bs.bs_1D.easy;

/*
 * Last occurrence in a sorted array
Given a sorted array of N integers, write a program to find the index of the last occurrence of the target key. If the target is not found then return -1.

Note: Consider 0 based indexing

Examples:

Example 1:
Input: N = 7, target=13, array[] = {3,4,13,13,13,20,40}
Output: 4
Explanation: As the target value is 13 , it appears for the first time at index number 2.

Example 2:
Input: N = 7, target=60, array[] = {3,4,13,13,13,20,40}
Output: -1
Explanation: Target value 60 is not present in the array 



Solution 2: Binary search solution (optimised) 
As given in the question, the array is already sorted

Whenever the word “sorted” or other similar terminologies are used in an array question, BINARY SEARCH can be one of the approaches.

Initially consider the start=0 and the end=n-1 pointers and the result as -1.

Till start does not crossover end pointer compare the mid element 

If the mid element is equal to the key value, store the mid-value in the result and move the start pointer to mid+1(move leftward)
Else if the key value is less than the mid element then end= mid-1(move leftward)
Else do start = mid+1 (move rightwards)
 */

public class LastOccurrence {
    public static int last(int[] arr, int x){
        int ans = -1;
        int start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = (start+end)/2;

            if(arr[mid] <= x){
                if(arr[mid] == x) {
                    ans = mid;
                }
                start = mid+1;
            }else {
                end = mid -1;
            }
        }

        return ans;
    }
}
