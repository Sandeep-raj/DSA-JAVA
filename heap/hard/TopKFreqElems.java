package heap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Top K Frequent Elements
 * 
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * 
 * Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]


Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */

public class TopKFreqElems {
    static class ElemCount {
        int key;
        int count;

        public ElemCount(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    public static int[] topk(int[] arr, int k) {
        ///////////////////////////// Priority Queue
        // PriorityQueue<ElemCount> pq = new PriorityQueue<>((a,b) -> (b.count -
        ///////////////////////////// a.count));
        // Hashtable<Integer,Integer> map = new Hashtable<>();

        // for(int i = 0; i < arr.length; i++) {
        // if(map.containsKey(arr[i])) {
        // map.put(arr[i], map.get(arr[i]) + 1);
        // }else {
        // map.put(arr[i], 1);
        // }
        // }

        // Iterator<Integer> itr = map.keys().asIterator();
        // while (itr.hasNext()) {
        // Integer key = itr.next();
        // pq.add(new ElemCount(key, map.get(key)));
        // }

        // int[] result = new int[k];
        // int cnt = 0;
        // while (k > 0) {
        // ElemCount max = pq.remove();
        // result[cnt] = max.key;
        // cnt++;
        // k--;
        // }

        // return result;

        ///////////////////////////////////// Bucket Sort
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[arr.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] result = new int[k];
        int cnt = 0;
        for (int i = arr.length; i >= 0; i--) {
            if (bucket[i] != null) {
                for (; cnt < k && bucket[i].size() > 0;) {
                    result[cnt] = bucket[i].remove(0);
                    cnt++;
                }
            }
        }

        return result;
    }
}
