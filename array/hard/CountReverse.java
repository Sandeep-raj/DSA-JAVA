package array.hard;

import java.util.Arrays;

/*
 * Count Reverse Pairs
Problem Statement: Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Examples
Example 1:
Input:
 N = 5, array[] = {1,3,2,3,1)

Output
: 2 

Explanation:
 The pairs are (3, 1) and (3, 1) as from both the pairs the condition arr[i] > 2*arr[j] is satisfied.

Example 2:
Input:
 N = 4, array[] = {3,2,1,4}

Output:
 1

Explaination: 
There is only 1 pair  ( 3 , 1 ) that satisfy the condition arr[i] > 2*arr[j]
 */

public class CountReverse {
    static int Count = 0;
    public static int count(int[] arr) {
        int[] result = mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));
        return Count;
    }

    static int[] mergeSort(int[] arr, int start, int end) {
        if(start == end) {
            return new int[]{arr[start]};
        }

        int mid = (start + end) /2;

        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid+1, end);

        return insertionSort(left, right);
    }

    static int[] insertionSort(int[] arr1 , int[] arr2) {
        int i = 0, j = 0;
        int cnt = 0;
        int[] temp = new int[arr1.length + arr2.length];

        // put your logic
        int loclCnt = 0;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] > 2 * arr2[j]) {
                loclCnt += 1;
                j++;
            }else {
                if(arr1[i] > 2*arr2[j]) {
                    loclCnt *= 2;
                }
                i++;
            }
        }
        Count += loclCnt;

        i = 0; j = 0;

        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                temp[cnt] = arr1[i];
                i++;
            }else {
                temp[cnt] = arr2[j];
                j++;
            }
            cnt++;
        }


        while (i < arr1.length) {
            temp[cnt] = arr1[i];
                i++;
                cnt++;
        }

        while (j < arr2.length) {
            temp[cnt] = arr2[j];
                j++;
                cnt++;
        }

        return temp;
    }
}
