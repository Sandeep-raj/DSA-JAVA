package heap.hard;

import java.util.PriorityQueue;

/*
 * Find Median from Data Stream
 * 
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 */

public class FindMedianDataStream {
    static class MedianClass {
        private PriorityQueue<Integer> sq = new PriorityQueue<>((a,b) -> (b-a));
        private PriorityQueue<Integer> gq = new PriorityQueue<>((a,b) -> (a-b));

        public void add(int val) {
            sq.add(val);
            gq.add(sq.poll());

            if(gq.size() > sq.size()) {
                sq.add(gq.poll());
            }
        }

        public double median() {
            if(gq.size() == sq.size()) {
                return ((gq.peek()*1.0) + (sq.peek() * 1.0))/2;
            }else {
                return sq.peek();
            }
        }
    }

    public static void test() {
        MedianClass mc = new MedianClass();
        int[] arr = new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

        for(int i = 0 ; i < arr.length; i++) {
            mc.add(arr[i]);
            System.err.println(mc.median());
        }
    }
}
