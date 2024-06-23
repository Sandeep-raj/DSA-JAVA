package graph.mst_disjoint;

/*
 * Disjoint Set | Union by Rank | Union by Size | Path Compression: G-46

In this article, we will discuss the Disjoint Set data structure which is a very important topic in the entire graph series. Let’s first understand why we need a Disjoint Set data structure using the below question:
Question: Given two components of an undirected graph
The question is whether node 1 and node 5 are in the same component or not.

Edges -> {{1,2}, {2,3}, {4,5}, {6,7}, {5,6}, {3,7}}
 */

public class DisjointSet_Size {
    public int[] parents;
    public int[] size;

    public DisjointSet_Size(int v) {
        parents = new int[v+1];
        size = new int[v+1];
        for(int i = 0; i < v+1; i++) {
            parents[i] = i;
            size[i] = 1;
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

    public void unionBySize(int u, int v) {
        int uParent = getUParent(u);
        int vParent = getUParent(v);

        if(vParent == uParent) {
            return;
        }

        if(size[uParent] == size[vParent]) {
            parents[vParent] = uParent;
            size[uParent] += size[vParent];
        }else if(size[uParent] > size[vParent]) {
            parents[vParent] = uParent;
            size[uParent] += size[vParent];
        }else {
            parents[uParent] = vParent;
            size[vParent] += size[uParent];
        }
    }

    public static void test() {
        DisjointSet_Size ds = new DisjointSet_Size(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.getUParent(3) == ds.getUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.getUParent(3) == ds.getUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

