// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 
Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*/

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        System.out.println(quickSelect(new int[]{3,2,1,5,6,4}, 0, 5, 4));
    }

    static int quickSelect(int[] arr, int left, int right, int idx) {
        int pivot = right;
        int i = left, j = left;

        while(j < right) {
            if(arr[j] < arr[pivot]) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                i++;
            }
            j++;
        }

        int temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;

        if(idx < i) {
            return quickSelect(arr, left, i-1, idx);
        }else if(idx > i) {
            return quickSelect(arr, i+1, right, idx);
        }else {
            return arr[i];
        }
    }
}
