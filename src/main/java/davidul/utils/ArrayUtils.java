package davidul.utils;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.reflect.Array.getLength;
import static java.lang.reflect.Array.newInstance;

public class ArrayUtils {


    public static <T> T[] allocate(Class<T> t, int size) {
        final T[] ts = (T[]) newInstance(t, size);
        return ts;
    }

    /**
     * Extend array by specified amount.
     *
     * @param t        input array
     * @param extendBy extension factor
     * @param <T>      generic type
     * @return new extended array
     */
    public static <T> T[] extend(T[] t, int extendBy) {
        if(extendBy < 0){
            return t;
        }
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length + extendBy);
        System.arraycopy(t, 0, ts, 0, t.length);
        return ts;
    }

    /**
     * Shrink array by specified amount.
     * If shrinkBy is 0, then behaves like copy.
     *
     * @param t        input array
     * @param shrinkBy shrink by amount
     * @param <T>      type
     * @return new shrinked array
     */
    public static <T> T[] shrink(T[] t, int shrinkBy) {
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length - shrinkBy);
        System.arraycopy(t, 0, ts, 0, t.length - shrinkBy);
        return ts;
    }

    /**
     * Remove first item
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T[] shift(T[] t) {
        if(t.length == 0){
            return t;
        }
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length - 1);
        System.arraycopy(t, 1, ts, 0, t.length - 1);
        return ts;
    }

    /**
     * Prepend item to the array
     * @param t array
     * @param item item to prepend
     * @param <T> type
     * @return new array with prepended item
     */
    public static <T> T[] unshift(T[] t, T item) {
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length + 1);
        System.arraycopy(t, 0, ts, 1, t.length);
        ts[0] = item;
        return ts;
    }

    public static <T> T[] unshift(T[] t, T [] items) {
        return merge(items, t);
    }


    public static <T> T[] shiftByN(T[] t, int shift){
        final T item = t[0];
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), t.length - shift);
        System.arraycopy(t, 1, ts, 0, t.length - 1);
        return ts;
    }

    /**
     * Append last
     * @param t
     * @param item
     * @param <T>
     * @return
     */
    public static <T> T[] push(T[] t, T item) {
        final T[] extend = extend(t, 1);
        extend[extend.length - 1] = item;
        return extend;
    }

    //remove the last element
    public static <T> Tuple<T, T[]> pop(T[] t) {
        final T item = t[t.length - 1];
        final T[] shrink = shrink(t, 1);
        return new Tuple<T, T[]>(item, shrink);
    }

    public static <T> T[] subarray(T[] t, int start, int end) {
        final int i = end - start;
        final T[] ts = (T[]) newInstance(t.getClass().componentType(), i);
        System.arraycopy(t, start, ts, 0, i);
        return ts;
    }

    public static <T> T[] reverse(T[] t) {
        for (int i = 0; i < t.length/2; i++) {
            T tmp = t[i];
            t[i] = t[t.length - 1 - i];
            t[t.length - 1 - i] = tmp;
        }
        return t;
    }

    public static <T> T min(T[] t, Comparator<T> comparator){
        T min = t[0];
        for(int i = 1; i < t.length; i++){
            if(comparator.compare(min, t[i]) > -1){
                min = t[i];
            }
        }
        return min;
    }

    /**
     * Change every n-th element. At the end
     * of the array, roll back to beginning.
     * @param t
     * @param rot
     * @param <T>
     * @return
     */
    public static <T> T[] rotate(T[] t, int rot) {
        final int length = t.length;
        if(length == 0 || length == 1 || rot == 0)
            return t;

        T temp = t[0];
        for(int r = 0; r < rot; r++){
            if(length%2 == 0)//if even elements
                temp = t[r];

            for(int i = 0; i < length; i+=rot){
                if(i+rot+r < length) { //n-th element with regards to number of rotations
                    T temp2 = t[i + rot + r];
                    t[i + rot+r] = temp;
                    temp = temp2;
                }else{
                    if(length%2 == 0) {//even elements
                        t[i+rot+r - length] = temp;
                    }else {//odd elements
                        T temp2 = t[i + rot + r - length];
                        t[i + rot + r - length] = temp;
                        temp = temp2;
                    }
                }
            }
        }
        return t;
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
    public static <T> void minHeap(T[] t, int start, int end, Comparator<T> comparator) {
        //((t.length - 1)/2 - 1)
        if (start == 0)
            start = ((t.length - 1) / 2 - 1);


        for (int i = start; i >= end; i--) {
            //swap f & g
            if (2 * i + 2 < t.length && comparator.compare(t[2 * i + 2], t[2 * i + 1]) < 0) {
                T temp = t[2 * i + 1];
                t[2 * i + 1] = t[2 * i + 2];
                t[2 * i + 2] = temp;
                minHeap(t, 2 * i + 1, i, comparator);
            }
            //compare with parent
            if (2 * i + 1 < t.length && comparator.compare(t[2 * i + 1], t[i]) < 0) {
                T temp = t[i];
                t[i] = t[2 * i + 1];
                t[2 * i + 1] = temp;
                minHeap(t, 2 * i + 1, i, comparator);
            }
        }
    }

    /**
     * Array must be sorted
     * @param t
     * @param find
     * @param <T>
     * @return
     */
    public static <T> T binarySearch(T[] t, T find, Comparator<T> comparator){
        int middle = t.length/2;
        int result = comparator.compare(t[middle], find);
        if(result == 0){
            return find;
        }else if(result > 0){ //middle item is greater, take lower half
            binarySearch(subarray(t, 0, middle+1), find, comparator);
        }else{ //upper half
            binarySearch(subarray(t, middle, t.length + 1), find, comparator);
        }

        return find;
    }


    public static <T> T[] merge(T[] t1, T[] t2){
        final T[] ts = Arrays.copyOf(t1, t1.length + t2.length);
        System.arraycopy(t2, 0, ts, t1.length, t2.length);
        return ts;
    }

    public static <T> T[] empty(T[] t){
        return (T[]) newInstance(t.getClass().componentType(), 0);
    }

    public static <T> T[] empty(Class c){
        return (T[]) newInstance(c, 0);
    }

    public static <T> T[] append(T[] t, T a){
        final T[] extend = extend(t, 1);
        extend[t.length] = a;
        return extend;
    }

}
