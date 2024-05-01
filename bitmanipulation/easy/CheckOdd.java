package bitmanipulation.easy;

/*
 * Odd Even
 * 
 * Problem statement
You are given an integer 'N'.
Return 'odd' if the given number 'N' is odd, else return 'even'.
For Example:
N=5

Output: odd


Sample Input 1:
9
Sample Output 1:
odd
Sample Input 2:
6
Sample Output 2:
even
Constraints:
1 <= N <= 10^4
Time Limit: 1 sec
 */

public class CheckOdd {
    public static String isOddEven(int n) {
        int isOdd = n&1;
        return isOdd == 1 ? "ODD" : "EVEN";
    }
}
