package bitmanipulation.easy;

/*
 * Set The Rightmost Unset Bit
 * 
 * Problem statement
The problem is to find the rightmost bit of a non-negative number 'N' that is currently unset (i.e., has a value of 0) in its binary representation and set it to 1.
Return the number after setting the rightmost unset bit of 'N'. If there are no unset bits in N's binary representation, then the number should remain unchanged.

Example:
N = 5
Output: 7
Explanation: The binary representation of 5 is 101. After setting the rightmost unset bit it becomes 111 which is 7.


Sample Input 1:
10
Sample Output 1:
11
Explanation Of Sample Input 1:
N=10
The binary representation of 10 is 1010. After setting the rightmost unset bit it becomes 1011 which is 11.
Sample Input 2:
7
Sample Output 2:
7
Explanation Of Sample Input 2:
N=7
The binary representation of 7 is 111. As there is no unset bit it remains the same.
Constraints:
1 <= N <= 10^9
Time Limit: 1 sec
 */

public class RightmostUnsetBit {
    public static int setUnset(int n) {
        // int result = n | (n+1);
        // return (result > n*2) ? n : result;


        // find the first zero mask
        int mask = 1;
        while ((n & mask) != 0) {
            mask = mask << 1;
        }

        int result = n | mask;
        return (result > n*2) ? n : result;
        // Uselss solution

        // int result = 0;
        // int x = 0;
        // Boolean isSet = false;

        // while (n > 0) {
        //     int isone = n&1;
        //     if(isone == 0 && !isSet) {
        //         isSet = true;
        //         result += Math.pow(2, x);
        //     }else if (isone == 1) {
        //         result += Math.pow(2, x);
        //     }
        //     n = n >> 1;
        //     x++;
        // }

        // return result;
    }
}
