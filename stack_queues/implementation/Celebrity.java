package stack_queues.implementation;

import java.util.Stack;

/*
 * Celebrity Problem
 * 
 * There are ‘N’ people at a party. Each person has been assigned a unique id between 0 to 'N- 1’ (both inclusive). A celebrity is a person who is known to everyone but does not know anyone at the party. Your task is to find out the celebrity at the party. Print the id of the celebrity. If there is no celebrity at the party, then print -1.
 * 
 * Input:

MATRIX = { {0, 0, 1, 0},

           {0, 0, 1, 0},

           {0, 0, 0, 0},

           {0, 0, 1, 0} }

Output:id = 2

Explanation: The person with ID 2 does not know anyone, but everyone knows him


 */

public class Celebrity {
    public static int celeb(int[][] arr) {
        int noOfPeps = arr.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < noOfPeps; i++) {
            stack.push(i);
        }

        while (stack.size() != 1) {
            int celeb1 = stack.pop();
            int celeb2 = stack.pop();

            if(arr[celeb1][celeb2] == 1) {
                stack.push(celeb2);
            }else {
                stack.push(celeb1);
            }
        }

        int celeb = stack.pop();
        int rowCnt = 0;
        for(int i = 0; i < arr.length; i++) {
            rowCnt += arr[celeb][i];
        }

        if(rowCnt == 0) {
            for(int i = 0; i < arr.length; i++) {
                rowCnt += arr[i][celeb];
            }

            if(rowCnt == arr.length - 1) {
                return celeb+1;
            }else {
                return -1;
            }
        }else {
            return -1;
        }
    }
}
