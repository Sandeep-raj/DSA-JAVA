package graph.other;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Strongly Connected Components - Kosaraju's Algorithm
 * 
 * Problem Statement: Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 * 
 * Input Format:
 * edges: {{0,2}.{2,1},{1,0},{0,3},{3,4}}
Result: 3
Explanation: Three strongly connected components are marked below

Input Format:
edges: {{0,1},{1,2},{2,0},{2,3},{3,4},{4,5},{5,6},{6,4},{6,7},{4,7}}
Result: 4
 */

public class KosarajusAlgorithm {
    public static int stronglyConnectedComponents(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        boolean[] vis = new boolean[n+1];
        ArrayList<Integer> sortTimerNode = new ArrayList<>();

        for(int[] edge : edges) {
            if(adj[edge[0]] == null) {
                adj[edge[0]]  = new ArrayList<>();
            }
            adj[edge[0]].add(edge[1]);
        }

        LinkedList<Integer> sortList = new LinkedList<>();
        sortNodeByTimeIN(0, sortList, adj, vis);

        vis = new boolean[n+1];
        ArrayList<Integer>[] revAdj = new ArrayList[n+1];
        for(int i = 0; i <= n ;i++) {
            if(adj[i] != null) {
                for(int d : adj[i]) {
                    if(revAdj[d] == null) {
                        revAdj[d] = new ArrayList<>();
                    }
                    revAdj[d].add(i);
                }
            }
        }

        int count = 0;
        for(int x : sortList) {
            if(!vis[x]) {
                dfs(x, revAdj, vis);
                count++;
            }
        }

        return count;
    }

    static void dfs(int node, ArrayList<Integer>[] adj, boolean[] vis) {
        vis[node] = true;

        if(adj[node] != null) {
            for(int x : adj[node]) {
                if(!vis[x]) {
                    dfs(x, adj, vis);
                }
            }
        }
    }

    static void sortNodeByTimeIN(int node, LinkedList<Integer> sortList, ArrayList<Integer>[] adj, boolean[] vis) {
        vis[node] = true;

        if(adj[node] != null) {
            for(int x : adj[node]) {
                if(!vis[x]) {
                    sortNodeByTimeIN(x, sortList, adj, vis);
                }
            }
        }
        sortList.addFirst(node);
    }
}
