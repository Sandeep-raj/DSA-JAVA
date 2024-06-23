package graph.bfs_dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Word Ladder II
 * 
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].


Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
The sum of all shortest transformation sequences does not exceed 105.
 */

public class WordLadderII {
    static class WordNode {
        public String word;
        public ArrayList<String> words;
        public HashSet<String> wordlist;

        public WordNode(String w, ArrayList<String> s, HashSet<String> list){
            this.word = w;
            this.words = s;
            this.wordlist = list;
        }
    }

    public static String ladder(String beginWord, String endWord, String[] wordList) {
        ArrayList<WordNode> q = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>();
        for(int i =0; i< wordList.length; i++){
            wordSet.add(wordList[i]);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> tempArr = new ArrayList<>();
        tempArr.add(beginWord);
        q.add(new WordNode(beginWord, tempArr, wordSet));
        while (q.size() > 0) {
            WordNode wn = q.remove(0);

            if(wn.word.equals(endWord)) {
                result.add(wn.words);
            }

            for(int i = 0; i < wn.word.length(); i++) {
                char[] chars = wn.word.toCharArray();
                for(char x = 'a'; x <= 'z'; x++ ){
                    chars[i] = x;

                    String temp = new String(chars);
                    if(wn.wordlist.contains(temp)) {
                        ArrayList<String> words = deepCloneArrayList(wn.words);
                        HashSet<String> set = deepCloneSet(wn.wordlist);
                        set.remove(temp);
                        words.add(temp);
                        q.add(new WordNode(temp, words, set));
                    }
                }
            }
        }

        return result.toString();
    }

    static HashSet<String> deepCloneSet(HashSet<String> inpSet) {
        HashSet<String> outSet = new HashSet<>();
        Iterator<String> itr = inpSet.iterator();
        while (itr.hasNext()) {
            outSet.add(itr.next());
        }

        return outSet;
    }

    static ArrayList<String> deepCloneArrayList(ArrayList<String> inpArr) {
        ArrayList<String> outArr = new ArrayList<String>();
        Iterator<String> itr = inpArr.iterator();
        while (itr.hasNext()) {
            outArr.add(itr.next());
        }

        return outArr;
    }
}
