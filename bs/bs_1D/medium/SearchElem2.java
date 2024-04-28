package bs.bs_1D.medium;

/**
 * Search Element in Rotated Sorted Array II
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False. 
 * 
 * Example 1:
Input Format:
 arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
Result:
 True
Explanation:
 The element 3 is present in the array. So, the answer is True.

Example 2:
Input Format:
 arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 10
Result:
 False
Explanation:
 The element 10 is not present in the array. So, the answer is False.




 Optimal Approach(Using Binary Search): 
Like the previous problem, we will use the Binary Search algorithm to solve this problem.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

In the previous problem, in order to efficiently search for the target value, we followed a simple two-step process. 

First, we identify the sorted half of the array. 
Once found, we determine if the target is located within this sorted half. 
If not, we eliminate that half from further consideration. 
Conversely, if the target does exist in the sorted half, we eliminate the other half.
Let’s observe how we identify the sorted half:

We basically compare arr[mid] with arr[low] and arr[high] in the following way:

If arr[low] <= arr[mid]: In this case, we identified that the left half is sorted.
If arr[mid] <= arr[high]: In this case, we identified that the right half is sorted.
This check was effective in the previous problem, where there were no duplicate numbers. However, in the current problem, the array may contain duplicates. Consequently, the previous approach will not work when arr[low] = arr[mid] = arr[high].

How to handle the edge case arr[low] = arr[mid] = arr[high]:

In the algorithm, we first check if arr[mid] is the target before identifying the sorted half. If arr[mid] is not our target, we encounter this edge case. In this scenario, since arr[mid] = arr[low] = arr[high], it means that neither arr[low] nor arr[high] can be the target. To handle this edge case, we simply remove arr[low] and arr[high] from our search space, without affecting the original algorithm. 

To eliminate elements arr[low] and arr[high], we can achieve this by simply incrementing the low pointer and decrementing the high pointer by one step. We will continue this process until the condition arr[low] = arr[mid] = arr[high] is no longer satisfied.


Note: As long as this condition is met, we will skip the steps of determining the sorted half and eliminating one of the halves based on the target's location. Instead, we will solely focus on eliminating arr[low] and arr[high].

We will apply the same algorithm as the previous problem by just adding an extra check to handle the above edge case.

Algorithm:
The steps are as follows:

Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index, and high will point to the last index.
Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
Check if arr[mid] = target: If it is, return True.
Check if arr[low] = arr[mid] = arr[high]: If this condition is satisfied, we will just increment the low pointer and decrement the high pointer by one step. We will not perform the later steps until this condition is no longer satisfied. So, we will continue to the next iteration from this step.
Identify the sorted half, check where the target is located, and then eliminate one half accordingly:
If arr[low] <= arr[mid]: This condition ensures that the left part is sorted.
If arr[low] <= target && target <= arr[mid]: It signifies that the target is in this sorted half. So, we will eliminate the right half (high = mid-1).
Otherwise, the target does not exist in the sorted half. So, we will eliminate this left half by doing low = mid+1.
Otherwise, if the right half is sorted:
If arr[mid] <= target && target <= arr[high]: It signifies that the target is in this sorted right half. So, we will eliminate the left half (low = mid+1).
Otherwise, the target does not exist in this sorted half. So, we will eliminate this right half by doing high = mid-1.
Once, the ‘mid’ points to the target, we will return True.
This process will be inside a loop and the loop will continue until low crosses high. If no element is found, we will return False.
 */

public class SearchElem2 {
    public static boolean search(int[] arr, int k) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end)/2;

            if(arr[mid] == k ) {
                return true;
            }

            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }

            if(arr[start] <= arr[mid]) {
                if(arr[start] <= k && k < arr[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if( k <= arr[end] && k >= arr[mid]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
