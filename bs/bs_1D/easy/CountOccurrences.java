package bs.bs_1D.easy;

/*
 * Count Occurrences in Sorted Array
Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.

Example 1:
Input:
 N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
Output
: 4
Explanation:
 3 is occurring 4 times in 
the given array so it is our answer.

Example 2:
Input:
 N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
Output
: 5
Explanation:
 2 is occurring 5 times in the given array so it is our answer.


 Optimal Approach(Binary Search): 
In the previous article, we discussed how to find the first and the last occurrences of a number in a sorted array using Binary Search.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

Now in order to solve this problem, we are going to use the previous concept. We will find the first and the last occurrences and figure out the number of occurrences like the following:

Total number of occurrences = last occurrence - first occurrence + 1

Algorithm:
We will get the first and the last occurrences of the number using the function firstAndLastPosition(). For the implementation details of the function, please refer to the previous article.
After getting the indices, we will check the following cases:
If the first index == -1: This means that the target value is not present in the array. So, we will return 0 as the answer.
Otherwise: We will find the total number of occurrences like this:
The total number of occurrences  = (last index - first index + 1) and return this length as the answer.
 */

public class CountOccurrences {
    public static int count(int[] arr, int x ) {
        int endIdx = LastOccurrence.last(arr, x);
        int startIdx = first(arr, x);
        System.out.println(endIdx + " - " + startIdx);
        return endIdx - startIdx+1;
    }

    static int first(int[] arr, int x) {
        int ans = arr.length-1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] >= x) {
                if(arr[mid] == x) {
                    ans = mid;
                }
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return ans;

    }
}
