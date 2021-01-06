package davidul.utils.trees;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

    @Test
    public void add() {
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10, Integer::compareTo);
        tree.add(8, Integer::compareTo);
        tree.add(12, Integer::compareTo);
        assertThat(tree.size()).isEqualTo(3);
        assertThat(tree.height()).isEqualTo(2);
    }

    @Test
    public void in_order(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10, Integer::compareTo);
        tree.add(8, Integer::compareTo);
        tree.add(7, Integer::compareTo);
        tree.add(9, Integer::compareTo);
        tree.add(12, Integer::compareTo);
        tree.add(13, Integer::compareTo);
        tree.add(11, Integer::compareTo);

        final List<Integer> integers = tree.inOrder();
        assertThat(integers).isEqualTo(List.of(7,8,9,10,11,12,13));
    }

//     10
//  8      12
//7   9   11 13
    @Test
    public void pre_order(){
        final BinaryTree<Integer> objectBinaryTree = new BinaryTree<>();
        objectBinaryTree.add(10, Integer::compareTo);
        objectBinaryTree.add(8, Integer::compareTo);
        objectBinaryTree.add(7, Integer::compareTo);
        objectBinaryTree.add(9, Integer::compareTo);
        objectBinaryTree.add(12, Integer::compareTo);
        objectBinaryTree.add(13, Integer::compareTo);
        objectBinaryTree.add(11, Integer::compareTo);

        final List<Integer> integers = objectBinaryTree.preOrder();
        assertThat(integers).isEqualTo(List.of(10, 8, 7, 9, 12, 11, 13));
    }

    @Test
    public void post_order(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10, Integer::compareTo);
        tree.add(8, Integer::compareTo);
        tree.add(7, Integer::compareTo);
        tree.add(9, Integer::compareTo);
        tree.add(12, Integer::compareTo);
        tree.add(13, Integer::compareTo);
        tree.add(11, Integer::compareTo);
        //7 8 12 10
        final List<Integer> integers = tree.postOrder();
        assertThat(integers).isEqualTo(List.of(7, 9, 8, 11, 13,12,10));
    }

    @Test
    public void size(){
        final BinaryTree<Integer> bt = new BinaryTree<>();
        assertThat(bt.size()).isEqualTo(0);

        bt.add(10, Integer::compareTo);
        assertThat(bt.size()).isEqualTo(1);

        bt.add(12, Integer::compareTo);
        assertThat(bt.size()).isEqualTo(2);

        bt.add(8, Integer::compareTo);
        assertThat(bt.size()).isEqualTo(3);

        for(int i = 0; i < 100; i++){
            bt.add(i + 20, Integer::compareTo);
        }

        assertThat(bt.size()).isEqualTo(103);
    }

    @Test
    public void height(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10, Integer::compareTo);
        tree.add(8, Integer::compareTo);
        tree.add(7, Integer::compareTo);
        tree.add(12, Integer::compareTo);

        final int height = tree.height();
        System.out.println(height);
    }

    @Test
    public void search(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10, Integer::compareTo);
        tree.add(8, Integer::compareTo);
        tree.add(7, Integer::compareTo);
        tree.add(12, Integer::compareTo);

        assertThat(tree.find(10, Integer::compareTo)).isEqualTo(10);
        assertThat(tree.find(8, Integer::compareTo)).isEqualTo(8);
    }

    @Test
    public void search_non_exist(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10, Integer::compareTo);
        tree.add(8, Integer::compareTo);
        tree.add(12, Integer::compareTo);

        assertThat(tree.find(20, Integer::compareTo)).isNull();
    }

    @Test
    public void remove_left_leaf(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1, Integer::compareTo);
        tree.add(10, Integer::compareTo);
        tree.add(0, Integer::compareTo);
        assertThat(tree.inOrder()).isEqualTo(List.of(0, 1, 10));
        tree.remove(0, Integer::compareTo);
        assertThat(tree.find(0, Integer::compareTo)).isNull();
        assertThat(tree.inOrder()).isEqualTo(List.of(1, 10));

        final BinaryTree<Integer> tree1 = new BinaryTree<>();
        tree1.add(10, Integer::compareTo);
        tree1.add(8, Integer::compareTo);
        tree1.add(7, Integer::compareTo);
        tree1.add(9, Integer::compareTo);
        tree1.add(12, Integer::compareTo);
        tree1.add(13, Integer::compareTo);
        tree1.add(11, Integer::compareTo);
        assertThat(tree1.inOrder()).isEqualTo(List.of(7, 8, 9, 10, 11, 12, 13));
        tree1.remove(7, Integer::compareTo);
        assertThat(tree1.inOrder()).isEqualTo(List.of(8, 9, 10, 11, 12, 13));
    }

    @Test
    public void remove_right_leaf(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(10, Integer::compareTo);
        tree.add(11, Integer::compareTo);
        tree.add(9, Integer::compareTo);
        assertThat(tree.inOrder()).isEqualTo(List.of(9, 10, 11));
        tree.remove(11, Integer::compareTo);
        assertThat(tree.inOrder()).isEqualTo(List.of(9, 10));
    }

    @Test
    public void max(){
        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1, Integer::compareTo);
        tree.add(10, Integer::compareTo);
        tree.add(0, Integer::compareTo);
        tree.max();
    }
}