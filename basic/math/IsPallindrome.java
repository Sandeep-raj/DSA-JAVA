package basic.math;

public class IsPallindrome {
    public static String check(int num) {
        int revnum = Rev_Number.rev(num);
        if (revnum == num ){
            return "Pallindrome";
        }
        return "Not Pallindrome";
    }
}
