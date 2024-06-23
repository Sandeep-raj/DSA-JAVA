package graph.bfs_dfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import graph.learn.Representaion.Node;

/*
 * Number of Provinces
 * 
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */

public class NumberofProvinces {
    public static int num(int[][] mtx) {
        int vertex = mtx.length;
        int edge = 0;
        ArrayList<int[]> edgesArr = new ArrayList<>();

        for(int i = 0; i < mtx.length; i++) {
            for(int j = 0; j < mtx.length; j++) {
                if(mtx[i][j] == 1) {
                    edge++;
                    edgesArr.add(new int[]{i,j});
                }
            }
        }

        int[][] edges = edgesArr.toArray(new int[edgesArr.size()][]);
        LinkedList<Node>[] adjList = graph.learn.Representaion.adjList(edges, vertex, edge, false);
        boolean[] visited = new boolean[vertex];

        int provinces = 1;
        Stack<Integer> dfs = new Stack<>();
        dfs.push(0);
        visited[0] = true; 

        while(true) {
            while (!dfs.isEmpty()) {
                int curr = dfs.pop();

                Iterator<Node> itr = adjList[curr].iterator();
                while (itr.hasNext()) {
                    Node n = itr.next();
                    if(!visited[n.node]) {
                        dfs.push(n.node);
                        visited[n.node] = true;
                    }
                }
            }

            int idx = -1;
            for(int i = 0; i < visited.length; i++) {
                if(!visited[i]) {
                    idx = i;
                    break;
                }
            }

            if(idx == -1) {
                break;
            }else {
                provinces++;
                dfs.push(idx);
                visited[idx] = true;
            }
        }

        return provinces;
        
    }

    public static int numAlt(int[][] mtx) {
        boolean[] visited = new boolean[mtx.length];

        int province = 0;
        int idx = -1;
        
        while (true) {
            idx = -1;
            for(int i = 0 ; i < visited.length; i++) {
                if(!visited[i]) {
                    idx = i;
                    break;
                }
            }

            if(idx == -1) {
                break;
            }else {
                province++;
                dfs(mtx, visited, idx);
            }
        }
        

        return province;
    }

    static void dfs(int[][] mtx, boolean[] visited, int idx) {
        ArrayList<Integer> dfs = new ArrayList<Integer>();
        dfs.add(idx);
        visited[idx] = true;

        while (dfs.size() > 0) {
            int curr = dfs.remove(0);

            for(int i = 0; i < mtx[curr].length; i++) {
                if(mtx[curr][i] == 1 && !visited[i]) {
                    dfs.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
