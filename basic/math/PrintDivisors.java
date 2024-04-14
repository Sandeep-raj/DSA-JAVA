package basic.math;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Given a number, print all the divisors of the number. A divisor is a number that gives the remainder as zero when divided.

Examples
Example 1:
Input:
 n = 36
Output:
 1 2 3 4 6 9 12 18 36
Explanation:
 All the divisors of 36 are printed.

Example 2:
Input:
 n = 97
Output:
 1 97
Explanation:
 Since 97 is a prime number, only 1 and 97 are printed.



 Intuition:
The above method takes O(n) time complexity. We can also think of another approach. If we take a closer look, we can notice that the quotient of a division by one of the divisors is actually another divisor. Like, 4 divides 36. The quotient is 9, and 9 also divides 36.
Another intuition is that the root of a number actually acts as a splitting part of all the divisors of a number.
Also, the quotient of a division by any divisor gives an equivalent divisor on the other side. Like, 4 gives 9 while dividing 36. See the image below.

https://lh5.googleusercontent.com/EDvgYtan3tC1zxyzBMf_UjPb1GAQeeeQvyewZLFbvMAjthKA9s0XxN003nkq46imtFH55BKOGZpgKpVoHhKzD8HbaPtoLcdeHQ9yjASCbprm405m5nJnNvsTAh2pjKVVkIr1cjkQ

Approach:
From the intuition, we can come to the conclusion that we don't need to traverse all the candidates and if we found a single divisor, we can also find another divisor(Here, we need to be careful, if the given number is a perfect square, like 36, 6 also give 6 as quotient. This is a corner case.)
By keeping these in mind, it is enough if we traverse up to the root of a number. Whenever we find a divisor, we print it and also print the quotient. If the quotient is the same, we ignore it. Because the root of a perfect square will give the same quotient as itself.
The quotients are the numbers that are on the other side of the root. So, it's okay if we stop traversing at the root.
This approach is more time efficient than the previous one. But the output sequences are not the same. In the previous approach, we get an ordered output unlike here.
 */

public class PrintDivisors {
    public static ArrayList<Integer> print(int num) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        int sqroot = (int)Math.sqrt(num); 
        for (int i = 1; i  <= sqroot; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if( i != num/i) {
                    divisors.add(num/i);
                }
            }
        }

        Iterator<Integer> itr = divisors.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        return divisors;
    }
}
