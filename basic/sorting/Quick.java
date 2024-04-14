package basic.sorting;

public class Quick {
    public static int[] sort(int[] arr) {
        recSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void recSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i <= j) {
            if (arr[i] <= pivot) {
                i++;
            }else if (arr[j] >= pivot) {
                j--;
            }else if (arr[i] > pivot && arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        int temp = arr[j];
        arr[j] = arr[start];
        arr[start] = temp;

        recSort(arr, start, j-1);
        recSort(arr, j+1, end);

        return;
    }
}
