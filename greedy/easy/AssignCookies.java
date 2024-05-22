package greedy.easy;

import java.util.Arrays;

/*
 * Assign Cookies
 * 
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.


Example 1:
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:
Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.



Constraints:
1 <= g.length <= 3 * 104
0 <= s.length <= 3 * 104
1 <= g[i], s[j] <= 231 - 1
 */

public class AssignCookies {
    public static int assign(int[] g, int[] s) {
        // with sorting (O(nlogn))

        // Arrays.sort(g);
        // Arrays.sort(s);
        // int ptr1 = 0, ptr2 = 0, count = 0;

        // while (ptr1 < g.length && ptr2 < s.length) {
        //     if(s[ptr2] >= g[ptr1]) {
        //         count++;
        //         ptr1++;
        //     }

        //     ptr2++;
        // }

        // return count;


        int max_s = -1;
        for(int i = 0; i < s.length; i++) {
            if(max_s < s[i]) {
                max_s = s[i];
            }
        }

        int max_g = -1;
        for(int i = 0; i < g.length; i++) {
            if(max_g < g[i]) {
                max_g = g[i];
            }
        }

        int[] map_s = new int[max_s + 1];
        int[] map_g = new int[max_g + 1];

        for(int i = 0; i < s.length; i++) {
            map_s[s[i]]++;
        }

        for(int i = 0; i < g.length; i++) {
            map_g[g[i]]++;
        }

        int ptr1 = 0, ptr2 = 0,count = 0;
        while (ptr1 < map_g.length && ptr2 < map_s.length) {
            
            while (ptr1 < map_g.length && map_g[ptr1] == 0) {
                ptr1++;
                ptr2 = ptr1;
            }

            while (ptr2 < map_s.length && map_s[ptr2] == 0) {
                ptr2++;
            }

            if(ptr1 < map_g.length && ptr2 < map_s.length && ptr2 >= ptr1) {
                map_s[ptr2]--;
                map_g[ptr1]--;
                count++;
            }
        }

        return count;
    }
}
