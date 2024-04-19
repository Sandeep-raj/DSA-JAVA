import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Basic Math
        // int result = basic.math.Count_Digit.count(123456);
        // int result = basic.math.Rev_Number.rev(123);
        // String result = basic.math.IsPallindrome.check(1321);
        // int result = basic.math.GCD.find_opti(36,78);
        // String result = basic.math.IsArmstrong.check(153);
        // ArrayList<Integer> result =  basic.math.PrintDivisors.print(154);
        //  Boolean result =  basic.math.IsPrime.check(7);


        // Basic Recursion
        // int result =  basic.recursion.Factorial.print(5);
        // int[] result = basic.recursion.RevArray.rev(new int[]{1,2,3,4,5});
        // String result =  basic.recursion.IsPallindrome.check("axxa");
        // int result = basic.recursion.Fibonacci.print(5);
        // basic.hashing.CntFrq.getExtreme(new int[]{1,2,3,2,1,5,1,2,3,4,5,2});
        // int[] result = basic.sorting.Selection.sort(new int[]{2,1,4,7,3,0,9,7});
        // int[] result = basic.sorting.Bubble.sort(new int[]{2,1,4,7,3,0,9,7});
        // int[] result = basic.sorting.Insertion.sort(new int[]{2,1,4,7,3,0,9,7});
        // int[] result = basic.sorting.Merge.sort(new int[]{2,1,4,7,3,0,9,7});
        // int[] result = basic.sorting.Bubble.recSort(new int[]{2,1,4,7,3,0,9,7}, 7);
        // int[] result = basic.sorting.Selection.recSort(new int[]{2,1,4,7,3,0,9,7}, 7);
        // int[] result = basic.sorting.Quick.sort(new int[]{2,1,4,7,3,0,9,7});

        // Arrays
        // int result = array.easy.LargestElement.solve(new int[]{2,1,4,7,3,0,9,7});
        // int[] result = array.easy.SecondSmallestAndLargest.solve(new int[]{2,1,4,7,3,0,9,7});
        // boolean result = array.easy.CheckSorted.isSorted(new int[]{1,1,2,3,5});
        // int[] result = array.easy.RemoveDups.removeDups(new int[]{1,1,2,2,2,3,3,4});
        // int[] result = array.easy.RotateArray.rotate(new int[]{1,1,2,2,2,3,3,4}, 3,"right");
        // int[] result = array.easy.MoveZerosToEnd.move(new int[]{1,2,0,0,0,0,0,1,0,4,0});
        // int[] result = array.easy.Union2SortedArray.union(new int[]{1,2,3,4,5,6,7,8,9,10}, new int[]{2,3,4,4,5,11,12});
        // int result = array.easy.FindMissinNumber.find(new int[]{1,2,4,5});
        // int result = array.easy.CountMaxConsecutiveOnes.count(new int[]{1, 1, 0, 1, 1, 1});
        // int result = array.easy.FindSingleOne.find(new int[]{4,1,2,1,2});
        // int result = array.easy.LongestArrayWithSumK.findLen(new int[]{-1, 1, 1}, 1);
        // int[] result = array.medium.TwoSum.find(new int[]{2,6,5,8,11}, 14);
        // int[] result = array.medium.Sort012Array.sort(new int[]{2,0,2,1,1,0});
        // int result = array.medium.MajorityElement.find(new int[]{2,2,1,1,1,2,2});
        // int result = array.medium.Kadanes.maxVal(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        // int result = array.medium.StockBuyAndSell.findMax(new int[] {7,1,5,3,6,4});
       //  int[] result = array.medium.RearrangeArrayBySign.rearrange(new int[]{1,2,-3,-1,-2,-3});
       // int[] result = array.medium.NextPermutation.next(new int[]{2,1,5,4,3,0,0});
       // int[] result = array.medium.LeadersInArray.leaders(new int[]{4, 7, 1, 0});
       // int result = array.medium.LongestConsecutive.longestConsecutive(new int[]{100, 200, 1, 3, 2, 4});
       // int[][] result = array.medium.SetMat0.setZeros(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
       // int[][] result = array.medium.Rotate90deg.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    //    array.medium.SpiralTraversalMatrx.traverse(new int[][]{{ 1, 2, 3, 4 },
    //    { 5, 6, 7, 8 },
    //    { 9, 10, 11, 12 },
    //        { 13, 14, 15, 16 }});
    // int result = array.medium.SubarraySumEqualK.count(new int[]{3, -1, -2, 4}, 4);
    // array.hard.PascalsTriangle.print(7, 3);
    // int result = array.hard.MajorityElement.majority(new int[]{2,1,1,3,1,4,5,6});
    // String result = array.hard.Sum3.find(new int[]{-1,0,1,2,-1,-4});
    // String result = array.hard.Sum4.find(new int[]{1,0,-1,0,-2,2});
    // int result = array.hard.LongestLengthSubArray.findLongest(new int[] {1, 3, -5, 6, -2});
    // int result = array.hard.CountSubArrayXORK.count(new int[]{4, 2, 2, 6, 4}, 6);
    // String result = array.hard.MergeOverlapping.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    // int[][] result = array.hard.Merge2SortedArray.merge(new int[]{1,4,8,10}, new int[]{2,3,9});
    // int[] result = array.hard.FindRepeatingAndMissingNumbers.find(new int[]{3,1,2,5,4,6,7,5});
    // int result = array.hard.CountInversions.count(new int[]{5,4,3,2,1});
    // int result = array.hard.CountReverse.count(new int[]{3,2,1,4});
    int result = array.hard.MaximumProductSubArray.max(new int[]{1,2,3,4,5,0});
    System.out.println(result);
    }
}