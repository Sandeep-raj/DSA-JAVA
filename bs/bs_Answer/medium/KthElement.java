package bs.bs_Answer.medium;

/*
 * K-th Element of two sorted arrays
 * 
 * Problem Statement: Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the kth position of the final sorted array.
 * 
 * Input: m = 5
       n = 4
       array1 = [2,3,6,7,9]
       array2 = [1,4,8,10]
       k = 5

Output:
 6

Explanation: Merging both arrays and sorted. Final array will be -
 [1,2,3,4,6,7,8,9,10]
We can see at k = 5 in the final array has 6. 


Input:
 m = 1
       n = 4
       array1 = [0]
       array2 = [1,4,8,10]
       k = 2

Output:
 4

Explanation:
 Merging both arrays and sorted. Final array will be -
 [1,4,8,10]
We can see at k = 2 in the final array has 4






Intuition :

It is mentioned that given arrays are sorted. This gives us some hints to use binary search in them.

If we look into the final merged sorted array.



We can part it in such a way that our kth element will be at the end of the left half array. Let’s make some observations. The left portion of the array is made of some elements of both array1 and array2. We can see that all elements of the right half of the array are always larger than the left ones. So, with help of binary search, we will divide arrays into partitions with keeping k elements in the left half. We have to keep in mind that l1 <= r2 and l2 <= r1. Why so? This ensures that left-half elements are always lesser than right elements.

Approach :

Apply binary search in an array with a small size. Start iterating with two pointers, say left and right. Find the middle of the range. Take elements from low to middle of array1 and the remaining elements from the second array. Then using the condition mentioned above, check if the left half is valid. If valid, print the maximum of both array's last element. If not, move the range towards the right if l2 > r1, else move the range towards the left if l1 > r2.
 */

public class KthElement {
    public static int kthElement(int[] arr1, int[] arr2, int k) {
        int[] biggerArr,smallerArr;
        if(arr1.length > arr2.length) {
            biggerArr = arr1;
            smallerArr = arr2;
        }else {
            biggerArr = arr2;
            smallerArr = arr1;
        }

        int start = 0, end = (k < smallerArr.length ? k : smallerArr.length);

        while (start <= end) {
            int mid1 = (start+end)/2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 - 1 >= 0) {
                l1 = smallerArr[mid1 - 1];
            }
            if(mid1 < smallerArr.length) {
                r1 = smallerArr[mid1];
            }
            if (mid2 - 1 >= 0) {
                l2 = biggerArr[mid2 - 1];
            }
            if(mid2 < biggerArr.length) {
                r2 = biggerArr[mid2];
            }

            if(l1 > r2) {
                end = mid1 - 1;
            }else if (l2 > r1) {
                start = mid1 + 1;
            }else if(l1 < r2 && l2 < r1) {
                return Math.max(l1, l2);
            }
        }
        return -1;
    }
}
