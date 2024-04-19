package array.hard;

/*
 * Maximum Product Subarray in an Array
Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.

Examples
Example 1:
Input:

 Nums = [1,2,3,4,5,0]
Output:

 120
Explanation:

 In the given array, we can see 1×2×3×4×5 gives maximum product value.


Example 2:
Input:
 Nums = [1,2,-3,0,-4,-5]
Output:

 20
Explanation:

 In the given array, we can see (-4)×(-5) gives maximum product value.





 Algorithm / Intuition
We will optimize the solution through some observations.

Observations:

If the given array only contains positive numbers: If this is the case, we can confidently say that the maximum product subarray will be the entire array itself.
If the given also array contains an even number of negative numbers: As we know, an even number of negative numbers always results in a positive number. So, also, in this case, the answer will be the entire array itself.
If the given array also contains an odd number of negative numbers: Now, an odd number of negative numbers when multiplied result in a negative number. Removal of 1 negative number out of the odd number of negative numbers will leave us with an even number of negatives. Hence the idea is to remove 1 negative number from the result. Now we need to decide which 1 negative number to remove such that the remaining subarray yields the maximum product.

For example, the given array is: {3, 2, -1, 4, -6, 3, -2, 6}
We will try to remove each possible negative number and check in which case the subarray yields the maximum product.


Upon observation, we notice that each chosen negative number divides the array into two parts.
The answer will either be the prefix or the suffix of that negative number.
To find the answer, we will check all possible prefix subarrays (starting from index 0) and all possible suffix subarrays (starting from index n-1).
The maximum product obtained from these prefix and suffix subarrays will be our final answer.
If the array contains 0’s as well: We should never consider 0’s in our answer(as considering 0 will always result in 0) and we want to obtain the maximum possible product. So, we will divide the given array based on the location of the 0’s and apply the logic of case 3 for each subarray.

For example, the given array is: {-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4}.
In this case, we will divide the array into 3 different subarrays based on the 0’s locations. So, the subarrays will be {-2, 3, 4, -1}, {-2, 3, 1, 4}, and {4, 6, -1, 4}.
In these 3 subarrays, we will apply the logic discussed in case 3. We will get 3 different answers for 3 different subarrays.
The maximum one among those 3 answers will be the final answer.
Summary: In real-life problems, we will not separate out the cases as we did in the observations. Instead, we can directly apply the logic discussed in the 4th observation to any given subarray, and it will automatically handle all the other cases.

Algorithm: 
We will first declare 2 variables i.e. ‘pre’(stores the product of the prefix subarray) and ‘suff’(stores the product of the suffix subarray). They both will be initialized with 1(as we want to store the product).
Now, we will use a loop(say i) that will run from 0 to n-1.
We have to check 2 cases to handle the presence of 0:
If pre = 0: This means the previous element was 0. So, we will consider the current element as a part of the new subarray. So, we will set ‘pre’ to 1.
If suff = 0: This means the previous element was 0 in the suffix. So, we will consider the current element as a part of the new suffix subarray. So, we will set ‘suff’ to 1.
Next, we will multiply the elements from the starting index with ‘pre’ and the elements from the end with ‘suff’. To incorporate both cases inside a single loop, we will do the following:
We will multiply arr[i] with ‘pre’ i.e. pre *= arr[i].
We will multiply arr[n-i-1] with ‘suff’ i.e. suff *= arr[n-i-1].
After each iteration, we will consider the maximum among the previous answer, ‘pre’ and ‘suff’ i.e. max(previous_answer, pre, suff).
Finally, we will return the maximum product.
 */

public class MaximumProductSubArray {
    public static int max(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        int prefixProduct = 1, suffixProduct = 1;

        for(int i = 0; i < arr.length ; i++) {
           if(prefixProduct == 0) {
            prefixProduct = 1;
           }

           if(suffixProduct == 0) {
            suffixProduct = 1;
           }
           prefixProduct *= arr[i];
           suffixProduct *= arr[arr.length-1-i];

           maxProduct =  Math.max(maxProduct , prefixProduct);
           maxProduct =  Math.max(maxProduct , suffixProduct);
        }
        return maxProduct;
    }
}
