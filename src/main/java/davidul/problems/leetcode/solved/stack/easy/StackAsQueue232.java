package davidul.problems.leetcode.unsolved.stack.easy;

import java.util.Stack;

/**
 * mplement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the MyQueue class:
 * <p>
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * <p>
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * <p>
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 */
public class StackAsQueue232 {

    public static void main(String[] args) {
        StackAsQueue232 myQueue = new StackAsQueue232();
        System.out.println(myQueue.empty());
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false

        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

        myQueue.push(1);
        System.out.println(myQueue.peek());
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.push(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

    private Stack<Integer> stack;
    private Stack<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public StackAsQueue232() {
        this.stack = new Stack<>();
        this.queue = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (!this.queue.isEmpty()) {
            toStack();
        }
        this.stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (this.queue.isEmpty()) {
            toQueue();
        }
        return this.queue.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(this.queue.isEmpty()){
            toQueue();
        }
        return this.queue.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.queue.empty() && this.stack.empty();
    }

    private void toStack() {
        while (!this.queue.isEmpty()) {
            this.stack.push(this.queue.pop());
        }
    }
    private void toQueue() {
        while (!this.stack.isEmpty()) {
            this.queue.push(this.stack.pop());
        }
    }

}
