package graph.bfs_dfs;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Word Ladder
 * 
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */

public class WordLadder {
    static class WordNode {
        public String word;
        public int step;

        public WordNode(String w, int s){
            this.word = w;
            this.step = s;
        }
    }
    public static int ladder(String beginWord, String endWord, String[] wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for(int i =0; i < wordList.length; i++) {
            wordSet.add(wordList[i]);
        }

        ArrayList<WordNode> q = new ArrayList<>();
        q.add(new WordNode(beginWord, 1));

        while (q.size() > 0) {
            WordNode wn = q.remove(0);
            if(wn.word.equals(endWord)) {
                return wn.step;
            }

            for(int i = 0; i < wn.word.length(); i++) {  
                char[] chars = wn.word.toCharArray();
                for(char x = 'a'; x <= 'z'; x++) {
                    chars[i] = x;

                    String temp = new String(chars);
                    
                    if(wordSet.contains(temp)) {
                        wordSet.remove(temp);
                        q.add(new WordNode(temp, wn.step + 1));
                    }
                }
            }
        }

        return 0;
    }
}
