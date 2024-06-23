package graph.mst_disjoint;

/*
 * Number of Islands - II - Online Queries
 * 
 * Problem Statement: You are given an n, m which means the row and column of the 2D matrix, and an array of size k denoting the number of operations. Matrix elements are 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integers A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many islands are there in the matrix after each operation. You need to return an array of size k.
 * 
 * 
 * Input Format: n = 4 m = 5 k = 4 A = {{1,1},{0,1},{3,3},{3,4}} Output: 1 1 2 2 Explanation: The following illustration is the representation of the operation:

Example 2:
Input Format: n = 4 m = 5 k = 12 A = {{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2}} Output: 1 1 2 1 1 2 2 2 3 3 1 1 Explanation: If we follow the process like in example 1, we will get the above result.
 */

public class NumberofIslandsII {
    public static int[] number(int n, int m, int k, int[][] queries) {
        boolean[][] visited = new boolean[n][m];
        DisjointSet_Size ds = new DisjointSet_Size(n*m);
        int count = 0;

        int[] result = new int[k];
        for(int i = 0 ; i < k; i++) {
            int x = queries[i][0], y = queries[i][1];
            if(!visited[x][y]) {
                count++;
                visited[x][y] = true;
                int node = x*m + y;
                if(x - 1 >= 0 && visited[x-1][y]) {
                    int temp = (x-1)*m + y;
                    if(ds.getUParent(node) != ds.getUParent(temp)) {
                        ds.unionBySize(node, temp);
                        count--;
                    }
                }
                if(x + 1 < n && visited[x+1][y]) {
                    int temp = (x+1)*m + y;
                    if(ds.getUParent(node) != ds.getUParent(temp)) {
                        ds.unionBySize(node, temp);
                        count--;
                    }
                }
                if(y - 1 >= 0 && visited[x][y - 1]) {
                    int temp = (x)*m + y-1;
                    if(ds.getUParent(node) != ds.getUParent(temp)) {
                        ds.unionBySize(node, temp);
                        count--;
                    }
                }
                if(y + 1 < m && visited[x][y+1]) {
                    int temp = (x)*m + y+1;
                    if(ds.getUParent(node) != ds.getUParent(temp)) {
                        ds.unionBySize(node, temp);
                        count--;
                    }
                }
            }

            result[i] = count;
        }

        return result;
    }
}
