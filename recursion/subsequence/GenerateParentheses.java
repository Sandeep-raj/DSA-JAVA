package recursion.subsequence;

import java.util.ArrayList;

/*
 * Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:
1 <= n <= 8
 */

public class GenerateParentheses {
    public static String generate(int n) {
        ArrayList<String> result = new ArrayList<>();
        genPar(n, 0, 0, "", result);
        return result.toString();
    }

    static void genPar(int n, int start, int end, String currS, ArrayList<String> result) {
        if(currS.length() == 2*n) {
            result.add(currS);
            return;
        }

        if(start >= end && start < n) {
            genPar(n, start+1, end, currS + "(", result);
        }
        if(end < start) {
            genPar(n, start, end + 1, currS + ")", result);
        }
    }
}
