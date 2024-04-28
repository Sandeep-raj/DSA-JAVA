package bs.bs_2D.medium;

/*
 * Median of Row Wise Sorted Matrix
 * 
 * Problem Statement: Given a row-wise sorted matrix of size r*c, where r is no. of rows and c is no. of columns, find the median in the given matrix.
 * 
 * Example 1:
Input: 
r = 3 , c = 3
1 4 9 
2 5 6
3 8 7
Output: Median = 5
Explanation: If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9
So, median = 5

Example 2:
Input: 
r = 3 , c = 3
1 3 8
2 3 4
1 2 5
Output: Median = 3
Explanation: If we find the linear sorted array, the array becomes 1 1 2 2 3 3 4 5 7 8
So, median = 3



Efficient Approach (Using Binary Search)

Step 1: Find the minimum and maximum element in the given array. By just traversing the first column, we find the minimum element and by just traversing the last column, we find the maximum element.

Step 2: Now find the middle element of the array one by one and check in the matrix how many elements are present in the matrix.

Three cases can occur:-

If count ==  (r*c+1)/2 , so it may be the answer still we mark max as mid since we are not referring indices , we are referring the elements and 5 elements can be smaller than 6 also and 7 also , so to confirm we mark max as mid.
If count<(r*c+1)/2 , we mark  min as mid+1 since curr element or elements before it cannot be the answer.
If count>(r*c+1)/2 , we mark max as mid , since elements after this can only be the  answer now.
 */

public class RowSortedMedian {
    public static int findMedian(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        int midElems = row*col/2;

        int start = 1, end = 1000000;
        while (start <= end) {
            int mid = (start+end)/2;
            int totSmallerElems = 0;
            for(int i = 0; i < row; i++) {
                totSmallerElems += findElesSmaller(arr[i], mid);
            }

            if(totSmallerElems <= midElems) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return start;
    }

    static int findElesSmaller(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int ans = 0;
        while (start <= end) {
            int mid = (start+end)/2;

            if(arr[mid] <= k) {
                ans = mid+1;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
