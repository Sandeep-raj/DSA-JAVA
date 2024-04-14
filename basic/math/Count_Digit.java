package basic.math;

/*
 * Problem Statement: Given an integer N, write a program to count the number of digits in N.
 * 
 Example 1:
Input:
 N = 12345
Output
: 5
Explanation:
 N has 5 digits

Example 2:
Input:
 N = 8394
Output
: 4
Explanation:
 N has 4 digits


 Algorithm / Intuition
Use logarithm base 10 to count the number of digits. As
The number of digits in an integer = the upper bound of log10(n).

Example :

n = 12345
log10(12345) = 4.091
Integral part of 4.091 is 4 and 4 + 1 =  5 which is also the number of digits in 12345               
 */

public class Count_Digit {
    public static int count(int num) {
        int digit = (int) Math.floor(Math.log10(num) + 1);
        return digit;
    }
}
