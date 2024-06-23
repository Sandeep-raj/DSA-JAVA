package graph.topologicalSort;

import java.util.ArrayList;

/*
 * Course Schedule
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */

public class CourseSchedule {
    public static boolean schedule(int numOfCourse, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numOfCourse];
        for(int i = 0;i < prerequisites.length; i++) {
            if(adjList[prerequisites[i][1]] == null) {
                adjList[prerequisites[i][1]] = new ArrayList<Integer>();
            }

            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int[] indegree = new int[numOfCourse];
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        ArrayList<Integer> q = new ArrayList<>();
        for(int i =0;i < indegree.length;i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        while (q.size() > 0) {
            int node = q.remove(0);
            count++;

            if(adjList[node] != null) {
                for (int x : adjList[node]) {
                    if(indegree[x] > 0) {
                        indegree[x]--;
    
                        if(indegree[x] == 0){
                            q.add(x);
                        }
                    }
                }
            }
        }

        return count == numOfCourse;
    }
}
