package bitmanipulation.medium;

/*
 * One Odd Occurring
 * 
 * Problem statement
Given an array ‘ARR’ of ‘N’ integers, where all the elements occur an even number of times and only one number occurs an odd number of times.

Find and return the number which occurs an odd number of times.
For example:
'N' = 5, 'ARR' = [1, 2, 3, 2, 3]
Output: 1

Except for number 1, all numbers occur an even number of times.

Sample Input 1 :
9
4 5 6 5 6 9 9 4 4
Sample Output 1 :
4
Explanation Of Sample Input 1 :
5, 6, and 9 occur an even number of times, and only 4 occur odd number of times.
Sample Input 2 :
5
1 1 1 1 1
Sample Output 2 :
1
Constraints :
1 <= 'N' <= 10^5

1 <= 'ARR[i]' <= 10^5

Time Limit: 1 sec
 */

public class OneOdd {
    public static int oddOne(int[] arr) {
        // XOR approach
        // int resutt = 0;
        // for(int i =0; i < arr.length; i++) {
        //     resutt = resutt ^ arr[i];
        // }

        int result = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            int mask = (1<<i);

            for (int j = 0; j < arr.length; j++) {
                if ((arr[j]&mask) > 0){
                    cnt++;
                }
            }

            if((cnt&1) == 1) {
                result += (1<<i);
            }
        }

        return result;
    }
}
