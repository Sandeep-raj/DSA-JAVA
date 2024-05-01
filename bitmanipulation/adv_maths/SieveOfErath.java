package bitmanipulation.adv_maths;

import java.util.ArrayList;

/*
 * Sieve of Eratosthenes
 * 
 * Count Primes
 * 
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * 
 * Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
 */

public class SieveOfErath {
    public static int[] count(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        // pre process prime array
        int[] prime = new int[n];
        for(int i = 0; i < n; i++) {
            prime[i] = 1;
        }

        for (int i = 2; i*i < n; i++) {
            if(prime[i - 2] == 1) {
                int ctr = 2;
                while (i*ctr <= n) {
                    prime[i*ctr - 2] = 0;
                    ctr++;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if(prime[i-2] == 1) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
