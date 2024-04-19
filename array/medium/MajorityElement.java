package array.medium;

import java.util.HashMap;

/*
 * Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

Examples
Example 1:
Input Format
: N = 3, nums[] = {3,2,3}
Result
: 3
Explanation
: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

Example 2:
Input Format:
  N = 7, nums[] = {2,2,1,1,1,2,2}

Result
: 2

Explanation
: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Example 3:
Input Format:
  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

Result
: 4



Solution 2 (Better):
Intuition:
Use a better data structure to reduce the number of look-up operations and hence the time complexity. Moreover, we have been calculating the count of the same element again and again - so we have to reduce that also.

Approach: 
Use a hashmap and store as (key, value) pairs. (Can also use frequency array based on the size of nums) 
Here the key will be the element of the array and the value will be the number of times it occurs. 
Traverse the array and update the value of the key. Simultaneously check if the value is greater than the floor of N/2. 
If yes, return the key 
Else iterate forward.



Optimal Approach: Moore’s Voting Algorithm:
Intuition:
If the array contains a majority element, its occurrence must be greater than the floor(N/2). Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we try to keep track of the count of elements and the element itself for which we are tracking the count. 

After traversing the whole array, we will check the element stored in the variable. If the question states that the array must contain a majority element, the stored element will be that one but if the question does not state so, then we need to check if the stored element is the majority element or not. If not, then the array does not contain any majority element.

Approach: 
Initialize 2 variables:
Count –  for tracking the count of element
Element – for which element we are counting
Traverse through the given array.
If Count is 0 then store the current element of the array as Element.
If the current element and Element are the same increase the Count by 1.
If they are different decrease the Count by 1.
The integer present in Element should be the result we are expecting 

 */

public class MajorityElement {
    public static int find(int[] arr) {
        // Hashing Algorithm
        // int k = arr.length/2;
        // HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        // for (int i = 0; i < arr.length; i++) {
        //     if (map.containsKey(arr[i])) {
        //         int currVal = map.get(arr[i]) + 1;
        //         if(currVal > k) {
        //             return arr[i];
        //         }

        //         map.put(arr[i], currVal);
        //     }else {
        //         map.put(arr[i], 1);
        //     }
        // }
        // return 0;

        // Morre's Voting Algorithm
        int element = 0, count =0;
        for (int i =0; i < arr.length; i++) {
            if (count == 0) {
                element = arr[i];
                count++;
            }else if(arr[i] == element) {
                count++;
            }else {
                count--;
            }
        }

        return element;
    }
}
