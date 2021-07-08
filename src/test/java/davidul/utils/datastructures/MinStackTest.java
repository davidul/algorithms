package davidul.utils.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinStackTest {

    @Test
    public void push(){
        final MinStack minStack = new MinStack();
        minStack.push(1);
        assertThat(minStack.size()).isEqualTo(1);
        assertThat(minStack.pop()).isEqualTo(1);
    }

    @Test
    public void pop(){
        final MinStack minStack = new MinStack();
        minStack.push(1);
        assertThat(minStack.pop()).isEqualTo(1);
        minStack.push(2);
        minStack.push(3);
        assertThat(minStack.pop()).isEqualTo(3);
        assertThat(minStack.pop()).isEqualTo(2);
    }

    @Test
    public void min(){
        final MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        assertThat(minStack.min()).isEqualTo(1);
        minStack.pop();
        assertThat(minStack.min()).isEqualTo(1);
        minStack.pop();
        assertThat(minStack.min()).isEqualTo(1);
        minStack.push(0);
        assertThat(minStack.min()).isEqualTo(0);
    }
}
