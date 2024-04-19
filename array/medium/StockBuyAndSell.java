package array.medium;

import java.util.Stack;

/*
 * You are given an array of prices where prices[i] is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Examples
Example 1:
Input:
 prices = [7,1,5,3,6,4]
Output:
 5
Explanation:
 Buy on day 2 (price = 1) and 
sell on day 5 (price = 6), profit = 6-1 = 5.

Note
: That buying on day 2 and selling on day 1 
is not allowed because you must buy before 
you sell.

Example 2:
Input:
 prices = [7,6,4,3,1]
Output:
 0
Explanation:
 In this case, no transactions are 
done and the max profit = 0.


Algorithm / Intuition
Intuition: We will linearly travel the array. We can maintain a minimum from the start of the array and compare it with every element of the array, if it is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum.

Approach:

Create a variable maxPro and store 0 initially.
Create a variable minPrice and store some larger value(ex: MAX_VALUE) value initially.
Run a for loop from 0 to n.
Update the minPrice if it is greater than the current element of the array
Take the difference of the minPrice with the current element of the array and compare and maintain it in maxPro.
Return the maxPro.
 */

public class StockBuyAndSell {
    public static int findMax(int[] arr) {
        // montonic array 

        // Stack<Integer> stack = new Stack<Integer>();
        // int maxProfit = Integer.MIN_VALUE;

        // for (int i =0; i < arr.length; i++) {
        //     if(stack.empty()) {
        //         stack.push(arr[i]);
        //     }else if(stack.peek() <= arr[i]) {
        //         stack.push(arr[i]);
        //     }else {
        //         while (!stack.empty() && stack.peek() > arr[i]) {
        //             int firstEle = stack.firstElement();
        //             int currVal = stack.pop();
        //             maxProfit = Math.max(maxProfit, currVal - firstEle);
        //         }

        //         stack.push(arr[i]);
        //     }
        // }

        // while(!stack.empty()) {
        //     int firstEle = stack.firstElement();
        //     int currVal = stack.pop();
        //     maxProfit = Math.max(maxProfit, currVal - firstEle);
        // }

        // return maxProfit;

        // maintain minima
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }else {
                maxProfit = Math.max(maxProfit, arr[i] - min);
            }
        }

        return maxProfit;
    }
}
