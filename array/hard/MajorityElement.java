package array.hard;

/*
 * Majority Elements(&gt;N/3 times) | Find the elements that appears more than N/3 times in the array
 * 
 * Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.

Pre-requisite: Majority Element(>N/2 times)

Examples
Example 1:
Input Format
: N = 5, array[] = {1,2,2,3,2}
Result
: 2
Explanation:
 Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format
:  N = 6, array[] = {11,33,33,11,33,11}
Result:
 11 33
Explanation:
 Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.




 


 Optimal Approach (Extended Boyer Moore’s Voting Algorithm): 
Approach: 
Initialize 4 variables:
cnt1 & cnt2 –  for tracking the counts of elements
el1 & el2 – for storing the majority of elements.
Traverse through the given array.
If cnt1 is 0 and the current element is not el2 then store the current element of the array as el1 along with increasing the cnt1 value by 1.
If cnt2 is 0 and the current element is not el1 then store the current element of the array as el2 along with increasing the cnt2 value by 1.
If the current element and el1 are the same increase the cnt1 by 1.
If the current element and el2 are the same increase the cnt2 by 1.
Other than all the above cases: decrease cnt1 and cnt2 by 1.
The integers present in el1 & el2 should be the result we are expecting. So, using another loop, we will manually check their counts if they are greater than the floor(N/3).
Intuition: If the array contains the majority of elements, their occurrence must be greater than the floor(N/3). Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we try to keep track of the counts of elements and the elements themselves for which we are tracking the counts. 

After traversing the whole array, we will check the elements stored in the variables. Then we need to check if the stored elements are the majority elements or not by manually checking their counts.

Note: This intuition is simply the logic of cancellation i.e. a variation of Moore’s Voting Algorithm that we used in the problem Majority Element (> N/2).

The projection will be the following:


Edge Case: Why we are adding extra checks like el2 != v[i] and el1 != v[i] in the first if statements? Let’s understand it using an example:
Assume the given array is: {2, 1, 1, 3, 1, 4, 5, 6}. Now apply the algorithm without the checks:


We can clearly notice that in iteration 5, el1 and el2 both are set to 1 as cnt1 becomes 0 in iteration 4. But this is incorrect. So, to avoid this edge case, we are checking if the current element is already included in our elements, and if it is, we will not again include it in another variable.
 */

public class MajorityElement {
    public static int majority(int[] arr) {
        int ele1 = -1, ele2 = -1;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cnt1 == 0) {
                ele1 = arr[i];
                cnt1++;
            }else if (cnt2 == 0) {
                ele2 = arr[i];
                cnt2++;
            }

            if(arr[i] == ele1) {
                cnt1++;
            }else if(arr[i] == ele2) {
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }

        if(cnt1 > cnt2) {
            return ele1;
        }else {
            return ele2;
        }
    }
}
