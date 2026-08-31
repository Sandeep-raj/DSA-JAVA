// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

/*
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
class Node {
    public int val;
    public List<Node> neighbors;
}
 
Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
*/

class Node {
    public int val;
    public ArrayList<Node> neighbour;

    public Node(int v) {
        this.val = v;
        this.neighbour = new ArrayList<Node>();
    }

    public void addN(Node n) {
        this.neighbour.add(n);
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        solve();
    }

    static void solve() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.addN(n2);
        n2.addN(n1);
        n2.addN(n3);
        n3.addN(n2);
        n3.addN(n4);
        n4.addN(n3);
        n4.addN(n1);
        n1.addN(n4);

        cloneGraph(n1);
    }

    static void cloneGraph(Node n) {
        HashMap<Integer, Node> map = new HashMap();
        Node nn = new Node(n.val);
        map.put(n.val, nn);

        clone(n,nn, map);

        // display nodes
        map.forEach((k,v) -> {
            System.out.print("Node val " + v.val + " with neighbours ");
            for(Node x : v.neighbour) {
                System.out.print(" " + x.val);
            }
            System.out.println("");
        });
    }

    static void clone(Node o, Node n, HashMap<Integer, Node> map) {
        for(Node x : o.neighbour) {
            if(map.containsKey(x.val)) {
                n.addN(map.get(x.val));
            }else {
                Node next = new Node(x.val);
                map.put(x.val, next);
                n.addN(next);
                clone(x, next, map);
            }
        }
    }
}
