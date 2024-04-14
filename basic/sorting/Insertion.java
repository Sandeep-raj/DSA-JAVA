package basic.sorting;

/**
 * Approach: 

Select an element in each iteration from the unsorted array(using a loop).
Place it in its corresponding position in the sorted part and shift the remaining elements accordingly (using an inner loop and swapping).
The “inner while loop” basically shifts the elements using swapping.
 */

public class Insertion {
    public static int[] sort(int[] arr) {
        for (int sortidx = 1; sortidx < arr.length; sortidx++) {
            int temp = arr[sortidx];
            int insertidx = sortidx -1;

            while (insertidx >= 0) {
                if (arr[insertidx] > temp) {
                    arr[insertidx + 1] = arr[insertidx];
                    insertidx--;
                }else {
                    break;
                }
            }

            arr[insertidx + 1] = temp;
        }
        return arr;
    }
}
