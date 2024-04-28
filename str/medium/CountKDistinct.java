package str.medium;

import java.util.Hashtable;

/*
 * Count With K Different Characters
 * 
 * Problem statement
You are given a string 'str' of lowercase alphabets and an integer 'k' .

Your task is to return the count all the possible substrings that have exactly 'k' distinct characters.
For example:

'str' = abcad and 'k' = 2. 

We can see that the substrings {ab, bc, ca, ad} are the only substrings with 2 distinct characters. 
Therefore, the answer will be 4.   


Sample Input 1 :
aacfssa    
3
Sample Output 1 :
5    
Explanation of The Sample Input 1:
Given 'str' = “aacfssa”. We can see that the substrings with only 3 distinct characters are {aacf, acf, cfs, cfss, fssa}. 

Therefore, the answer will be 5.
Sample Input 2 :
qffds
4
Sample Output 2 :
1
Constraints:
1 <= |str| <= 10^5
1 <= k <= 26

Time Limit: 1 second
 */

public class CountKDistinct {
    public static int count(String str, int k) {
        // two pointer
        Hashtable<Character,Integer> charMap = new Hashtable<>();
        int ptr1 = 0, ptr2 = 0, result = 0;

        while (ptr2 < str.length()) {
            if(charMap.size() <= k && (ptr2 - ptr1) <= k ) {
                char c = str.charAt(ptr2);

                if(charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                }else {
                    charMap.put(c, 1);
                }
                ptr2++;
            }else if(charMap.size() >= k && (ptr2 - ptr1) > k) {
                char c = str.charAt(ptr1);
                int cVal = charMap.get(c);

                if(cVal > 1) {
                    charMap.put(c, cVal - 1);
                }else {
                    charMap.remove(c);
                }
                ptr1++;
            }

            if(charMap.size() == k) {
                System.out.println(str.substring(ptr1, ptr2));
                result++;
            }
        }
        return result;
    }
}
