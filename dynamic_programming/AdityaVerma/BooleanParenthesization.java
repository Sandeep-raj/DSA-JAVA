package dynamic_programming.AdityaVerma;

import java.util.HashMap;

/*
 * Boolean Parenthesization Problem
 * 
 * Given a boolean expression with the following symbols
 * Symbols
    'T' ---> true 
    'F' ---> false 

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 

Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true. 
Let the input be in form of two arrays one contains the symbols (T and F) in order and the other contains operators (&, | and ^}


Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )". 

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
and (T|((T&F)^T)). 

Input: 
n = 7
s = T|T&F^T
Output: 
4
Explaination: 
The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).

Input: 
n = 5
s = T^F|F
Output: 
2
Explaination: 
((T^F)|F) and (T^(F|F)) are the only ways.
 */

public class BooleanParenthesization {
    static HashMap<String,Integer> map = new HashMap<>();

    public static int eval(String exp) {
        return solve(exp, 0, exp.length()-1, true, map);
    }

    static int solve(String str, int i, int j, boolean isTrue, HashMap<String,Integer> dp) {
        if(i > j) {
            return 0;
        }

        if(i == j) {
            if(isTrue) {
                return str.charAt(i) == 'T' ? 1 : 0;
            }else {
                return str.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if(dp.containsKey(i + " " + j + " " + isTrue)) {
            return dp.get(i + " " + j + " " + isTrue);
        }


        int count = 0;
        for(int k = i + 1; k < j; k = k + 2) {
            int lt = solve(str, i, k-1, true, dp);
            int lf = solve(str, i, k-1, false, dp);
            int rt = solve(str, k+1, j, true, dp);
            int rf = solve(str, k+1, j, false, dp);

            if(str.charAt(k) == '&') {
                if(isTrue) {
                    count += lt*rt;
                }else {
                    count += lt*rf + lf*rf + lf*rt;
                }
            }else if(str.charAt(k) == '|') {
                if(isTrue) {
                    count += lt*rt + lt*rf + lf*rt;
                }else {
                    count += lf*rf;
                }
            }else if(str.charAt(k) == '^') {
                if(isTrue) {
                    count += lt*rf + lf*rt;
                }else {
                    count += lt*rt + lf*rf;
                }
            }
        }

        dp.put(i + " " + j + " " + isTrue, count);
        return count;
    }
}
