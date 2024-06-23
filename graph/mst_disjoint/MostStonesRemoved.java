package graph.mst_disjoint;

import java.util.HashSet;

/*
 * Most Stones Removed with Same Row or Column
 * 
 * There are n stones at some integer coordinate points on a 2D plane. Each coordinate point may have at most one stone.
You need to remove some stones. 
A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Given an array of stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the maximum possible number of stones that you can remove.

Input Format: n=6  stones = [[0, 0],[ 0, 1], [1, 0],[1, 2],[2, 1],[2, 2]]
Result: 5
Explanation: One of the many ways to remove 5 stones is to remove the following stones:
[0,0], [1,0], [0,1], [2,1], [1,2]


Input Format: N = 6, stones = {{0, 0}, {0, 2},  {1, 3}, {3, 1}, {3, 2}, {4, 3}};
Result: 4
Explanation: We can remove the following stones:
[0,0], [0,2], [1,3], [3,1]
 */

public class MostStonesRemoved {
    static class DisjointSet {
        int[] parents;
        int[] size;

        public DisjointSet(int v) {
            parents = new int[v + 1];
            size = new int[v + 1];

            for(int i = 0; i < v + 1; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int getParent(int node) {
            if(node == this.parents[node]) {
                return node;
            }

            int parent = getParent(parents[node]);
            this.parents[node] = parent;
            return parent;
        }

        public void union(int u, int v) {
            int uParent = getParent(u);
            int vParent = getParent(v);

            if(uParent == vParent) {
                return;
            }

            if(this.size[uParent] > this.size[vParent]) {
                this.parents[vParent] = uParent;
                this.size[vParent] += this.size[uParent];
            }else {
                this.parents[uParent] = vParent;
                this.size[uParent] += this.size[vParent];
            }
        }
    }
    public static int remove(int n, int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashSet<Integer> uniqNodes = new HashSet<>();
        for(int[] stone : stones) {
            int uNode = stone[0];
            int vNode = stone[1] + maxRow + 1;

            ds.union(uNode, vNode);
            uniqNodes.add(uNode);
            uniqNodes.add(vNode);
        }

        HashSet<Integer> uniqParents = new HashSet<>();
        int uniqCounts = 0;
        for(int node : uniqNodes) {
            int parent = ds.getParent(node);
            if(!uniqParents.contains(parent)) {
                uniqCounts++;
                uniqParents.add(parent);
            }
        }

        return n - uniqCounts;
    }
}
