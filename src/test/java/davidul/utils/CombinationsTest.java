package davidul.utils;

import org.junit.Test;

import java.util.List;

public class CombinationsTest {

    @Test
    public void combinations() {
        final String[] n = {"a", "b", "c"};
        final List<String[]> combinations = Combinations.combinations(n);
        //assertThat(combinations.size()).isEqualTo(Math.pow(2, n.length));

        final String[] x = {"D", "a", "v","i","d"};
        final List<String[]> combinations1 = Combinations.combinations(x);
        //final List<String[]> combinations = Combinations.combinations(new String[]{"a", "b"});
    }
}