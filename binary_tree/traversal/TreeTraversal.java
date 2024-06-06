package binary_tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Tree Traversals
 * 
 * Problem statement
You have been given a Binary Tree of 'N' nodes, where the nodes have integer values.
Your task is to return the ln-Order, Pre-Order, and Post-Order traversals of the given binary tree.



 */

public class TreeTraversal {
    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public static void inorder(Node curr, ArrayList<Integer> result) {
        if(curr == null) {
            return;
        }

        inorder(curr.left, result);
        result.add(curr.key);
        inorder(curr.right, result);
    }

    public static void preorder(Node curr, ArrayList<Integer> result) {
        if(curr == null) {
            return;
        }

        result.add(curr.key);
        preorder(curr.left, result);
        preorder(curr.right, result);
    }

    public static void postorder(Node curr, ArrayList<Integer> result) {
        if(curr == null) {
            return;
        }

        postorder(curr.left, result);
        postorder(curr.right, result);
        result.add(curr.key);
    }

    public static void levelorder(Node curr, ArrayList<List<Integer>> result) {
        List<Node> child_q = new LinkedList<>();
        child_q.add(curr);

        while (!child_q.isEmpty()) {
            List<Node> parent_q = child_q;
            child_q = new LinkedList<>();
            List<Integer> res_list = new LinkedList<>();

            while (!parent_q.isEmpty()) {
                Node n = parent_q.remove(0);

                res_list.add(n.key);

                if(n.left != null) {
                    child_q.add(n.left);
                }
                if(n.right != null) {
                    child_q.add(n.right);
                }
            }

            result.add(res_list);
        }
    }

    public static void preorder_itr(Node curr, ArrayList<Integer> result) {
        Stack<Node> stack = new Stack<>();
        stack.push(curr);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            result.add(n.key);
            
            if(n.right != null) {
                stack.push(n.right);
            }

            if(n.left != null) {
                stack.push(n.left);
            }
        }
    }

    public static void inorder_itr(Node curr, ArrayList<Integer> result) {
        Stack<Node> stack = new Stack<>();
        
        while (true) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }else {
                if(stack.isEmpty()) {
                    break;
                }

                Node temp = stack.pop();
                result.add(temp.key);

                curr = temp.right;
            }
        }
    }

    public static void postorder_itr_2stack(Node curr, ArrayList<Integer> result) {
        Stack<Node> q1 = new Stack<>();
        Stack<Node> q2 = new Stack<>();

        q1.push(curr);

        while (!q1.isEmpty()) {
            Node n = q1.pop();
            q2.push(n);

            if(n.left != null) {
                q1.push(n.left);
            }

            if(n.right != null) {
                q1.push(n.right);
            }
        }

        while (!q2.isEmpty()) {
            result.add(q2.pop().key);
        }
    }

    public static void postorder_itr_1stack(Node curr, ArrayList<Integer> result) {
        Stack<Node> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }else {
                Node n = stack.peek();
                if(n.right != null) {
                    stack.push(n.right);
                    curr = n.right;
                }else {
                    result.add(n.key);
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek().right == n) {
                        n = stack.pop();
                        result.add(n.key);
                    }

                    if(!stack.isEmpty()) {
                        curr = stack.peek().right;
                    }else {
                        break;
                    }
                }
            }
        }
    }

    static class AuxNode {
        Node node;
        int level;

        public AuxNode(Node n) {
            this.node = n;
            this.level = 1;
        }

        public void incLvl() {
            this.level++;
        }

        public int getlvl() {
            return this.level;
        }
    }

    public static ArrayList<ArrayList<Integer>> in_pre_post_traversal(Node curr) {
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();

        Stack<AuxNode> stack = new Stack<>();

        AuxNode an = new AuxNode(curr);
        stack.push(an);

        while (!stack.isEmpty()) {
            an = stack.pop();

            if(an.level == 1) {
                preorder.add(an.node.key);
                an.incLvl();
                stack.push(an);

                if(an.node.left != null) {
                    stack.push(new AuxNode(an.node.left));
                }
            }else if(an.level == 2) {
                inorder.add(an.node.key);
                an.incLvl();
                stack.push(an);

                if(an.node.right != null) {
                    stack.push(new AuxNode(an.node.right));
                }
            }else if(an.level == 3) {
                postorder.add(an.node.key);
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(preorder);
        result.add(inorder);
        result.add(postorder);

        return result;
    }



    public static void binTraversal() {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n2 = new Node(2);
        Node n7 = new Node(7);
        Node n6 = new Node(6);

        n3.left = n5;
        n3.right = n2;
        n4.left = n7;
        n4.right = n6;
        n1.left = n3;
        n1.right = n4;

        ArrayList<Integer> inorder = new ArrayList<>();
        inorder(n1, inorder);
        System.out.println("inorder -> " + inorder.toString());

        ArrayList<Integer> preorder = new ArrayList<>();
        preorder(n1, preorder);
        System.out.println("preorder -> " +preorder.toString());

        ArrayList<Integer> postorder = new ArrayList<>();
        postorder(n1, postorder);
        System.out.println("postorder -> " + postorder.toString());

        ArrayList<List<Integer>> result = new ArrayList<>();
        levelorder(n1, result);
        System.out.println("level order -> " + result);

        ArrayList<Integer> preorderitr = new ArrayList<>();
        preorder_itr(n1, preorderitr);
        System.out.println("preorder itr -> " + preorderitr.toString());

        ArrayList<Integer> inorderitr = new ArrayList<>();
        inorder_itr(n1, inorderitr);
        System.out.println("inorder itr -> " + inorderitr.toString());

        ArrayList<Integer> postorderitr2stack = new ArrayList<>();
        postorder_itr_2stack(n1, postorderitr2stack);
        System.out.println("postorder itr -> " + postorderitr2stack.toString());

        ArrayList<Integer> postorderitr1stack = new ArrayList<>();
        postorder_itr_1stack(n1, postorderitr1stack);
        System.out.println("postorder itr -> " + postorderitr1stack.toString());

        ArrayList<ArrayList<Integer>> result1 = in_pre_post_traversal(n1);
        System.out.println("all traversal itr -> " + result1.toString());
    }
}
