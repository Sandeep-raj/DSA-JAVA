import java.util.*;

/*
Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 

Example 1:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true
Example 2:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false
Example 3:

Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true
 

Constraints:

p1.length == p2.length == p3.length == p4.length == 2
-104 <= xi, yi <= 104
*/

class Main {
    public static void main(String[] args) {
        // p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
        validateSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1});
    }

        static boolean validateSquare(int[] a, int[] b, int[] c, int[] d) {
        HashMap<Double, Integer> map = new HashMap();
        int[][] pts = new int[][]{a,b,c,d};

        for(int i = 0 ; i < pts.length - 1; i++) {
            for(int j = i + 1; j < pts.length; j++) {
                double dis = getDistance(pts[i], pts[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
        }

        if(map.size() != 2) {
            System.out.println("not valid");
            return false;
        }
        double[] side = {0}, dia = {0};
        map.forEach((k,v) -> {
            System.out.println(k + " " + v);
            if(v == 4) {
                side[0] = k;
            }else {
                dia[0] = k;
            }
        });

        if(dia[0] != (Math.sqrt(2) * side[0])) {
            System.out.println("not valid");
            return false;
        }

        System.out.println("valid");
        return true;
    }

    static double getDistance(int[] x, int[] y) {
        double h2 = Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1] , 2);
        return Math.sqrt(h2);
    }
}
