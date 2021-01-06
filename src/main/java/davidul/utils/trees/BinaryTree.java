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


    /**
     *          8
     *      6        11
     *    5   7   9     14
     * @param data
     * @param comparator
     */
    public void remove(T data, Comparator<T> comparator){
        Node<T> item = find(data, root, comparator);
        if(item != null){
            if(item.left == null && item.right == null){//leaf
                if (comparator.compare(item.parent.left.data, data) == 0) //left or right child of the parent
                    item.parent.left = null;
                else
                    item.parent.right = null;
            }else if(item.left != null && item.right == null){ //just left subtree
                item.parent.left = item.left;
                item  = null;
            }else if(item.left == null) {//just right subtree
                item.parent.right = item.right;
                item = null;
            }else{
                final Node<T> min = min(item.right);//minimum of the right subtree
                min.parent.left = null;
                min.parent = item.parent;
                min.left = item.left;
                min.right = item.right;
                item = null;
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

    public Node<T> max(){
        return this.max(this.root);
    }

    public Node<T> max(Node<T> subtree){
        if(subtree.right != null)
            return max(subtree.right);
        else
            return subtree;
    }

    public Node<T> min(Node<T> subtree){
        if(subtree.left != null)
            return min(subtree.left);
        else
            return subtree;
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

    /**
     *
     * @return
     */
    public List<T> preOrder() {
        List<T> collect = new ArrayList<>();
        preOrder(this.root, collect);
        return collect;
    }

    private void preOrder(Node<T> node, List<T> collect){
        if(node != null) {
            collect.add(node.data);
            preOrder(node.left, collect);
            preOrder(node.right, collect);
        }
    }

    /**
     * @return
     */
    public List<T> postOrder() {
        List<T> collect = new ArrayList<>();
        postOrder(this.root, collect);
        return collect;
    }

    private void postOrder(Node<T> node, List<T> collect){
        if(node != null){
            postOrder(node.left, collect);
            postOrder(node.right, collect);
            collect.add(node.data);
        }
    }

    /**
     * @return
     */
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
