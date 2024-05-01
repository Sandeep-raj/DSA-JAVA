package bitmanipulation.medium;

/*
 * L to R XOR
 * 
 * Problem statement
You are given two numbers 'L' and 'R'.

Find the XOR of the elements in the range [L, R].
For Example:
For 'L' = 1 and ‘R’ = 5.
The answer is 1.


Sample Input 1:
3 5
Sample Output 1:
2
Explanation of sample output 1:
'L' = 3 and ‘R’ = 5
Answer is 2. Value of 3^4^5 is 2.
Sample Input 2:
1 3
Sample Output 2:
0
Constraints:
1 <= ‘L’ <= ‘R’ <= 10^9
Time Limit: 1 sec
 */

public class LtoRXOR {
    public static int ltor(int l, int r) {

        // Simple Loop (O(n))
        // int ans = 0;
        // for(int i = l; i <= r; i++) {
        //     ans ^= i;
        // }

        // return ans;


        // Optimal Approach (Pattern) (O(1))
        return xortoN(l-1)^xortoN(r);
    }

    static int xortoN(int n) {
        /*
         * Pattern 
         * 1 -> 1
         * 2 -> n + 1
         * 3 -> 0
         * 4 -> n
         */
        if(n%4 == 1) {
            return 1;
        }else if(n%4 == 2) {
            return n+1;
        }else if(n%4 == 3) {
            return 0;
        }else {
            return n;
        }
    }
}
