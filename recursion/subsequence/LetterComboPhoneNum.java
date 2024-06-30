package recursion.subsequence;

import java.util.ArrayList;

/*
 * Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

public class LetterComboPhoneNum {
    static char[][] map = new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public static String letterCombo(String inp) {
        ArrayList<String> result = new ArrayList<>();
        process(inp, 0, result, "");

        StringBuilder sb = new StringBuilder();
        for(String x : result) {
            sb.append(x+",");
        }

        return sb.toString();
    }

    static void process(String inp, int i, ArrayList<String> result, String str) {
        if(i == inp.length()) {
            result.add(str);
            return;
        }

        int idx = inp.charAt(i) - '0';
        char[] arr = map[idx];

        for(int x=0; x < arr.length; x++) {
            process(inp, i + 1, result, str + arr[x]);
        }
    }
}
