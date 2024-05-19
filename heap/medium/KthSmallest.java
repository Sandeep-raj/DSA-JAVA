package heap.medium;

/*
 * Kth smallest element
 * 
 * Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array. It is given that all array elements are distinct.

Note:-  l and r denotes the starting and ending index of the array.

Example 1:

Input:
n = 6
arr[] = 7 10 4 3 20 15
k = 3
l=0 r=5

Output : 
7

Explanation :
3rd smallest element in the given 
array is 7.
Example 2:

Input:
n = 5
arr[] = 7 10 4 20 15
k = 4 
l=0 r=4

Output : 
15

Explanation :
4th smallest element in the given 
array is 15.


Your Task:
You don't have to read input or print anything. Your task is to complete the function kthSmallest() which takes the array arr[], integers l and r denoting the starting and ending index of the array and an integer k as input and returns the kth smallest element.
 
Expected Time Complexity: O(n*log(n) )
Expected Auxiliary Space: O(log(n))
Constraints:
1 <= n <= 105
l = 0
r = N-1
1<= arr[i] <= 105
1 <= k <= n
 */

public class KthSmallest {
    public static int smallest(int[] arr, int k) {
        // Priority Queue (O(nlogn))
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        // for (int i = 0; i < arr.length; i++) {
        //     pq.add(arr[i]);
        // }

        // int result = -1;
        // while (k > 0) {
        //     result = pq.remove();
        //     k--;
        // }

        // return result;


        // Counter Based(O(n)) 
        int result = -1;
        int[] counter = new int[20001];
        for(int i = 0; i < arr.length; i++) {
            counter[arr[i] + 10000]++;
        }

        int x = 0;
        while (k > 0 && x < 20001) {
            if(counter[x] > 0) {
                counter[x]--;
                k--;
                result = x - 10000;
            }else {
                x++;
            }
        }

        return result;
    }
}
