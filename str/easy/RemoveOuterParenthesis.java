package str.easy;

/*
 * Remove Outermost Parentheses
 * 
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.


Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".


Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.
 */

public class RemoveOuterParenthesis {
    public static String remove(String str) {

        // Counter (Optimized)
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char curr : str.toCharArray()) {
            if(curr == '(') {
                if(cnt > 0 ){
                    sb.append(curr);
                }
                cnt++;
            }else{
                cnt--;
                if(cnt > 0){
                    sb.append(curr);
                }
            }
        }

        return sb.toString();

        // Stacks

        // Stack<Character> charStack = new Stack<Character>();
        // String result = "";
        // for (int i = 0; i < str.length(); i++) {
        // if(str.charAt(i) == '(') {
        // if(!charStack.isEmpty()) {
        // result += '(';
        // }
        // charStack.push('(');
        // }else {
        // charStack.pop();
        // if (!charStack.isEmpty()) {
        // result += ")";
        // }
        // }
        // }

        // return result;
    }
}
