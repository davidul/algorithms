package davidul.utils.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @param <T>
 *
 * @author ulicny.david@gmail.com
 */
public class BinaryTree<T> {

    private static class Node<T> {
        private final T data;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> root;

    public void add(T data, Comparator<T> comparator) {
        if (root == null) {
            this.root = new Node<>(data);
            return;
        }

        add(this.root, data, comparator);
    }

    private Node<T> add(Node<T> parent, T data, Comparator<T> comparator) {
        if (parent == null) {
            return new Node<>(data);
        }
        //parent is greater then data, put it to left
        if (comparator.compare(parent.data, data) > 0) {
            parent.left = add(parent.left, data, comparator);
            parent.left.parent = parent;
        }

        if (comparator.compare(parent.data, data) < 0) {
            parent.right = add(parent.right, data, comparator);
            parent.right.parent = parent;
        }
        return parent;
    }

    public void remove(T data, Comparator<T> comparator){
        final Node<T> item = find(data, root, comparator);
        if(item != null){
            if(item.left == null && item.right == null){//leaf
                if (comparator.compare(item.parent.left.data, data) == 0) //left or right child of the parent
                    item.parent.left = null;
                else
                    item.parent.right = null;
            }
        }

    }

    public T find(T data, Comparator<T> comparator){
        final int compare = comparator.compare(data, root.data);
        if(compare == 0){
            return data;
        }else if(compare > 0){
            final Node<T> search = find(data, root.right, comparator);
            if (search != null) {
                return search.data;
            }
        }else {
            final Node<T> search = find(data, root.left, comparator);
            if (search != null) {
                return search.data;
            }
        }

        return null;
    }

    private Node<T> find(T data, Node<T> node, Comparator<T> comparator){
        if(node == null){
            return null;
        }
        final int compare = comparator.compare(data, node.data);
        if(compare == 0){
            return node;
        }else if(compare > 0){
            node = find(data, node.right, comparator);
        }else {
            node = find(data, node.left, comparator);
        }
        return node;
    }

    /**
     * Size of the tree, number of nodes
     * @return number of nodes
     */
    public int size(){
        if(root == null) return 0;

        return size(root, 0);
    }

    private int size(Node<T> node, int count){
        if(node != null) {
            int s = size(node.left, count);
            s++;
            final int s1 = size(node.right, count);
            count = count + s + s1;
        }
        return count;
    }

    /**
     * Calculates the height of the tree
     * @return height of the tree
     */
    public int height(){
        return height(root);
    }

    private int height(Node<T> node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        if(left > right){
            return ++left;
        }else {
            return ++right;
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node<T> node){
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node<T> node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public List<T> inOrder() {
        List<T> collect = new ArrayList<>();
        inOrder(this.root, collect);
        return collect;
    }

    private void inOrder(Node<T> node, List<T> collect) {
        if (node != null) {
            inOrder(node.left, collect);
            collect.add(node.data);
            inOrder(node.right, collect);
        }
    }
}
