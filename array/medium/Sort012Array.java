package array.medium;

/*
 * Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

Examples
Input:
 nums = [2,0,2,1,1,0]
Output
: [0,0,1,1,2,2]

Input:
 nums = [2,0,1]
Output:
 [0,1,2]

Input:
 nums = [0]
Output:
 [0]


 
 Algorithm / Intuition
This problem is a variation of the popular Dutch National flag algorithm. 

This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

arr[0….low-1] contains 0. [Extreme left part]
arr[low….mid-1] contains 1.
arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
The middle part i.e. arr[mid….high] is the unsorted segment. So, hypothetically the array with different markers will look like the following:


In our case, we can assume that the entire given array is unsorted and so we will place the pointers accordingly. For example, if the given array is: [2,0,2,1,1,0], the array with the 3 pointers will look like the following:


Here, as the entire array is unsorted, we have placed the mid pointer in the first index and the high pointer in the last index. The low is also pointing to the first index as we have no other index before 0. Here, we are mostly interested in placing the ‘mid’ pointer and the ‘high’ pointer as they represent the unsorted part in the hypothetical array.

Now, let’s understand how the pointers will work to make the array sorted.

Approach:

Note: Here in this tutorial we will work based on the value of the mid pointer.

The steps will be the following:

First, we will run a loop that will continue until mid <= high.
There can be three different values of mid pointer i.e. arr[mid]
If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
If arr[mid] == 1, we will just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subarray from index high+1 to (n-1) only contains 2.
In this step, we will do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.
Finally, our array should be sorted.
 */

public class Sort012Array {
    public static int[] sort(int[] arr) {
        int i = 0,k =0, j = arr.length - 1;

        while (k < j) {
            if(arr[k] == 2) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                j--;
            }else if (arr[k] == 0) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
            }
            k++;
        }
        return arr;
    }
}
