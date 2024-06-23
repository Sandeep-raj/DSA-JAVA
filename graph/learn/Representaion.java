package graph.learn;

import java.util.Iterator;
import java.util.LinkedList;

public class Representaion {
    public static int[][] adjMtx(int[][] edges, int vertex, int edge, boolean bidirectional) {
        int[][] mtx = new int[vertex + 1][vertex + 1];

        for(int i = 0; i < edge; i++) {
            if(edges[i].length == 3) {
                mtx[edges[i][0]][edges[i][1]] = edges[i][2];
                if(bidirectional) {
                    mtx[edges[i][1]][edges[i][0]] = edges[i][2];
                }
            }else {
                mtx[edges[i][0]][edges[i][1]] = 1;
                if(bidirectional) {
                    mtx[edges[i][1]][edges[i][0]] = 1;
                }
            }
        }

        return mtx;
    }

    public static class Node {
        public int node;
        public int weight;

        public Node(int node, int wt) {
            this.node = node;
            this.weight = wt;
        }
    }

    public static LinkedList<Node>[] adjList(int[][] edges, int vertex, int edge, boolean bidirectional) {
        LinkedList<Node>[] lists = new LinkedList[vertex+1];
        for(int i = 0; i < vertex+1; i++) {
            lists[i] = new LinkedList<Node>();
        }

        for(int i = 0; i < edge; i++) {
            Node n = null;
            if(edges[i].length == 3){
                n = new Node(edges[i][1], edges[i][2]);
            }else {
                n = new Node(edges[i][1], 1);
            }
            lists[edges[i][0]].add(n);

            if(bidirectional) {
                Node n2 = null;
                if(edges[i].length == 3){
                    n2 = new Node(edges[i][0], edges[i][2]);
                }else {
                    n2 = new Node(edges[i][0], 1);
                }
                lists[edges[i][1]].add(n2);
            }
        }

        return lists;
    }

    public static void printAdjMtx(int[][] adjMtx) {
        for(int i = 0; i < adjMtx.length; i++) {
            for(int j = 0; j < adjMtx[i].length; j++) {
                System.out.print(adjMtx[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public static void printAdjList(LinkedList<Node>[] adjList) {
        for(int i = 0 ; i < adjList.length; i++) {
            System.out.print("Node " + i + "  --> [ ");
            Iterator<Node> itr = adjList[i].iterator();
            while (itr.hasNext()) {
                Node n = itr.next();
                System.out.print(n.node+" - "+n.weight + "  |  ");
            }
            System.out.println("]");
        }
    }

    public static void test() {
        int vertex = 5;
        int edge = 6;
        int[][] edges = new int[][]{{1,2}, {1,3}, {2,4},{3,4},{3,5},{4,5}};

        int[][] result = adjMtx(edges, vertex, edge, true);
        printAdjMtx(result);

        LinkedList<Node>[] listresult = adjList(edges, vertex, edge, true);
        printAdjList(listresult);
    }
}
