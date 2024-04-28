package bs.bs_2D.medium;

/*
 * Search in a sorted 2D matrix
 * 
 * Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists). You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.
 * 
 * Example 1:
Input Format:
 N = 3, M = 4, target = 8,
mat[] = 
1 2 3 4
5 6 7 8 
9 10 11 12
Result:
 true
Explanation:
 The ‘target’  = 8 exists in the 'mat' at index (1, 3).

Example 2:
Input Format:
 N = 3, M = 3, target = 78,
mat[] = 
1 2 4
6 7 8 
9 10 34
Result:
 false
Explanation:
 The ‘target' = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'.




 Algorithm / Intuition
If we flatten the given 2D matrix to a 1D array, the 1D array will also be sorted. By utilizing binary search on this sorted 1D array to locate the 'target' element, we can further decrease the time complexity. The flattening will be like the following:


But if we really try to flatten the 2D matrix, it will take O(N x M) time complexity and extra space to store the 1D array. In that case, it will not be the optimal solution anymore.

How to apply binary search on the 1D array without actually flattening the 2D matrix:

If we can figure out how to convert the index of the 1D array into the corresponding cell number in the 2D matrix, our task will be complete. In this scenario, we will use the binary search with the indices of the imaginary 1D array, ranging from 0 to (NxM)-1(total no. of elements in the 1D array = NxM). When comparing elements, we will convert the index to the cell number and retrieve the element. Thus we can apply binary search in the imaginary 1D array.

How to convert 1D array index to the corresponding cell of the 2D matrix:

We will use the following formula:

If index = i, and no. of columns in the matrix = m, the index i corresponds to the cell with
row = i / m and col = i % m. More formally, the cell is (i / m, i % m)(0-based indexing).


The range of the indices of the imaginary 1D array is [0, (NxM)-1] and in this range, we will apply binary search.

Algorithm:

Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 0 and the high will point to (NxM)-1.
Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
Eliminate the halves based on the element at index mid: To get the element, we will convert index ‘mid’ to the corresponding cell using the above formula. Here no. of columns of the matrix = M.
row = mid / M, col = mid % M.
If matrix[row][col] == target: We should return true here, as we have found the ‘target’.
If matrix[row][col] < target: In this case, we need bigger elements. So, we will eliminate the left half and consider the right half (low = mid+1).
If matrix[row][col] > target: In this case, we need smaller elements. So, we will eliminate the right half and consider the left half (high = mid-1).
Steps 2-3 will be inside a while loop and the loop will end once low crosses high
(i.e. low > high). If we are out of the loop, we can say the target does not exist in the matrix. So, we will return false.
 */

public class SearchSorted2D {
    public static boolean search(int[][] arr, int k) {

        // make bs to find row and bs over row to find element
        // int start = 0, end = arr.length - 1;
        // int ans = 0;
        // while (start <= end) {
        //     int mid  = (start+end)/2;
        //     if(arr[mid][0] <= k) {
        //         ans = mid;
        //         start = mid + 1;
        //     }else {
        //         end = mid - 1;
        //     }
        // }


        // start = 0; 
        // end = arr[0].length-1;

        // while (start <= end) {
        //     int mid = (start+end)/2;

        //     if(arr[ans][mid] == k) {
        //         return true;
        //     }

        //     if(arr[ans][mid] < k) {
        //         start = mid + 1;
        //     }else {
        //         end = mid - 1;
        //     }
        // }

        // return false;

        // make bs search over complete 2d array by flattening
        int start = 0, end = arr.length*arr[0].length;
        int col = arr[0].length;

        while (start <= end) {
            int mid = (start+end)/2;

            int i = mid/col;
            int j = mid%col;

            if(arr[i][j] == k) {
                return true;
            }

            if(arr[i][j] < k) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }
}
