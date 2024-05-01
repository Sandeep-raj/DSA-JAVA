package bitmanipulation.easy;

/*
 * Check whether K-th bit is set or not
 * 
 * Problem statement
Given a number ‘N’ and a number ‘K’. Return true if ‘K’th bit of number is set, else return false.



Example:
Input: ‘N’ = 5, ‘K’ = 1

Output: YES

5 in binary can be written as 101 and as we can see a first bit from the right of 5 is set so the answer is 'YES'.

Sample Input 1 :
3 2
Sample Output 1 :
YES
Explanation Of Sample Input 1 :
3 in binary can be represented as 11 and 2 bit from right is set there, So answer is 'YES'.
Sample Input 2 :
128 7
Sample Output 2 :
NO
Constraints :
1 <= N <= 10^9
1 <= K <= 20

Time Limit: 1 sec
 */

public class CheckKBitSet {
    public static Boolean check(int n, int k) {
        int mask = (1 << (k-1));
        int isavail = n&mask;

        return isavail==mask?true:false;
    }
}
