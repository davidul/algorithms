package davidul.utils;

public class Tuple<A, B> {
    private A a;
    private B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A _1(){
        return this.a;
    }

    public B _2(){
        return this.b;
    }
}

