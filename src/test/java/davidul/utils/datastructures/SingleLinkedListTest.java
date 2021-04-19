package davidul.utils.datastructures;

import org.junit.Test;

import java.security.cert.CertificateParsingException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class SingleLinkedListTest {

    @Test
    public void size() {
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        assertThat(list.size()).isEqualTo(0);
        list.add("A");
        assertThat(list.size()).isEqualTo(1);
        list.add("B");
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void isEmpty() {
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        assertThat(list.isEmpty()).isTrue();
        list.add("A");
        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    public void add() {
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        assertThat(list.add("A")).isTrue();
    }

    @Test
    public void addFirst() {
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("A");
        list.addFirst("B");
        assertThat(list.getFirst()).isEqualTo("B");

    }

    @Test
    public void getFirst() {
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("A");
        assertThat(list.getFirst()).isEqualTo("A");
        list.add("B");
        assertThat(list.getFirst()).isEqualTo("A");
        list.addFirst("C");
        assertThat(list.getFirst()).isEqualTo("C");
    }

    @Test
    public void remove() {
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        assertThatThrownBy(() -> list.remove()).isInstanceOf(NoSuchElementException.class);
        list.add("A");
        assertThat(list.remove()).isEqualTo("A");
        assertThat(list.size()).isEqualTo(0);
        list.add("A");
        list.add("B");
        assertThat(list.remove()).isEqualTo("A");
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.getFirst()).isEqualTo("B");
    }

    @Test
    public void reverse(){
        final SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("A");
        list.add("B");
        list.reverse();
        final SingleLinkedList<String> list1 = new SingleLinkedList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.reverse();
    }
}