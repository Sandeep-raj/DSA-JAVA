package bitmanipulation.easy;

/*
 * Count total set bits
 * 
 * Problem statement
For a given integer 'N', you have to return the number of set bits in the binary representation of the numbers from 1 to 'N'.



In a binary number '1' is considered as a set bit and '0' as not set.



Example:
If 'N' is 4, then

1 has a binary representation of 1
2 has a binary representation of 10
3 has a binary representation of 11
4 has a binary representation of 100

Hence number of set bits is 5.


Sample Input 1:
 7
Sample Output 1:
  12
Explanation of sample input 1:
1 has a binary representation of 1
2 has a binary representation of 10
3 has a binary representation of 11
4 has a binary representation of 100
5 has a binary representation of 101
6 has a binary representation of 110
7 has a binary representation of 111

Hence number of set bits is 12.
Sample Input 2:
 5
Sample Output 2:
  7
Constraints:
 1 <= N <= 10^9
 */

public class CountSetBits {
    public static int count(int n) {
        if (n == 1) {
            return 1;
        }else if (n == 0) {
            return 0;
        }else if(n == 2){
            return 2;
        }

        int x = highest2Power(n);

        int sumTillPower = (int)Math.pow(2, x-1)* x;
        int sumofOneAfterPower = (n - (int)Math.pow(2, x) + 1);
        return sumTillPower + sumofOneAfterPower + count(n - (int)Math.pow(2, x));
    }

    static int highest2Power(int n) {
        int x = 1;
        int pow = 0;
        while (x <= n) {
            x = x << 1;
            pow++;
        }

        return pow == 0 ? pow : pow - 1;
    }
}
