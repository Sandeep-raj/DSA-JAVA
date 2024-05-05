package stack_queues.learning;

/*
 * Implement Queue using Linked List
 * 
 * Problem Statement:  Implement Queue using Singly LinkedList

Prerequisites: Queue and LinkedList Data Structure.

Detailed Explanation of the Queue and LinkedList Data Structures is Discussed here

Queue.
LinkedList
Queue Can be Implemented in two ways : 

Static Implementation (Using Arrays)
Dynamic implementation (Using LinkedList) .
In this article, we would discuss the implementation of queue using LinkedList.

Comparison between Implementation of Queue using LinkedList and Array.

            Array	                LinkedList
It is Static, Needs to provide space Before implementation.  
Overflow occurs when queue size reaches its maximum capacity
Nodes are allocated dynamically, so the queue can grow and shrink as much as needed.
Overflow is not possible until and unless the heap memory got exhausted.
Operations Associated with queue are :

Enqueue     (Insert Node at Rare End )
Dequeue     (Delete Node from Front ) 
Peek            (Return value of Front Node without Dequing)
Empty         (Returns True when queue is empty else False)
Size             (Returns size of Queue) 
Let the Initial Queue be 10→20→30→40→Null.

Enqueue: 
Let’s Enqueue Node with val 50 to Queue. Enqueue is 3 step process 

Create a node with a value that is to be Enqueued.
Make the Rare Pointers next, point to the newly created Node.
As the newly created Node is inserted at the rear end, this is the last value in Queue.


Dequeue :
Let’s Dequeue the front value that is, 10 from Queue.

First create a ListNode pointer temp, and make it point to the Front value of Queue.
We should delete the Front Value in Queue. So move the Front pointer to the next node after Front Node. That means Front = Front→next 
Temp is pointing to the previous Front value, temp→next is pointing to the newFront value, as we are interested to delete the temp, Make the temp→next point null.
We don’t require temp anymore, So delete the temp.


Peek: 
If Queue is not empty return Front value of Queue.

Empty: 
If Front is Null then Queue is empty else not.

Size: 
Maintain a variable size, initially set to zero. Upon Enqueue increment size and on Dequeue decrement size.
 */

public class QueueLL {
    public static class Node {
        public int data;
        public Node next;

        public Node(int n) {
            this.data = n;
        }
    }

    public static class Queue {
        private Node start;
        private Node end;
        private int size;

        public int Insert(int n) {
            Node node = new Node(n);
            if(this.end == null) {
                this.start = node;
                this.end = node;
            }else {
                this.end.next = node;
                this.end = node;
            }
            this.size++;
            return n;
        }

        public int Remove() {
            if(this.size > 0) {
                int ans = this.start.data;
                this.start = this.start.next;
                this.size--;

                if(this.size == 0) {
                    this.start = null;
                    this.end = null;
                }

                return ans;
            }else {
                return -1;
            }
        }

        public int Peek() {
            if(this.size > 0) {
                return this.start.data;
            }
            return -1;
        }

        public int Size() {
            return this.size;
        }

    }

    public static void ImplementQueueUsingLL() {
        QueueLL.Queue q = new QueueLL.Queue();
        q.Insert(1);
        q.Insert(2);
        q.Insert(3);
        q.Remove();
        q.Insert(4);
        q.Insert(5);

        while (q.Size() > 0) {
            System.out.println(q.Remove());
        }

        q.Insert(1);
        q.Insert(2);
        q.Insert(3);

        while (q.Size() > 0) {
            System.out.println(q.Remove());
        }
    }
}
