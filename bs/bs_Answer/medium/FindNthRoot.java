package bs.bs_Answer.medium;

/*
 * Nth Root of a Number using Binary Search
 * 
 * Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.
 * 
 * Example 1:
Input Format:
 N = 3, M = 27
Result:
 3
Explanation:
 The cube root of 27 is equal to 3.

Example 2:
Input Format:
 N = 4, M = 69
Result:
 -1
Explanation:
 The 4th root of 69 does not exist. So, the answer is -1.





 Algorithm / Intuition
Optimal Approach(Using Binary Search): 
We are going to use the Binary Search algorithm to optimize the approach.

The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

Now, we are not given any sorted array on which we can apply binary search. But, if we observe closely, we can notice that our answer space i.e. [1, n] is sorted. So, we will apply binary search on the answer space.

Edge case: How to eliminate the halves:

Our first approach should be the following:

After placing low at 1 and high m, we will calculate the value of ‘mid’.
Now, based on the value of ‘mid’ raised to the power n, we will check if ‘mid’ can be our answer, and based on this value we will also eliminate the halves. If the value is smaller than m, we will eliminate the left half and if greater we will eliminate the right half.
But, if the given numbers m and n are big enough, we cannot store the value midn in a variable. So to resolve this problem, we will implement a function like the following:

func(n, m, mid):

We will first declare a variable ‘ans’ to store the value midn.
Now, we will run a loop for n times to multiply the ‘mid’ n times with ‘ans’. 
Inside the loop, if at any point ‘ans’ becomes greater than m, we will return 2.
Once the loop is completed, if the ‘ans’ is equal to m, we will return 1.
If the value is smaller, we will return 0.
Now, based on the output of the above function, we will check if ‘mid’ is our possible answer or we will eliminate the halves. Thus we can avoid the integer overflow case.

Algorithm:

Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to m.
Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
Eliminate the halves accordingly: 
If func(n, m, mid) == 1: On satisfying this condition, we can conclude that the number ‘mid’ is our answer. So, we will return to ‘mid’.
If func(n, m, mid) == 0: On satisfying this condition, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
If func(n, m, mid) == 2: the value mid is larger than the number we want. This means the numbers greater than ‘mid’ will not be our answers and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
Finally,  if we are outside the loop, this means no answer exists. So, we will return -1.
The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.
 */

public class FindNthRoot {
    public static int find(int n, int k) {
        int start = 0, end = n;
        while (start <= end) {
            int mid = (start + end)/2;
            
            if(Math.pow(mid, k) == n) {
                return mid;
            }


            if(Math.pow(mid, k) >= n) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return start;
    }
}
