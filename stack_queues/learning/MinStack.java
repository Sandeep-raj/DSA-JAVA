package stack_queues.learning;

import java.util.Stack;

/*
 * Implement Min Stack : O(2N) and O(N) Space Complexity
 * 
 * Problem Statement: Implement Min Stack | O(2N) and O(N) Space Complexity. Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Examples:
 * Input Format:["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
[
[ ], [-2], [0], [-3], [ ], [ ], [ ], [ ]
]

Result: [null, null, null, null, -3, null, 0, -2]
Explanation: 
stack < long long > st
st.push(-2); Push element in stack
st.push(0); Push element in stack
st.push(-3); Push element in stack
st.getMin(); Get minimum element fromstack
st.pop(); Pop the topmost element
st.top(); Top element is 0
st.getMin(); Minimum element is -2


Approach: 

Let’s take a variable that stores the minimum number. So whenever a push operation comes in just take that number put it in the stack and update the variable to the number.

Push operation:

Now if there is a push operation just check whether that number is less than the min number. If it is smaller than min we will push a modified value which is a push(2 * Val - min) into the stack and will update min to the value of the original number. If it’s not then we will just push it as it is.

getMin() operation:

We will just return the value of min.

Top operation:

While returning the top value we know that it is a modified value. We will check if the top value is lesser than min, If it is then we will return the min as the top value.

Pop operation:

While making pop we will check if the top value is lesser than min, If it is then we must update our min to its previous value. In order to do that min = (2 * min) - (modified value) and we will pop the element.

Time Complexity: O(1)

Space Complexity: O(N)
 */

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Integer Min = Integer.MAX_VALUE;

    public boolean push(int n) {
        if(stack.isEmpty()) {
            this.Min = n; 
            return this.stack.add(n);
        }else {
            if(this.Min <= n) {
                return this.stack.add(n);
            }else {
                int currVal = 2*n - this.Min;
                this.Min = n;
                return this.stack.add(currVal);
            }
        }
    }

    public int getMin() {
        return this.Min;
    }

    public int pop() {
        if(stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }else {
            int currVal = this.stack.pop();
            if(currVal <= this.Min) {
                int currMin = this.Min;
                this.Min = 2*currMin - currVal;
                if(this.stack.isEmpty()) {
                    this.Min = Integer.MAX_VALUE;
                }
                return currMin;
            }else {
                if(this.stack.isEmpty()) {
                    this.Min = Integer.MAX_VALUE;
                }
                return currVal;
            }
        }
    }

    public int peek() {
        if(stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }else {
            int currVal = this.stack.peek();
            if(currVal <= this.Min) {
                return this.Min;
            }else {
                if(this.stack.isEmpty()) {
                    this.Min = Integer.MAX_VALUE;
                }
                return currVal;
            }
        }
    }

    public int Size() {
        return this.stack.size();
    }

    public static void ImplementMinStack() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.print("getMin "+ stack.getMin());
        System.out.print("poped " + stack.pop());
        System.out.print("top " + stack.peek());
        System.out.print("getMin " + stack.getMin());

    }
}
