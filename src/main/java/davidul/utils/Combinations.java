package davidul.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.reflect.Array.newInstance;

public class Combinations {

   /* public static <T> T[][] combinations(T[] n) {
        if (n.length == 0) return (T[][]) newInstance(n.getClass().componentType(), 1, 1);
        T firstElement = n[0];
        final T[] restArray = ArrayUtils.subarray(n, 1, n.length);
        final T[][] combinationsWithoutFirst = combinations(restArray);

        T[][] combWithFirst = (T[][]) newInstance(n.getClass().componentType(), combinationsWithoutFirst.length, combinationsWithoutFirst.length);

        for(int i = 0; i < combinationsWithoutFirst.length; i++){
            T[] ts = combinationsWithoutFirst[i];
            if(ts.length > 1 && ts[0] == null) {
                ts = ArrayUtils.shift(ts);
            }
            combWithFirst[i] = ArrayUtils.append(ts, firstElement);
        }


        final T[][] ts = (T[][]) newInstance(n.getClass().componentType(), combWithFirst.length + combinationsWithoutFirst.length,1);
        for(int i = 0; i < combWithFirst.length; i++){
            ts[i] = combWithFirst[i];
        }

        for(int i = combWithFirst.length; i < combinationsWithoutFirst.length + combWithFirst.length; i++){
            ts[i] = combinationsWithoutFirst[i - combWithFirst.length];
        }

        return ts;
    }*/

    public static <T> List<T[]> combinations(T[] n){
        if (n.length == 0) {
            final ArrayList<T[]> ts = new ArrayList<>();
            ts.add(ArrayUtils.empty(n));
            return ts;
        }
        T firstElement = n[0];
        final T[] restArray = ArrayUtils.subarray(n, 1, n.length);
        final List<T[]> combinationsWithoutFirst = combinations(restArray);

        List<T[]> combWithFirst = new ArrayList<>();

        T [] o = (T[])newInstance(n.getClass().componentType(), 1);
        o[0] = firstElement;
        for(T[] ts : combinationsWithoutFirst){
            final T[] append = ArrayUtils.append(ts, firstElement);
            combWithFirst.add(append);
        }
        combinationsWithoutFirst.addAll(combWithFirst);

        return  combinationsWithoutFirst;
    }

}
