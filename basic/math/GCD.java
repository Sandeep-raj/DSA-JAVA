package basic.math;

/*
 * Problem Statement: Find the gcd of two numbers.

Examples
Example 1:
Input:
 num1 = 4, num2 = 8
Output:
 4
Explanation:
 Since 4 is the greatest number which divides both num1 and num2.

Example 2:
Input:
 num1 = 3, num2 = 6
Output:
 3
Explanation:
 Since 3 is the greatest number which divides both num1 and num2.



Using Euclidean’s theorem.
Intuition: Gcd is the greatest number which is divided by both a and b.If a number is divided by both a and b, it is should be divided by (a-b) and b as well.

Approach:
Recursively call gcd(b,a%b) function till the base condition is hit.
b==0 is the base condition.When base condition is hit return a,as gcd(a,0) is equal to a.
 */

public class GCD {
    public static int find(int num1, int num2) {
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int temp = num1;
        int cnt = 1;
        while(temp > 0) {
            if (num1 % temp == 0 && num2 % temp == 0) {
                break;
            }

            temp = num1/(++cnt);
        }

        return  temp;
    }


    public static int find_opti(int num1, int num2) {

        if (num1 < num2 ) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num2 == 0) {
            return num1;
        }

        int remainder = num1%num2;

        return find_opti(num2, remainder);
    }
}
