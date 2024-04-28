package str.easy;

import java.util.HashMap;
import java.util.Hashtable;

/*
 * Check if two Strings are anagrams of each other
 * 
 * Problem Statement: Given two strings, check if two strings are anagrams of each other or not.
 * 
 * Example 1:
Input: CAT, ACT
Output: true
Explanation: Since the count of every letter of both strings are equal.

Example 2:
Input: RULES, LESRT 
Output: false
Explanation: Since the count of U and T  is not equal in both strings.
 */

public class CheckAnagrams {
    public static Boolean checkAnagrams(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        // HashTable Implementation

        // Hashtable<Character, Integer> charMap = new Hashtable<Character,Integer>();

        // for(Character c : str1.toCharArray()) {
        //     if(charMap.containsKey(c)) {
        //         charMap.put(c, charMap.get(c) + 1);
        //     }else {
        //         charMap.put(c, 1);
        //     }
        // }

        // for(Character c : str2.toCharArray()) {
        //     if(charMap.containsKey(c)) {
        //         int curVal = charMap.get(c);
        //         if(curVal == 0) {
        //             return false;
        //         }
        //         charMap.put(c, curVal - 1);
        //     }else {
        //         return false;
        //     }
        // }

        // return true;


        // Array Implementation
        int[] freq = new int[26];
        for (char c: str1.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c: str2.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
