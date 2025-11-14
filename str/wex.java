// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        System.out.println(mws("a", "aa"));
        System.out.println(wjp(2,6,5));
        System.out.println(mf(new int[]{2, 4, 9}, 3));
    }
    
    static String mws(String str1, String str2) {
        HashMap<Character, Integer> map2 = new HashMap();
        char[] c2 = str2.toCharArray();
        
        for(int i = 0; i < c2.length; i++) {
            if(map2.containsKey(c2[i])) {
                map2.put(c2[i], map2.get(c2[i]) + 1);
            }else {
                map2.put(c2[i], 1);
            }
        }
        
        char[] c1 = str1.toCharArray();
        int start = 0, end = 0, count = c2.length, minlen = Integer.MAX_VALUE;
        String res = "";
        
        // HashMap<Character, Integer> map2 = new HashMap();
        while(end < c1.length) {
            char t = c1[end];
            
            if(!map2.containsKey(t)) {
                map2.put(t, -1);
            }else {
                map2.put(t, map2.get(t) - 1);
                
                if(map2.get(t) >= 0) {
                    count--;
                }
                
                if(count == 0) {
                    while(start <= end) {
                        char t2 = c1[start];
                        if(map2.get(t2) < 0) {
                            map2.put(t2, map2.get(t2) + 1);
                            start++;
                        }else {
                            break;
                        }
                    }
                    
                    if(minlen > end - start + 1) {
                        res = str1.substring(start, end+1);
                        minlen = end - start + 1;
                    }
                }
            }
            
            end++;
        }
        
        return res;
    }
    
    static boolean wjp(int x, int y, int target) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet();
        
        q.add(0);
        set.add(0);
        
        while(q.size() > 0) {
            int curr = q.remove(0); 
            if(curr == target) {
                return true;
            }
            
            int val = curr + x;
            if(val < x + y && val > 0 && !set.contains(val)) {
                q.add(val);
                set.add(val);
            }
            
            val = curr - x;
            if(val < x + y && val > 0 && !set.contains(val)) {
                q.add(val);
                set.add(val);
            }
            
            val = curr - y;
            if(val < x + y && val > 0 && !set.contains(val)) {
                q.add(val);
                set.add(val);
            }
            
            val = curr + y;
            if(val < x + y && val > 0 && !set.contains(val)) {
                q.add(val);
                set.add(val);
            }
        }
        
        return false;
    }
    
    static int mf(int[] arr, int ops) {
        Arrays.sort(arr);
        
        int start = 0, end = 0, sum = 0;
        int max = Integer.MIN_VALUE;
        
        while(end < arr.length) {
            sum += arr[end];
            int l = end - start + 1;
            
            while(start <= end && l*arr[end] - sum > ops) {
                sum -= arr[start];
                start++;
            }
            
            max = Math.max(max, end - start + 1);
            end++;
        }
        
        return max;
    }
    
    
    
}
