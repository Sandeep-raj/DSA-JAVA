package array.hard;

import java.util.Arrays;

/*
 * Merge two Sorted Arrays Without Extra Space
 * 
Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Examples
Example 1:
Input:
 
n = 4, arr1[] = [1 4 8 10] 
m = 5, arr2[] = [2 3 9]

Output:
 
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]

Explanation:

After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:
Input:
 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]

Output:
 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]

Explanation:

After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.






Optimal Approach 1 (without using any extra space): 
In this optimal approach, we need to get rid of the extra space we were using.

Approach:
The sizes of the given arrays are n(size of arr1[]) and m(size of arr2[]).

The steps are as follows:

We will declare two pointers i.e. left and right. The left pointer will point to the last index of the arr1[](i.e. Basically the maximum element of the array). The right pointer will point to the first index of the arr2[](i.e. Basically the minimum element of the array).
Now, the left pointer will move toward index 0 and the right pointer will move towards the index m-1. While moving the two pointers we will face 2 different cases like the following:
If arr1[left] > arr2[right]: In this case, we will swap the elements and move the pointers to the next positions.
If arr1[left] <= arr2[right]: In this case, we will stop moving the pointers as arr1[] and arr2[] are containing correct elements.
Thus, after step 2, arr1[] will contain all smaller elements and arr2[] will contain all bigger elements. Finally, we will sort the two arrays.
Intuition:
If we merge the given array, one thing we can assure is that arr1[] will contain all the smaller elements and arr2[] will contain all the bigger elements. This is the logic we will use. Using the 2 pointers, we will swap the bigger elements of arr1[] with the smaller elements of arr2[] until the minimum of arr2[] becomes greater or equal to the maximum of arr1[].





Optimal Approach 2 (Using gap method): 
This gap method is based on a sorting technique called shell sort. The intuition of this method is simple. 

Intuition:
Similar to optimal approach 1, in this approach, we will use two pointers i.e. left and right, and swap the elements if the element at the left pointer is greater than the element at the right pointer. 

But the placing of the pointers will be based on the gap value calculated. The formula to calculate the initial gap is the following:

Initial gap = ceil((size of arr1[] + size of arr2[]) / 2)

Assume the two arrays as a single continuous array and initially, we will place the left pointer at the first index and the right pointer at the (left+gap) index of that continuous array.

Now, we will compare the elements at the left and right pointers and move them by 1 place each time after comparison. While comparing we will swap the elements if the element at the left pointer > the element at the right pointer. After some steps, the right pointer will reach the end and the iteration will be stopped.

After each iteration, we will decrease the gap and will follow the same procedure until the iteration for gap = 1 gets completed. Now, after each iteration, the gap will be the following:

gap = ceil( previous gap / 2)

The whole process will be applied to the imaginary continuous array constructed using arr1[] and arr2[].

Approach:
The steps are as follows:

First, assume the two arrays as a single array and calculate the gap value i.e. ceil((size of arr1[] + size of arr2[]) / 2).
We will perform the following operations for each gap until the value of the gap becomes 0:
Place two pointers in their correct position like the left pointer at index 0 and the right pointer at index (left+gap).
Again we will run a loop until the right pointer reaches the end i.e. (n+m). Inside the loop, there will be 3 different cases:
If the left pointer is inside arr1[] and the right pointer is in arr2[]: We will compare arr1[left] and arr2[right-n] and swap them if arr1[left] > arr2[right-n].
If both the pointers are in arr2[]: We will compare arr1[left-n] and arr2[right-n] and swap them if arr1[left-n] > arr2[right-n].
If both the pointers are in arr1[]: We will compare arr1[left] and arr2[right] and swap them if arr1[left] > arr2[right].
After the right pointer reaches the end, we will decrease the value of the gap and it will become ceil(current gap / 2). 
Finally, after performing all the operations, we will get the merged sorted array.

 */

public class Merge2SortedArray {
    public static int[][] merge(int[] arr1, int[] arr2) {
        // 2 Pointer with Quick Sort

        // int leftPtr = arr1.length - 1;
        // int rightPtr = 0;

        // while (leftPtr >= 0 && rightPtr <= arr2.length - 1) {
        //     if(arr1[leftPtr] > arr2[rightPtr]) {
        //         int temp = arr1[leftPtr];
        //         arr1[leftPtr] = arr2[rightPtr];
        //         arr2[rightPtr] = temp;
        //         leftPtr--;
        //         rightPtr++;
        //     }else {
        //         break;
        //     }
        // }

        // Arrays.sort(arr1);
        // Arrays.sort(arr2);

        // return new int[][]{arr1, arr2};


        // 2 Pointer with Shell Sort
        int len = arr1.length + arr2.length;

        int gap = (len/2) + (len%2);

        int leftPtr = 0, rightPtr = leftPtr + gap;
        while (true) {
            leftPtr = 0;
            rightPtr = leftPtr + gap;
            while(rightPtr < len) {
                // arr1 & arr2
                if(leftPtr < arr1.length && rightPtr >= arr1.length) {
                    swap(arr1, arr2, leftPtr, rightPtr - arr1.length);
                }
                // arr1 & arr1
                if(rightPtr < arr1.length) {
                    swap(arr1, arr1, leftPtr, rightPtr);
                }
                // arr2 & arr2
                if(leftPtr >= arr1.length) {
                    swap(arr2, arr2, leftPtr - arr1.length, rightPtr - arr1.length);
                }
                leftPtr++;
                rightPtr++;
            }

            if(gap == 1) {
                break;
            }

            gap = (gap/2) + (gap%2);
        }
        return new int[][]{arr1, arr2};
    }

    static void swap(int[] arr1, int[] arr2, int idx1 , int idx2) {
        if(arr1[idx1] > arr2[idx2] ) {
            int temp = arr1[idx1];
            arr1[idx1] = arr2[idx2];
            arr2[idx2] = temp;
        }
    }
}
