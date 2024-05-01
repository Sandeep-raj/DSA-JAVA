package bitmanipulation.adv_maths;

import java.util.ArrayList;

/*
 * Print all Divisors of a number
 * 
 * Problem statement
Given an integer ‘N’, your task is to write a program that returns all the divisors of ‘N’ in ascending order.



For example:
'N' = 5.
The divisors of 5 are 1, 5.

Sample Input 1 :
10
Sample Output 1 :
1 2 5 10
Explanation of Sample Input 1:
The divisors of 10 are 1,2,5,10.
Sample Input 2 :
6
Sample Output 2 :
1 2 3 6
Explanation of Sample Input 2:
The divisors of 6 are 1, 2, 3, and 6.
Constraints :
1 <= 'N' <= 10^5 
 */

public class PrintAllDivisor {
    public static int[] allDivisor(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1; i*i <= n; i++) {
            if(n % i == 0) {
                result.add(i);

                if(n/i != i) {
                    result.add(n/i);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
