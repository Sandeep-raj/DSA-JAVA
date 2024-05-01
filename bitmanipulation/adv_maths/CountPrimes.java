package bitmanipulation.adv_maths;

import java.util.ArrayList;

/*
 * Count Primes
 * 
 * Problem statement
You are given an integer 'N'.
You must return the unique prime factors of 'N' in increasing order.

For Example:
For ‘N’ = 10.

Unique prime factors are 2 and 5.

Hence we return {2, 5}.


Sample Input 1:
35
Sample Output 1:
5 7
Explanation For Sample Output 1:
Unique prime factors are 5 and 7.

Hence we return {5, 7}.
Sample Input 2:
14
Sample Output 2:
2 7
Constraints:
1 <= 'N' <= 10^6

Time Limit: 1 sec.
 */
public class CountPrimes {
    public static int[] count(int n) {
        int sqroot = (int)Math.sqrt(n);
        ArrayList<Integer> result = new ArrayList<>();

        for(int  i =2 ; i < sqroot; i++) {
            if(n % i == 0) {
                if(isPrime(i)) {
                    result.add(i);
                }

                while (n%i == 0) {
                    n = n/i;
                }
            }
        }


        if(n > 1) {
            result.add(n);
        }

        return result.stream().mapToInt(Integer :: intValue).toArray();
    }


    public static int[] countSieve(int n) {
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


        for(int i = 2; i*i < n ; i++) {
            if(prime[i - 2] == 1 && n%i == 0) {
                result.add(i);

                if(prime[n/i - 2] == 1 && i != n/i) {
                    result.add(n/i);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean isPrime(int n) {
        int sqroot = (int)Math.sqrt(n);
        for(int i = 2; i < sqroot; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
