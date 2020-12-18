package davidul.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    //1 1 2 3 5 8
    @Test
    public void fib() {
        assertThat(Fibonacci.fib(1)).isEqualTo(1);
        assertThat(Fibonacci.fib(6)).isEqualTo(8);
        assertThat(Fibonacci.fib(40)).isEqualTo(102334155); //102334155
    }
}