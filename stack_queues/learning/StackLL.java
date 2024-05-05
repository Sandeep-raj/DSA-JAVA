package stack_queues.learning;

public class StackLL {
    public static class Node {
        public int Data;
        public Node next;

        public Node(int data) {
            this.Data = data;
        }
    }

    public static class Stack {
        private Node start;
        private int size = 0;

        public int Push(int n) {
            Node node = new Node(n);

            if(this.start == null) {
                this.start = node;
            }else {
                node.next = this.start;
                this.start = node;
            }

            this.size++;
            return n;
        }


        public int Pop() {
            if(this.start == null) {
                return -1;
            }else {
                int val = this.start.Data;
                this.start = this.start.next;
                this.size--;

                return val;
            }
        }

        public int Peek() {
            if(this.start == null) {
                return -1;
            }else {
                return this.start.Data;
            }
        }

        public int Size() {
            return this.size;
        }
    }


    public static void ImplementStackUsingLL() {
        StackLL.Stack stack = new StackLL.Stack();
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);
        stack.Push(5);

        while (stack.Size() > 0) {
            System.out.println(stack.Pop());
        }
    }
}
