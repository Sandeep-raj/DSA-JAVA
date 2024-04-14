package basic.hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array, we have found the number of occurrences of each element in the array.

Examples:

Example 1:
Input: arr[] = {10,5,10,15,10,5};
Output: 10  3
	 5  2
        15  1
Explanation: 10 occurs 3 times in the array
	      5 occurs 2 times in the array
              15 occurs 1 time in the array

Example2: 
Input: arr[] = {2,2,3,4,4,2};
Output: 2  3
	3  1
        4  2
Explanation: 2 occurs 3 times in the array
	     3 occurs 1 time in the array
             4 occurs 2 time in the array
 */

public class CntFrq {
    public static void count(int[] inpArr) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < inpArr.length; i++) {
            if (map.containsKey(inpArr[i])) {
                map.put(inpArr[i], map.get(inpArr[i]) + 1);
            }else {
                map.put(inpArr[i], 1);
            }
        }


       for (Map.Entry<Integer ,Integer> entries : map.entrySet()) {
        System.out.println(entries.getKey() + "  " + entries.getValue());
       }
    }

    public static void getExtreme(int[] inpArr) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < inpArr.length; i++) {
            if (map.containsKey(inpArr[i])) {
                map.put(inpArr[i], map.get(inpArr[i]) + 1);
            }else {
                map.put(inpArr[i], 1);
            }
        }

        Map.Entry<Integer,Integer> max =  Map.entry(0, -1);
        Map.Entry<Integer,Integer> min =  Map.entry(0, 10000);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > max.getValue()) {
                max = entry;
            }

            if (entry.getValue() < min.getValue()) {
                min = entry;
            }
        }

        System.out.println("Max : " + max.getKey() + "  " + max.getValue());
        System.out.println("Min : " + min.getKey() + "  " + min.getValue());
    }
}
