package davidul.utils.datastructures;

import java.lang.reflect.Parameter;
import java.util.Stack;

/**
 * https://cp-algorithms.com/data_structures/stack_queue_modification.html
 */
public class MinStack {
    private static class Pair {
        int val;
        int min;

        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Stack<Pair> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int item) {
        if (this.stack.isEmpty())
            this.stack.push(new Pair(item, item));
        else {
            this.stack.push(
                    new Pair(
                            item, Math.min(this.stack.peek().min, item)));
        }
    }

    public int pop(){
        return this.stack.pop().val;
    }

    public int min(){
        return this.stack.peek().min;
    }

    public int peek(){
        return this.stack.peek().val;
    }

    public int size(){
        return this.stack.size();
    }
}
