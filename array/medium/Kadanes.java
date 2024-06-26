package array.medium;

/*
 *  Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Examples
Example 1:
Input:
 arr = [-2,1,-3,4,-1,2,1,-5,4] 

Output:
 6 

Explanation:
 [4,-1,2,1] has the largest sum = 6. 

Examples 2:
Input:
 arr = [1] 

Output:
 1 

Explanation:
 Array has only one element and which is giving positive sum of 1. 



 Algorithm / Intuition
Intuition:
The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0. A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.

Here, we will iterate the given array with a single loop and while iterating we will add the elements in a sum variable. Now, if at any point the sum becomes less than 0, we will set the sum as 0 as we are not going to consider any subarray with a negative sum. Among all the sums calculated, we will consider the maximum one.

Thus we can solve this problem with a single loop.

Approach:
The steps are as follows:

We will run a loop(say i) to iterate the given array.
Now, while iterating we will add the elements to the sum variable and consider the maximum one.
If at any point the sum becomes negative we will set the sum to 0 as we are not going to consider it as a part of our answer.
Note: In some cases, the question might say to consider the sum of the empty subarray while solving this problem. So, in these cases, before returning the answer we will compare the maximum subarray sum calculated with 0(i.e. The sum of an empty subarray is 0). And after that, we will return the maximum one.
For e.g. if the given array is {-1, -4, -5}, the answer will be 0 instead of -1 in this case. 
 */

public class Kadanes {
    public static int maxVal(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int[] subArr = new int[]{-1,-1};

        for (int i =0; i < arr.length; i++){
            currSum += arr[i];
            if(subArr[0] == -1) {
                subArr[0] = i;
            }

            maxSum = Math.max(maxSum, currSum);
            if (maxSum == currSum) {
                subArr[1] = i;
            }
            if (currSum < 0){
                currSum =0;
                subArr[0] = -1;
                subArr[1] = -1;
            }
        }

        System.out.println(subArr[0] + " | " + subArr[1]);
        return maxSum;
    }
}
