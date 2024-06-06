package binary_tree.utils;

import java.util.ArrayList;

public class Create {
    public static class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int k) {
            this.key = k;
        }

        public int getKey() {
            return this.key;
        }
    }

    public static Node createBinTree(int[] arr) {
        Node[] nodes = new Node[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != -1) {
                nodes[i] = new Node(arr[i]);
            }else {
                nodes[i] = null;
            }
        }

        ArrayList<Node> q = new ArrayList<Node>();
        q.add(nodes[0]);
        int cnt = 0;

        while (!q.isEmpty()) {
            Node n = q.remove(0);
            cnt++;
            if(cnt < arr.length) {
                Node l = nodes[cnt];
                if(l != null) {
                    n.left = l;
                    q.add(l);
                }
            }

            cnt++;
            if(cnt < arr.length) {
                Node r = nodes[cnt];
                if(r != null) {
                    n.right = r;
                    q.add(r);
                }
            }
        }

        return nodes[0];
    }

    public static String LvlTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Node> q = new ArrayList<>();
        ArrayList<Node> auxq = new ArrayList<>();

        if(root != null) {
            q.add(root);
            result.add(root.key);
        }
        
        while (!q.isEmpty()) {
            Node n = q.remove(0);

            if(n.left != null) {
                result.add(n.left.key);
                auxq.add(n.left);
            }else {
                result.add(-1);
            }

            if(n.right != null) {
                result.add(n.right.key);
                auxq.add(n.right);
            }else {
                result.add(-1);
            }

            if(q.isEmpty()) {
                q = auxq;
                auxq = new ArrayList<>();
            }
        }

        return result.toString();
    }
}
