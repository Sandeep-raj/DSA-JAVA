package basic.sorting;

/*
 * Approach:

The algorithm steps are as follows:

First, we will select the range of the unsorted array. For that, we will run a loop(say i) that will signify the last index of the selected range. The loop will run backward from index n-1 to 0(where n = size of the array). The value i = n-1 means the range is from 0 to n-1, and similarly, i = n-2 means the range is from 0 to n-2, and so on.
Within the loop, we will run another loop(say j, runs from 0 to i-1 though the range is from 0 to i) to push the maximum element to the last index of the selected range, by repeatedly swapping adjacent elements.
Basically, we will swap adjacent elements(if arr[j] > arr[j+1]) until the maximum element of the range reaches the end.
Thus, after each iteration, the last part of the array will become sorted. Like: after the first iteration, the array up to the last index will be sorted, and after the second iteration, the array up to the second last index will be sorted, and so on.
After (n-1) iteration, the whole array will be sorted.
Note: Here, after each iteration, the array becomes sorted up to the last index of the range. That is why the last index of the range decreases by 1 after each iteration. This decrement is achieved by the outer loop and the last index is represented by variable i in the following code. And the inner loop(i.e. j) helps to push the maximum element of range [0….i] to the last index(i.e. index i).
 */

public class Bubble {
    public static int[] sort(int[] arr) {
        for (int top = arr.length - 1; top > 1; top--){
            for(int bubble = 1; bubble <= top; bubble++){
                if(arr[bubble-1] > arr[bubble]){
                    int temp =  arr[bubble-1];
                    arr[bubble-1] = arr[bubble];
                    arr[bubble] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] recSort(int[] arr, int top) {

        if (top == 0) {
            return arr;
        }

        for (int i = 0; i < top; i++) {
            if (arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i + 1] = temp;
            }
        }

        return recSort(arr, top - 1);
    }
}
