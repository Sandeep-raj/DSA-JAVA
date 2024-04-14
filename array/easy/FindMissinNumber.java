package array.easy;

/*
 * Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

Examples
Example 1:
Input Format:
 N = 5, array[] = {1,2,4,5}
Result:
 3
Explanation: 
In the given array, number 3 is missing. So, 3 is the answer.

Example 2:
Input Format:
 N = 3, array[] = {1,3}
Result:
 2
Explanation: 
In the given array, number 2 is missing. So, 2 is the answer.


Summation Approach:
Intuition:
We know that the summation of the first N numbers is (N*(N+1))/2. We can say this S1. Now, in the given array, every number between 1 to N except one number is present. So, if we add the numbers of the array (say S2), the difference between S1 and S2 will be the missing number. Because, while adding all the numbers of the array, we did not add that particular number that is missing.

Sum of first N numbers(S1) = (N*(N+1))/2
Sum of all array elements(S2) = i = 0n-2a[i]
The missing number = S1-S2
Approach:
The steps are as follows:

We will first calculate the summation of first N natural numbers(i.e. 1 to N) using the specified formula.
Then we will add all the array elements using a loop.
Finally, we will consider the difference between the summation of the first N natural numbers and the sum of the array elements.
Dry run:

Assume the given array is: {1, 2, 4, 5} and N = 5.
Summation of 1 to 5 = (5*(5+1))/2 = 15
Summation of array elements = 12
So, the difference will be = 15 - 12 = 3. 
And the missing number is also 3.



XOR Approach:
Intuition:
Two important properties of XOR are the following:

XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

Now, let’s XOR all the numbers between 1 to N.
xor1 = 1^2^.......^N

Let’s XOR all the numbers in the given array.
xor2 = 1^2^......^N (contains all the numbers except the missing one).

Now, if we again perform XOR between xor1 and xor2, we will get:
xor1 ^ xor2 = (1^1)^(2^2)^........^(missing Number)^.....^(N^N)

Here all the numbers except the missing number will form a pair and each pair will result in 0 according to the XOR property. The result will be = 0 ^ (missing number) = missing number (according to property 2).

So, if we perform the XOR of the numbers 1 to N with the XOR of the array elements, we will be left with the missing number.

Approach:
The steps are as follows:

We will first run a loop(say i) from 0 to N-2(as the length of the array = N-1).
Inside the loop, xor2 variable will calculate the XOR of array elements
i.e. xor2 = xor2 ^ a[i].
And the xor1 variable will calculate the XOR of 1 to N-1 i.e. xor1 = xor1 ^ (i+1).
After the loop ends we will XOR xor1 and N to get the total XOR of 1 to N.
Finally, the answer will be the XOR of xor1 and xor2.

 */

public class FindMissinNumber {
    public static int find(int[] arr) {
        // Summation Approach
        // int sum = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     sum += arr[i];
        // }

        // int totSum = (arr.length + 1) * (arr.length + 2)/2;

        // return totSum - sum;

        // XOR Approach
        int totSum = 1;
        int currSum = 0;
        for (int i  =1; i <= arr.length; i++) {
            totSum ^= i+1;
            currSum ^= arr[i-1];
        }

        return totSum^currSum;
    }
}
