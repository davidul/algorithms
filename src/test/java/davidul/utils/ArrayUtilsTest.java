package davidul.utils;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayUtilsTest {

    @Test
    public void extend() {
        String [] a = new String[]{"a", "b", "c"};
        final String[] extend = ArrayUtils.extend(a, 10);
        assertThat(extend.length).isEqualTo(13);

        final String[] extend1 = ArrayUtils.extend(a, 0);
        assertThat(extend1.length).isEqualTo(3);
    }

    @Test
    public void shrink(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] shrink = ArrayUtils.shrink(a, 1);
        assertThat(shrink.length).isEqualTo(2);
    }

    @Test
    public void shift(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] shift = ArrayUtils.shift(a);
        assertThat(shift.length).isEqualTo(2);
        assertThat(shift[0]).isEqualTo("b");
    }

    @Test
    public void unshift(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] ds = ArrayUtils.unshift(a, "d");
        assertThat(ds.length).isEqualTo(4);
        assertThat(ds[0]).isEqualTo("d");
    }

    @Test
    public void pop(){
        String [] a = new String[]{"a", "b", "c"};
        final Tuple<String, String[]> pop = ArrayUtils.pop(a);
        assertThat(pop._1()).isEqualTo("c");
        assertThat(pop._2().length).isEqualTo(2);
    }

    @Test
    public void push(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] ds = ArrayUtils.push(a, "d");
        assertThat(ds.length).isEqualTo(4);
        assertThat(ds[ds.length-1]).isEqualTo("d");
    }

    @Test
    public void subarray(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] subarray = ArrayUtils.subarray(a, 1, a.length);
        assertThat(subarray.length).isEqualTo(2);
    }

    @Test
    public void minHeap(){
        String [] a = new String[]{"c", "b", "a"};
        ArrayUtils.minHeap(a, 0, 0, String::compareTo);


        String [] b = new String[]{"c", "b", "z", "e", "h", "x", "a"};
        ArrayUtils.minHeap(b, 0, 0,String::compareTo);

        String [] c = new String[]{"c", "b", "z", "e", "h", "x", "n","y","g","v", "w","k", "l", "m", "a"};
        ArrayUtils.minHeap(c, 0, 0, String::compareTo);
        final String[] shift = ArrayUtils.shift(c);
        ArrayUtils.minHeap(shift, 0, 0, String::compareTo);

    }

    @Test
    public void rotate(){
        String [] a = new String[]{"1","2","3"};
        String [] expected = new String[]{"3","2","1"};
        final String[] rotate = ArrayUtils.rotate(a, 2);
        Assertions.assertThat(rotate).containsExactlyElementsOf(Lists.newArrayList("2","3","1"));

        String [] b = new String[]{"1", "2", "3", "4" ,"5"};
        final String[] rotate1 = ArrayUtils.rotate(b, 2);
        Assertions.assertThat(rotate1).containsExactlyElementsOf(Lists.newArrayList("4","5","1","2","3"));

        String [] c = new String[]{"1", "2", "3", "4" ,"5","6"};
        final String[] rotate2 = ArrayUtils.rotate(c, 2);
        Assertions.assertThat(rotate2).containsExactlyElementsOf(Lists.newArrayList("5","6","1","2","3","4"));

        String [] d = new String[]{"1", "2", "3", "4" ,"5","6"};
        final String[] rotate3 = ArrayUtils.rotate(d, 3);
        Assertions.assertThat(rotate3).containsExactlyElementsOf(Lists.newArrayList("4","5","6","1","2","3"));

        String [] e = new String[]{"1","2","3","4","1","2","3","4","1","2","3","4"};
        final String[] rotate4 = ArrayUtils.rotate(e, 4);
        Assertions.assertThat(rotate4).containsExactlyElementsOf(Lists.newArrayList("1","2","3","4","1","2","3","4","1","2","3","4"));

    }

    @Test
    public void reverse(){
        String [] a = new String[]{"1","2","3"};
        String[] reverse = ArrayUtils.reverse(a);
        Assertions.assertThat(reverse).containsExactlyElementsOf(Lists.newArrayList("3","2","1"));

        String [] b = new String[]{"1","2","3","4"};
        reverse = ArrayUtils.reverse(b);
        Assertions.assertThat(reverse).containsExactlyElementsOf(Lists.newArrayList("4","3","2","1"));
    }
}
