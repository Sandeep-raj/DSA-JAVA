package binary_tree.hard;

import java.util.ArrayList;

import binary_tree.utils.Create;
import binary_tree.utils.Create.Node;

/*
 * Serialize And Deserialize a Binary Tree
 * 
 * Problem Statement: Given a Binary Tree, design an algorithm to serialise and deserialise it. There is no restriction on how the serialisation and deserialization takes place. But it needs to be ensured that the serialised binary tree can be deserialized to the original tree structure. Serialisation is the process of translating a data structure or object state into a format that can be stored or transmitted (for example, across a computer network) and reconstructed later. The opposite operation, that is, extracting a data structure from stored information, is deserialization.
 * 
 * Example 1:
Input:Binary Tree: 1 2 3 -1 -1 4 5
Output:After Serialisation: 1,2,3,#,#,4,5,#,#,#,#, After Deserialization: (Original Tree Back)
Explanation:  Any algorithm that compresses this binary tree to a string which can be transmitted and from which the binary tree can be reconstructed later can be used.
				Here we have used a serialisation algorithm based on level order traversal where comma separates the nodes and # denotes null nodes.


Example 2:
Input:Binary Tree: 1 2 3 -1 4 5 -1
Output :After Serialisation: 1,2,3,#,4,5,#, After Deserialization: (Original Tree Back)
Explanation:  Any algorithm that compresses this binary tree to a string which can be transmitted and from which the binary tree can be reconstructed later can be used.
				Here we have used a serialisation algorithm based on level order traversal where comma separates the nodes and # denotes null nodes. 


 */

public class SerializeDeserializeBinaryTree {
    public static void serialize_deserailize(int[] arr) {
        Node head = Create.createBinTree(arr);
        String ser_result = serialize(head);
        System.out.println(ser_result);

        Node head2 = deserialize(ser_result);
        inorderTraversal(head2);
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }

    public static Node deserialize(String binTree) {
        String[] nStr = binTree.split(",");
        ArrayList<Node> q = new ArrayList<>();
        
        Node head = new Node(Integer.parseInt(nStr[0]));
        q.add(head);
        int cnt = 0;
        while (!q.isEmpty()) {
            Node n = q.remove(0);

            cnt++;
            if(cnt < nStr.length) {
                if(nStr[cnt].equals("#")) {
                    n.left = null;
                }else {
                    Node l = new Node(Integer.parseInt(nStr[cnt]));
                    n.left = l;
                    q.add(l);
                }
            }

            cnt++;
            if(cnt < nStr.length) {
                if(nStr[cnt].equals("#")) {
                    n.right = null;
                }else {
                    Node r = new Node(Integer.parseInt(nStr[cnt]));
                    n.right = r;
                    q.add(r);
                }
            }
        }

        return head;
    }

    public static String serialize(Node curr) {
        ArrayList<String> result = new ArrayList<>();

        ArrayList<Node> q = new ArrayList<>();
        q.add(curr);

        while (!q.isEmpty()) {
            Node n = q.remove(0);

            if(n == null) {
                result.add("#");
                continue;
            }else {
                result.add("" + n.key);
            }

            q.add(n.left);
            q.add(n.right);
        }

        return String.join(",", result);
    }
}
