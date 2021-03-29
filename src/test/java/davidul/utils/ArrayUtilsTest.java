package davidul.utils;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayUtilsTest {


    @Test
    public void allocate(){
        try {
            final Class<String> aClass = (Class<String>) Class.forName("java.lang.String");
            final String[] allocate = ArrayUtils.allocate(aClass, 2);
            assertThat(allocate.length).isEqualTo(2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void extend() {
        String [] a = new String[]{"a", "b", "c"};
        final String[] extend = ArrayUtils.extend(a, 10);
        assertThat(extend.length).isEqualTo(13);

        final String[] extend1 = ArrayUtils.extend(a, 0);
        assertThat(extend1.length).isEqualTo(3);

        final String[] extend2 = ArrayUtils.extend(a, -1);
        assertThat(extend2.length).isEqualTo(a.length);
    }

    @Test
    public void shrink(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] shrink = ArrayUtils.shrink(a, 1);
        assertThat(shrink.length).isEqualTo(2);

        final String[] shrink0 = ArrayUtils.shrink(a, 0);
        assertThat(shrink0.length).isEqualTo(a.length);
    }

    @Test
    public void shift(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] shift = ArrayUtils.shift(a);
        assertThat(shift.length).isEqualTo(2);
        assertThat(shift[0]).isEqualTo("b");

        String[] shift1 = ArrayUtils.shift(new String[]{});
        assertThat(shift1.length).isEqualTo(0);
    }

    @Test
    public void unshift(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] ds = ArrayUtils.unshift(a, "d");
        assertThat(ds.length).isEqualTo(4);
        assertThat(ds[0]).isEqualTo("d");
    }

    @Test
    public void unshift_array(){
        String [] a = new String[]{"a", "b", "c"};
        String [] b = new String[]{"d", "e", "f"};
        final String[] unshift = ArrayUtils.unshift(a, b);
        assertThat(unshift.length).isEqualTo(6);
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

        String [] b = new String[]{};
        final String[] ds1 = ArrayUtils.push(b, "d");
        assertThat(ds1.length).isEqualTo(1);
        final String[] es = ArrayUtils.push(ds1, "e");
        assertThat(es.length).isEqualTo(2);
    }

    @Test
    public void push_position(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] ds = ArrayUtils.push(a, "d", 0);
        assertThat(ds.length).isEqualTo(4);
        assertThat(ds[0]).isEqualTo("d");

        String [] b = new String[]{"a", "b", "c"};
        final String[] bs = ArrayUtils.push(b, "d", b.length);
        assertThat(bs.length).isEqualTo(4);
        assertThat(bs[bs.length - 1]).isEqualTo("d");

        String [] c = new String[]{"a", "b", "c"};
        final String[] cs = ArrayUtils.push(c, "d", 1);
        assertThat(cs.length).isEqualTo(4);
        assertThat(cs[1]).isEqualTo("d");
    }

    @Test
    public void subarray(){
        String [] a = new String[]{"a", "b", "c"};
        final String[] s = ArrayUtils.subarray(a, 1, a.length);
        assertThat(s.length).isEqualTo(2);

        String [] b = new String[]{"a", "b", "c", "d", "e", "f"};
        final String[] s1 = ArrayUtils.subarray(b, 2, 4);
        assertThat(s1.length).isEqualTo(2);
        assertThat(s1).containsExactlyElementsOf(Lists.newArrayList("c", "d"));

        String [] c = new String[]{"a", "b", "c", "d", "e", "f"};
        final String[] s2 = ArrayUtils.subarray(b, 0, 1);

        String [] d = new String[]{"a", "b", "c", "d", "e", "f"};
        ArrayUtils.subarray(d,4,5);
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

        String [] f = new String[0];
        final String[] rotate5 = ArrayUtils.rotate(f, 4);
        Assertions.assertThat(rotate5).containsExactlyElementsOf(Lists.newArrayList());

        String [] g = new String[]{"1"};
        final String[] rotate6 = ArrayUtils.rotate(g, 4);
        Assertions.assertThat(rotate6).containsExactlyElementsOf(Lists.newArrayList("1"));

    }

    @Test
    public void rotate_big(){
        Integer [] n = new Integer[1000_000] ;
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n.length; i++){
            sb.append(i + " ");
            n[i] = r.nextInt(100_000);
        }
        final String[] s = sb.toString().split(" ");
        ArrayUtils.rotate(n, 11110);
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

    @Test
    public void reverse2(){
        String [] a = new String[]{"1","2","3"};
        String[] reverse = ArrayUtils.reverse2(a);
        Assertions.assertThat(reverse).containsExactlyElementsOf(Lists.newArrayList("3","2","1"));

        String [] b = new String[]{"1","2","3","4"};
        reverse = ArrayUtils.reverse2(b);
        Assertions.assertThat(reverse).containsExactlyElementsOf(Lists.newArrayList("4","3","2","1"));
    }

    @Test
    public void min(){
        String [] a = new String[]{"1","2","3"};
        final String min = ArrayUtils.min(a, String::compareTo);
        assertThat(min).isEqualTo("1");
    }

    @Test
    public void binary_search(){
        String [] b = new String[]{"1","2","3","4"};
        ArrayUtils.binarySearch(b, "2", String::compareTo);
    }

    @Test
    public void merge(){
        String [] a = new String[]{"1","2","3"};
        String [] b = new String[]{"4","5","6"};
        final String[] merge = ArrayUtils.merge(a, b);
        assertThat(merge.length).isEqualTo(6);
        final String join = String.join("", merge);
        assertThat(join).isEqualTo("123456");
    }

}
