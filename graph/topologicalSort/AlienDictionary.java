package graph.topologicalSort;

import java.util.ArrayList;

/*
 * Alien Dictionary - Topological Sort
 * 
 * Problem Statement: Given a sorted dictionary of an alien language having N words and k starting alphabets of a standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order.

Examples:

Example 1:
Input: N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output: b d a c
Explanation: 
We will analyze every consecutive pair to find out the order of the characters.
The pair “baa” and “abcd” suggests ‘b’ appears before ‘a’ in the alien dictionary.
The pair “abcd” and “abca” suggests ‘d’ appears before ‘a’ in the alien dictionary.
The pair “abca” and “cab” suggests ‘a’ appears before ‘c’ in the alien dictionary.
The pair “cab” and “cad” suggests ‘b’ appears before ‘d’ in the alien dictionary.
So, [‘b’, ‘d’, ‘a’, ‘c’] is a valid ordering.

Example 2:
Input: N = 3, K = 3
dict = {"caa","aaa","aab"}
Output: c a b
Explanation: Similarly, if we analyze the consecutive pair 
for this example, we will figure out [‘c’, ‘a’, ‘b’] is 
a valid ordering.
 */

public class AlienDictionary {
    public static Object[] dicts(int n, int k, String[] dict) {
        ArrayList<Integer>[] adjList = new ArrayList[k];
        
        for(int i = 1; i < n; i++) {
            char[] cArr1 = dict[i - 1].toCharArray();
            char[] cArr2 = dict[i].toCharArray();

            for(int j = 0; j < cArr1.length; j++) {
                if(cArr1[j] != cArr2[j]) {
                    if(adjList[cArr1[j] - 'a'] == null) {
                        adjList[cArr1[j] - 'a'] = new ArrayList<>();
                    }

                    adjList[cArr1[j] - 'a'].add(cArr2[j] - 'a');
                    break;
                }
            }
        }

        int[] indegree = new int[k];
        for(int i = 0; i < indegree.length; i++) {
            if(adjList[i] != null) {
                for(int x : adjList[i]) {
                    indegree[x]++;
                }
            }
        }

        ArrayList<String> result = new ArrayList<>();
        ArrayList<Integer> q = new ArrayList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while (q.size() > 0) {
            int node = q.remove(0);

            char curr = (char) ('a' + node);
            result.add("" + curr);

            if(adjList[node] != null) {
                for(int x : adjList[node]) {
                    indegree[x]--;
                    if(indegree[x] == 0) {
                        q.add(x);
                    }
                }
            }
        }

        return result.toArray();
    }
}
