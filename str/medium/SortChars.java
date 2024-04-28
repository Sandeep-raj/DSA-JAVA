package str.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Sort Characters By Frequency
 * 
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
 */

public class SortChars {
    public static class CharCtr {
        public int Ctr;
        public char C;

        public CharCtr(char c, int cnt) {
            this.C = c;
            this.Ctr = cnt;
        }
    }

    public static String sort(String str) {
        int[] freqMap = new int[128];
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            freqMap[c]++;
        }

        PriorityQueue<CharCtr> pq = new PriorityQueue<>(new Comparator<CharCtr>() {
            public int compare(CharCtr o1, CharCtr o2) {
                if(o1.Ctr < o2.Ctr) {
                    return 1;
                }else if(o1.Ctr > o2.Ctr) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        for(int i =0; i < 128; i++) {
            if(freqMap[i] > 0) {
                CharCtr c = new CharCtr((char)i, freqMap[i]);
                pq.add(c);
            }
        }

        while (!pq.isEmpty()) {
            CharCtr cc = pq.poll();

            while (cc.Ctr > 0) {
                sb.append(cc.C);
                cc.Ctr--;
            }
        }

        return sb.toString();
    }
}
