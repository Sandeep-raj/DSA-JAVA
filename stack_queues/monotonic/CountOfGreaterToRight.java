package stack_queues.monotonic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Count Of Greater Elements To The Right
 * 
 * Problem statement
You are given an array 'arr' of length 'N'.



You are given 'Q' queries, and for each query, you are given an index(0-based indexing).



Answer to each query is the number of the strictly greater elements to the right of the given index element.



You must return an array 'answer' of length ’N’, where ‘answer[i]’ is the answer to the ‘ith’ query.



Example:
Input:
arr = [5, 2, 10, 4], N=4, Q=2, query = [0, 1]
Output:
1 2

Explanation: The element at index 0 is 5 for the first query. There is only one element greater than 5 towards the right, i.e., 10.

For the second query, the element at index 1 is 2. There are two elements greater than 2 towards the right, i.e., 10 and 4. 

Hence we return [1, 2]


Sample Input 1:
8 3
1 3 6 5 8 9 13 4
0 1 5
Sample Output 1:
7 6 1
Explanation Of Sample Input 1:
For test case one:
Input:
arr = [1, 3, 6, 5, 8, 9, 13, 4], N=8, Q=3, query = [0, 1, 5]
Output:
7 6 1

Explanation: The element at index 0 is 1 for the first query. There are seven elements greater than 1 towards the right, i.e., 3, 6, 5, 8, 9, 13, and 4.

For the second query, the element at index 1 is 3. There are six elements greater than 3 towards the right, i.e., 6, 5, 8, 9, 13, and 4. 

For the third query, the element at index 5 is 9. There is only one element greater than 9 towards the right, i.e., 13. 

Hence we return [7, 6, 1].
Sample Input 2:
4 4
1 2 3 4
0 1 2 3
Sample Output 2:
3 2 1 0
Constraints:
1 <= N <= 10^4
1 <= Q <= 100
1 <= arr[i] <= 10^5.
0 <= query[i] <= ‘N’-1
Time Limit: 1 sec
 */

public class CountOfGreaterToRight {
    static int sorted(Stack<Integer> st, int val) {
        if (st.isEmpty() || st.peek() > val) {
            st.push(val);
            return st.size() - 1;
        }

        int temp = st.pop();
        int cnt = sorted(st, val);
        st.push(temp);

        return cnt;
    }

    static void solve(int[] arr, Stack<Integer> st, List<Integer> ans, int index) {
        if (index < 0) {
            return;
        }

        if (st.isEmpty()) {
            ans.set(index, 0);
        }

        int count = sorted(st, arr[index]);
        ans.set(index, count);
        solve(arr, st, ans, index - 1);
    }

    public static int[] count(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>(n);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            ans.add(0);
        }

        solve(arr, st, ans, n - 1);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}