package stack_queues.learning;

/*
 * Implement Queue Using Array

 Problem Statement: Implement Queue Data Structure using Array with all functions like pop, push, top, size, etc.

 Input: push(4)
       push(14)
       push(24)
       push(34)
       top()
       size()
       pop()

Output: 

The element pushed is 4
The element pushed is 14
The element pushed is 24
The element pushed is 34
The peek of the queue before deleting any element 4
The size of the queue before deletion 4
The first element to be deleted 4
The peek of the queue after deleting an element 14
The size of the queue after deleting an element 3


Intuition: 

The intuition is to fill the array in a circular manner, (ie) after popping from the front, rather than moving all the elements towards the front. We can have 2 variables to keep track of the start and end indexes of the sequence. Mod addition is done to handle boundary conditions.

Approach: 

The basic approach is to maintain two variables to point to the START and END of the filled elements in the array. START pointer is used to point to the starting index of the elements and the same case for the END pointer(ending index). Initially, both have value -1(indicating empty queue). 

First, let's see the implementation of the push function. Push basically inserts a new element at the end. So only the END variable is going to be incremented.

Corner case 1: What if we have no empty places in the array? So, first check that, if we don't have we exit, in the other case we increment the START variable and put the new element.

Corner case 2: What if END reaches the last index? We are doing mod with addition. So, END goes back to index 0([0-(n-1)] will always be the range for END).

Second, let us see the pop function. In Queue pop removes and returns the front element. So, START needs to be modified. The general approach is to copy the current element pointed by START and increase the START variable to the next index.

Corner case 3: What if the Queue is empty? That's why we are checking the START variable. If it is -1, then the queue is empty, we just exit.

Corner case 4: What if START goes out of bound? As done for END, mod addition comes to the rescue.

Corner case 5: What happens after popping the last element? We check this state with the currSize variable. Queue returns to the initial state, both START and END are set to -1.

Third, let's see the top function. It behaves more like a pop function. We need to return the element pointed by the START variable. Since we are not actually removing any element, it's fine to ignore corner cases 4 and 5.

That's all about the Queue class implementation. In the main function, we just initialize the Queue class to check all corner cases.
 */

public class MyQueue {
    public static class Queue {
        private int front;
        private int back;
        private int size;
        private int count;
        private int[] qArr;

        public Queue(int size) {
            if(size > 0) {
                this.size = size;
            }

            this.qArr = new int[this.size];
            this.front = 0;
            this.back = 0;
            this.count = 0;
        }


        public int Insert(int n) {
            if(this.count < this.size) {
                this.qArr[this.back] = n;
                this.count++;
                this.back = (this.back + 1)%this.size;
                return n;
            }else {
                return -1;
            }
        }

        public int Remove() {
            if(this.count > 0 ) {
                int res = this.qArr[this.front];
                this.front = (this.front + 1)%this.size;
                this.count--;
                return res;
            }else {
                return -1;
            }
        }

        public int Peek() {
            if(this.count > 0 ) {
                return this.qArr[this.front];
            }
            return -1;
        }


        public int Size() {
            return this.count;
        }
    }

    public static void ImplementQueue() {
        MyQueue.Queue q = new MyQueue.Queue(3);
        q.Insert(1);
        q.Insert(2);
        q.Insert(3);
        q.Remove();
        q.Insert(4);
        q.Insert(5);

        while (q.Size() > 0) {
            System.out.println(q.Remove());
        }
    }


    public static class Stack {
        MyQueue.Queue q;
        public Stack(int n) {
            this.q = new MyQueue.Queue(n);
        }

        public int Push(int n) {
            return this.q.Insert(n);
        }

        public int Pop() {
            int qSize = this.q.Size();
            int ans = -1;
            if(qSize > 0) {
                while (qSize > 1) {
                    this.q.Insert(this.q.Remove());
                    qSize--;
                }
                ans = this.q.Remove();
            }

            return ans;
        }

        public int Size() {
            return this.q.Size();
        }

        public int Peek() {
            int qSize = this.q.Size();
            int ans = -1;
            if(qSize > 0) {
                while (qSize > 1) {
                    this.q.Insert(this.q.Remove());
                    qSize--;
                }
                ans = this.q.Peek();
            }

            return ans;
        }
    }

    public static void ImplementStackUsingQueue() {
        MyQueue.Stack stack = new MyQueue.Stack(5);
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);
        stack.Push(5);
        stack.Pop();
        stack.Push(6);
        stack.Push(7);

        while (stack.Size() > 0) {
            System.out.println(stack.Pop());
        }
    }
}
