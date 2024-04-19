package array.medium;

import java.util.ArrayList;

/*
 * There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.

Note: Start the array with positive elements.

Examples: 

Example 1:

Input:
arr[] = {1,2,-4,-5}, N = 4
Output:
1 -4 2 -5

Explanation: 

Positive elements = 1,2
Negative elements = -4,-5
To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.

Example 2:
Input:
arr[] = {1,2,-3,-1,-2,-3}, N = 6
Output:
1 -3 2 -1 3 -2
Explanation: 

Positive elements = 1,2,3
Negative elements = -3,-1,-2
To maintain relative ordering, 1 must occur before 2, and 2 must occur before 3.
Also, -3 should come before -1, and -1 should come before -2.

Optimal Method

Approach:

In this optimal approach, we will try to solve the problem in a single pass and try to arrange the array elements in the correct order in that pass only.
We know that the resultant array must start from a positive element so we initialize the positive index as 0 and negative index as 1 and start traversing the array such that whenever we see the first positive element, it occupies the space at 0 and then posIndex increases by 2 (alternate places).
Similarly, when we encounter the first negative element, it occupies the position at index 1, and then each time we find a negative number, we put it on the negIndex and it increments by 2.
When both the negIndex and posIndex exceed the size of the array, we see that the whole array is now rearranged alternatively according to the sign.




Variety-2
Problem Statement:
There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal). Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover elements should be placed at the very end in the same order as in array A.

Example 1:

Input:
arr[] = {1,2,-4,-5,3,4}, N = 6
Output:
1 -4 2 -5 3 4

Explanation: 

Positive elements = 1,2
Negative elements = -4,-5
To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.
Leftover positive elements are 3 and 4 which are then placed at the end of the array.

Example 2:
Input:
arr[] = {1,2,-3,-1,-2,-3}, N = 6
Output:
1 -3 2 -1 3 -2
Explanation: 

Positive elements = 1,2
Negative elements = -3,-1,-2,-4
To maintain relative ordering, 1 must occur before 2.
Also, -3 should come before -1, and -1 should come before -2.
After alternate ordering, -2 and -4 are left, which would be placed at the end of the ans array.

Intuition:
In this variety, the number of positive and negative numbers shall not necessarily be equal to each other in the given array. So, there can be two cases possible: either the positive elements exceed the negatives or the negatives exceed the positives. So, instead of using the optimal solution discussed for the variety-1 above, we’ll fall back to the brute force solution where we create separate arrays for storing positives and negatives and then put them back into the array alternatively. The remaining negative or positive elements are added to the array at last.

Approach:

In this problem, first, we create a neg array and a pos array for storing all the negative and positive elements of array A separately.
Now, similar to the Brute force approach for variety-1, we start putting elements of pos and neg array alternatively back into array A.
Since the array must begin with a positive number and the start index is 0, so all the positive numbers would be placed at even indices (2*i) and negatives at the odd indices (2*i+1), where i is the index of the pos or neg array while traversing them simultaneously.
After all the elements are added to the index where positives were equal to the negatives, we now put all the remaining elements ( whether positive or negative) at the last of the array by running a single loop from pos.size() to neg.size() {if positives < negatives} or neg.size() to pos.size() {if negatives < positives}.
 */

public class RearrangeArrayBySign {
    public static int[] rearrange(int[] arr) {
        // variant 1

        // int[] result = new int[arr.length];
        // int evenPos = 0;
        // int oddPos = 1;
        // for (int i = 0; i < arr.length; i++) {
        //     if(arr[i] > 0) {
        //         result[evenPos] = arr[i];
        //         evenPos += 2;
        //     }else {
        //         result[oddPos] = arr[i];
        //         oddPos += 2;
        //     }
        // }

        // return result;


        // variant 2
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                pos.add(arr[i]);
            }else {
                neg.add(arr[i]);
            }
        }

        int i = 0, j = 0,cnt = 0;
        while (i < pos.size() && j < neg.size()) {
            if(cnt %2 == 0) {
                result[cnt] = pos.get(i);
                i++;
                cnt++;
            }else {
                result[cnt] = neg.get(j);
                j++;
                cnt++;
            }
        }

        while (i < pos.size()) {
            result[cnt] = pos.get(i);
            i++;
            cnt++;
        }

        while (j < neg.size()) {
            result[cnt] = neg.get(j);
            j++;
            cnt++;
        }

        return result;
    }
}
