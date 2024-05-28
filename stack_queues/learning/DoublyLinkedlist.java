package stack_queues.learning;

public class DoublyLinkedlist {
    public static class Node {
        public int key;
        public int value;
        public Node Next;
        public Node Last;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int GetValue() {
            return this.value;
        }

        public int GetKey() {
            return this.key;
        }

        public void SetValue(int value) {
            this.value = value;
        }
    }

    public static class DLL {
        private int size = 10;
        private int count = 0;
        private Node firstNode = new Node(0, 0);
        private Node lastNode = new Node(0, 0);

        public DLL(int size) {
            this.firstNode.Next = lastNode;
            lastNode.Last = firstNode;
            if (size > 0) {
                this.size = size;
            }
        }

        public int Insert(int key, int value) {
            if (this.count < this.size) {
                Node node = new Node(key, value);
                Node nextNode = firstNode.Next;
                this.firstNode.Next = node;
                node.Next = nextNode;
                nextNode.Last = node;
                node.Last = firstNode;
                this.count++;
                return key;
            } else {
                return -1;
            }
        }

        public int Remove(Node node) {
            if (this.count > 0) {
                Node lastNode = node.Last;
                Node nextNode = node.Next;

                lastNode.Next = nextNode;
                nextNode.Last = lastNode;
                this.count--;
                return node.key;
            } else {
                return -1;
            }
        }

        public Node PeekFirst() {
            if(this.count > 0) {
                return this.firstNode.Next;
            }else {
                return null;
            }
        }

        public Node peekLast() {
            if(this.count > 0) {
                return this.lastNode.Last;
            }else {
                return null;
            }
        }

        public int Size() {
            return this.count;
        }

        public int InsertNode(Node node) {
            if(this.count < this.size) {
                Node nextNode = firstNode.Next;
                firstNode.Next = node;
                node.Last = firstNode;
                node.Next = nextNode;
                nextNode.Last = node;
                this.count++;

                return node.key;
            }else {
                return -1;
            }
        }
    }
}
