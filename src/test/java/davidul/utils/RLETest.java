package davidul.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class RLETest {

    @Test
    public void rle() {
        int [] a = new int[]{1,1,1,3};
        final int[] rle = RLE.rle(a);
        assertArrayEquals(new int[]{3,1,1,3}, rle);

        int [] b = new int [] {1,2,1,1};
        final int[] rle1 = RLE.rle(b);
        assertArrayEquals(new int[]{1,1,1,2,2,1}, rle1);
    }

    @Test
    public void count() {
        int[] a = new int[]{1,2,3};
        final int count = RLE.count(a, 0);

        int [] b = new int[]{1,1,1,3};
        final int count1 = RLE.count(b, 0);
    }

    @Test
    public void sequence(){
        int [] a = new int[]{1};
        int n = 1;
        int[] rle = RLE.rle(a);
        while (n < 6) {
            rle = RLE.rle(rle);
            n++;
        }
        System.out.println(rle);
    }
}