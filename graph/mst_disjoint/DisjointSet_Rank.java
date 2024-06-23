package graph.mst_disjoint;

/*
 * Disjoint Set | Union by Rank | Path Compression
 * 
 * In this article, we will discuss the Disjoint Set data structure which is a very important topic in the entire graph series. Let’s first understand why we need a Disjoint Set data structure using the below question:
Question: Given two components of an undirected graph

edges = {{1,2}, {2,3}, {4,5}, {6,7}, {5,6}, {3,7}}

 */

public class DisjointSet_Rank {
    public int[] parents;
    public int[] rank;

    public DisjointSet_Rank(int v) {
        parents = new int[v+1];
        rank = new int[v+1];
        for(int i = 0; i < v+1; i++) {
            parents[i] = i;
            rank[i] = 0;
        }
    }

    public int getUParent(int node) {
        if(parents[node] == node) {
            return node;
        }

        int parent = getUParent(parents[node]);
        parents[node] = parent;
        return parent;
    }

    public void unionByRank(int u, int v) {
        int uParent = getUParent(u);
        int vParent = getUParent(v);

        if(vParent == uParent) {
            return;
        }

        if(rank[uParent] == rank[vParent]) {
            parents[vParent] = uParent;
            rank[uParent]++;
        }else if(rank[uParent] < rank[vParent]) {
            parents[uParent] = vParent;
        }else {
            parents[vParent] = uParent;
        }
    }

    public static void test() {
        DisjointSet_Rank ds = new DisjointSet_Rank(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.getUParent(3) == ds.getUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.getUParent(3) == ds.getUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
