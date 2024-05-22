package greedy.med_hard;

/*
 * Candy
 * 
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.


Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.


Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
 */

public class Candy {
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        candies[ratings.length - 1] = 1;

        // update from left to right
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }else {
                candies[i] = 1;
            }
        }


        // update from right to left
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && candies[i] < candies[i+1] + 1) {
                candies[i] = candies[i+1] + 1;
            }
        }

        int totCandies = 0;
        for(int i =0; i < candies.length; i++) {
            totCandies += candies[i];
        }

        return totCandies;
    }
}
