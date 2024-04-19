package array.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Examples
Example 1:
Input:
 [100, 200, 1, 3, 2, 4]

Output:
 4

Explanation:
 The longest consecutive subsequence is 1, 2, 3, and 4.

Input:
 [3, 8, 5, 7, 6]

Output:
 4

Explanation:
 The longest consecutive subsequence is 5, 6, 7, and 8.

 Algorithm / Intuition
Optimal Approach(Using Set data structure): 
We will adopt a similar approach to the brute-force method but with optimizations in the search process. Instead of searching sequences for every array element as in the brute-force approach, we will focus solely on finding sequences only for those numbers that can be the starting numbers of the sequences. This targeted approach narrows down our search and improves efficiency.

We will do this with the help of the Set data structure.

How to identify if a number can be the starting number for a sequence:

First, we will put all the array elements into the set data structure.
If a number, num, is a starting number, ideally, num-1 should not exist. So, for every element, x, in the set, we will check if x-1 exists inside the set. :
If x-1 exists: This means x cannot be a starting number and we will move on to the next element in the set.
If x-1 does not exist: This means x is a starting number of a sequence. So, for number, x, we will start finding the consecutive elements.
How to search for consecutive elements for a number, x:

Instead of using linear search, we will use the set data structure itself to search for the elements x+1, x+2, x+3, and so on.
Thus, using this method we can narrow down the search and optimize the approach.

Algorithm:
We will declare 2 variables, 

‘cnt’ → (to store the length of the current sequence), 
‘longest’ → (to store the maximum length).
First, we will put all the array elements into the set data structure.
For every element, x, that can be a starting number(i.e. x-1 does not exist in the set) we will do the following:
We will set the length of the current sequence(cnt) to 1.
Then, again using the set, we will search for the consecutive elements such as x+1, x+2, and so on, and find the maximum possible length of the current sequence. This length will be stored in the variable ‘cnt’.
After that, we will compare ‘cnt’ and ‘longest’ and update the variable ‘longest’ with the maximum value (i.e. longest = max(longest, cnt)).
Finally, we will have the answer i.e. ‘longest’.
 */

public class LongestConsecutive {
    public static int longestConsecutive(int[] arr) {
        // sort 

        // Arrays.sort(arr);
        // int result = -1;
        // int maxLen = 0;
        // for (int i = 1; i < arr.length; i++) {
        //     maxLen++;
        //     result = Math.max(maxLen, result);
        //     if(arr[i] - arr[i-1] != 1) {
        //         maxLen = 0;
        //     }
        // }

        // return result;


        // set

        Set<Integer> set = new HashSet<Integer>();

        // save the ele to set
        for(int i =0; i < arr.length; i++){
            set.add(arr[i]);
        }

        // find maxlen
        int result = 0;
        int currLen = 0;
        for (int i = 0 ; i < arr.length; i++) {
            // check arr[i] is starting
            if (!set.contains(arr[i] - 1)) {
                int elem = arr[i];
                currLen = 1;
                while (set.contains(elem + 1)) {
                    currLen++;
                    elem++;
                }
                result = Math.max(currLen, result);
            }
        }

        return result;
    }
}
