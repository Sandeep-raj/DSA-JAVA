package str.easy;

import java.util.HashMap;

/*
 * Isomorphic Strings
 * 
 * Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

public class IsomorphicStrings {
    public static boolean isIso(String str1, String str2) {
        HashMap<Character,Character> charMap = new HashMap<>();

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if(charMap.containsKey(str1.charAt(i))) {
                if(charMap.get(str1.charAt(i)) != str2.charAt(i)) {
                    return false;
                }
            }else {
                if(charMap.containsValue(str2.charAt(i))) {
                    return false;
                }
                charMap.put(str1.charAt(i), str2.charAt(i));
            }
        }

        return true;
    }
}
