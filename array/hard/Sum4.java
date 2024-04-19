package array.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 4 Sum | Find Quads that add up to a target value

Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.

Pre-req: 3-sum problem and 2-sum problem

Note:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
arr[a] + arr[b] + arr[c] + arr[d] == target

Examples
Example 1:
Input Format:
 arr[] = [1,0,-1,0,-2,2], target = 0
Result:
 [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Explanation:
 We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

Example 2:
Input Format:
 arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
Result:
 [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
Explanation:
 The sum of all the quadruplets is equal to the target i.e. 9.
 */

public class Sum4 {
    public static String find(int[] arr) {
        Arrays.sort(arr);
        
        int sum = 0;
        HashSet<String> set = new HashSet<String>();

        for (int i =0; i < arr.length-3; i++) {
            for (int j = i +1; j < arr.length - 2;j++) {
                int k = j+1, l = arr.length - 1;
                while (k < l) {
                    sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < 0) {
                        k++;
                    }else if(sum > 0) {
                        l--;
                    }else {
                        String data = "[ " + arr[i] + ", " + arr[j] + ", " + arr[k] + ", " + arr[l] + " ]";
                        if(!set.contains(data)) {
                            set.add(data);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        
        return set.toString();
    }
}
