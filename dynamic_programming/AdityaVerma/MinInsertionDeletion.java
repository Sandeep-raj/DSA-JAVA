package dynamic_programming.AdityaVerma;

/*
 * Minimum number of deletions and insertions to transform one string into another
 * 
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted at some another point.
 * 
 * Input : 
str1 = "heap", str2 = "pea" 
Output : 
Minimum Deletion = 2 and
Minimum Insertion = 1
Explanation:
p and h deleted from heap
Then, p is inserted at the beginning
One thing to note, though p was required yet
it was removed/deleted first from its position and
then it is inserted to some other position.
Thus, p contributes one to the deletion_count
and one to the insertion_count.

Input : 
str1 = "geeksforgeeks", str2 = "geeks"
Output : 
Minimum Deletion = 8
Minimum Insertion = 0       
 */

public class MinInsertionDeletion {
    public static int[] minInsertDeletion(String s1, String s2) {
        int lcs = LongestCommonSubsequence.lcs(s1, s2);
        int n = s1.length(), m = s2.length();

        return new int[]{m - lcs, n - lcs};
    }
}
