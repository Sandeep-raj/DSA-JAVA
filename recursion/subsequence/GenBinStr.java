package recursion.subsequence;

import java.util.ArrayList;

/*
 * Generate all binary strings without consecutive 1’s
 * 
 * Given an integer, K. Generate all binary strings of size k without consecutive 1’s.
 * 
 * Input : K = 3  
Output : 000 , 001 , 010 , 100 , 101 
Input : K  = 4 
Output :0000 0001 0010 0100 0101 1000 1001 1010


 */

public class GenBinStr {
    public static String binStr(int k) {
        ArrayList<String> result = new ArrayList<>();
        process(k, 0, result, 0, "");

        return result.toString();
    }

    static void process(int k, int currk, ArrayList<String> result, int last ,String currStr) {
        if(currk == k) {
            result.add(currStr);
            return;
        }

        process(k, currk+1, result, 0, currStr + 0);
        if(last == 0) {
            process(k, currk+1, result, 1, currStr + 1);
        }
    }
}
