package bs.bs_1D.easy;

/*
 * Find out how many times the array has been rotated
 * 
 * Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated. 
 * 
 * Example 1:
Input Format:
 arr = [4,5,6,7,0,1,2,3]
Result:
 4
Explanation:
 The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.

Example 2:
Input Format:
 arr = [3,4,5,1,2]
Result:
 3
Explanation:
 The original array should be [1,2,3,4,5]. So, we can notice that the array has been rotated 3 times.




 

 Optimal Approach(Using Binary Search): 
We are going to use the binary search algorithm to solve this problem.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

In the previous article, find the minimum in a rotated sorted array, we have discussed how to find the minimum element in a rotated and sorted array using Binary search. In this problem, we will employ the same algorithm to determine the index of the minimum element. In the previous problem, we only stored the minimum element itself. However, in this updated approach, we will additionally keep track of the index. By making this small adjustment, we can effectively solve the problem using the existing algorithm.

Algorithm:
The steps are as follows:

To begin, we will declare the variable 'ans' and initialize it with the largest possible value. Additionally, we will have two pointers, 'low' and 'high', as usual. In this case, we will also introduce an 'index' variable and initialize it with -1.

Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index and high will point to the last index.
Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
If arr[low] <= arr[high]: In this case, the array from index low to high is completely sorted. Therefore, we can select the minimum element, arr[low].
Now, if arr[low] < ans, we will update ‘ans’ with the value arr[low] and ‘index’ with the corresponding index low.
Once this is done, there is no need to continue with the binary search algorithm. So, we will break from this step.
Identify the sorted half, and after picking the leftmost element, eliminate that half.
If arr[low] <= arr[mid]:
This condition ensures that the left part is sorted. So, we will pick the leftmost element i.e. arr[low].
Now, if arr[low] < ans, we will update ‘ans’ with the value arr[low] and ‘index’ with the corresponding index low.
After that, we will eliminate this left half(i.e. low = mid+1).
Otherwise, if the right half is sorted:  This condition ensures that the right half is sorted. So, we will pick the leftmost element i.e. arr[mid].
Now, if arr[mid] < ans, we will update ‘ans’ with the value arr[mid] and ‘index’ with the corresponding index mid.
After that, we will eliminate this right half(i.e. high = mid-1).
This process will be inside a loop and the loop will continue until low crosses high. Finally, we will return the ‘index’ variable that stores the index of the minimum element.
 */

public class FindRotateTimes {
    public static int find(int[] arr) {
        return getLowIndex(arr);
    }

    static int getLowIndex(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (
                (mid == 0 && arr[mid] < arr[mid + 1]) || 
                (mid == arr.length  - 1 && arr[mid] < arr[mid - 1]) ||
                (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid+1])
            ) {
                return mid;
            }

            if (arr[mid] > arr[end]) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return 0;
    }
}
