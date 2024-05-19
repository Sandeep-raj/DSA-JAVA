package heap.learning;

/*
 * Implementation of Priority Queue using Binary Heap
 * 
 * Given a binary heap implementation of Priority Queue. Extract the maximum element from the queue i.e. remove it from the Queue and return it's value. 
 * 
 * Example 1:

Input: 4 2 8 16 24 2 6 5
Output: 24
Priority Queue after extracting maximum: 16 8 6 5 2 2 4
Example 2:

Input: 64 12 8 48 5
Output: 64
Priority Queue after extracting maximum: 48 12 8 5


Your Task:
Complete the function extractMax() which extracts the maximum element, i.e. remove it from the Queue and return it's value.

Expected Time Complexity: O(logN)
Expected Space Complexity: O(N)

Constraints:
1<=N<=500
 */

public class ImplementationPriorityQueue {
    public static class MinHeap {
        private int size = 10;
        private int count = 0;
        private int[] arr;

        public MinHeap(int size) {
            if (size > 0) {
                this.size = size;
            }
            arr = new int[size];
        }

        public void Insert(int val) {
            if (this.count < this.size) {
                this.arr[this.count] = val;
                sweepeUp(this.count);
                this.count++;
            }
        }

        public int Remove() {
            int smallest = 0;
            if (this.count > 0) {
                smallest = this.arr[0];
                this.count--;
                this.arr[0] = this.arr[this.count];

                percolateDown();
            }
            return smallest;
        }

        private void sweepeUp(int idx) {
            while (idx > 0) {
                int parentIdx = (idx - 1) / 2;

                if (this.arr[idx] > this.arr[parentIdx]) {
                    break;
                }

                int temp = this.arr[idx];
                this.arr[idx] = this.arr[parentIdx];
                this.arr[parentIdx] = temp;

                idx = parentIdx;
            }
        }

        private void percolateDown() {
            int idx = 0;

            while (((2 * idx) + 1) <= this.count) {
                int leftChild = (2 * idx) + 1;
                int rightChild = (2 * idx) + 2;

                int smallestIdx = leftChild;
                if (rightChild <= this.count && this.arr[leftChild] > this.arr[rightChild]) {
                    smallestIdx = rightChild;
                }

                if (this.arr[idx] > this.arr[smallestIdx]) {
                    int temp = this.arr[idx];
                    this.arr[idx] = this.arr[smallestIdx];
                    this.arr[smallestIdx] = temp;

                    idx = smallestIdx;
                } else {
                    break;
                }
            }
        }

        public int Size() {
            return this.count;
        }
    }

    public static class MaxHeap {
        private int count = 0;
        private int size = 10;
        private int[] arr;

        public MaxHeap(int size) {
            if(size > 0) {
                this.size = size;
            }

            this.arr = new int[this.size];
        }

        public void Insert(int val) {
            if(this.count < this.size) {
                this.arr[this.count] = val;
                sweepUp();
                this.count++;
            }
        }

        public int Remove() {
            int biggest = this.arr[0];
            this.count--;
            this.arr[0] = this.arr[this.count];
            if(this.count > 1) {
                percolateDown();
            }
            return biggest;
        }

        public int Size() {
            return this.count;
        }

        private void sweepUp() {
            int idx = this.count;
            while (idx > 0) {
                int parentIdx = (idx - 1)/2;

                if(this.arr[idx] > this.arr[parentIdx]) {
                    int temp = this.arr[idx];
                    this.arr[idx] = this.arr[parentIdx];
                    this.arr[parentIdx] = temp;

                    idx = parentIdx;
                }else {
                    break;
                }
            }
        }

        private void percolateDown() {
            int idx = 0;
            int leftIdx = 2*idx + 1;

            while (leftIdx <= this.count) {
                int largest = leftIdx;
                int rightIdx = 2*idx + 2;

                if(rightIdx <= this.count && this.arr[leftIdx] < this.arr[rightIdx]) {
                    largest = rightIdx;
                }

                if(this.arr[idx] < this.arr[largest]) {
                    int temp = this.arr[idx];
                    this.arr[idx] = this.arr[largest];
                    this.arr[largest] = temp;

                    idx = largest;
                }else {
                    break;
                }
            }
        }
    }

    public static void Test() {
        int[] inp = new int[] { 64 ,12 ,8 ,48 ,5 };
        MaxHeap pq = new MaxHeap(inp.length);
        for(int i : inp) {
            pq.Insert(i);
        }

        while (pq.Size() > 0) {
            System.out.println(pq.Remove());
        }
    }
}
