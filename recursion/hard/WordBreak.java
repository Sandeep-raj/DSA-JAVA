package recursion.hard;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Word Break
 * 
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

public class WordBreak {
    public static boolean wordBreak(String s, String[] worddict) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> dict = new HashSet<>();
        for(int i = 0; i < worddict.length; i++) {
            dict.add(worddict[i]);
        }

        return wBreak(s, result, dict);
    }


    static boolean wBreak(String str, ArrayList<String> result, HashSet<String> dict) {

        if(str.length() == 0) {
            System.out.println(result.toString());
            return true;
        }

        for(int i = 0; i < str.length(); i++) {
            if(dict.contains(str.substring(0, i+1))) {
                result.add(str.substring(0, i+1));
                boolean found = wBreak(str.substring(i+1), result, dict);
                if(found) {
                    return found;
                }

                result.remove(result.size() - 1);
            }
        }

        return false;
    }

    static boolean wordExists(String str, HashSet<String> dict) {
        return dict.contains(str);
    }
}
