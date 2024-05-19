package heap.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Task Scheduler
 * 
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
 * 
 * Return the minimum number of intervals required to complete all tasks.
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.


Input: tasks = ["A","C","A","B","D","B"], n = 1
Output: 6
Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
With a cooling interval of 1, you can repeat a task after just one other task.


Input: tasks = ["A","A","A", "B","B","B"], n = 3
Output: 10
Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.



Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100
 */

public class TaskScheduler {
    public static int taskScheduler(char[] tasks, int coolingTime) {
        // Priority Queue Approach
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        // int[] map = new int[26];
        // for (char c : tasks) {
        // map[c - 'A']++;
        // }

        // for (int i = 0; i < 26; i++) {
        // if (map[i] > 0) {
        // pq.add(map[i]);
        // }
        // }

        // int time = 0;
        // while (pq.size() > 0) {
        // int[] q = new int[coolingTime+1];
        // int cnt = 0;
        // for(int i = 0; i <= coolingTime; i++) {
        // if(pq.size() > 0) {
        // time++;
        // int task = pq.remove();
        // task--;
        // if(task > 0) {
        // q[cnt] = task;
        // cnt++;
        // }
        // }else {
        // if(cnt > 0 ) {
        // time++;
        // }else {
        // break;
        // }
        // }
        // }

        // for(int i = 0; i < cnt; i++) {
        // pq.add(q[i]);
        // }
        // }

        // return time;


        


        // Greedy Algorithm (O(nlogn))
        // int[] map = new int[26];
        // for (char c : tasks) {
        //     map[c - 'A']++;
        // }

        // Arrays.sort(map);

        // int max = map[25];
        // int idleLeft = (max - 1) * coolingTime;

        // for (int i = 24; i >= 0; i--) {
        //     if (map[i] == 0) {
        //         break;
        //     }

        //     idleLeft -= Math.min(map[i] , max - 1);
        // }

        // if(idleLeft > 0) {
        //     return tasks.length + idleLeft;
        // }else {
        //     return tasks.length;
        // }




        // Greedy Algorithm Without Sort (O(n))
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }

        int max = 0, numOfMax = 0;
        for(int i = 0; i < 26; i++) {
            if(map[i] == 0) continue;

            if(map[i] > max){
                max = map[i];
                numOfMax = 1;
            }else if(map[i] == max) {
                numOfMax++;
            }
        }

        int spaces = (max-1)*coolingTime + max + (numOfMax-1);
        return tasks.length > spaces ? tasks.length : spaces;
    }
}
