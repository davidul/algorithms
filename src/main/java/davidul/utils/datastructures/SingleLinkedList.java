package davidul.utils.datastructures;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple linked list, for educational purposes
 * @param <T>
 */
public class SingleLinkedList<T> {

    public static void main(String[] args) {
        final SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        linkedList.addFirst("D");
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }

    /**
     * Helper method for linked list size
     * @return true if empty
     */
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    /**
     * Add at the end
     *  Head -> Data -> T
     *
     * @param data
     */
    public boolean add(T data) {
        final Node<T> tNode = new Node<>(data);
        if (this.head == null) {
            this.head = tNode;
            size++;
            return true;
        } else {
           append(this.head, tNode);
        }

        return true;
    }

    /**
     * Add at the beginning. Prepend.
     *
     * @param data
     */
    public void addFirst(T data) {
        final Node<T> head = this.head;
        this.head = new Node<>(data);
        this.head.next = head;
    }

    /**
     * Returns Head data.
     * @return head data, null if empty
     */
    public T getFirst() {
        if(this.head == null)
            return null;
        return this.head.data;
    }

    /**
     * Removes and returns first element
     * @return
     */
    public T remove(){
        if(this.head == null)
            throw new NoSuchElementException();
        final Node<T> nextHead = this.head.next;
        final T headData = this.head.data;
        this.head = nextHead;
        size--;
        return headData;
    }

    /**
     * Returns but does not remove
     * @return data
     */
    public T peekFirst(){
        if(this.head == null)
            return null;
        return this.head.data;
    }

    /**
     * Reverse the linked list.
     */
    public void reverse(){
        if(this.head == null || size == 1)
            return;
        Node<T> tNode = swapToHead(this.head);
        while (tNode.next != null){
            tNode = swapToHead(tNode);
        }
    }

    /**
     * Swap current node next node to head.
     * H -> B -> C then swap(B) will produce
     * C -> H -> B
     * @param current
     * @return
     */
    // A -> B -> C -> D
    // C -> A -> B -> D
    //move successor of current (next) to head
    private Node<T> swapToHead(Node<T> current){
        //current B
        //nextHead C
        final Node<T> nextHead = current.next;//move to head C
        current.next = nextHead.next; //B -> D
        final Node<T> previousHead = this.head; //A
        this.head = nextHead;
        this.head.next = previousHead;
        return current;
    }


    /**
     * Convert linked list to array
     * @return
     */
    public Object[] toArray(){
        final Object[] objects = new Object[size];
        Node<T> n = this.head;
        for(int i = 0; i < size; i++) {
            objects[i] = n.data;
            n = n.next;
        }

        return objects;
    }


    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node<T> node = SingleLinkedList.this.head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                if(node != null){
                    final T data = node.data;
                    node = node.next;
                    return data;
                }
                throw new NoSuchElementException();
            }
        };
    }

    private void append(Node<T> start, Node<T> n) {
        if (start.next == null) {
            start.next = n;
            size++;
        } else {
            append(start.next, n);
        }
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}
