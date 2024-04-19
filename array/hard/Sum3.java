package array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * 3 Sum : Find triplets that add up to a zero

Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

Pre-requisite: 2 Sum Problem

Examples
Example 1:
Input:
 nums = [-1,0,1,2,-1,-4]

Output:
 [[-1,-1,2],[-1,0,1]]

Explanation:
 Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k

Example 2:
Input:
 nums=[-1,0,1,0]
Output:
 Output: [[-1,0,1],[-1,1,0]]
Explanation:
 Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k




 
 Algorithm / Intuition
In this approach, we intend to get rid of two things i.e. the HashSet we were using for the look-up operation and the set data structure used to store the unique triplets.

So, We will first sort the array. Then, we will fix a pointer i, and the rest 2 pointers j and k will be moving. 

Now, we need to first understand what the HashSet and the set were doing to make our algorithm work without them. So, the set data structure was basically storing the unique triplets in sorted order and the HashSet was used to search for the third element.

That is why, we will first sort the entire array, and then to get the unique triplets, we will simply skip the duplicate numbers while moving the pointers.

How to skip duplicate numbers:
As the entire array is sorted, the duplicate numbers will be in consecutive places. So, while moving a pointer, we will check the current element and the adjacent element. Until they become different, we will move the pointer by 1 place. We will follow this process for all 3 pointers. Thus, we can easily skip the duplicate elements while moving the pointers.

Now, we can also remove the HashSet as we have two moving pointers i.e. j and k that will find the appropriate value of arr[j] and arr[k]. So, we do not need that HashSet anymore for the look-up operations.

The process will look like the following:


Among the 3 pointers, 1 will be fixed and 2 will be moving. In each iteration, we will check if the sum i.e.arr[i]+arr[j]+arr[k] is equal to the target i.e. 0. 

If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k--). 
If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++). 
If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k], into our answer and move the pointers j and k skipping the duplicate elements.
Approach:
The steps are as follows:

First, we will sort the entire array.
We will use a loop(say i) that will run from 0 to n-1. This i will represent the fixed pointer. In each iteration, this value will be fixed for all different values of the rest of the 2 pointers. Inside the loop, we will first check if the current and the previous element is the same and if it is we will do nothing and continue to the next value of i.
After that, there will be 2 moving pointers i.e. j(starts from i+1) and k(starts from the last index). The pointer j will move forward and the pointer k will move backward until they cross each other while the value of i will be fixed.
Now we will check the sum i.e. arr[i]+arr[j]+arr[k].
If the sum is greater, then we need lesser elements and so we will decrease the value of k(i.e. k--). 
If the sum is lesser than the target, we need a bigger value and so we will increase the value of j (i.e. j++). 
If the sum is equal to the target, we will simply insert the triplet i.e. arr[i], arr[j], arr[k] into our answer and move the pointers j and k skipping the duplicate elements(i.e. by checking the adjacent elements while moving the pointers).
Finally, we will have a list of unique triplets.
 */

public class Sum3 {
    public static String find(int[] arr) {
        // Using Hashing

        // HashMap<Integer,int[]> map = new HashMap<Integer,int[]>();
        // ArrayList<int[]> result = new ArrayList<int[]>();

        // for (int i =0; i < arr.length; i++) {
        // if(map.containsKey(-1*arr[i])) {
        // int[] sumArr = map.get(-1*arr[i]);
        // if(sumArr[0] != i && sumArr[1] != i) {
        // result.add(new int[]{sumArr[0],sumArr[1], i});
        // }
        // }

        // for (int j = i+1; j < arr.length; j++ ) {
        // map.put(arr[i] + arr[j], new int[]{i,j});
        // }
        // }

        // return result.stream()
        // .mapMulti((intArr, consumer) -> consumer.accept(intArr))
        // .toArray(int[][]::new);

        // Using 2 pointer after sort

        Arrays.sort(arr);
        int i = 0, j = 1, k = arr.length - 1;
        int currSum = 0;
        HashSet<String> set = new HashSet<String>();

        while (i < arr.length - 2) {
            j = i + 1;
            k = arr.length - 1;
            while (j < k) {
                currSum = arr[i] + arr[j] + arr[k];
                if (currSum < 0) {
                    j++;
                } else if (currSum > 0) {
                    k--;
                } else {
                    String data = "[ " + arr[i] + ", " + arr[j] + ", " + arr[k] + " ]";
                    if (!set.contains(data)) {
                        set.add(data);
                    }
                    j++;
                    k--;
                }
            }
            i++;
        }

        return set.toString();
    }
}
