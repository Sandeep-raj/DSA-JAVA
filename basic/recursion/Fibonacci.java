package basic.recursion;

public class Fibonacci {
    public static int print(int num) {
        return printRec(num);
    }

    static int printRec(int num) {
       if (num <= 1) {
        return num;
       }

       int res = printRec(num - 2) + printRec(num - 1);
       // System.out.println(num + " " + res);
       return res;
    }
}
