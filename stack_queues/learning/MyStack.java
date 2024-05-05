package stack_queues.learning;

/*
 * Implement Stack using Array
 * 
 * Problem statement: Implement a stack using an array.

Note: Stack is a data structure that follows the Last In First Out (LIFO) rule.



Explanation: 

push(): Insert the element in the stack.

pop(): Remove and return the topmost element of the stack.

top(): Return the topmost element of the stack

size(): Return the number of remaining elements in the stack.


Solution
Disclaimer: Don’t jump directly to the solution, try it out yourself first.

Intuition: As we know stack works on the principle of last in first out, so we have to put elements in an array such that it keeps track of the most recently inserted element. Hence we can think of using a Top variable which will help in keeping track of recent elements inserted in the array.

Approach:

Declare an array of particular size.
Define a variable “Top” and initialize it as -1.
push(x): insert element is the array by increasing top by one.
pop(): check whether top is not equal to -1 if it is so, return top and decrease its value by one.
size(): return top+1.



 */

public class MyStack {
    /**
     * InnerMyStack
     */
    public static class Stack {
        private int[] stackArr;
        private int top;
        private int size = 1000;
        public Stack(int size) {
            if (size > 0) {
                this.size = size;
            }
            this.stackArr = new int[this.size];
            this.top = -1;
        }

        public int Push(int n) {
            if(this.top < this.size - 1) {
                this.top++;
                this.stackArr[this.top] = n;
                return n;
            }else {
                return -1;
            }
        }

        public int Pop() {
            if(this.top >= 0) {
                int res = this.stackArr[this.top];
                this.top--;
                return res;
            }else {
                return -1;
            }
        }

        public int Peek() {
            if(this.top >= 0) {
                return this.stackArr[this.top];
            }else {
                return -1;
            }
        }

        public int Size() {
            return this.top + 1;
        }
    }

    public static void implementStack() {
        MyStack.Stack s = new MyStack.Stack(0);
        s.Push(2);
        s.Push(5);
        s.Push(9);
        System.out.println(s.Peek());
        while (s.Size() > 0) {
            System.out.println(s.Pop());
        }
    }

    public static class Queue {
        MyStack.Stack input;
        MyStack.Stack output;

        public Queue(int size) {
            input = new MyStack.Stack(size);
            output = new MyStack.Stack(size);
        }

        public int Insert(int n) {
            while (input.Size() > 0) {
                output.Push(input.Pop());
            }

            int ans = output.Push(n);

            while (output.Size() > 0) {
                input.Push(output.Pop());
            }

            return ans;
        }

        public int Remove() {
            return input.Pop();
        }

        public int Peek() {
            return input.Peek();
        }

        public int Size() {
            return input.Size();
        }
    }

    public static void ImplementQueueUsingStack() {
        MyStack.Queue q = new MyStack.Queue(5);
        q.Insert(1);
        q.Insert(2);
        q.Insert(3);
        q.Insert(4);
        q.Insert(5);
        q.Remove();
        q.Insert(6);

        while (q.Size() > 0) {
            System.out.println(q.Remove());
        }
    }
}
