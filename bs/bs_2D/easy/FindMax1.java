package bs.bs_2D.easy;

/*
 * Find the row with maximum number of 1's
 * 
 * Problem Statement: You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
Your task is to find the index of the row with the maximum number of ones.
Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 zero, return -1.


Example 1:
Input Format:
 n = 3, m = 3, 
mat[] = 
1 1 1
0 0 1
0 0 0
Result:
 0
Explanation:
 The row with the maximum number of ones is 0 (0 - indexed).

Example 2:
Input Format:
 n = 2, m = 2 , 
mat[] = 
0 0
0 0
Result:
 -1
Explanation:
  The matrix does not contain any 1. So, -1 is the answer.


  

  Algorithm / Intuition
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

We cannot optimize the row traversal but we can optimize the counting of 1’s for each row.

Instead of counting the number of 1’s, we can use the following formula to calculate the number of 1’s:
Number_of_ones = m(number of columns) - first occurrence of 1(0-based index).

As, each row is sorted, we can find the first occurrence of 1 in each row using any of the following approaches:

lowerBound(1) (ref: Implement Lower Bound)
upperBound(0) (ref: Implement Upper Bound)
firstOccurrence(1) (ref: First and Last Occurrences in Array)
Note: Here, we are going to use the lowerBound() function to find the first occurrence. You can use the other methods as well.

Algorithm:

First, we will declare 2 variables i.e. cnt_max(initialized with 0), and index(initialized with -1). The first variable will store the maximum number of 1’s we have got and ‘index’ will store the row number.
Next, we will start traversing the rows. We will use a loop(say i) to select each row at a time.
Now, for each row i, we will use lowerBound() to get the first occurrence of 1. Now, using the following formula we will calculate the number of 1’s:
Number_of_ones = m(number of columns) - lowerBound(1)(0-based index).
After that, we will compare it with cnt_max and if the current number of 1’s is greater, we will update cnt_max with the current no. of 1’s and ‘index’ with the current row index.
Finally, we will return the variable ‘index’. It will store the index of the row with the maximum no. of 1’s. And if the matrix does not contain any 1, it stores -1.

 */

public class FindMax1 {
    public static int max(int[][] arr) {
        int ans = -1;
        for(int i = 0; i < arr.length; i++) {
            int idx1 = getIdx(arr[i]);
            if(idx1 != -1) {
                ans = Math.max(ans, arr[0].length - idx1);
            }
        }

        return ans;
    }

    static int getIdx(int[] arr) {
        int start = 0, end = arr.length - 1;
        int ans  = -1;
        while (start <= end) {
            int mid = (start+end)/2;

            if(arr[mid] == 0) {
                start = mid + 1;
            }else {
                if(arr[mid] == 1) {
                    ans = mid;
                }
                end = mid - 1;
            }
        }

        return ans;
    }
}
