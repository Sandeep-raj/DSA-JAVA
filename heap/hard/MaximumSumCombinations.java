package heap.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * Maximum Sum Combinations
 * 
 * Given two equally sized 1-D arrays A, B containing N integers each.
A sum combination is made by adding one element from array A and another element of array B.
Return the maximum C valid sum combinations from all the possible sum combinations.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 105
1 <= C <= N


Example Input
Input 1:

 A = [3, 2]
 B = [1, 4]
 C = 2
Input 2:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
 C = 4


 Example Output
Output 1:

 [7, 6]
Output 1:

 [10, 9, 9, 8]




 Example Explanation
Explanation 1:

 7     (A : 3) + (B : 4)
 6     (A : 2) + (B : 4)
Explanation 2:

 10   (A : 4) + (B : 6)
 9   (A : 4) + (B : 5)
 9   (A : 3) + (B : 6)
 8   (A : 3) + (B : 5)
 */

public class MaximumSumCombinations {
    static class PairSum {
        public int Val;
        public int AIdx;
        public int BIdx;

        public PairSum(int val, int aidx, int bidx) {
            this.Val = val;
            this.AIdx = aidx;
            this.BIdx = bidx;
        }
    }
    public static int[] maxSumCombo(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<PairSum> pq = new PriorityQueue<>((x,y) -> (y.Val - x.Val));
        HashSet<String> set = new HashSet<>();

        int[] result = new int[k];
        int cnt = 0;
        int n = a.length;
        set.add((n-1)+"|"+(n-1));
        pq.add(new PairSum(a[n-1] + b[n-1], n-1, n-1));

        while (cnt < k) {
            PairSum max = pq.remove();
            result[cnt] = max.Val;
            cnt++;

            if(max.BIdx - 1 >= 0 && !set.contains(max.AIdx+"|"+(max.BIdx - 1))) {
                pq.add(new PairSum(a[max.AIdx] + b[max.BIdx - 1], max.AIdx, max.BIdx - 1));
            }

            if(max.AIdx - 1 >= 0 && !set.contains((max.AIdx - 1)+"|"+max.BIdx)) {
                pq.add(new PairSum(a[max.AIdx - 1] + b[max.BIdx], max.AIdx - 1, max.BIdx));
            }
        }

        return result;
    }
}
