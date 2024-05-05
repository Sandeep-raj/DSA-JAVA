package stack_queues.monotonic;

import java.util.Stack;

/*
 * Asteroid Collision
 * 
 * We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */

public class AsteroidCollision {
    public static int[] collision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        

        // for(int i = 0 ; i < arr.length; i++) {
        //     if(stack.isEmpty()) {
        //         stack.push(arr[i]);
        //     } else {
        //         if(arr[i] < 0) {
        //             while (!stack.isEmpty() && stack.peek() > 0) {
        //                 if(stack.peek() < Math.abs(arr[i])) {
        //                     stack.pop();
        //                 }else {
        //                     break;
        //                 }
        //             }

        //             if(!stack.isEmpty() && stack.peek() >= -1*arr[i]) {
        //                 if(stack.peek() == -1*arr[i]){
        //                     stack.pop();
        //                 }
        //                 continue;
        //             }

        //             stack.push(arr[i]);
        //         }else {
        //             stack.push(arr[i]);
        //         }
        //     }
        // }

        for(int i =0 ; i< arr.length; i++){
            int a = arr[i];
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int sum = a + stack.peek();

                if(sum > 0){
                    a =0;
                }else if (sum < 0 ){
                    stack.pop();
                }else{
                    stack.pop();
                    a=0;
                }
            }

            if(a != 0) {
                stack.push(arr[i]);
            }
        }


        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
