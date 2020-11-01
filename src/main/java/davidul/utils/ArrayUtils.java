package davidul.utils;

import java.util.Comparator;

import static java.lang.reflect.Array.newInstance;

public class ArrayUtils {

    /**
     * Extend array by specified amount.
     * @param t
     * @param extendBy
     * @param <T>
     * @return
     */
    public static <T> T[] extend(T[] t, int extendBy){
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length + extendBy);
        System.arraycopy(t,0,ts,0,t.length);
        return ts;
    }

    /**
     * Shrink array by specified amount.
     * @param t
     * @param shrinkBy
     * @param <T>
     * @return
     */
    public static <T> T[] shrink(T[] t, int shrinkBy){
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length - shrinkBy);
        System.arraycopy(t,0,ts,0,t.length - shrinkBy);
        return ts;
    }

    //remove first item
    public static <T> T[] shift(T[] t){
        final T item = t[0];
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length -1);
        System.arraycopy(t,1, ts,0,t.length - 1);
        return ts;
    }

    //append first item
    public static <T> T[] unshift(T[] t, T item){
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length + 1);
        System.arraycopy(t,0, ts,1,t.length);
        ts[0] = item;
        return ts;
    }

    //append to last
    public static <T> T[] push(T[] t, T item){
        final T[] extend = extend(t, 1);
        extend[extend.length - 1] = item;
        return extend;
    }

    //remove the last element
    public static <T> Tuple<T, T[]> pop(T[] t){
        final T item = t[t.length - 1];
        final T[] shrink = shrink(t, 1);
        return new Tuple<T, T[]>(item, shrink);
    }

    public static <T> T[] subarray(T[] t, int start, int end){
        final int i = end - start;
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), i);
        System.arraycopy(t,start, ts,0,i);
        return ts;
    }

    public static void reverse(){

    }

    /*
              a                0
           b     c          1    2
         d  e  f  g        3 4  5 6

         7/2 - 1 = 3 - 1 = 2
         3/2 - 1 = 1 - 1
         7-x = 2^n

          a b c d e f g
          0 1 2 3 4 5 6
     */
    public static <T> void minHeap(T[] t, int start, int end, Comparator<T> comparator){
        //((t.length - 1)/2 - 1)
        if(start == 0)
            start = ((t.length - 1)/2 - 1);


        for(int i = start; i >= end; i--){
            //swap f & g
            if(2*i+2 < t.length && comparator.compare(t[2*i + 2],t[2*i+1]) < 0){
                T temp = t[2*i+1];
                t[2*i+1] = t[2*i+2];
                t[2*i+2] = temp;
                minHeap(t, 2*i+1, i, comparator);
            }
            //compare with parent
            if(2*i+1 < t.length && comparator.compare(t[2*i+1], t[i]) < 0){
                T temp = t[i];
                t[i] = t[2*i+1];
                t[2*i+1] = temp;
                minHeap(t, 2*i +1, i, comparator);
            }
        }
    }
}
