package array.hard;

/*
 * Find the repeating and missing numbers
Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Examples
Example 1:
Input Format
:  array[] = {3,1,2,5,3}
Result
: {3,4)
Explanation
: A = 3 , B = 4 
Since 3 is appearing twice and 4 is missing

Example 2:
Input Format
: array[] = {3,1,2,5,4,6,7,5}
Result
: {5,8)
Explanation
: A = 5 , B = 8 
Since 5 is appearing twice and 8 is missing







Algorithm / Intuition
Optimal Approach 1 (Using Maths): 
Intuition:
The idea is to convert the given problem into mathematical equations. Since we have two variables i.e. missing and repeating, we will try to form two linear equations. And then we will find the values of two variables using those equations.

Assume the repeating number to be X and the missing number to be Y.

In the array, the numbers are between 1 to N, and in that range, one number is missing and one number is occurring twice.

Step 1: Form equation 1:

Now, we know the summation of the first N numbers is:

Sn = (N*(N+1))/2
Let’s say, S = the summation of all the elements in the given array.

Therefore, S - Sn = X - Y…………………equation 1
Step 2: Form equation 2:

Now, we know the summation of squares of the first N numbers is:

S2n = (N*(N+1)*(2N+1))/6
Let’s say, S2 = the summation of squares of all the elements in the given array.

Therefore, S2-S2n = X2-Y2...................equation 2
From equation 2 we can conclude,

X+Y = (S2 - S2n) / (X-Y) [From equation 1, we get the value X-Y] ………… equation 3
From equation 1 and equation 3, we can easily find the value of X and Y. And this is what we want.

Note: Here, we are summing all the numbers and squares of all the numbers, so we should use a bigger data type(Like in C++, long long instead of int).

Approach:
Assume the repeating number to be X and the missing number to be Y.

The steps are as follows:

First, find out the values of S and Sn and then calculate S - Sn (Using the above formulas).
Then, find out the values of S2 and S2n and then calculate S2 - S2n.
After performing steps 1 and 2, we will be having the values of X + Y and X - Y. Now, by substitution of values, we can easily find the values of X and Y.
 */

public class FindRepeatingAndMissingNumbers {
    public static int[] find(int[] arr) {
        int cumSum = 0;
        int cumSqSum = 0;
        int XminusY = 0;
        int XplusY = 0;

        for (int i = 0; i < arr.length; i++) {
            cumSum += (i+1 - arr[i]);
            cumSqSum += (Math.pow(i+1, 2) - Math.pow(arr[i], 2));
        }

        XminusY = cumSum;
        XplusY = cumSqSum/XminusY;
        
        int X = (XplusY + XminusY)/2;
        int Y = XplusY - X;

        return new int[]{Y,X};
    }
}
