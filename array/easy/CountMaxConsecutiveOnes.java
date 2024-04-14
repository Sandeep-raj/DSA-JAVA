package array.easy;

public class CountMaxConsecutiveOnes {
    public static int count(int[] arr) {
        int cnt = 0;
        int maxcnt = 0;
        for (int i =0; i < arr.length; i++) {
            if(arr[i] == 1) {
                cnt++;
            }else {
                if (maxcnt < cnt) {
                    maxcnt = cnt;
                }
                cnt = 0;
            }
        }

        if (maxcnt < cnt) {
            maxcnt = cnt;
        }
        return maxcnt;
    }
}
